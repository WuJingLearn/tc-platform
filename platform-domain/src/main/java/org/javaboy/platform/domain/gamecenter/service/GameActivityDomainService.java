package org.javaboy.platform.domain.gamecenter.service;

import org.javaboy.platform.domain.gamecenter.model.entity.GameActivity;
import org.javaboy.platform.domain.gamecenter.model.entity.GameActivityAward;

import java.util.List;
import java.util.Map;

/**
 * @author:majin.wj
 */
public interface GameActivityDomainService {


    boolean createGameActivity(GameActivity gameActivity);

    GameActivity queryGameActivity(Map<String,Object> queryParams);

    boolean addActivityAward(GameActivityAward activityAward);

    List<GameActivityAward> queryActivityAwards(Long activityId);

}
