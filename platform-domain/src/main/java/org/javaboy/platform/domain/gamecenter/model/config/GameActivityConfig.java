package org.javaboy.platform.domain.gamecenter.model.config;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author:majin.wj
 */
@Data
public class GameActivityConfig {

    private String activityName;

    private String activityDesc;

    private Date startTime;

    private Date endTime;

    /**
     * 活动级别兑换配置,通常可以设置在抽奖活动中。抽奖活动
     * 只需在活动级别设置抽奖条件即可
     */
    private ExchangeConfig exchangeConfig;


    /**
     * 活动级别的疲劳度配置；通常用于限制活动期间最多兑换几次
     */
    private FatigueConfig fatigueConfig;

    /**
     * 奖励
     */
    private List<AwardConfig> awardConfigs;

}
