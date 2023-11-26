package org.javaboy.platform.application.gamecenter.service;

import org.javaboy.platform.application.gamecenter.model.config.GameActivityConfig;

/**
 * @author:majin.wj
 */
public interface GameActivityConfigService {

    void publishActivityConfig(GameActivityConfig gameActivityConfig);


    void getActivityConfig(String activityName);

}
