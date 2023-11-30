package org.javaboy.platform.infrastructure.dao.gamecenter;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.javaboy.platform.infrastructure.dataobject.gamecenter.GamePointDO;

/**
 * @author:majin.wj
 */
public interface GamePointMapper extends BaseMapper<GamePointDO> {

    int addUserPoint(@Param("uid") Long uid, @Param("amount") Long amount);

    int deductUserPoint(@Param("uid") Long uid, @Param("amount") Long amount);


}
