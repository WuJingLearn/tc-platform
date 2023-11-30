package org.javaboy.platform.domain.gamecenter.model.config;

import lombok.Data;

/**
 * @author:majin.wj
 */
@Data
public class InventoryConfig {

    /**
     * 库存类型
     */
    private String type;

    /**
     * 库存数量
     */
    private Long amount;

}
