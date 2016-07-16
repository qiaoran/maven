package org.bussiness.mq.base;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * @author joy-pc
 *
 */
public class Threads {


	public static void sleep(long durationMillis) {
		try {
			Thread.sleep(durationMillis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static void shutdown(ExecutorService pool, int shutdownTimeout, int shutdownNowTimeout, TimeUnit timeUnit) {
		pool.shutdown();
		try {
			if (!pool.awaitTermination(shutdownTimeout, timeUnit)) {
				pool.shutdownNow();
				if (!pool.awaitTermination(shutdownNowTimeout, timeUnit)) {
					//logger.error("Pool did not terminated");
				}
			}
		} catch (InterruptedException ie) {
			pool.shutdownNow();
			Thread.currentThread().interrupt();
		}
	}
}
