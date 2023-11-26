package org.javaboy.platform.application.gamecenter.service.impl;

import org.javaboy.platform.application.gamecenter.command.GameActivityAwardConfigCreateCommand;
import org.javaboy.platform.application.gamecenter.command.GameActivityCreateCommand;
import org.javaboy.platform.application.gamecenter.service.GameActivityService;
import org.javaboy.platform.application.gamecenter.service.builder.GameActivityBuilder;
import org.javaboy.platform.domain.gamecenter.model.entity.GameActivity;
import org.javaboy.platform.domain.gamecenter.model.entity.GameActivityAward;
import org.javaboy.platform.domain.gamecenter.service.GameActivityDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author:majin.wj
 */
@Service
public class GameActivityServiceImpl implements GameActivityService {

    @Autowired
    private GameActivityDomainService activityDomainService;

    @Override
    public boolean createGameActivity(GameActivityCreateCommand activityCreateCommand) {
        GameActivity gameActivity = GameActivityBuilder.build(activityCreateCommand);
        return activityDomainService.createGameActivity(gameActivity);
    }


    @Override
    public boolean addGameActivityAwardConfig(GameActivityAwardConfigCreateCommand activityAwardConfigCreateCommand) {
        GameActivityAward gameActivityAward = GameActivityBuilder.buildActivityAward(activityAwardConfigCreateCommand);
        return activityDomainService.addActivityAward(gameActivityAward);
    }

    @Override
    public void publishGameActivity(String activityId) {
        HashMap<String, Object> queryParams = new HashMap<>();
        queryParams.put("id",activityId);
        GameActivity gameActivity = activityDomainService.queryGameActivity(queryParams);
        List<GameActivityAward> activityAwards = activityDomainService.queryActivityAwards(gameActivity.getId());

    }
}
