package org.javaboy.platform.domain.gamecenter.service.impl;

import org.javaboy.platform.domain.gamecenter.model.entity.GameActivity;
import org.javaboy.platform.domain.gamecenter.repository.GameActivityRepository;
import org.javaboy.platform.domain.gamecenter.service.GameActivityDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public GameActivity queryGameActivity(String activityName) {
        return gameActivityRepository.queryGameActivity(activityName);
    }
}
