<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
<meta name="renderer" content="webkit">
<title>管理平台</title>
<title>Login</title>
</head>
<body>


<div id="head" style="height: 59px;width:100%:hidden;margin:0;">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="59" background="../../static/base/images/top.gif"><table
							width="99%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td ><span class="top-font01">商丘师范发票归档系统</spa里n></td>
							</tr>
						</table></td>
				</tr>
			</table></div>
<div class="main">
    <div class="content" id="content">
   <!-- <div style="font: bolder 20px/600px '方正舒体';text-align: center;">  欢迎来到商丘师范发票归档系统！</div> -->
   <tr/>
     <div style="font: bolder 30px '方正舒体';top: 50px;left: 50px;">  欢迎来到商丘师范发票归档系统！</div>
    </div>
</div>
<div class="sitebar">
	<table width="198" cellpadding="0" cellspacing="0" class="left-table01" border="1" style="border:1px solid #6795B4">
  		<tr height="55px">
   		 <TD>
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
		  	 <tr>
				<td width="207" height="55" background="../../static/base/images/nav01.gif">
					<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" height="54px">
				  		<tr>
							<td width="25%" rowspan="2"><img src="../../static/base/images/ico02.gif" width="35" height="35" /></td>
							<td width="75%" height="22px" class="left-font01">您好，<span class="left-font02">
							 <c:choose>
										<c:when test="${null!=sessionScope.loginAccount.nickName&&''!=sessionScope.loginAccount.nickName}">
							${sessionScope.loginAccount.nickName}
							</c:when>
										<c:otherwise>
							${sessionScope.loginAccount.account}
							</c:otherwise>
									</c:choose>
									</span></td>
				 		 </tr>
				  		<tr>
							<td height="22" class="left-font01">
								[&nbsp;<a href="welcome.jsp" target="_top" class="left-font01" onclick="ajaxLogout();">退出</a>&nbsp;]</td>
				  		</tr>
					</table>
				</td>
		  	 </tr>
			</table> 
		  </TD>
  		</tr>
  		<tr style="border:1px solid #6795B4" height="545px">
  		<td valign="top" style="text-align: center;">
   		 	<li style="margin-top: 10px;" onclick="openFormList();">2016年6月</li>
   		  	<li style="margin-top: 10px;" onclick="openFormList();">2016年5月</li>
   		  	<li style="margin-top: 10px;" onclick="openFormList();">2016年4月</li>
   		    <li style="margin-top: 10px;" onclick="openFormList();">2016年3月</li>
   		    <li style="margin-top: 10px;" onclick="openFormList();">2016年2月</li>
		  </TD>
  		</tr>
  	  </table>
</div>
-
<div style="margin-left: 20px;">
<a href="http://www.baidu.com" >关于商丘师院</a>
</div>
<script type="text/javascript">
/**
 * 根据月份打开关联的发票信息 列表
 */
function openFormList(date){
	$.ajax({
		url : "/manage/form/lists",
		success : function(data) {
			$("#content").html(data);
		}
	});
}
</script>
</body>
</html>
