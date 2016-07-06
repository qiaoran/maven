package com.tgb.SpringActivemq.mq.base;

import javax.annotation.Resource;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerServiceImpl  {
	 public JmsTemplate jmsTemplate;   
     
	   /* public void sendMessage(Destination destination, final String message) {   
	        System.out.println("---------------生产者发送消息-----------------");   
	        System.out.println("---------------生产者发了一个消息：" + message);   
	        jmsTemplate.send(destination, new MessageCreator() {   
	            public Message createMessage(Session session) throws JMSException {   
	                return session.createTextMessage(message);   
	            }   
	        });   
	    }    
	    
	  */
	    public JmsTemplate getJmsTemplate() {   
	        return jmsTemplate;   
	    }    
	  
	    @Resource  
	    public void setJmsTemplate(JmsTemplate jmsTemplate) {   
	        this.jmsTemplate = jmsTemplate;   
	    }   
}
