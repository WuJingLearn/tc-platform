package org.javaboy.platform.domain.gamecenter.repository;


import org.javaboy.platform.domain.gamecenter.model.entity.GameActivity;
import org.javaboy.platform.domain.gamecenter.model.entity.GameActivityAward;

import java.util.List;
import java.util.Map;

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
     * @param queryParams
     * @return
     */
    GameActivity queryGameActivity(Map<String,Object> queryParams);

    /**
     * 添加活动奖励
     * @param activityAward
     * @return
     */
    boolean addActivityAward(GameActivityAward activityAward);

    /**
     * 查询活动奖励
     * @param activityId
     * @return
     */
    List<GameActivityAward> queryActivityAwards(Long activityId);

}
