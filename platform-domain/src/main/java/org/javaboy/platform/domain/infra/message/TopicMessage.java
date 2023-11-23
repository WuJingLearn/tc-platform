package org.javaboy.platform.domain.infra.message;

/**
 * @author:majin.wj
 */
public class TopicMessage {

    private String topic;
    private String tag;

    public TopicMessage(){}

    public TopicMessage(String topic,String tag){
        this.topic = topic;
        this.tag = tag;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTopic() {
        return topic;
    }

    public String getTag() {
        return tag;
    }
}
