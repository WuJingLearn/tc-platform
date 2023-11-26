package org.javaboy.platform.domain.gamecenter.service.impl;

import org.javaboy.platform.domain.gamecenter.model.entity.GameActivity;
import org.javaboy.platform.domain.gamecenter.model.entity.GameActivityAward;
import org.javaboy.platform.domain.gamecenter.repository.GameActivityRepository;
import org.javaboy.platform.domain.gamecenter.service.GameActivityDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author:majin.wj
 */
@Service
public class GameActivityDomainServiceImpl implements GameActivityDomainService {

    @Autowired
    private GameActivityRepository gameActivityRepository;

    @Override
    public boolean createGameActivity(GameActivity gameActivity) {
        return gameActivityRepository.createGameActivity(gameActivity);
    }

    @Override
    public GameActivity queryGameActivity(Map<String,Object> queryParams) {
        return gameActivityRepository.queryGameActivity(queryParams);
    }

    @Override
    public boolean addActivityAward(GameActivityAward activityAward) {
        return gameActivityRepository.addActivityAward(activityAward);
    }

    @Override
    public List<GameActivityAward> queryActivityAwards(Long activityId) {
        return gameActivityRepository.queryActivityAwards(activityId);
    }
}
