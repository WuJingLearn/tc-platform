package org.javaboy.platform.domain.seckill.service;

import org.javaboy.platform.domain.seckill.model.entity.SeckillActivity;

/**
 * @author:majin.wj
 */
public interface SeckillActivityDomainService {
    void saveSeckillActivity(SeckillActivity seckillActivity);

    void publishSeckillActivity(Long activityId);

    SeckillActivity getSeckillActivityById(Long activityId);
}
