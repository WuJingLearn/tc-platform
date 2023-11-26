package org.javaboy.platform.infrastructure.repository.gamecenter;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.rocketmq.common.filter.impl.Op;
import org.javaboy.platform.domain.gamecenter.model.entity.GameActivity;
import org.javaboy.platform.domain.gamecenter.repository.GameActivityRepository;
import org.javaboy.platform.infrastructure.dao.gamecenter.GameActivityMapper;
import org.javaboy.platform.infrastructure.dataobject.gamecenter.GameActivityDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author:majin.wj
 */
@Repository
public class GameActivityRepositoryImpl implements GameActivityRepository {

    @Autowired
    private GameActivityMapper gameActivityMapper;

    @Override
    public boolean createGameActivity(GameActivity gameActivity) {
        GameActivityDO gameActivityDO = new GameActivityDO();
        BeanUtils.copyProperties(gameActivity, gameActivityDO);
        return gameActivityMapper.insert(gameActivityDO) == 1;
    }

    @Override
    public GameActivity queryGameActivity(String activityName) {
        HashMap<String, Object> queryParams = new HashMap<>();
        queryParams.put("activityName", activityName);
        List<GameActivityDO> gameActivityDO = gameActivityMapper.selectByMap(queryParams);
        if (CollectionUtils.isNotEmpty(gameActivityDO)) {
            GameActivity gameActivity = new GameActivity();
            BeanUtils.copyProperties(gameActivityDO.get(0), gameActivity);
            return gameActivity;
        }
        return null;
    }
}
