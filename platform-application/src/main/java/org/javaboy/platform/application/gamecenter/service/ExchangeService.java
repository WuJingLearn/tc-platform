package org.javaboy.platform.application.gamecenter.service;

import org.javaboy.platform.application.gamecenter.model.dto.ExchangeActivityDTO;
import org.javaboy.platform.application.gamecenter.model.dto.ExchangeAwardDTO;
import org.javaboy.platform.application.gamecenter.model.request.ExchangeRequest;

/**
 * @author:majin.wj 兑换服务
 * 1.奖励预览
 * 2.兑换
 */
public interface ExchangeService {


    /**
     * 用户查看活动
     * 1.疲劳度,兑换次数
     * 2.兑换条件,用户资产
     * 3.库存限制
     *
     * @param activityName
     * @param uid
     * @return
     */
    ExchangeActivityDTO preview(String activityName, Long uid);

    /**
     * 用户兑换商品请求
     *
     * @param request
     */
    ExchangeAwardDTO exchange(ExchangeRequest request);

}
