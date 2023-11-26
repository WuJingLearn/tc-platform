package org.javaboy.platform.application.gamecenter.service;

import org.javaboy.platform.application.gamecenter.command.GameActivityAwardConfigCreateCommand;
import org.javaboy.platform.application.gamecenter.command.GameActivityCreateCommand;

/**
 * @author:majin.wj
 * 活动接口
 */
public interface GameActivityService {


    /**
     * 创建活动
     * @param activityCreateCommand
     * @return
     */
    boolean createGameActivity(GameActivityCreateCommand activityCreateCommand);

    /**
     * 添加活动奖励信息
     * @param activityAwardConfigCreateCommand
     * @return
     */

    boolean addGameActivityAwardConfig(GameActivityAwardConfigCreateCommand activityAwardConfigCreateCommand);

}
