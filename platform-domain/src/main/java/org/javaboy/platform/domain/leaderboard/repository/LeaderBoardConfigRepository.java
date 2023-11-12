package org.javaboy.platform.domain.leaderboard.repository;

import org.javaboy.platform.domain.leaderboard.model.entity.LeaderBoardConfig;

/**
 * @author:majin.wj 排行榜配置
 */
public interface LeaderBoardConfigRepository {

    LeaderBoardConfig getLeaderBoardConfig(String scene);


}
