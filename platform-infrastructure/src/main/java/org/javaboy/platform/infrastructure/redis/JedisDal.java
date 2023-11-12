package org.javaboy.platform.infrastructure.redis;

import org.javaboy.platform.domain.infra.redis.RedisDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * @author:majin.wj
 */
@Component
public class JedisDal implements RedisDal {

    @Autowired
    private Jedis jedis;

    public void set(String key, String value) {
        jedis.set(key, value);
    }

    public String get(String key) {
        return jedis.get(key);
    }

    @Override
    public long incrBy(String key, long value) {
        return jedis.incrBy(key, value);
    }

    public void expire(String key, long seconds) {
        jedis.expire(key, seconds);
    }
}
