package org.javaboy.platform.application.gamecenter.model.request;

import lombok.Data;

/**
 * @author:majin.wj
 *
 * 兑换活动奖励配置；
 */
@Data
public class GameActivityAwardConfigCreateCommand {

    private Long activityId;

    /**
     * 道具名称
     */
    private String assetName;
    /**
     * 道具码
     */
    private String assetCode;

    /**
     * 道具图片
     */
    private String url;

    /**
     * 道具数量
     */
    private Integer amount;

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
