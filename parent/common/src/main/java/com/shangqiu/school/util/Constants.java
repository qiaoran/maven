package com.shangqiu.school.util;

import java.util.UUID;

/**
 * 常量类
 * @author Wang
 *
 */
public class Constants {

	/**
	 * 结果code   "00000" : 接口执行成功
	 */
	public static final String RESULT_CODE_00000 = "00000";
	
	/**
	 * 结果code   "00001" : 发送/上传失败
	 */
	public static final String RESULT_CODE_00001 = "00001";
	
	/**
	 * 结果code   "00002" : 接口执行错误
	 */
	public static final String RESULT_CODE_00002 = "00002";
	
	/**
	 * 结果code   "00003" : 签名生成失败
	 */
	public static final String RESULT_CODE_00003 = "00003";
	
	/**
	 * 结果code   "00004" : 参数不正确
	 */
	public static final String RESULT_CODE_00004 = "00004";
	
	/**
	 * 结果code   "00005" : 地址异常
	 */
	public static final String RESULT_CODE_00005 = "00005";
	
	/**
	 * 结果code   "00006" : 发送频繁
	 */
	public static final String RESULT_CODE_00006 = "00006";
	
	/**
	 * 短信签名-->小鸟爱巢
	 */
	public static final String SMS_FREE_SIGN_000 = "中美家网";
	
	/**
	 * 短信签名-->活动验证
	 */
	public static final String SMS_FREE_SIGN_001  = "活动验证";
	
	/**
	 * 短信签名-->变更验证
	 */
	public static final String SMS_FREE_SIGN_002  = "变更验证";
	
	/**
	 * 短信签名-->登录验证
	 */
	public static final String SMS_FREE_SIGN_003  = "登录验证";
	
	/**
	 * 短信签名-->注册验证
	 */
	public static final String SMS_FREE_SIGN_004  = "注册验证";
	
	/**
	 * 短信签名-->身份验证
	 */
	public static final String SMS_FREE_SIGN_005  = "身份验证";
	
	/**
	 * 短信签名-->小鸟爱巢
	 */
	public static final String SMS_FREE_SIGN_006 = "小鸟爱巢";
	
	/**
	 * 短信模板-->活动确认验证码<br>
	 * 模板内容:验证码${code}，您正在参加${product}的${item}活动，请确认系本人申请。<br>
	 * 模板参数:{"code":"1234","product":"中美家网","item":"??"}
	 */
	//public static final String SMS_TEMPLATE_CODE_001  = "SMS_2975118";
	public static final String SMS_TEMPLATE_CODE_001  = "SMS_4435684";
	
	/**
	 * 短信模板-->信息变更验证码<br>
	 * 模板内容:验证码${code}，您正在尝试变更${product}重要信息，请妥善保管账户信息。<br>
	 * 模板参数:{"code":"1234","product":"中美家网"}
	 */
	//public static final String SMS_TEMPLATE_CODE_002  = "SMS_2975116";
	public static final String SMS_TEMPLATE_CODE_002  = "SMS_4435682";
	
	/**
	 * 短信模板-->身份验证验证码<br>
	 * 模板内容:验证码${code}，您正在进行${product}身份验证，打死不要告诉别人哦！如非您本人操作，请忽略我吧。<br>
	 * 模板参数:{"code":"1234","product":"中美家网"}
	 */
	//public static final String SMS_TEMPLATE_CODE_003  = "SMS_2975119";
	public static final String SMS_TEMPLATE_CODE_003  = "SMS_4435688";
	
	/**
	 * 短信模板-->修改密码成功<br>
	 * 模板内容:亲，您已成功修改密码，新密码为：${code}。万万不可落入他人手中！若非您本人操作，请务必传信我们的客服${phone}。<br>
	 * 模板参数:{"code":"123456","phone":"4008190000"}
	 */
	//public static final String SMS_TEMPLATE_CODE_004  = "SMS_3070252";
	public static final String SMS_TEMPLATE_CODE_004  = "SMS_4485607";
	
	/**
	 * 短信模板-->成功修改绑定手机<br>
	 * 模板内容: 您已成功修改绑定手机：${phone}。若非您本人操作，请务必传信我们的客服${tell}。<br>
	 * 模板参数:{"phone":"18622223333","tell":"4008190000"}
	 */
	//public static final String SMS_TEMPLATE_CODE_005  = "SMS_3125255";
	public static final String SMS_TEMPLATE_CODE_005  = "SMS_4465780";
	
	/**
	 * 短信模板-->修改密码验证码<br>
	 * 模板内容:验证码${code}，您正在尝试修改${product}登录密码，请妥善保管账户信息。<br>
	 * 模板参数:{"code":"1234","product":"中美家网"}
	 */
	//public static final String SMS_TEMPLATE_CODE_006  = "SMS_2975117";
	public static final String SMS_TEMPLATE_CODE_006  = "SMS_4435683";
	
	/**
	 * 短信模板-->身份验证验证码<br>
	 * 模板内容: 验证码${code}，您正在进行${product}身份验证，打死不要告诉别人哦！<br>
	 * 模板参数:{"code":"1234","product":"中美家网"}
	 */
	//public static final String SMS_TEMPLATE_CODE_007  = "SMS_2975122";
	public static final String SMS_TEMPLATE_CODE_007  = "SMS_4435688";
	
	/**
	 * 短信模板-->注册成功验证码<br>
	 * 模板内容: 亲，您已成功注册为${product}会员！登录密码为${code}（注册手机号后六位）。为了您的账户安全，记得尽快修改密码哦。<br>
	 * 模板参数:{"product":"中美家网","code":"123456"}
	 * 待审批:SMS_5420225
	 */															
	//public static final String SMS_TEMPLATE_CODE_008  = "SMS_3115292";
	//public static final String SMS_TEMPLATE_CODE_008  = "SMS_4400631";
	public static final String SMS_TEMPLATE_CODE_008  = "SMS_5420225";
	
	/**
	 * 短信模板-->预约验证<br>
	 * 模板内容: 验证码${code}。您正在${product}预约${item}，如非您本人操作，请忽略我吧。<br>
	 * 模板参数:{"code":"1234","product":"中美家网","item":"装修公司/设计师"}
	 */
	//public static final String SMS_TEMPLATE_CODE_009  = "SMS_3070299";
	public static final String SMS_TEMPLATE_CODE_009  = "SMS_4445646";
	
	/**
	 * 短信模板-->预约成功<br>
	 * 模板内容: 亲，在您成功预约${product}的同时，已成为我们的会员大人！登录密码为${code}（手机号后六位）。为了您的账户安全，记得尽快修改密码哦。<br>
	 * 模板参数:{"product":"设计师/装修公司","code":"123456"}
	 */
	//public static final String SMS_TEMPLATE_CODE_0010  = "SMS_3120215";
	public static final String SMS_TEMPLATE_CODE_0010  = "SMS_4455579";
	
	/**
	 * 短信模板-->装修公司接单提醒<br> *************************
	 * 模板内容: 亲，${product}已经接受了您的订单，您预约的${item}约为${time}，在此期间一定要保持电话畅通哦！<br>
	 * 模板参数:{"product":"中美家网","item":"装修公司/设计师","time":"12月17日11:11"}
	 * 
	 * 当前错误模板：亲，${item}已经接受了您的订单，您预约的${item}约为${time}，在此期间一定要保持电话畅通哦！    SMS_3135311
	 * 正在审批模板：亲，${product}已经接受了您的订单，您预约的${item}约为${time}，在此期间一定要保持电话畅通哦！   SMS_4055878
	 */
	//public static final String SMS_TEMPLATE_CODE_011  = "SMS_4055878";
	public static final String SMS_TEMPLATE_CODE_011  = "SMS_4435710";
	
	/**
	 * 短信模板-->量房信息上传完成<br>
	 * 模板内容: 亲，所有为您量房的装修公司均已上传完成量房信息啦。装修要赶早！请您认真审阅，仔细考虑后，果断选择一家为您装修吧！<br>
	 * 模板参数:
	 */
	//public static final String SMS_TEMPLATE_CODE_012  = "SMS_3145182";
	public static final String SMS_TEMPLATE_CODE_012  = "SMS_4460619";
	
	/**
	 * 短信模板-->中美家网-装修阶段变更提醒<br>
	 * 模板内容: 亲，您的“${project}”项目装修已经进入到“${item1}”啦！“${item2}”施工日志已上传完成，静待您批阅！<br>
	 * 模板参数:{"project":"中美家网","item1":"水电阶段","item2":"开工大吉"}
	 */
	//public static final String SMS_TEMPLATE_CODE_013  = "SMS_3095453";
	public static final String SMS_TEMPLATE_CODE_013  = "SMS_4420637";
	
	/**
	 * 短信模板-->抢单成功提醒<br>
	 * 模板内容: 亲，恭喜您已成功抢到${code}号订单！在${item}里可以查看详细信息，一定要记得在${time}上门量房哦！<br>
	 * 模板参数:{"code":"20151212121212","item":"预约订单","time":"12月17日11:11"}
	 */
	//public static final String SMS_TEMPLATE_CODE_014  = "SMS_3145183";
	public static final String SMS_TEMPLATE_CODE_014  = "SMS_4430600";
	
	
	/**
	 * 短信模板-->施工订单达成提醒<br>
	 * 模板内容: 亲，努力并没有白费！您已经被订单号为${code}的客户选中为ta家装修啦！请小跑与ta联系，尽快开始施工哦！<br>
	 * 模板参数:{"code":"中美家网"}
	 */
	//public static final String SMS_TEMPLATE_CODE_015  = "SMS_3085268";
	public static final String SMS_TEMPLATE_CODE_015  = "SMS_4425825";
	

	/**
	 * 短信模板-->派单提醒<br>
	 * 模板内容: 亲爱的设计师，我们把订单号为${code}的客户交给您了。联系电话${phone}。记得小跑联系ta哦！<br>
	 * 模板参数:{"product":"中美家网","item1":"????","item2":"开工大吉"}
	 */
	//public static final String SMS_TEMPLATE_CODE_016  = "SMS_3095454";
	public static final String SMS_TEMPLATE_CODE_016  = "SMS_4445645";
	
	/**
	 * 短信模板-->用户注册验证码<br>
	 * 模板内容:验证码${code}，您正在注册成为${product}用户，感谢您的支持！<br>
	 * 模板参数:{"code":"1234","product":"中美家网"}
	 */
	//public static final String SMS_TEMPLATE_CODE_0019  = "SMS_2975119";
	public static final String SMS_TEMPLATE_CODE_0019  = "SMS_4435685";
	
	/**
	 * 短信模板-->客服预约提醒<br>
	 * 模板内容: 您正在${product}预约${item}，如非您本人操作，请忽略我吧。<br>
	 * 模板参数:{"product":"中美家","item":"装修公司/设计师"}
	 */
	public static final String SMS_TEMPLATE_CODE_020  = "SMS_4726113";
	
	
	/**
	 * 短信模板-->公司上传量房信息提醒<br>
	 * 模板内容: 亲，为您量房的${cname}已上传完成量房信息啦。装修要赶早！请您认真审阅，仔细考虑后，果断选择一家为您装修吧！<br>
	 * 模板参数:{"cname":"某某装修公司"}
	 */
	public static final String SMS_TEMPLATE_CODE_021  = "SMS_4991839";
	
	/**
	 * 短信模板-->施工日志全部上传 待验收<br>
	 * 模板内容: 亲！您的“${project}"项目已经全部施工完成啦！快去验收吧。搬新家啦！别忘了对装修公司评价哦！<br>
	 * 模板参数:{"project":"某某装修案例名称"}
	 */
	public static final String SMS_TEMPLATE_CODE_022  = "SMS_5007110";
	
	/**
	 * 短信模板-->派单成功送电影票br>
	 * 模板内容: 亲！感谢您参与中美家预约活动，双人观影券如约奉上啦！ 兑换码：${number}，请在${address}兑换使用哦~<br>
	 * 模板参数:{"number":"某某装修案例名称"}
	 * 
	 */
	public static final String SMS_TEMPLATE_CODE_023 = "SMS_5049249";
	
	/**
	 * 短信模板-->注册用户预约成功<br>
	 * 模板内容: 亲,您已成功约${product}。预约订单号为${ordernumber}。<br>
	 * 模板参数:{"product":"装修公司或者设计师"}
	 * {"ordernumber":"订单号"}
	 * 
	 */
	public static final String SMS_TEMPLATE_CODE_024 = "SMS_5225400";
	
	
}
