package org.javaboy.platform.domain.seckill.event;

import org.javaboy.platform.domain.infra.message.TopicMessage;

/**
 * @author:majin.wj
 */
public class SeckillBaseEvent extends TopicMessage {

    public static final String SECKILL_TOPIC = "seckillTopic";

    private Long id;
    private Integer status;

    public SeckillBaseEvent(Long id, Integer status, String tag) {
        super(SECKILL_TOPIC, tag);
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Integer getStatus() {
        return status;
    }

}
