package org.javaboy.platform.domain.gamecenter.model.entity;

import lombok.Data;

/**
 * @author:majin.wj
 * 用户道具
 */
@Data
public class AssetUserDetail {

    private String assetCode;
    private String assetName;
    private String url;
    private Long amount;
    private Long uid;

}
