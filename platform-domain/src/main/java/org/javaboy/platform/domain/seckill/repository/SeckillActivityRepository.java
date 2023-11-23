package org.javaboy.platform.domain.seckill.repository;

import org.javaboy.platform.domain.seckill.model.entity.SeckillActivity;

/**
 * @author:majin.wj
 */
public interface SeckillActivityRepository {

    int saveSeckillActivity(SeckillActivity seckillActivity);

    int updateSeckllActivity(SeckillActivity seckillActivity);

    SeckillActivity getSeckilllActivityById(Long activityId);

}
