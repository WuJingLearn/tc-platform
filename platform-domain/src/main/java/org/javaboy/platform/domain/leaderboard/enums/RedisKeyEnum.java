package org.javaboy.platform.domain.leaderboard.enums;

/**
 * @author:majin.wj
 */
public enum RedisKeyEnum {

    REDIS_KEY_ENUM("programing_")
    ;

    private String key;

    private RedisKeyEnum(String key){
        this.key = key;
    }



}
