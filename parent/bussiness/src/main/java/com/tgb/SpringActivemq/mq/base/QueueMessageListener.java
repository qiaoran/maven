package com.tgb.SpringActivemq.mq.base;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


/**
 * Create Date: 2014年8月22日 下午1:03:03
 * 
 * @version: V3.0.1
 * @author: Terry.Li
 */
public abstract class QueueMessageListener implements MessageListener, InitializingBean, DisposableBean {


	private ExecutorService executorService = null;

	protected BlockingQueue<Message> queue = null;

	public QueueMessageListener() {
		executorService = ThreadPool.getInstance(50).getExecutorService();
		queue = new LinkedBlockingQueue<Message>();
	}

	@Override
	public void onMessage(final Message message) {
		executorService.execute(new Runnable() {

			@Override
			public void run() {
				try {
					getQueue().put(message);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		//getQueue().clear();
	}

	public abstract void execute(Message message);

	private void preHandle(Message message) {
	//	logger.debug("preHandle..." + message);
	}

	private void postHandle(Message message) {
		//logger.debug("postHandle..." + message);
	}

	public abstract BlockingQueue<Message> getQueue();

	@Override
	public void afterPropertiesSet() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						final Message message = queue.take();
						preHandle(message);
						execute(message);
						postHandle(message);
						// sleep
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} // while
			} // run
		});
		thread.setDaemon(true);
		thread.start();
	}

	@Override
	public void destroy() throws Exception {
		if (executorService != null) {
			Threads.shutdown(executorService, 1000, 1000, TimeUnit.MILLISECONDS);
		}
	}

}
