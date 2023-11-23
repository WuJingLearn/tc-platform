package org.javaboy.platform.domain.infra.message;

/**
 * @author:majin.wj
 */
public interface MessageSenderService {
    boolean sendMessage(TopicMessage message);
}
