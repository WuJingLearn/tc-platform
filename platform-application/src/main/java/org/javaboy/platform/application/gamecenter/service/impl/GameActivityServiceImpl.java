package org.javaboy.platform.application.gamecenter.service.impl;

import com.alibaba.fastjson2.JSON;
import org.javaboy.platform.application.gamecenter.model.request.GameActivityAwardConfigCreateCommand;
import org.javaboy.platform.application.gamecenter.model.request.GameActivityCreateCommand;
import org.javaboy.platform.domain.gamecenter.model.config.GameActivityConfig;
import org.javaboy.platform.application.gamecenter.service.GameActivityConfigService;
import org.javaboy.platform.application.gamecenter.service.GameActivityService;
import org.javaboy.platform.application.gamecenter.service.builder.GameActivityBuilder;
import org.javaboy.platform.domain.gamecenter.model.entity.GameActivity;
import org.javaboy.platform.domain.gamecenter.model.entity.GameActivityAward;
import org.javaboy.platform.domain.gamecenter.service.GameActivityDomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author:majin.wj
 */
@Service
public class GameActivityServiceImpl implements GameActivityService {

    private static final Logger LOG = LoggerFactory.getLogger(GameActivityService.class);

    @Autowired
    private GameActivityDomainService activityDomainService;

    @Autowired
    private GameActivityConfigService gameActivityConfigService;


    @Override
    public boolean createGameActivity(GameActivityCreateCommand activityCreateCommand) {
        GameActivity gameActivity = GameActivityBuilder.build(activityCreateCommand);
        return activityDomainService.createGameActivity(gameActivity);
    }


    @Override
    public boolean addGameActivityAwardConfig(GameActivityAwardConfigCreateCommand activityAwardConfigCreateCommand) {
        GameActivityAward gameActivityAward = GameActivityBuilder.buildActivityAward(activityAwardConfigCreateCommand);
        gameActivityAward.setAwardCode(generateAwardCode());
        return activityDomainService.addActivityAward(gameActivityAward);
    }

    @Override
    public void publishGameActivity(String activityId) {
        HashMap<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", activityId);
        GameActivity gameActivity = activityDomainService.queryGameActivity(queryParams);
        List<GameActivityAward> activityAwards = activityDomainService.queryActivityAwards(gameActivity.getId());
        GameActivityConfig gameActivityConfig = GameActivityBuilder.buildGameActivityConfig(gameActivity, activityAwards);
        gameActivityConfigService.publishActivityConfig(gameActivityConfig);
        LOG.info("发布活动配置成功|gameActivityConfig:{}", JSON.toJSONString(gameActivityConfig));
    }

    private String generateAwardCode() {
        String uuid = UUID.randomUUID().toString().replace("_", "");
        return "award_" + uuid;
    }

}
