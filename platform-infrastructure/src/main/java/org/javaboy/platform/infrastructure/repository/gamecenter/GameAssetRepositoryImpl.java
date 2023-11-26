package org.javaboy.platform.infrastructure.repository.gamecenter;

import org.javaboy.platform.domain.gamecenter.model.entity.GameAsset;
import org.javaboy.platform.domain.gamecenter.repository.GameAssetRepository;
import org.javaboy.platform.infrastructure.dao.gamecenter.GameAssetMapper;
import org.javaboy.platform.infrastructure.dataobject.gamecenter.GameAssetDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:majin.wj
 */
@Repository
public class GameAssetRepositoryImpl implements GameAssetRepository {

    @Autowired
    private GameAssetMapper gameAssetMapper;


    @Override
    public boolean createGameAsset(GameAsset gameAsset) {
        GameAssetDO gameAssetDO = new GameAssetDO();
        BeanUtils.copyProperties(gameAsset, gameAssetDO);
        return gameAssetMapper.insert(gameAssetDO) == 1;
    }

    @Override
    public List<GameAsset> queryAllGameAsset() {
        List<GameAssetDO> gameAssetDOS = gameAssetMapper.selectList(null);
        List<GameAsset> result = new ArrayList<>();
        if (gameAssetDOS != null) {
            for (GameAssetDO gameAssetDO : gameAssetDOS) {
                GameAsset gameAsset = new GameAsset();
                BeanUtils.copyProperties(gameAssetDO, gameAsset);
                result.add(gameAsset);
            }
        }
        return result;

    }
}
