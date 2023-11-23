package org.javaboy.platform.domain.infra.redis.lock;

/**
 * @author:majin.wj
 */
public interface DistributedLockFactory {
    DistributedLock getLock(String key);

}
