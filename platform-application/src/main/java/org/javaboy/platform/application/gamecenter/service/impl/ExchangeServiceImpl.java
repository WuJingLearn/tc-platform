package org.javaboy.platform.application.gamecenter.service.impl;

import org.apache.commons.lang3.tuple.Pair;
import org.javaboy.common.utils.exception.BizException;
import org.javaboy.platform.application.gamecenter.model.dto.*;
import org.javaboy.platform.application.gamecenter.model.request.ExchangeRequest;
import org.javaboy.platform.application.gamecenter.service.ExchangeService;
import org.javaboy.platform.application.gamecenter.service.GameActivityConfigService;
import org.javaboy.platform.domain.gamecenter.context.GameExchangeContext;
import org.javaboy.platform.domain.gamecenter.model.config.AwardConfig;
import org.javaboy.platform.domain.gamecenter.model.config.ExchangeConfig;
import org.javaboy.platform.domain.gamecenter.model.config.GameActivityConfig;
import org.javaboy.platform.domain.gamecenter.model.config.InventoryConfig;
import org.javaboy.platform.domain.gamecenter.service.FatigueService;
import org.javaboy.platform.domain.gamecenter.service.InventoryService;
import org.javaboy.platform.domain.gamecenter.service.impl.GamePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author:majin.wj
 */
@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private GameActivityConfigService activityConfigService;

    @Autowired
    private GamePointService gamePointService;

    @Autowired
    private FatigueService fatigueService;

    @Autowired
    private InventoryService inventoryService;

    @Override
    public ExchangeActivityDTO preview(String activityName, Long uid) {
        GameExchangeContext context = buildContext(activityName, uid);
        ExchangeActivityDTO exchangeActivityDTO = new ExchangeActivityDTO();
        exchangeActivityDTO.setActivityName(activityName);
        exchangeActivityDTO.setStartTime(context.getGameActivityConfig().getStartTime());
        exchangeActivityDTO.setEndTime(context.getGameActivityConfig().getEndTime());
        // 用户个人积分
        Long userPoint = gamePointService.queryPoint(uid);
        exchangeActivityDTO.setPoint(userPoint);
        // 获取每个奖励兑换次数情况
        Map<String, Pair<Integer, Integer>> stringPairMap = fatigueService.checkAwardFatigue(context);
        List<ExchangeAwardDTO> exchangeAwardDTOList = new ArrayList<>();
        for (AwardConfig awardConfig : context.getGameActivityConfig().getAwardConfigs()) {
            ExchangeAwardDTO exchangeAwardDTO = new ExchangeAwardDTO();
            exchangeAwardDTO.setAwardCode(awardConfig.getAwardCode());
            exchangeAwardDTO.setUrl(awardConfig.getUrl());
            exchangeAwardDTO.setAssetCode(awardConfig.getAssetCode());
            // 兑换信息
            ExchangeInfo exchangeInfo = new ExchangeInfo();
            ExchangeConfig exchangeConfig = awardConfig.getExchangeConfig();
            if (exchangeConfig == null) {
                exchangeInfo.setReach(true);
                exchangeInfo.setDesc("免费兑换");
            } else {
                exchangeInfo.setAmount(exchangeInfo.getAmount());
                exchangeInfo.setReach(userPoint >= exchangeInfo.getAmount());
                exchangeInfo.setDesc(userPoint >= exchangeInfo.getAmount() ? "可兑换" : "积分不足");
            }
            exchangeAwardDTO.setExchangeInfo(exchangeInfo);
            // 疲劳度信息
            FatigueInfo fatigueInfo = new FatigueInfo();
            Pair<Integer, Integer> fatiguePair = stringPairMap.get(awardConfig.getAwardCode());
            if (fatiguePair == null) {
                fatigueInfo.setReachLimit(false);
                fatigueInfo.setDesc("无限制兑换");
            } else {
                fatigueInfo.setCur(fatiguePair.getLeft());
                fatigueInfo.setLimit(fatiguePair.getRight());
                fatigueInfo.setReachLimit(fatiguePair.getLeft() >= fatiguePair.getRight());
            }
            exchangeAwardDTO.setFatigueInfo(fatigueInfo);
            // 库存配置
            InventoryConfig inventoryConfig = awardConfig.getInventoryConfig();
            InventoryInfo inventoryInfo = new InventoryInfo();
            if (inventoryConfig == null) {
                inventoryInfo.setUseInventory(false);
            }else {
                inventoryInfo.setUseInventory(true);
                Long amount = inventoryService.queryInventory(activityName, awardConfig.getAwardCode());
                inventoryInfo.setAmount(amount);
            }
            exchangeAwardDTO.setInventoryInfo(inventoryInfo);
            exchangeAwardDTOList.add(exchangeAwardDTO);
        }
        exchangeActivityDTO.setAwardDTOList(exchangeAwardDTOList);
        return exchangeActivityDTO;
    }

    @Override
    public ExchangeAwardDTO exchange(ExchangeRequest request) {
        return null;
    }


    private GameExchangeContext buildContext(String activityName, Long uid) {
        GameActivityConfig activityConfig = activityConfigService.getActivityConfig(activityName);
        if (activityConfig == null) {
            throw new BizException("兑换活动" + activityName + ",不存在");
        }
        GameExchangeContext context = new GameExchangeContext();
        context.setUid(uid);
        context.setGameActivityConfig(activityConfig);
        return context;
    }


}
