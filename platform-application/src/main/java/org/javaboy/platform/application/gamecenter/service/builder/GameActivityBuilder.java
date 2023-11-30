package org.javaboy.platform.application.gamecenter.service.builder;

import com.alibaba.fastjson.JSON;
import org.javaboy.platform.application.gamecenter.model.request.GameActivityAwardConfigCreateCommand;
import org.javaboy.platform.application.gamecenter.model.request.GameActivityCreateCommand;
import org.javaboy.platform.domain.gamecenter.model.config.*;
import org.javaboy.platform.domain.gamecenter.model.entity.GameActivity;
import org.javaboy.platform.domain.gamecenter.model.entity.GameActivityAward;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

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

    public static GameActivityConfig buildGameActivityConfig(GameActivity gameActivity, List<GameActivityAward> awards) {
        GameActivityConfig gameActivityConfig = new GameActivityConfig();
        BeanUtils.copyProperties(gameActivity, gameActivityConfig);
        List<AwardConfig> awardConfigs = new ArrayList<>();
        for (GameActivityAward activityAward : awards) {
            AwardConfig awardConfig = new AwardConfig();
            awardConfig.setAssetName(activityAward.getAssetName());
            awardConfig.setAssetCode(activityAward.getAssetCode());
            awardConfig.setUrl(activityAward.getUrl());
            awardConfig.setAmount(activityAward.getAmount());
            awardConfig.setExchangeConfig(JSON.parseObject(activityAward.getExchangeConfig(), ExchangeConfig.class));
            awardConfig.setFatigueConfig(JSON.parseObject(activityAward.getFatigueConfig(), FatigueConfig.class));
            awardConfig.setInventoryConfig(JSON.parseObject(activityAward.getInventoryConfig(), InventoryConfig.class));
            awardConfigs.add(awardConfig);
        }
        gameActivityConfig.setAwardConfigs(awardConfigs);
        return gameActivityConfig;
    }

}
