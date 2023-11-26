package org.javaboy.platform.domain.gamecenter.service;

import org.javaboy.platform.domain.gamecenter.model.entity.GameActivity;

/**
 * @author:majin.wj
 */
public interface GameActivityDomainService {


    public boolean createGameActivity(GameActivity gameActivity);


    GameActivity queryGameActivity(String activityName);


}
