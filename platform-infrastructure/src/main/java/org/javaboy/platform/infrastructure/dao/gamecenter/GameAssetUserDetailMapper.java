package org.javaboy.platform.infrastructure.dao.gamecenter;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.javaboy.platform.infrastructure.dataobject.gamecenter.GameAssetUserDetailDO;

/**
 * @author:majin.wj
 */
public interface GameAssetUserDetailMapper extends BaseMapper<GameAssetUserDetailDO> {


    int addUserAsset(@Param("uid") Long uid, @Param("assetCode") String assetCode, @Param("amount") Long amount);

}
