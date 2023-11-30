package org.javaboy.platform.infrastructure.redis;

import org.javaboy.platform.domain.infra.redis.DistributedCacheService;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author:majin.wj
 */
@Component
public class RedissionDistributedService implements DistributedCacheService {

    @Override
    public void put(String key, String value) {


    }

    @Override
    public void put(String key, Object value) {

    }

    @Override
    public void put(String key, Object value, long timeout, TimeUnit unit) {

    }

    @Override
    public void put(String key, Object value, long expireTime) {

    }

    @Override
    public <T> T getObject(String key, Class<T> targetClass) {
        return null;
    }

    @Override
    public Object getObject(String key) {
        return null;
    }

    @Override
    public String getString(String key) {
        return null;
    }

    @Override
    public <T> List<T> getList(String key, Class<T> targetClass) {
        return null;
    }

    @Override
    public Boolean delete(String key) {
        return null;
    }

    @Override
    public Boolean deleteKeyPrefix(String prefix) {
        return null;
    }

    @Override
    public Boolean hasKey(String key) {
        return null;
    }

    @Override
    public Long addSet(String key, Object... values) {
        return null;
    }

    @Override
    public Long removeSet(String key, Object... values) {
        return null;
    }

    @Override
    public Boolean isMemberSet(String key, Object o) {
        return null;
    }
}
