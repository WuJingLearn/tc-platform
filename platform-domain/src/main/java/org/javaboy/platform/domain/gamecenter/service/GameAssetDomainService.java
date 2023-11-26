package org.javaboy.platform.domain.gamecenter.service;

import org.javaboy.platform.domain.gamecenter.model.entity.GameAsset;

import java.util.List;

/**
 * @author:majin.wj
 */
public interface GameAssetDomainService {


    boolean createGameAsset(GameAsset gameAsset);


    List<GameAsset> queryAllGameAsset();


}
