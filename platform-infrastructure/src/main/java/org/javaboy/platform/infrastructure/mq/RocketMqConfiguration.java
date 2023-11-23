package org.javaboy.platform.infrastructure.mq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.javaboy.common.utils.DebugLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:majin.wj
 */
@Configuration
public class RocketMqConfiguration {

    @Value("${rocket.mq.nameserver}")
    private String nameServer;

    /**
     * todo 开发期间暂时忽略
     *
     * @return
     * @throws MQClientException
     */
    @Bean
    public DefaultMQProducer mqMessageSender() throws MQClientException {
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer();
        try {
            defaultMQProducer.setNamesrvAddr(nameServer);
            defaultMQProducer.setProducerGroup("mqMessageSender");
            defaultMQProducer.start();
        } catch (Exception e) {
            DebugLogger.error("RocketMq初始化失败"+e.getMessage());
        }
        return defaultMQProducer;
    }


}
