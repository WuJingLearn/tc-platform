package org.javaboy.platform.infrastructure.repository.leaderboard;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.CollectionUtils;
import org.javaboy.platform.domain.leaderboard.model.entity.LeaderBoardConfig;
import org.javaboy.platform.domain.leaderboard.model.entity.Member;
import org.javaboy.platform.domain.leaderboard.repository.LeaderBoardConfigRepository;
import org.javaboy.platform.domain.leaderboard.repository.LeaderBoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * ·
 *
 * @author:majin.wj
 */
@Component
public class LeaderBoardRepositoryImpl implements LeaderBoardRepository {


    private static final Logger LOGGER = LoggerFactory.getLogger(LeaderBoardRepositoryImpl.class);

    /**
     * 排榜榜中一个桶的key
     * 1.榜单id
     * 2.桶编号
     */
    private static final String LEADER_KEY = "leaderboard_%s_%s";

    /**
     * 使用lua脚本保证进入排行时的原子性；
     */
    private String enterLeaderBoardScript = "local size = redis.call('ZCARD', KEYS[1])\n"
            + "if size < tonumber(ARGV[3]) then\n"
            + "    redis.call('ZADD', KEYS[1], ARGV[1], ARGV[2])\n" + "else\n"
            + "    redis.call('ZADD', KEYS[1], ARGV[1], ARGV[2])\n"
            + "    redis.call('ZPOPMIN', KEYS[1], 0, 0)\n" + "end";

    @Autowired
    private Jedis jedis;

    @Autowired
    private LeaderBoardConfigRepository configRepository;

    /**
     * 对于一个榜单，进行分桶处理。目的是为了避免排行榜key写热点问题；
     * 在读取TOP N元素时,需要查询所有分桶的榜单的TOPN个元素，然后取这些元素的TOPN作为排行榜的TOPN元素
     *
     * @param logicBid
     * @param itemRule
     * @param score
     */
    @Override
    public void enterLeaderBoard(String logicBid, String itemRule, Long score) {
        LeaderBoardConfig leaderBoardConfig = configRepository.getLeaderBoardConfig(getScene(logicBid));
        // 分桶数量
        Integer buckets = leaderBoardConfig.getBucket();
        // 上榜数量限制b
        Integer limit = leaderBoardConfig.getLimit();
        String realBid = getRealBid(buckets, itemRule, logicBid);
        LOGGER.info("进入排行榜|realBid:{}|item:{}|totalScore:{}", realBid, itemRule, score);
        jedis.eval(enterLeaderBoardScript, 1, realBid, String.valueOf(score), itemRule, String.valueOf(limit));
    }

    @Override
    public List<Member> queryLeaderBoard(String logicBid, Integer topN) {
        LOGGER.info("查询排行榜|logicBid:{}",logicBid);
        LeaderBoardConfig leaderBoardConfig = configRepository.getLeaderBoardConfig(getScene(logicBid));
        topN = Math.min(topN, leaderBoardConfig.getLimit());
        // 大顶推,分数最大的元素在堆顶
        PriorityQueue<Tuple> queue = new PriorityQueue<>(leaderBoardConfig.getBucket() * topN, Comparator.reverseOrder());
        for (int i = 0; i < leaderBoardConfig.getBucket(); i++) {
            String bucketKey = String.format(LEADER_KEY, logicBid, i);
            LOGGER.info("查询排行榜分桶|bucketKey:{}",bucketKey);
            Set<Tuple> tuples = jedis.zrevrangeWithScores(bucketKey, 0, topN);
            LOGGER.info("查询排行榜分桶|bucketKey:{}|members:{}",bucketKey, JSON.toJSONString(tuples));
            if (CollectionUtils.isNotEmpty(tuples)) {
                queue.addAll(tuples);
            }
        }
        return IntStream.range(0, topN).mapToObj(rank -> {
            Tuple tuple = queue.poll();
            if (tuple == null) {
                return null;
            }
            Member member = new Member();
            member.setItemRule(tuple.getElement());
            member.setScore(Double.valueOf(tuple.getScore()).longValue());
            member.setRank(rank + 1);
            return member;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    private String getRealBid(Integer buckets, String itemRule, String logicBid) {
        int slot = itemRule.hashCode() % buckets;
        return String.format(LEADER_KEY, logicBid, slot);
    }

    private String getScene(String bidKey) {
        return bidKey.split("_")[0];
    }

}
