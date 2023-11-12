package org.javaboy.platform.domain.leaderboard.enums;

/**
 * @author:majin.wj 排行榜周期
 */
public enum Period {
    DAY("day"), WEAK("weak"), CUSTOM("custom");

    private String period;

    private Period(String period) {
        this.period = period;
    }

    public static boolean isCustom(String type) {
        return CUSTOM.period.equals(type);
    }
}
