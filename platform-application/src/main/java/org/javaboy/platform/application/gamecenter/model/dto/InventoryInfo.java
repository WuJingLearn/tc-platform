package org.javaboy.platform.application.gamecenter.model.dto;

import lombok.Data;

/**
 * @author:majin.wj
 * 库存
 */
@Data
public class InventoryInfo {

    /**
     * 是否使用库存
     */
    private boolean useInventory;

    /**
     * 剩余库存
     */
    private Long amount;

}
