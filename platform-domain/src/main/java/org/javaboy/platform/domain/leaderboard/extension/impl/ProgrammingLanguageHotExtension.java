package org.javaboy.platform.domain.leaderboard.extension.impl;

import org.javaboy.common.utils.DateUtils;
import org.javaboy.platform.client.request.leaderboard.EnterRequest;
import org.javaboy.platform.client.request.leaderboard.LeaderBoardRequest;
import org.javaboy.platform.domain.infra.redis.RedisDal;
import org.javaboy.platform.domain.leaderboard.constants.LeaderBoardSceneConstant;
import org.javaboy.platform.domain.leaderboard.extension.LeaderBoardExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author:majin.wj
 * 编程语言每周热度排行
 */
@Component("programmingLanguage")
public class ProgrammingLanguageHotExtension extends LeaderBoardExtension {


    private String programingScore = "programing_score_record_%s_%s";

    private String programingBidKey = "%s_bid_%s";

    @Autowired
    private RedisDal redisDal;

    @Override
    public Long refreshAndGetScoreRecord(EnterRequest request) {
        String recordKey = String.format(programingScore, DateUtils.getMondayDate(), request.getRuleItem());
        Long addScore = request.getScore();
        return redisDal.incrBy(recordKey, addScore);
    }


    @Override
    public String getBid(LeaderBoardRequest request) {
        return String.format(programingBidKey,getScene(),DateUtils.getMondayDate());
    }

    @Override
    protected String getScene() {
        return LeaderBoardSceneConstant.PROGRAMMING_LANGUAGE_SCENE;
    }

}
