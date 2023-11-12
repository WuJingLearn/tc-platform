package org.javaboy.platform.domain.leaderboard.extension.impl;

import org.javaboy.platform.client.request.leaderboard.EnterRequest;
import org.javaboy.platform.client.request.leaderboard.LeaderBoardRequest;
import org.javaboy.platform.domain.infra.redis.RedisDal;
import org.javaboy.platform.domain.leaderboard.extension.LeaderBoardExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author:majin.wj
 * 亚运会排行榜扩展点
 */
@Component
public class HangzhouAsianGameExtension extends LeaderBoardExtension {

    @Autowired
    private RedisDal redisDal;


    @Override
    public Long refreshAndGetScoreRecord(EnterRequest request) {
        return null;
    }

    @Override
    public String getBid(LeaderBoardRequest request) {
        return null;
    }

}
