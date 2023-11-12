package org.javaboy.platform.application.leaderboard.service;

import org.javaboy.platform.client.request.leaderboard.EnterRequest;
import org.javaboy.platform.client.request.leaderboard.QueryRequest;
import org.javaboy.platform.domain.leaderboard.model.entity.Member;

import java.util.List;

/**
 * @author:majin.wj
 */
public interface LeaderBoardAppService {

    void enterLeaderBoard(EnterRequest request);

    List<Member> queryLeaderBoard(QueryRequest request);
}
