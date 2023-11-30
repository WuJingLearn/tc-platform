package org.javaboy.platform.domain.gamecenter.model.config;

import lombok.Data;

/**
 * @author:majin.wj
 * 兑换配置
 */
@Data
public class ExchangeConfig {

    /**
     * 兑换类型，暂时就是point积分
     */
    private String type;

    private Long amount;

}
