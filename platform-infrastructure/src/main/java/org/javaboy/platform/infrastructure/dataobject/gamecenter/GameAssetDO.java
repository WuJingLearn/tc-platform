package org.javaboy.platform.infrastructure.dataobject.gamecenter;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * @author:majin.wj
 */
@Data
@TableName("game_asset")
public class GameAssetDO {

    private Long id;

    /**
     * 道具名称
     */
    private String assetName;
    /**
     * 道具code
     */
    private String assetCode;

    /**
     * 道具图片
     */
    private String url;

}
