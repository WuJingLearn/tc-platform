package org.javaboy.platform.application.gamecenter.service.impl;

import com.alibaba.fastjson2.JSON;
import org.apache.commons.lang3.StringUtils;
import org.javaboy.common.utils.exception.BizException;
import org.javaboy.platform.domain.gamecenter.model.config.AwardConfig;
import org.javaboy.platform.domain.gamecenter.model.config.GameActivityConfig;
import org.javaboy.platform.application.gamecenter.service.GameActivityConfigService;
import org.javaboy.platform.domain.gamecenter.model.config.InventoryConfig;
import org.javaboy.platform.domain.gamecenter.service.InventoryService;
import org.javaboy.platform.infrastructure.nacos.NacosConfigHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:majin.wj
 */
@Service
public class GameActivityConfigServiceImpl implements GameActivityConfigService {

    private static final Logger LOG = LoggerFactory.getLogger(GameActivityConfigService.class);

    @Autowired
    private NacosConfigHelper nacosConfigHelper;

    @Autowired
    private InventoryService inventoryService;

    private Map<String, GameActivityConfig> gameActivityConfigCache = new HashMap<>();

    /**
     * 目前手动写死即可
     */
    @PostConstruct
    public void initActivityConfig() {
        initGameActivityConfig("crazyExchange");
    }


    /**
     * 发布配置,发布到中心存储即可，然后应用启动时,需要加在
     *
     * @param gameActivityConfig
     */
    @Override
    public void publishActivityConfig(GameActivityConfig gameActivityConfig) {
        nacosConfigHelper.publishData(gameActivityConfig.getActivityName(), "gameCenter", JSON.toJSONString(gameActivityConfig));
        //
        List<AwardConfig> awardConfigs = gameActivityConfig.getAwardConfigs();
        for (AwardConfig awardConfig : awardConfigs) {
            InventoryConfig inventoryConfig = awardConfig.getInventoryConfig();
            if (inventoryConfig == null) {
                continue;
            }
            inventoryService.init(inventoryConfig, gameActivityConfig.getActivityName(), awardConfig.getAwardCode());
            LOG.info("初始化库存|activityName:{}|awardCode:{}|amount:{}",gameActivityConfig.getActivityName(),awardConfig.getAwardCode(),inventoryConfig.getAmount());
        }
    }

    @Override
    public GameActivityConfig getActivityConfig(String activityName) {
        return gameActivityConfigCache.get(activityName);
    }

    private void initGameActivityConfig(String activityName) {
        String activityConfig = nacosConfigHelper.getData(activityName, "gameCenter");
        if (StringUtils.isEmpty(activityConfig)) {
            throw new BizException("活动配置不存在");
        }
        GameActivityConfig gameActivityConfig = JSON.parseObject(activityConfig, GameActivityConfig.class);
        gameActivityConfigCache.put(activityName, gameActivityConfig);
    }
}
