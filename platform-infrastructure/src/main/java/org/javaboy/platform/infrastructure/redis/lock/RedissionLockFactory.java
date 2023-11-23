package org.javaboy.platform.infrastructure.redis.lock;

import org.javaboy.platform.domain.infra.redis.lock.DistributedLock;
import org.javaboy.platform.domain.infra.redis.lock.DistributedLockFactory;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author:majin.wj
 */
@Component
public class RedissionLockFactory implements DistributedLockFactory {

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public DistributedLock getLock(String key) {
        RLock lock = redissonClient.getLock(key);
        return new DistributedLock() {
            @Override
            public boolean tryLock(long waitTime, long leaseTime, TimeUnit unit) throws InterruptedException {
                return lock.tryLock(waitTime, leaseTime, unit);
            }

            @Override
            public boolean tryLock() throws InterruptedException {
                return lock.tryLock();
            }

            @Override
            public void lock() throws InterruptedException {
                lock.lock();
            }

            @Override
            public void unlock() {
                if (isLocked() && isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }

            @Override
            public boolean isLocked() {
                return lock.isLocked();
            }

            @Override
            public boolean isHeldByCurrentThread() {
                return lock.isHeldByCurrentThread();
            }
        };
    }
}
