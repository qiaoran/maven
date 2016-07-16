package org.bussiness.mq.listener;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.jms.MapMessage;
import javax.jms.Message;

import org.apache.commons.lang.StringUtils;
import org.bussiness.mq.base.QueueMessageListener;
import org.springframework.stereotype.Component;

/**
 * 订单接受
 * @author joy-pc
 *
 */
@Component
public class OrderLintener extends QueueMessageListener {
	private static final BlockingQueue<Message> orderQueue = new LinkedBlockingQueue<Message>();

	public synchronized void execute(Message message) {
		try {
			MapMessage mapMessage = (MapMessage) message;
			String answer = mapMessage.getString("answer");
			if (StringUtils.isNotBlank(answer)) {
				System.out.println("接收到一个纯文本消息。");
				System.out.println(answer);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public BlockingQueue<Message> getQueue() {
		return OrderLintener.orderQueue;
	}
	
	@Override
	public void afterPropertiesSet() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
						if (!getQueue().isEmpty()) {
							Message message = getQueue().take();
							execute(message);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.setDaemon(true);
		thread.start();
	}

}
