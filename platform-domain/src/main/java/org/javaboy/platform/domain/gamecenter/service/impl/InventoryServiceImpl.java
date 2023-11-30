package org.javaboy.platform.domain.gamecenter.service.impl;

import org.javaboy.platform.domain.gamecenter.model.config.InventoryConfig;
import org.javaboy.platform.domain.gamecenter.service.InventoryService;
import org.springframework.stereotype.Service;

/**
 * @author:majin.wj
 */
@Service
public class InventoryServiceImpl implements InventoryService {
    @Override
    public void init(InventoryConfig inventoryConfig, String activityName, String awardCode) {

    }

    @Override
    public Long queryInventory(String activityName, String awardCode) {
        return null;
    }

    @Override
    public void incrInventory(String activityName, String awardCode, Long amount) {

    }

    @Override
    public void decrInventory(String activityName, String awardCode, Long amount) {

    }
}
