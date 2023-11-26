package org.javaboy.platform.domain.gamecenter.model.entity;

/**
 * @author:majin.wj
 * 活动奖励;兑换配置信息，疲劳度信息，库存信息以json的方式存放在数据库中
 */
public class GameActivityAward {

    private Long activityId;

    /**
     * 奖励信息
     */
    private String assetName;
    /**
     * 道具码
     */
    private String assetCode;

    private String url;

    /**
     * 兑换配置,兑换这个道具需要消耗的用户个人资产
     */
    private String exchangeConfig;

    /**
     * 疲劳度配置,兑换次数
     */
    private String fatigueConfig;

    /**
     * 库存配置；该商品的库存；
     */
    private String inventoryConfig;
}
