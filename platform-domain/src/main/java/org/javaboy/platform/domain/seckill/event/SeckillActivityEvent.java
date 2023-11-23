package org.javaboy.platform.domain.seckill.event;

/**
 * @author:majin.wj
 */
public class SeckillActivityEvent extends SeckillBaseEvent{
    public SeckillActivityEvent(Long id, Integer status, String tag) {
        super(id, status, tag);
    }
}
