package org.javaboy.platform.infrastructure.dataobject.gamecenter;

import lombok.Data;

/**
 * @author:majin.wj
 */
@Data
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
