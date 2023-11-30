package org.javaboy.platform.domain.gamecenter.service;

import org.javaboy.platform.domain.gamecenter.model.entity.AssetUserDetail;
import org.javaboy.platform.domain.gamecenter.model.entity.GameAsset;

import java.rmi.server.UID;
import java.util.List;

/**
 * @author:majin.wj
 */
public interface GameAssetDomainService {


    /**
     * 场景道具
     * @param gameAsset
     * @return
     */
    boolean createGameAsset(GameAsset gameAsset);


    /**
     * 查询道具
     * @return
     */
    List<GameAsset> queryAllGameAsset();

    /**
     * 给用户发放道具
     * @param userDetail
     * @return
     */
     boolean addUserAsset(AssetUserDetail userDetail);

    /**
     * 查询用户道具
     * @param uid
     * @return
     */
     List<AssetUserDetail> queryUserAsset(Long uid);


}
