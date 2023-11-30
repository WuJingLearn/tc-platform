package org.javaboy.platform.domain.gamecenter.service.impl;

import org.javaboy.platform.domain.gamecenter.model.entity.AssetUserDetail;
import org.javaboy.platform.domain.gamecenter.model.entity.GameAsset;
import org.javaboy.platform.domain.gamecenter.repository.GameAssetRepository;
import org.javaboy.platform.domain.gamecenter.service.GameAssetDomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:majin.wj
 */
@Service
public class GameAssetDomainServiceImpl implements GameAssetDomainService {

    private static final Logger LOG = LoggerFactory.getLogger(GameAssetDomainService.class);

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

    @Override
    public boolean addUserAsset(AssetUserDetail userDetail) {
        try {
            return gameAssetRepository.addUserAsset(userDetail);
        } catch (Exception e) {
            LOG.error("添加用户道具失败|{}", e.getMessage());
            return false;
        }

    }

    @Override
    public List<AssetUserDetail> queryUserAsset(Long uid) {
        return null;
    }
}
