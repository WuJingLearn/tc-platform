package org.javaboy.platform.application.gamecenter.service.builder;

import org.javaboy.platform.application.gamecenter.command.GameActivityCreateCommand;
import org.javaboy.platform.domain.gamecenter.model.entity.GameActivity;
import org.springframework.beans.BeanUtils;

/**
 * @author:majin.wj
 */
public class GameActivityBuilder {


    public static GameActivity build(GameActivityCreateCommand gameActivityCreateCommand){
        GameActivity gameActivity = new GameActivity();
        BeanUtils.copyProperties(gameActivity,gameActivity);
        return gameActivity;
    }

}
