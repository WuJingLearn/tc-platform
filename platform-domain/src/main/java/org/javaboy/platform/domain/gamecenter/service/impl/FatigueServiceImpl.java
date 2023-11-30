package org.javaboy.platform.domain.gamecenter.service.impl;

import org.apache.commons.lang3.tuple.Pair;
import org.javaboy.common.utils.DateUtils;
import org.javaboy.platform.domain.gamecenter.context.GameExchangeContext;
import org.javaboy.platform.domain.gamecenter.enums.FatigueType;
import org.javaboy.platform.domain.gamecenter.model.config.AwardConfig;
import org.javaboy.platform.domain.gamecenter.model.config.FatigueConfig;
import org.javaboy.platform.domain.gamecenter.model.config.GameActivityConfig;
import org.javaboy.platform.domain.gamecenter.service.FatigueService;
import org.javaboy.platform.domain.infra.redis.DistributedCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author:majin.wj
 */
@Service
public class FatigueServiceImpl implements FatigueService {

    /**
     * 活动周期疲劳度 活动名称_开始时间_用户
     */
    private static final String ACTIVITY_FATIGUE_PERIOD_KEY = "activity_fatigue_period_%s_%s_%s";

    /**
     * 活动天疲劳度,活动名称_当天_用户
     */
    private static final String ACTIVITY_FATIGUE_DAY_KEY = "activity_fatigue_day_%s_%s_%s";

    /**
     * 权益周期疲劳度 awardCode_开始时间_uid
     */
    private static final String BENEFIT_FATIGUE_KEY = "activity_benefit_fatigue_period_%s_%s_%s";
    /**
     * 权益天级别疲劳度 awardCode_当天_uid
     */
    private static final String BENEFIT_FATIGUE_DAY_KEY = "activity_benefit_fatigue_day_%s_%s_%s";

    @Autowired
    private DistributedCacheService distributedCacheService;

    @Override
    public Map<String, Pair<Integer, Integer>> checkAwardFatigue(GameExchangeContext gameExchangeContext) {
        Map<String, Pair<Integer, Integer>> periodMap = new HashMap<>();
        GameActivityConfig gameActivityConfig = gameExchangeContext.getGameActivityConfig();
        List<AwardConfig> awardConfigs = gameActivityConfig.getAwardConfigs();
        Long uid = gameExchangeContext.getUid();
        for (AwardConfig awardConfig : awardConfigs) {
            FatigueConfig fatigueConfig = awardConfig.getFatigueConfig();
            if (Objects.isNull(fatigueConfig)) {
                continue;
            }
            String periodKey = null;
            switch (FatigueType.valueOf(fatigueConfig.getType().toUpperCase())) {
                case DAILY:
                    periodKey = String.format(BENEFIT_FATIGUE_DAY_KEY, awardConfig.getAwardCode(), DateUtils.toDay(), uid);
                    break;
                case PERIOD:
                    periodKey = String.format(BENEFIT_FATIGUE_KEY, awardConfig.getAwardCode(), DateUtils.dateStr(gameActivityConfig.getStartTime()), uid);
                    break;
            }
            Integer curTime = Optional.ofNullable(distributedCacheService.getString(periodKey)).map(Integer::valueOf).orElse(0);
            Pair<Integer, Integer> pair = Pair.of(curTime, fatigueConfig.getTime());
            periodMap.put(awardConfig.getAwardCode(), pair);
        }
        return periodMap;
    }

}
