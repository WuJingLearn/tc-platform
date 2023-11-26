package org.javaboy.platform.domain.gamecenter.repository;

import org.javaboy.platform.domain.gamecenter.model.entity.GameAsset;

import java.util.List;

/**
 * @author:majin.wj
 *
 */
public interface GameAssetRepository {


    public boolean createGameAsset(GameAsset gameAsset);

    List<GameAsset> queryAllGameAsset();
}
