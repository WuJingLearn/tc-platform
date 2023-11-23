package org.javaboy.platform.application.seckill.event.handler;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.javaboy.common.utils.DebugLogger;
import org.javaboy.platform.domain.seckill.event.SeckillActivityEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author:majin.wj
 */
@Component
public class SeckillActivityRocketMqEventHandler implements MessageListenerConcurrently {

    @Value("${rocket.mq.nameserver}")
    private String nameServer;

    @PostConstruct
    public void initEventConsumer() throws MQClientException {
        try {
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("seckillActivityEventConsumer");
            consumer.setNamesrvAddr(nameServer);
            consumer.registerMessageListener(this);
            consumer.start();
        }catch (Exception e) {
            DebugLogger.error("RocketMq消费者启动失败,"+e.getMessage());
        }

    }

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        MessageExt messageExt = list.get(0);
        SeckillActivityEvent seckillActivityEvent = getActivityEvent(messageExt);


        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }

    private SeckillActivityEvent getActivityEvent(MessageExt messageExt){
        byte[] body = messageExt.getBody();
        return JSON.parseObject(new String(body),SeckillActivityEvent.class);
    }


}
