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
    <div class="content" id="content" style="background:#F6F6F6;">
   <tr/>
     <div style="font: bolder 30px '方正舒体';top: 50px;left: 50px;">  欢迎来到商丘师范发票归档系统！</div>
    </div>
</div>
<div class="sitebar">
	<table width="198" cellpadding="0" cellspacing="0" class="left-table01">
  		<tr height="55px"  style="border:1px solid #6795B4" >
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
  		<tr style="border:1px solid #6795B4;border-top-color: red" height="545px">
  		<td valign="top" style="text-align: center;">
  		<!-- <label style="margin-left: -70px;">按年份列出</label> -->
  		<c:forEach var="yearList" items="${yearLists}">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" >
				<tr>
					<td>
						<table width="90%" border="0" align="center" cellpadding="0"cellspacing="0"  class="left-table03">
							<tr height="29px;">
								<td width="20%" align="right"><img id="${yearList.myyear}title" class="imageClass" name="img8" id="img8" src="../../static/base/images/ico04.gif"  height="11" /></td>
								<td width="40%" onClick="openMonth(this);" id="${yearList.myyear}"><a href="javascript:" target="mainFrame"class="left-font03" >${yearList.myyearname}</a></td>
								<td width="40%"></td>
							</tr>
						</table>
						<table  width="100%" border="0" cellpadding="0" cellspacing="0" style="display:none;" class="tableClass">
							<c:forEach var="month" items="${yearList.months}">
							<tr height="20px;" class="left-table04" style="margin-top: 5px;">
								<td width="20%"></td>
								<td width="40%">
								<img id="xiaotu3" src="../../static/base/images/ico06.gif"  width="8" height="12" />
								<a href="#" style="margin-left: 10px;" onclick = "openFormList('${month.mymonth}');">${month.mymonthname}</a>
								</td>
								<td width="40%"></td>
							</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
				
			</table>
		</c:forEach>
		</TD>
  		</tr>
  	  </table>
</div>
<div style="margin-left: 20px;margin-top: 610px;position:absolute;">
<a href="http://www.baidu.com" >关于商丘师院</a>
</div>
<script type="text/javascript">
/**
 * 根据月份打开关联的发票信息 列表
 */
function openFormList(month){
	$.ajax({
		url : "/manage/form/lists?date="+month,
		success : function(data) {
			$("#content").html(data);
		}
	});
}

function openMonth(obj){
	var falt = $(obj).parents('.left-table03').next().is(':hidden');
	$('.tableClass').hide();
	$('.imageClass').attr('src','../../static/base/images/ico04.gif');
	if(falt){
		$("#"+obj.id+"title").attr('src','../../static/base/images/ico03.gif');
		$(obj).parents('.left-table03').next().show();
	}
	
	
}
</script>
</body>
</html>
