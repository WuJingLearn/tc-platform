package org.javaboy.platform.application.gamecenter.service;

import org.javaboy.platform.domain.gamecenter.model.config.GameActivityConfig;

/**
 * @author:majin.wj
 */
public interface GameActivityConfigService {

    void publishActivityConfig(GameActivityConfig gameActivityConfig);


    GameActivityConfig getActivityConfig(String activityName);

}
