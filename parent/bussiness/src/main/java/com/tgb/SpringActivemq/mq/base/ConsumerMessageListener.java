package com.tgb.SpringActivemq.mq.base;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.stereotype.Component;

@Component
public class ConsumerMessageListener implements MessageListener {

	public void onMessage(Message message) {
		
		System.out.println("接收到一个纯文本消息。");
		try {
			MapMessage mapMessage = (MapMessage) message;
			String answer = mapMessage.getString("answer");
			System.out.println(answer);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
