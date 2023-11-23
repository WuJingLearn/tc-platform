package org.javaboy.platform.domain.leaderboard.service;

import org.javaboy.platform.client.request.leaderboard.EnterRequest;
import org.javaboy.platform.client.request.leaderboard.QueryRequest;
import org.javaboy.platform.domain.leaderboard.extension.LeaderBoardExtensionComponent;
import org.javaboy.platform.domain.leaderboard.model.entity.Member;
import org.javaboy.platform.domain.leaderboard.repository.LeaderBoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:majin.wj
 */
@Component
public class LeaderBoardServiceImpl implements LeaderBoardService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeaderBoardServiceImpl.class);

    @Autowired
    private LeaderBoardExtensionComponent extensionComponent;

    @Autowired
    private LeaderBoardRepository leaderBoardRepository;

    /**
     * 增量分数进入排行榜时,需要获得之前的分数；由于排行榜有上榜数量限制，所以排行榜上
     * 无法获取所有元素的分数，所以需要单独记录每个参与排行榜的历史分数；
     *
     * @param request
     */
    @Override
    public void enterLeaderBoard(EnterRequest request) {
        // 1.规则校验
        extensionComponent.preCheck(request.getScene());
        // 2.获取当前总分数，因为排行榜有数量限制，所有需要单独的记录每个成员的分数。
        Long score = extensionComponent.refreshAndGetScoreRecord(request);
        // 3.获取逻辑榜单
        String logicBid = extensionComponent.getBid(request);
        // 4.入榜
        LOGGER.info("进入排行榜|scene:{}|logicBid:{}|item:{}|totalScore:{}", request.getScene(), logicBid, request.getRuleItem(), score);
        leaderBoardRepository.enterLeaderBoard(logicBid, request.getRuleItem(), score);
    }

    @Override
    public List<Member> queryLeaderBoard(QueryRequest request) {
        extensionComponent.preCheck(request.getScene());
        String logicBid = extensionComponent.getBid(request);
        return leaderBoardRepository.queryLeaderBoard(logicBid, request.getTopN());
    }
}
