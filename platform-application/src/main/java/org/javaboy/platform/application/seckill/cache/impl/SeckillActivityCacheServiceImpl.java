package org.javaboy.platform.application.seckill.cache.impl;

import com.alibaba.fastjson.JSON;
import org.javaboy.common.cache.model.PlatformBusinessCache;
import org.javaboy.common.utils.PlatformConstants;
import org.javaboy.common.utils.SystemClock;
import org.javaboy.platform.application.seckill.cache.SeckillActivityCacheService;
import org.javaboy.platform.domain.infra.redis.DistributedCacheService;
import org.javaboy.platform.domain.infra.redis.lock.DistributedLock;
import org.javaboy.platform.domain.infra.redis.lock.DistributedLockFactory;
import org.javaboy.platform.domain.seckill.model.entity.SeckillActivity;
import org.javaboy.platform.domain.seckill.service.SeckillActivityDomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author:majin.wj
 */
@Service
public class SeckillActivityCacheServiceImpl implements SeckillActivityCacheService {

    private static final Logger LOG = LoggerFactory.getLogger(SeckillActivityCacheService.class);

    private static final String UPDATE_CACHE_KEY = "seckill_activity_update_lock_key_%s";

    private static final String SECKILL_ACTIVITY_CACHE_KEY = "seckill_activity_cache_key_%s";

    @Autowired
    private DistributedLockFactory distributedLockFactory;

    @Autowired
    private DistributedCacheService distributedCacheService;

    @Autowired
    private SeckillActivityDomainService seckillActivityDomainService;

    @Override
    public PlatformBusinessCache<SeckillActivity> getCachedSeckillActivity(Long activityId, Long version) {
        return null;
    }

    @Override
    public PlatformBusinessCache<SeckillActivity> tryUpdateSeckillActivityCacheByLock(Long activityId, boolean doubleCheck) {
        DistributedLock lock = distributedLockFactory.getLock(String.format(UPDATE_CACHE_KEY, activityId));
        try {
            boolean getLocked = lock.tryLock(1, 5, TimeUnit.SECONDS);
            // 为获取到锁，直接返回,上游咨询决定是否重试
            if (!getLocked) {
                return new PlatformBusinessCache<SeckillActivity>().retryLater();
            }
            PlatformBusinessCache<SeckillActivity> seckillActivityCache;
            SeckillActivity seckillActivity = seckillActivityDomainService.getSeckillActivityById(activityId);

            if (seckillActivity == null) {
                seckillActivityCache =  new PlatformBusinessCache<SeckillActivity>().notExist();
            }else {
                seckillActivityCache = new PlatformBusinessCache<SeckillActivity>().with(seckillActivity).withVersion(SystemClock.millisClock().now());
            }
            distributedCacheService.put(buildCacheKey(activityId), JSON.toJSONString(seckillActivityCache), PlatformConstants.FIVE_MINUTES);
            LOG.info("SeckillActivityCache|分布式缓存已经更新|{}", activityId);
            return seckillActivityCache;
        } catch (InterruptedException e) {
            LOG.error("SeckillActivityCache|更新分布式缓存失败|{}", activityId);
            return new PlatformBusinessCache<SeckillActivity>().retryLater();
        } finally {
            lock.unlock();
        }

    }

    private String buildCacheKey(Long activityId){
        return String.format(SECKILL_ACTIVITY_CACHE_KEY,activityId);
    }
}
