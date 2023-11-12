package org.javaboy.platform.domain.leaderboard.repository;

import org.apache.commons.lang3.tuple.Pair;
import org.javaboy.platform.domain.leaderboard.model.entity.Member;

import java.util.List;

/**
 * @author:majin.wj
 */
public interface LeaderBoardRepository {


    public void enterLeaderBoard(String logicBid, String itemRule, Long score);

    List<Member> queryLeaderBoard(String logicBid, Integer topN);

}
