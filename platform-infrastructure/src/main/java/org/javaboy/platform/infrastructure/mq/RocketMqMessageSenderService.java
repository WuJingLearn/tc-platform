package org.javaboy.platform.infrastructure.mq;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.javaboy.platform.domain.infra.message.MessageSenderService;
import org.javaboy.platform.domain.infra.message.TopicMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author:majin.wj
 */
@Component
public class RocketMqMessageSenderService implements MessageSenderService {

    private static Logger LOG = LoggerFactory.getLogger(RocketMqMessageSenderService.class);

    @Autowired
    public DefaultMQProducer mqMessageSender;

    @Override
    public boolean sendMessage(TopicMessage message) {
        try {
            mqMessageSender.send(toMessage(message));
            return true;
        } catch (Exception e) {
            LOG.error("rocketMq消息发送失败", e);
            return false;
        }
    }

    private Message toMessage(TopicMessage message) {
        MessageExt messageExt = new MessageExt();
        messageExt.setTopic(message.getTopic());
        messageExt.setTags(message.getTag());
        messageExt.setBody(JSON.toJSONString(messageExt).getBytes());
        return messageExt;
    }

}
