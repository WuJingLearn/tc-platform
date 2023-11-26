package org.javaboy.platform.application.gamecenter.service.impl;

import org.javaboy.platform.application.gamecenter.model.config.GameActivityConfig;
import org.javaboy.platform.application.gamecenter.service.GameActivityConfigService;
import org.javaboy.platform.infrastructure.nacos.NacosConfigHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:majin.wj
 */
@Service
public class GameActivityConfigServiceImpl implements GameActivityConfigService {

    @Autowired
    private NacosConfigHelper nacosConfigHelper;

    @Override
    public void publishActivityConfig(GameActivityConfig gameActivityConfig) {

    }

    @Override
    public void getActivityConfig(String activityName) {

    }
}
