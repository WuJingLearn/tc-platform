package org.javaboy.platform.domain.gamecenter.repository;


import org.javaboy.platform.domain.gamecenter.model.entity.GameActivity;

/**
 * @author:majin.wj
 */
public interface GameActivityRepository {

    /**
     * 创建游戏活动
     * @param gameActivity
     * @return
     */
    boolean createGameActivity(GameActivity gameActivity);

    /**
     * 查询游戏活动
     * @param activityName
     * @return
     */
    GameActivity queryGameActivity(String activityName);

}
