package org.javaboy.platform.application.gamecenter.model.config;

import lombok.Data;

/**
 * @author:majin.wj
 */
@Data
public class AwardConfig {

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
     * 兑换条件
     */
    private ExchangeConfig exchangeConfig;

    /**
     * 疲劳度/兑换周期
     */
    private FatigueConfig fatigueConfig;

    /**
     * 库存配置
     */
    private InventoryConfig inventoryConfig;

}
