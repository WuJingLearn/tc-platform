package org.javaboy.platform.application.seckill.cache;

import org.javaboy.common.cache.model.PlatformBusinessCache;
import org.javaboy.platform.domain.seckill.model.entity.SeckillActivity;

/**
 * @author:majin.wj
 */
public interface SeckillActivityCacheService {

    PlatformBusinessCache<SeckillActivity> getCachedSeckillActivity(Long activityId, Long version);


    PlatformBusinessCache<SeckillActivity> tryUpdateSeckillActivityCacheByLock(Long activityId, boolean doubleCheck);


}
