package org.bussiness.mq.base;

import javax.annotation.Resource;

import org.springframework.jms.core.JmsTemplate;

/**
 * @author joy-pc
 *
 */
public abstract class MessageProducer extends AbstractProducer {
	public JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	@Resource
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
}
