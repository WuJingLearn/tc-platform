package org.javaboy.platform.domain.gamecenter.service;

import org.apache.commons.lang3.tuple.Pair;
import org.javaboy.platform.domain.gamecenter.context.GameExchangeContext;

import java.util.Map;

/**
 * @author:majin.wj
 */
public interface FatigueService {

    /**
     * 校验权益疲劳度;
     * 在一个兑换列表中，可能会出现同样一个商品，但是数额配置的不一样。所以奖励中不能单单只有assetCode这个字段
     *
     * @param gameExchangeContext
     * @return key: awardCode,
     * Pair: v1:当前次数  v2: 限制数
     */
    Map<String, Pair<Integer,Integer>> checkAwardFatigue(GameExchangeContext gameExchangeContext);

    /**
     * 记录奖励疲劳度
     */
    void recordAwardFatigue(GameExchangeContext gaameExchangeContext );
}
