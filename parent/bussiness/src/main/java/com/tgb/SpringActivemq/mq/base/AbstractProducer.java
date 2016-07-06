package com.tgb.SpringActivemq.mq.base;


import java.io.Serializable;

/**
 * Create Date: 2015年4月22日 下午3:35:54
 * 
 * @version: V3.0.1
 * @author: Terry.Li
 */
public abstract class AbstractProducer {

	public abstract void send(final Serializable obj) throws Exception;
}
