package org.javaboy.platform.application.gamecenter.model.dto;

import lombok.Data;

/**
 * @author:majin.wj
 */
@Data
public class ExchangeAwardDTO {

    private String awardCode;
    private String assetCode;
    private String url;

    /**
     * 兑换条件展示
     */
    private ExchangeInfo exchangeInfo;

    private FatigueInfo fatigueInfo;

    private InventoryInfo inventoryInfo;


}
