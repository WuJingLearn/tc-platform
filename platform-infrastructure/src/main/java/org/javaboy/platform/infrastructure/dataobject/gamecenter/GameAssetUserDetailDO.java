package org.javaboy.platform.infrastructure.dataobject.gamecenter;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * @author:majin.wj
 */
@TableName("user_asset_detail")
@Data
public class GameAssetUserDetailDO {
    Long id;
    private String assetCode;
    private String assetName;
    private String url;
    private Long amount;
    private Long uid;
}
