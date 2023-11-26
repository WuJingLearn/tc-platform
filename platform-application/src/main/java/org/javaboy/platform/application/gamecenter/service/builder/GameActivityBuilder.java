package org.javaboy.platform.application.gamecenter.service.builder;

import org.javaboy.platform.application.gamecenter.command.GameActivityAwardConfigCreateCommand;
import org.javaboy.platform.application.gamecenter.command.GameActivityCreateCommand;
import org.javaboy.platform.domain.gamecenter.model.entity.GameActivity;
import org.javaboy.platform.domain.gamecenter.model.entity.GameActivityAward;
import org.javaboy.platform.infrastructure.dataobject.gamecenter.GameActivityAwardDO;
import org.springframework.beans.BeanUtils;

/**
 * @author:majin.wj
 */
public class GameActivityBuilder {


    public static GameActivity build(GameActivityCreateCommand gameActivityCreateCommand) {
        GameActivity gameActivity = new GameActivity();
        BeanUtils.copyProperties(gameActivityCreateCommand, gameActivity);
        return gameActivity;
    }


    public static GameActivityAward buildActivityAward(GameActivityAwardConfigCreateCommand gameActivityAwardConfigCreateCommand) {
        GameActivityAward gameActivityAward = new GameActivityAward();
        BeanUtils.copyProperties(gameActivityAwardConfigCreateCommand, gameActivityAward);
        return gameActivityAward;
    }

}
