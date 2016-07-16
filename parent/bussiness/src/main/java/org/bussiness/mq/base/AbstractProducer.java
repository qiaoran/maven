package org.bussiness.mq.base;


import java.io.Serializable;

/**
 * @author joy-pc
 *
 */
public abstract class AbstractProducer {

	public abstract void send(final Serializable obj) throws Exception;
}
