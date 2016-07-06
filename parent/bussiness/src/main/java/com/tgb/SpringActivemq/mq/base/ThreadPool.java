package com.tgb.SpringActivemq.mq.base;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Create Date: 2015年11月4日 下午6:47:08
 * 
 * @version: V3.1.0
 * @author: Terry.Li
 */
public class ThreadPool {

	private static ThreadPool _INSTANCE = null;

	private ExecutorService executorService;

	private ThreadPool(int nThreads) {
		executorService = new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
	}

	public static ThreadPool getInstance(int nThreads) {
		// if (_INSTANCE == null) {
		// _INSTANCE = new ThreadPool(nThreads);
		// }
		// return _INSTANCE;
		return new ThreadPool(nThreads);
	}

	public ExecutorService getExecutorService() {
		return executorService;
	}

	public void run(Runnable runnable) {
		this.executorService.execute(runnable);
	}
}
