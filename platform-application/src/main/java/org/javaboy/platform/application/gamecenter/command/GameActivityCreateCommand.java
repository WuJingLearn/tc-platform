package org.javaboy.platform.application.gamecenter.command;

import java.util.Date;

/**
 * @author:majin.wj
 */
public class GameActivityCreateCommand {


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
