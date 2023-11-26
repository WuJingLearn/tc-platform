package org.javaboy.platform.domain.gamecenter.model.entity;

import lombok.Data;

/**
 * @author:majin.wj
 * 道具的功能可以更加丰富, 比如道具的叠加属性, 道具的有效期。
 * 在抽象兑换里就当作是一个物品就好；
 */
@Data
public class GameAsset {

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
