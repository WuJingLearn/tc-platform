package org.javaboy.platform.infrastructure.dataobject.gamecenter;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * @author:majin.wj
 */
@Data
@TableName("game_activity_award")
public class GameActivityAwardDO {

    private Long id;

    /**
     * 道具名称
     */
    private String assetName;

    /**
     * 道具码
     */
    private String assetCode;

    private String awardCode;

    /**
     * 道具图片
     */
    private String url;

    /**
     * 关联的活动id
     */
    private Long activityId;

    /**
     * 兑换配置,兑换这个道具需要消耗的用户个人资产
     */
    private String exchangeConfig;

    /**
     * 疲劳度配置,兑换次数
     */
    private String fatigueConfig;

    /**
     * 库存配置；该商品的库存；
     */
    private String inventoryConfig;
}
