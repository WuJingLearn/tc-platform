package org.javaboy.platform.domain.infra.redis.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author:majin.wj
 */
public interface DistributedLock {

    /**
     *
     * @param waitTime  等待锁时间
     * @param leaseTime 过期时间
     * @param unit
     * @return
     */
    boolean tryLock(long waitTime, long leaseTime, TimeUnit unit) throws InterruptedException;

    /**
     * 不等待，默认的锁过期时间
     * @return
     * @throws InterruptedException
     */
    boolean tryLock() throws InterruptedException;

    /**
     * 未获取锁的线程一直等待到获取锁，高并发情况不建议使用。长期占用线程资源
     * @throws InterruptedException
     */
    void lock() throws InterruptedException;

    /**
     * 释放锁
     */
    void unlock();

    /**
     * 是否有线程持有锁
     * @return
     */
    boolean isLocked();

    /**
     * 是否被当前线程持有
     * @return
     */
    boolean isHeldByCurrentThread();

}
