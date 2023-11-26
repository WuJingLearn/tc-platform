package org.javaboy.platform.application.gamecenter.service.impl;

import org.javaboy.platform.application.gamecenter.command.GameActivityAwardConfigCreateCommand;
import org.javaboy.platform.application.gamecenter.command.GameActivityCreateCommand;
import org.javaboy.platform.application.gamecenter.service.GameActivityService;
import org.javaboy.platform.application.gamecenter.service.builder.GameActivityBuilder;
import org.javaboy.platform.domain.gamecenter.model.entity.GameActivity;
import org.javaboy.platform.domain.gamecenter.service.GameActivityDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return  activityDomainService.createGameActivity(gameActivity);
    }


    @Override
    public boolean addGameActivityAwardConfig(GameActivityAwardConfigCreateCommand activityAwardConfigCreateCommand) {
        return false;
    }
}
