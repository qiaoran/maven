package org.util.common;

/**
 * 站内信常量类
 * @author Wang
 * create 2015/12/16 20:23
 */
@SuppressWarnings("all")
public class ConstantsMsg {
	
	/**测试使用*/
	public static void main(String[] args) {
		
		String str2 = ConstantsMsg.MSG_002;
		
		str2 = str2.replaceAll("【code】", "111111");
		
		System.out.println(str2);
		
		/*SysteIfno systeInfo2=new SysteIfno();
		systeInfo2.setAccoundid(order.getCreatUser());					
		systeInfo2.setContent("订单编号"+order.getOrderNumber()+"："+com.getCompanyName()+"公司已接单!");
		systeInfo2.setUrl("/personal/order/lists");
		ObjectEvent objectEvent2=new ObjectEvent(this, systeInfo2);
		SpringContextHolder.publishEvent(objectEvent2);*/
		
		/*//发送站内信
		SysteIfno systeInfo = new SysteIfno();
		systeInfo.setAccoundid(dov.getReservationId());
		systeInfo.setContent(ConstantsMsg.MSG_019.replaceAll("【dname】", dov.getAccountName()));
		systeInfo.setUrl("/personal/designer/lists");
		systeInfo.setCratedate(new Date());
		ObjectEvent objectEvent = new ObjectEvent(this, systeInfo);
		SpringContextHolder.publishEvent(objectEvent);*/
		
	}
	
	
	/*********************************************    公用发送消息Start    ********************************************************/
	/*********************************************    公用发送消息Start    ********************************************************/
	/*********************************************    公用发送消息Start    ********************************************************/
	/*********************************************    公用发送消息Start    ********************************************************/
	/*********************************************    公用发送消息Start    ********************************************************/
	
	/**
	 * 密码修改成功
	 */
	public static final String MSG_002 = "您的密码更改成功啦，如果不是您本人操作，一定要小跑联系客服哦！";
	
	/**
	 * 【设计师/装修公司/用户】关闭与【设计师/装修公司/用户】的设计订单,提示【设计师/装修公司/用户】<br>
	 * @param role -> 角色 :设计师/装修公司/用户<br>
	 * @param code ->订单编号<br>
	 * @param content ->关闭原因
	 */
	public static final String MSG_022 = "您已关闭与【role】的【code】订单，关闭原因：【content】。";
	
	/**
	 * 【设计师/装修公司/用户】已关闭与您的设计订单,提示【设计师/装修公司/用户】<br>
	 * @param role -> 角色 :设计师/装修公司/用户<br>
	 * @param code ->订单编号<br>
	 * @param content ->关闭原因
	 */
	public static final String MSG_053= "【role】已关闭与您的【code】订单，关闭原因：【content】。";
	
	/**
	 * 客服关闭订单,提示【设计师/装修公司/用户】<br>
	 * @param role -> 角色 :设计师/装修公司/用户<br>
	 * @param code ->订单编号<br>
	 * @param content ->关闭原因
	 */
	public static final String MSG_024 = "客服已关闭您与【role】的【code】订单，关闭原因：【content】。";

	
	
	/*********************************************    对个人用户发送消息Start    ********************************************************/
	/*********************************************    对个人用户发送消息Start    ********************************************************/
	/*********************************************    对个人用户发送消息Start    ********************************************************/
	/*********************************************    对个人用户发送消息Start    ********************************************************/
	/*********************************************    对个人用户发送消息Start    ********************************************************/
	
	/**
	 * 用户注册成功
	 * @param image -> 图片链接<br>
	 */
	public static final String MSG_001 = "亲，您已经成功注册为中美家网会员啦！在这里，您可以找到最称心的装修公司；装修精英版块可以找到最专业的设计师、工长和散工；建材家居城有琳琅满目的建材、家具供您选购；所有精品设计、装修美图尽在成功案例；新手学装修必进知识库。这里的一切，只为让您体验到最轻松、最便捷、最安心的装修之旅。</br> <img src='【image】' width='100%' height='100%' alt=''/>"; 
	
	/**
	 * 绑定手机修改成功
	 */
	public static final String MSG_003 = "您的绑定手机更改成功啦，如果不是您本人操作，一定要小跑联系客服哦！";

	/**
	 * 绑定邮箱修改成功
	 */
	public static final String MSG_004 = "您的绑定邮箱更改成功啦，如果不是您本人操作，一定要小跑联系客服哦！";

	/**
	 * 用户装修公司预约申请成功
	 */
	public static final String MSG_005 = "亲，您已成功申请预约装修公司，我们的客服稍后会与您联系，一定要保持电话畅通哦！";

	/**
	 * 用户装修公司预约成功<br>
	 * @param cname ->装修公司名称<br>
	 */
	public static final String MSG_006 = "亲，您已成功预约了【cname】，我们的客服稍后会与您联系，一定要保持电话畅通哦！";

	/**
	 * 装修公司确认量房<br>
	 * @param cname ->装修公司名称<br>
	 */
	public static final String MSG_007 = "【cname】已接受您的预约，将于【date】上门量房，在此期间一定要保持电话畅通哦。";
	
	/**
	 * 装修公司上传量房<br>
	 * @param cname ->装修公司名称<br>
	 */
	public static final String MSG_008 = "【cname】上传量房信息完成啦！要装修请赶早！请您认真审阅，仔细考虑后，果断选择一家为您装修吧！";

	/**
	 * 用户确认选择装修公司装修<br>
	 * @param cname ->装修公司名称<br>
	 */
	public static final String MSG_009 = "亲，您已选择了【cname】为您装修，尽快预约开始施工吧！";

	/**
	 * 用户支付定金<br>
	 * @param cname ->装修公司名称<br>
	 */
	public static final String MSG_010 = "您已成功预约【cname】，将尽快根据合同开始施工。我们会在每个施工阶段上传装修日志，记得随时查看您的装修日记哦。";

	/**
	 * 装修公司更新施工日志<br>
	 * @param project ->项目名称<br>
	 */
	public static final String MSG_011 = "亲，您的\"【project】\"项目装修日志更新内容啦！快去施工日记查看吧！";

	/**
	 * 装修施工某阶段完成，进入下一阶段<br>
	 * @param project ->项目名称<br>
	 * @param item_last ->下一阶段名称<br>
	 * @param item_last ->当前阶段名称<br>
	 */
	public static final String MSG_012 = "亲，您的\"【project】\"项目装修已经进入到\"【item_last】\"阶段啦！\"【item_first】\"阶段日志已全部上传完成，快去看看吧！";

	/**
	 * 全部施工完成<br>
	 * @param project ->项目名称
	 */
	public static final String MSG_013 = "亲，您的\"【project】\"项目已经全部施工完成啦！快去验收吧。搬新家啦！别忘了对装修公司评价哦。";

	/**
	 * 装修公司关闭与用户订单,提示用户<br>
	 * @param cname ->装修公司名称<br>
	 * @param content ->关闭原因 
	 */
	public static final String MSG_014 = "【cname】已关闭订单，关闭原因：【content】。";

	/**
	 * 用户关闭订单与装修公司订单,提示用户<br>
	 * @param cname ->装修公司名称<br>
	 * @param content ->关闭原因 
	 */
	public static final String MSG_015 = "您已关闭与【cname】的订单，关闭原因：【content】。";

	/**
	 * 客服关闭用户与装修公司订单,提示用户<br>
	 * @param cname ->装修公司名称<br>
	 * @param content ->关闭原因 
	 */
	public static final String MSG_016 = "客服已关闭您与【cname】的订单，关闭原因：【content】。";

	/**
	 * 用户申请成功预约设计师,没有选中设计师
	 */
	public static final String MSG_017 = "亲，您已成功预约了设计师，我们的客服稍后会与您联系，一定要保持电话畅通哦！";

	/**
	 * 用户申请成功预约设计师,选中设计师<br>
	 * @param dname ->设计师名称
	 */
	public static final String MSG_018 = "亲，您已成功预约了设计师：【dname】，我们的客服稍后会与您联系，一定要保持电话畅通哦！";

	/**
	 * 设计师提交设计协议,提示用户<br>
	 * @param dname ->设计师名称
	 */
	public static final String MSG_019 = "亲，您预约的设计师：【dname】向您提交了设计协议，要仔细审核哦，通过后就可以开始为您设计啦。";

	/**
	 * 设计师提交某阶段设计协议,提示用户<br>
	 * @param dname ->设计师名称<br>
	 * @param num ->阶段数<br>
	 */
	public static final String MSG_020 = "您预约的设计师：【dname】向您提交了第【num】阶段设计内容，快去看看吧！";

	/**
	 * 用户对阶段全部审核通过,订单完成,提示用户<br>
	 * @param dname ->设计师名称<br>
	 */
	public static final String MSG_021 = "亲，您与设计师：【dname】的订单已全部完成啦！设计师辛苦了这么久，别忘了评价哦~";
	
	/**
	 * 评论装修日记,提示所属用户<br>
	 * @param project ->项目名称<br>
	 * @param item ->阶段名称
	 */
	public static final String MSG_025 = "亲，您的\"【project】\"装修日记\"【item】\"阶段有新回复啦，快去看看吧！";

	
	
	/*********************************************    对装修公司发送消息Start    ********************************************************/
	/*********************************************    对装修公司发送消息Start    ********************************************************/
	/*********************************************    对装修公司发送消息Start    ********************************************************/
	/*********************************************    对装修公司发送消息Start    ********************************************************/
	/*********************************************    对装修公司发送消息Start    ********************************************************/
	
	/**
	 * 装修公司注册成功
	 */
	public static final String MSG_026 = "恭喜您注册成功！编写更详细的公司信息会有更多的机会被用户选择，信息审核通过后才能在平台展示哦。";
	
	/**
	 * 客服对装修公司审核完成
	 */
	public static final String MSG_027 = "您提交的公司资料审核通过啦，快上传其它资料丰富自己，准备接单啦！";
	
	/**
	 * 客服审核信息驳回<br>
	 * @param content ->驳回理由
	 */
	public static final String MSG_028 = "您提交的公司信息已被驳回，驳回原因：【content】。请核对修改后重新提交。";
	
	/**
	 * 公司基本信息修改
	 */
	public static final String MSG_029 = "公司信息已被修改，若非本人操作请核对并及时修改。";
	
	/**
	 * 客服禁用/启用装修公司下设计师<br>
	 * @param dname ->设计师名称
	 */
	public static final String MSG_030 = "您的设计师：【dname】已被禁用（启用）。如有任何疑问请联系我们的客服。";
	
	/**
	 * 客服禁用/启用装修公司下工长<br>
	 * @param fname ->工长名称
	 */
	public static final String MSG_031 = "您的工长：【fname】已被禁用（启用）。如有任何疑问请联系我们的客服。";
	
	/**
	 * 客服禁用/启用装修公司设计案例<br>
	 * @param project ->设计案例名称
	 */
	public static final String MSG_032 = "您的设计案例《【project】》已被禁用（启用）。如有任何疑问请联系我们的客服。";
	
	/**
	 * 客服禁用/启用装修公司装修案例<br>
	 * @param project ->装修案例名称
	 */
	public static final String MSG_033 = "您的装修案例《【project】》已被禁用（启用）。如有任何疑问请联系我们的客服。";
	
	/**
	 * 客服对装修公司派单<br>
	 * @param code ->订单编号
	 */
	public static final String MSG_034 = "【code】号订单推送给您啦，快去抢啊！";
	
	/**
	 * 装修公司抢单支付成功<br>
	 * @param code ->订单编号
	 */
	public static final String MSG_035 = "您已成功抢到【code】号订单啦！千万别忘了在约定时间去量房哦。";
	
	/**
	 * 客户支付装修公司订单定金<br>
	 * @param code ->订单编号
	 */
	public static final String MSG_036 = "订单号为：【code】的用户已确认预约啦，请注意查收。尽快根据合同开始施工吧！";
	
	/**
	 * 订单全部完成<br>
	 * @param code ->订单编号
	 */
	public static final String MSG_037 = "【code】号订单已全部施工完成啦，请客户去验收吧！";
	
	/**
	 * 订单尾款支付完成<br>
	 * @param code ->订单编号
	 */
	public static final String MSG_038 = "订单号为：【code】的用户已确认，请注意查收。";
	
	/**
	 * 用户评论装修公司订单<br>
	 * @param code ->订单编号
	 */
	public static final String MSG_039 = "订单号为：【code】的用户提交了评价，快去看看吧！";
	
	
	
	/*********************************************    对设计师发送消息Start    ********************************************************/
	/*********************************************    对设计师发送消息Start    ********************************************************/
	/*********************************************    对设计师发送消息Start    ********************************************************/
	/*********************************************    对设计师发送消息Start    ********************************************************/
	/*********************************************    对设计师发送消息Start    ********************************************************/
	
	/**
	 * 设计师注册成功
	 */
	public static final String MSG_040 = "恭喜您注册成功！编写更详细的个人信息会有更多的机会被用户选择，信息审核通过后才能在平台展示哦。";
	
	/**
	 * 客服对设计师个人资料审核通过
	 */
	public static final String MSG_041 = "您提交的个人资料审核通过啦，快上传些得意作品丰富自己，准备接单啦！";
	
	/**
	 * 客服对设计师个人资料驳回<br>
	 * @param content ->驳回原因
	 */
	public static final String MSG_042 = "您提交的个人信息已被驳回，驳回原因：【content】。请核对修改后重新提交。";
	
	/**
	 * 客服禁用/启用设计师的装修案例<br>
	 * @param project->装修案例名称
	 */
	public static final String MSG_043 = "您的装修案例《【project】》已被禁用（启用）。如有任何疑问请联系我们的客服。";
	
	/**
	 * 客服派单给设计师<br>
	 * @param code ->订单编号
	 */
	public static final String MSG_044 = "您已收到了【code】号订单，一定要小跑联系客户哦~";
	
	/**
	 * 用户支付当前即将开始阶段费用<br>
	 * @param code ->订单编号<br>
	 * @param num ->阶段数
	 */
	public static final String MSG_045 = "订单号为：【code】的用户，已通过第【num】阶段啦！快根据协议设计并提交阶段内容吧！";
	
	/**
	 * 用户退回当前阶段设计<br>
	 * @param code ->订单编号<br>
	 * @param num ->阶段数<br>
	 * @param content ->退回原因
	 */
	public static final String MSG_046 = "订单号为：【code】的用户，已退回第【num】阶段内容。退回原因：【content】。";
	
	/**
	 * 用户验收通过当前阶段设计<br>
	 * @param code ->订单编号<br>
	 * @param num ->阶段数<br>
	 */
	public static final String MSG_047 = "订单号为：【code】的用户，已验收通过第【num】阶段内容啦！";
	
	/**
	 * 用户评价设计订单<br>
	 * @param code ->订单编号<br>
	 */
	public static final String MSG_048 = "订单号为：【code】的用户提交了评价，快去看看吧！";
	
	/**
	 * 用户申请退款<br>
	 * @param code ->订单编号<br>
	 * @param num ->阶段数<br>
	 */
	public static final String MSG_049 = "订单号为：【code】的用户正在申请退款，您可以确认退款或交给客服处理，24小时未处理自动通过退款。";
	
	/**
	 * 用户对阶段全部审核通过,订单完成<br>
	 * @param dname ->设计师名称<br>
	 */
	public static final String MSG_055 = "订单号为：【code】的用户，已验收通过第【num】阶段内容啦！你们的订单已经全部完成啦！快去犒劳一下自己吧！";

	
	
	/*********************************************    对散工/工长发送消息Start    ********************************************************/
	/*********************************************    对散工/工长发送消息Start    ********************************************************/
	/*********************************************    对散工/工长发送消息Start    ********************************************************/
	/*********************************************    对散工/工长发送消息Start    ********************************************************/
	/*********************************************    对散工/工长发送消息Start    ********************************************************/
	
	/**
	 * 散工/工长注册成功
	 */
	public static final String MSG_050 = "恭喜您注册成功！编写更详细的个人信息会有更多的机会被用户选择，信息审核通过后才能在平台展示哦。";
	
	/**
	 * 散工/工长个人信息审核通过
	 */
	public static final String MSG_051 = "您提交的个人资料审核通过啦，请随时保持电话畅通，准备接单啦！";
	
	/**
	 * 客服驳回散工/工长个人信息审核<br>
	 * @param content ->驳回原因
	 */
	public static final String MSG_052 = "您提交的个人信息已被驳回，驳回原因：【content】。请核对修改后重新提交。";
	
	/**
	 * 拍单成功后，发送电影票
	 */
	public static final String MSG_060 = "亲！感谢您参与中美家预约活动，双人观影券如约奉上啦！ 兑换码：【number】，请在【address】兑换使用哦~";
	
	
}
