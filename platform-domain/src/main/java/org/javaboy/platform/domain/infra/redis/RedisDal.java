package org.javaboy.platform.domain.infra.redis;

/**
 * @author:majin.wj
 */

public interface RedisDal {

    void set(String key, String value);

    long incrBy(String key,long value);

    String get(String key);

    void expire(String key, long seconds);
}
