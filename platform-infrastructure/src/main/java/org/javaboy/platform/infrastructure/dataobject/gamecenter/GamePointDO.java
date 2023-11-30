package org.javaboy.platform.infrastructure.dataobject.gamecenter;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * @author:majin.wj
 */
@Data
@TableName("game_point")
public class GamePointDO {

    private Long id;

    private Long uid;

    private Long amount;
}
