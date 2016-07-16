package org.util.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Copyright (c) 2015-2016 youzhai.com
 *
 * com.xnac.yz.utilsStringUtil.java
 *
 * @author Andrew
 * @date 2015年9月8日 上午9:20:33
 * @description String 工具类
 *
 */
public class StringUtil {
	
	private static final String SPLIT_SEPERATOR = ",";
	
	public static List<Long> splitAsList(String content) {
		
		List<Long> targetList = new ArrayList<Long>();
		
		if(null == content || "".equals(content)) {
			return targetList;
		}
		
		String[] strs = content.split(SPLIT_SEPERATOR);
		
		for(String s : strs) {
			targetList.add(Long.parseLong(s));
		}
		
		return targetList;
	}
	
	public static boolean isInstall(String[] list,String name){
		for(int i=0;i<list.length;i++){
			if(name.indexOf(list[i])!=-1){
				return true;
			}
		}
		return false;
	}
	
	/** 
	 * @Description:把list转换为一个用逗号分隔的字符串 
	 */  
	public static String listToString(List list) {  
	    StringBuilder sb = new StringBuilder();  
	    if (list != null && list.size() > 0) {  
	        for (int i = 0; i < list.size(); i++) {  
	            if (i < list.size() - 1) {  
	                sb.append(list.get(i) + ",");  
	            } else {  
	                sb.append(list.get(i));  
	            }  
	        }  
	    }  
	    return sb.toString();  
	}  
	
	public static String noView(String name){
		return name.substring(0, 3)+"********";
	}

}
