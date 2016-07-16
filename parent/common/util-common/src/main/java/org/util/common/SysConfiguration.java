package org.util.common;

import java.util.ResourceBundle;

/**
 * 读取sysconfig.properties配置文件
 * @author Wang
 *
 */
public class SysConfiguration {

	static ResourceBundle bundle = null;
    
	static {
		bundle = ResourceBundle.getBundle("sysconfig");
	}

	public static String getString(String key) {
		if (bundle == null) {
			bundle = ResourceBundle.getBundle("sysconfig");
		}
		return bundle.getString(key);
	}
	
}
