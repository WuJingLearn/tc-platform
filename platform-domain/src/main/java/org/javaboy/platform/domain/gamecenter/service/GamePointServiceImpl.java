package org.javaboy.platform.domain.gamecenter.service;

import org.javaboy.platform.domain.gamecenter.service.impl.GamePointService;
import org.springframework.stereotype.Service;

/**
 * @author:majin.wj
 * 积分系统
 */
@Service
public class GamePointServiceImpl implements GamePointService {

    @Override
    public boolean addPoint(Long userId, Long amount) {
        return false;
    }

    @Override
    public Long queryPoint(Long userId) {
        return null;
    }

    @Override
    public boolean deductPoint(Long userId, Long amount) {
        return false;
    }
}
