package org.javaboy.platform.domain.gamecenter.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author:majin.wj
 */
@Data
public class GameActivity {

    private String activityName;

    private String activityDesc;

    /**
     * 活动类型:
     * 0: 兑换
     * 1: 抽奖
     */
    private int type;

    private Date startTime;

    private Date endTime;

}
