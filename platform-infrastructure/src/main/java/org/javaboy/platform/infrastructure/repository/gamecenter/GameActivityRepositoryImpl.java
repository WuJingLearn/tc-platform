package org.javaboy.platform.infrastructure.repository.gamecenter;

import org.apache.commons.collections4.CollectionUtils;
import org.javaboy.platform.domain.gamecenter.model.entity.GameActivity;
import org.javaboy.platform.domain.gamecenter.model.entity.GameActivityAward;
import org.javaboy.platform.domain.gamecenter.repository.GameActivityRepository;
import org.javaboy.platform.infrastructure.dao.gamecenter.GameActivityAwardMapper;
import org.javaboy.platform.infrastructure.dao.gamecenter.GameActivityMapper;
import org.javaboy.platform.infrastructure.dataobject.gamecenter.GameActivityAwardDO;
import org.javaboy.platform.infrastructure.dataobject.gamecenter.GameActivityDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author:majin.wj
 */
@Repository
public class GameActivityRepositoryImpl implements GameActivityRepository {

    @Autowired
    private GameActivityMapper gameActivityMapper;

    @Autowired
    private GameActivityAwardMapper gameActivityAwardMapper;

    @Override
    public boolean createGameActivity(GameActivity gameActivity) {
        GameActivityDO gameActivityDO = new GameActivityDO();
        BeanUtils.copyProperties(gameActivity, gameActivityDO);
        return gameActivityMapper.insert(gameActivityDO) == 1;
    }

    @Override
    public GameActivity queryGameActivity(Map<String, Object> queryParams) {
        List<GameActivityDO> gameActivityDO = gameActivityMapper.selectByMap(queryParams);
        if (CollectionUtils.isNotEmpty(gameActivityDO)) {
            GameActivity gameActivity = new GameActivity();
            BeanUtils.copyProperties(gameActivityDO.get(0), gameActivity);
            return gameActivity;
        }
        return null;
    }

    @Override
    public boolean addActivityAward(GameActivityAward activityAward) {
        GameActivityAwardDO gameActivityAwardDO = new GameActivityAwardDO();
        BeanUtils.copyProperties(activityAward, gameActivityAwardDO);
        return gameActivityAwardMapper.insert(gameActivityAwardDO) == 1;
    }

    @Override
    public List<GameActivityAward> queryActivityAwards(Long activityId) {
        HashMap<String, Object> queryParams = new HashMap<>();
        queryParams.put("activityId", activityId);
        List<GameActivityAwardDO> gameActivityAwardDOS = gameActivityAwardMapper.selectByMap(queryParams);
        return Optional.ofNullable(gameActivityAwardDOS).orElse(Collections.emptyList()).stream().map(DO -> {
            GameActivityAward gameActivityAward = new GameActivityAward();
            BeanUtils.copyProperties(DO, gameActivityAward);
            return gameActivityAward;
        }).collect(Collectors.toList());

    }
}
