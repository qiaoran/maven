package org.util.common;

/**
 * Copyright (c) 2015-2016 youzhai.com
 *
 * com.xnac.yz.utilsBizException.java
 *
 * @author Andrew
 * @date 2015年9月9日 上午9:43:35
 * @description 
 *
 */
public class BizException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public BizException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BizException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public BizException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public BizException(Throwable cause) {
		super(cause);
	}
}
