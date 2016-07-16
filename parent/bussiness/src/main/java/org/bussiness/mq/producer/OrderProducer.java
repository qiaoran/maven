package org.bussiness.mq.producer;

import java.io.Serializable;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.bussiness.mq.base.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * @author joy-pc
 *
 */
@Component
public class OrderProducer extends MessageProducer {
	private final String ANSWER = "answer";

	@Autowired
	private Destination orderQueue;

	/*
	 *  发送
	 * @see org.bussiness.mq.base.MessageProducer#send(java.io.Serializable)
	 */
	public void send(Serializable obj) {
		sendMessage((String) obj, orderQueue);
	}

	private void sendMessage(final String answer, final Destination destination) {
		jmsTemplate.send(destination, new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				MapMessage message = session.createMapMessage();
				message.setString(ANSWER, answer);
				return message;
			}
		});
	}

	public Destination getQuestionAnswerQueue() {
		return orderQueue;
	}

	public void setQuestionAnswerQueue(Destination orderQueue) {
		this.orderQueue = orderQueue;
	}
}
