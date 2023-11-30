package org.javaboy.platform.application.gamecenter.model.dto;

import lombok.Data;

/**
 * @author:majin.wj
 * 兑换条件
 */
@Data
public class ExchangeInfo {

    /**
     * 兑换条件类型，目前就是积分
     */
    private String type;

    /**
     * 需要的积分数额
     */
    private int amount;

    /**
     * 用户是否到达
     */
    private boolean reach;

    /**
     * 免费兑换
     */
    private String desc;
}
