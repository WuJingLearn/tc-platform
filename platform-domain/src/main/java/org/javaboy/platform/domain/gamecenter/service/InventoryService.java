package org.javaboy.platform.domain.gamecenter.service;

import org.javaboy.platform.domain.gamecenter.model.config.InventoryConfig;

/**
 * @author:majin.wj
 */
public interface InventoryService {


    /**
     * 初始化库存
     * @param inventoryConfig
     * @param awardCode
     */
    public void init(InventoryConfig inventoryConfig,String activityName,String awardCode);

    /**
     * 查询库存
     * @param activityName
     * @param awardCode
     * @return
     */
    Long queryInventory(String activityName,String awardCode);

    /**
     * 增加库存
     * @param activityName
     * @param awardCode
     * @param amount
     */
    void incrInventory(String activityName,String awardCode,Long amount);

    /**
     * 扣减哭粗门
     * @param activityName
     * @param awardCode
     * @param amount
     */
    void decrInventory(String activityName,String awardCode,Long amount);

}
