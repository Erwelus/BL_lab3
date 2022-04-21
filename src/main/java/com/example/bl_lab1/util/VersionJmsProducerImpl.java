package com.example.bl_lab1.util;

import com.example.bl_lab1.model.VersionEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class VersionJmsProducerImpl implements VersionJmsProducer {

    private final JmsTemplate jmsTemplate;

    @Value("${queueName}")
    private String queue;

    public VersionJmsProducerImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendVersion(Map<String, Object> message){
        try{
            jmsTemplate.convertAndSend(queue, message);
        } catch(Exception e){
            System.err.println("Failed to send a message"+ message.toString());
            e.printStackTrace();
        }
    }
}
