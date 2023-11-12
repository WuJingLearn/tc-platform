package org.javaboy.platform.application.leaderboard.service;

import org.javaboy.platform.client.request.leaderboard.EnterRequest;
import org.javaboy.platform.client.request.leaderboard.QueryRequest;
import org.javaboy.platform.domain.leaderboard.model.entity.Member;
import org.javaboy.platform.domain.leaderboard.service.LeaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:majin.wj
 */
@Component
public class LeaderBoardAppServiceImpl implements LeaderBoardAppService {

    @Autowired
    private LeaderBoardService leaderBoardService;

    @Override
    public void enterLeaderBoard(EnterRequest request) {
        // todo 这里需要通过分布式锁，控制对同一个ruleItem进入排行榜时的并发
        // 因为在获取分数记录和入排行榜不是一个原子操作。当增加分数和减少分数同时入榜时，
        // 排行榜中的分数是不确定的。
        leaderBoardService.enterLeaderBoard(request);
    }

    @Override
    public List<Member> queryLeaderBoard(QueryRequest request) {
        return leaderBoardService.queryLeaderBoard(request);
    }

}
