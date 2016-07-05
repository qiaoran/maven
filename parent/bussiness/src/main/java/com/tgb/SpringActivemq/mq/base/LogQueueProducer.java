package com.tgb.SpringActivemq.mq.base;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * 发送消息
 * @author joy-pc
 *
 */
@Component
public class LogQueueProducer extends ProducerServiceImpl {
	private final String ANSWER = "answer";
	@Autowired
	private Destination logQueue;

	public void send(String obj) {
		sendMessage(obj, logQueue);
	}

	private void sendMessage(final String log, Destination destination) {
		jmsTemplate.send(destination, new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				MapMessage message = session.createMapMessage();
				message.setString(ANSWER, log);
				return message;
			}
		});
	}

	public Destination getLogQueue() {
		return logQueue;
	}

	public void setLogQueue(Destination logQueue) {
		this.logQueue = logQueue;
	}

}
