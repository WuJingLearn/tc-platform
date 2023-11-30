package org.javaboy.platform.infrastructure.repository.gamecenter;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.apache.rocketmq.common.filter.impl.Op;
import org.javaboy.common.utils.DebugLogger;
import org.javaboy.platform.domain.gamecenter.model.entity.AssetUserDetail;
import org.javaboy.platform.domain.gamecenter.model.entity.GameAsset;
import org.javaboy.platform.domain.gamecenter.repository.GameAssetRepository;
import org.javaboy.platform.infrastructure.dao.gamecenter.GameAssetMapper;
import org.javaboy.platform.infrastructure.dao.gamecenter.GameAssetUserDetailMapper;
import org.javaboy.platform.infrastructure.dataobject.gamecenter.GameAssetDO;
import org.javaboy.platform.infrastructure.dataobject.gamecenter.GameAssetUserDetailDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author:majin.wj
 */
@Repository
public class GameAssetRepositoryImpl implements GameAssetRepository {

    @Autowired
    private GameAssetMapper gameAssetMapper;

    @Autowired
    private GameAssetUserDetailMapper gameAssetUserDetailMapper;


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

    @Override
    public boolean addUserAsset(AssetUserDetail userDetail) {
        GameAssetUserDetailDO gameAssetUserDetailDO = new GameAssetUserDetailDO();
        BeanUtils.copyProperties(userDetail, gameAssetUserDetailDO);

        int result = gameAssetUserDetailMapper.addUserAsset(userDetail.getUid(), userDetail.getAssetCode(), userDetail.getAmount());
        if (result != 1) {
            gameAssetUserDetailMapper.insert(gameAssetUserDetailDO);
        }
        return true;
    }

    @Override
    public List<AssetUserDetail> queryUserAsset(Long uid) {
        Wrapper<GameAssetUserDetailDO> queryCondition = new Condition().eq("uid", uid);
        List<GameAssetUserDetailDO> gameAssetUserDetailDOS = gameAssetUserDetailMapper.selectList(queryCondition);
        return Optional.ofNullable(gameAssetUserDetailDOS).orElse(Collections.emptyList()).stream().map(DO -> {
            AssetUserDetail assetUserDetail = new AssetUserDetail();
            BeanUtils.copyProperties(DO, assetUserDetail);
            return assetUserDetail;
        }).collect(Collectors.toList());
    }
}
