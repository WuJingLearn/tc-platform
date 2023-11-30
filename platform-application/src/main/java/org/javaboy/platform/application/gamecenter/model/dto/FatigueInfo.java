package org.javaboy.platform.application.gamecenter.model.dto;

import lombok.Data;

/**
 * @author:majin.wj
 * 疲劳度
 */
@Data
public class FatigueInfo {

    /**
     * 是否到达限制
     */
    private boolean reachLimit;

    private String desc;

    /**
     * 当前进度
     */
    private int cur;

    /**
     * 限制次数
     */
    private int limit;

}
