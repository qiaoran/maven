package org.util.common;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

/**
 * 基础工具类
 * @author Wang
 *
 */
public class BasicUtil {
	
	/**处理字符串并转换为Long*/
	public static Long strToLong(String string){
		
		if(string == null || string.equals("")){
			
			return null;
		}
		
		try {
			
			return Long.parseLong(string);
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	public static Integer objectToInteger(Object object){
		
		if (object == null) {
			return null;
		}
		
		return Integer.parseInt(String.valueOf(object));
	}
	
	/**处理字符串为null*/
	public static String isNull(String string){
		return string == null ? "" : string;
	}
	
	/**处理Integer为null*/
	public static Integer isIntNull(Integer integer){
		return integer == null ? new Integer(0) : integer;
	}
	
	/**处理Double为null*/
	public static Double isIntNull(Double double1){
		return double1 == null ? new Double(0.0) : double1;
	}
	
	/**处理Long为null*/
	public static Long isIntNull(Long long1){
		return long1 == null ? new Long(0) : long1;
	}
	
	/**获取一个编码*/
	public static String getCode(){
		String time = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		return time;
	}
	
	/**根据总条数和每页条数计算总页数*/
	public static int getMaxPageByMaxNumAndPageSize(int maxNum, int pageSize){
		
		if(maxNum == 0){
			return 1;
		}
		
		// 计算页数
		int maxPage = maxNum / pageSize;
		
		// 计算多余的条数
		maxPage = maxNum % pageSize != 0 ? maxPage += 1 : maxPage;
		
		return maxPage;
	}
	
	/**
	 * 计算时间差
	 * @param time 待计算的时间毫秒值
	 * @return 计算后的距离时间
	 */
	public static String getTimeDifference(Long time){
		
		Long currentTime = System.currentTimeMillis();
		
		time = (currentTime - time);
		
		long day = time / (24 * 60 * 60 * 1000);
		long hour = (time / (60 * 60 * 1000) - day * 24);
		long min = ((time / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (time / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        
        String timeStr = null;
        
        if(day != 0){
        	
        	timeStr = "<time>" + day + "<time>天前";
		} else {
        	
			if(hour != 0){
				
				timeStr = "<time>" + hour + "<time>小时前";
			}else{
				
				if(min != 0){
					
					timeStr = "<time>" + min + "<time>分钟前";
				}else{
					
					timeStr = "<time>" + s + "<time>秒前";
				}
			}
        }

        return timeStr;
	}
	
	/**处理集合是否为空且返回第一个元素
	 * @param <T>
	 * @return */
	public static <T> T getListFirst(List<T> list){
		if (list == null || list.size() == 0){
			return null;
		} else {
			return list.get(0);
		}
	}
	
	/**ajax异步公共返回*/
	public static void ajaxReturnFunction(StringBuffer result, HttpServletResponse response) {
		
		response.setContentType("text/html;charset=utf-8");

		PrintWriter pw = null;
		
		try {
			
			pw = response.getWriter();

			pw.write(result.toString());
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			pw.flush();

			pw.close();
			
		}
		
	}
	
	/**
	 * 字符串转换成十六进制字符串
	 */
	public static String str2HexStr(String str) {

		char[] chars = "0123456789ABCDEF".toCharArray();
		StringBuilder sb = new StringBuilder("");
		byte[] bs = str.getBytes();
		int bit;
		for (int i = 0; i < bs.length; i++) {
			bit = (bs[i] & 0x0f0) >> 4;
			sb.append(chars[bit]);
			bit = bs[i] & 0x0f;
			sb.append(chars[bit]);
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * 十六进制转换字符串
	 */
	public static String hexStr2Str(String hexStr) {
		String str = "0123456789ABCDEF";
		char[] hexs = hexStr.toCharArray();
		byte[] bytes = new byte[hexStr.length() / 2];
		int n;
		for (int i = 0; i < bytes.length; i++) {
			n = str.indexOf(hexs[2 * i]) * 16;
			n += str.indexOf(hexs[2 * i + 1]);
			bytes[i] = (byte) (n & 0xff);
		}
		return new String(bytes);
	}
	
	
	/**
	 * 价格转换
	 * @param monery
	 * @return
	 */
	public static String getmoneyConvert(double monery)
	{
		String result="";
		DecimalFormat df = new DecimalFormat("#.##");
		if(monery!= 0){
				double viewPrice =monery/ 10000;		
				if(viewPrice < 1)
				{					
					double price = monery % 10000;	
					if (price == (int) price) {
						result = (((int) price)+"元");
					}else{
						 result = (df.format(price)+"元");
					}
				} 
				else {	
					if (viewPrice == (int) viewPrice) {
						result = (((int) viewPrice)+"万元");
					} else {						
					    result = (df.format(viewPrice)+"万元");
					}
				}
			}
		return result;
	}
	
	/**
	 * 价格转换
	 * @param monery
	 * @return
	 */
	public static String getmoneyConvertNOUnit(double monery)
	{
		String result="";
		DecimalFormat df = new DecimalFormat("#.##");
		if(monery!= 0){
				double viewPrice =monery/ 10000;		
				if(viewPrice < 1)
				{					
					double price = monery % 10000;	
					if (price == (int) price) {
						result =(int) price+"";
					}else{
						 result = df.format(price);
					}
				} 
				else {	
					if (viewPrice == (int) viewPrice) {
						result = (int) viewPrice+"";
					} else {						
					    result = df.format(viewPrice);
					}
				}
			}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		
		String string = "/mapi/wxuserinfo//bc040393-5eec-43f9-b4e4-f818f3caf65b";
		
		String hexStr = str2HexStr(string);
		
		String str = hexStr2Str(hexStr);
		
		System.out.println(hexStr);
		System.out.println(hexStr.length());
		System.out.println(str);
		
	}
	
	
	
}
