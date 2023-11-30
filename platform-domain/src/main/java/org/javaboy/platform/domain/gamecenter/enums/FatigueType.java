package org.javaboy.platform.domain.gamecenter.enums;

/**
 * @author:majin.wj
 * 疲劳度类型
 */
public enum FatigueType {

    DAILY("DAILY"),PERIOD("PERIOD");


    private String type;

    private FatigueType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
