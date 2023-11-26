package org.javaboy.platform.domain.gamecenter.service.impl;

import org.javaboy.platform.domain.gamecenter.model.entity.GameAsset;
import org.javaboy.platform.domain.gamecenter.repository.GameAssetRepository;
import org.javaboy.platform.domain.gamecenter.service.GameAssetDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:majin.wj
 */
@Service
public class GameAssetDomainServiceImpl implements GameAssetDomainService {

    @Autowired
    private GameAssetRepository gameAssetRepository;

    @Override
    public boolean createGameAsset(GameAsset gameAsset) {
        return gameAssetRepository.createGameAsset(gameAsset);
    }

    @Override
    public List<GameAsset> queryAllGameAsset() {
        return gameAssetRepository.queryAllGameAsset();
    }
}
