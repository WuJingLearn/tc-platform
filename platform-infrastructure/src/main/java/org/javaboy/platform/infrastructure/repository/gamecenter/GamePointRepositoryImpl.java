package org.javaboy.platform.infrastructure.repository.gamecenter;

import org.apache.commons.collections4.CollectionUtils;
import org.javaboy.platform.domain.gamecenter.repository.GamePointRepository;
import org.javaboy.platform.infrastructure.dao.gamecenter.GamePointMapper;
import org.javaboy.platform.infrastructure.dataobject.gamecenter.GamePointDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author:majin.wj
 */
@Repository
public class GamePointRepositoryImpl implements GamePointRepository {

    @Autowired
    private GamePointMapper gamePointMapper;

    @Override
    public boolean addPoint(Long userId, Long amount) {
        int i = gamePointMapper.addUserPoint(userId, amount);
        // 初始化分数
        if (i == 0) {
            GamePointDO gamePointDO = new GamePointDO();
            gamePointDO.setUid(userId);
            gamePointDO.setAmount(amount);
            gamePointMapper.insert(gamePointDO);
        }
        return true;
    }

    @Override
    public Long queryPoint(Long userId) {
        HashMap<String, Object> queryParams = new HashMap<>();
        queryParams.put("uid", userId);
        List<GamePointDO> gamePointDOS = gamePointMapper.selectByMap(queryParams);
        if (CollectionUtils.isNotEmpty(gamePointDOS)) {
            return gamePointDOS.get(0).getAmount();
        }
        return 0L;
    }

    @Override
    public boolean deductPoint(Long userId, Long amount) {
        return gamePointMapper.deductUserPoint(userId, amount) == 1;
    }
}
