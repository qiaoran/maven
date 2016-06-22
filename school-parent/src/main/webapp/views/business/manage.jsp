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
  		<div style="text-align: inherit;" >
  			<p class="add-font" onclick="opanadd();">发票数据录入</p>
  		</div>
  		<label style="margin-left: -70px;">年份快捷入口</label>
  		<div id="yearMonths">
		</div>
		</TD>
  		</tr>
  	  </table>
</div>
<div style="margin-left: 20px;margin-top: 610px;position:absolute;">
<a href="http://www.baidu.com" >关于商丘师院</a>
</div>
<script type="text/javascript">


$(function(){
	reCreateYear();
})

function reCreateYear(){
	$.ajax({
		url : "/manage/yearMonthList",
		success : function(data) {
			$("#yearMonths").html(data);
		}
	});
}

/**
 * 根据月份打开关联的发票信息 列表
 */
function openFormList(month){
	backurl1 = "/manage/form/lists?date="+month;
	backData1 = "";
	backurl = "/manage/form/lists?date="+month;
	backData = "";
	$.ajax({
		url : "/manage/form/lists?date="+month,
		success : function(data) {
			$("#content").html(data);
		}
	});
}

var backurl ="";
var backData = "";
var backurl1 ="";
var backData1 = "";
function opanadd(){
	backurl = backurl1;
	backData = backData1;
	backurl1 = "/manage/form/add";
	backData1 = "";
	$.ajax({
		url : "/manage/form/add",
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

function opeanInfo(formid){
	backurl = backurl1;
	backData = backData1;
	backurl1 = "/manage/form/info";
	backData1 = formid;
	$.ajax({
		url : "/manage/form/info",
		data : {
			"formId":formid
		},
		success : function(data) {
			$("#content").html(data);
		}
	});
}

function updateInfo(formid){
	backurl = backurl1;
	backData = backData1;
	backurl1 = "/manage/form/update";
	backData1= formid;
	$.ajax({
			url : "/manage/form/update",
			data : {
				"formId":formid
			},
			success : function(data) {
				$("#content").html(data);
			}
	});
}
function gobackFunct(){
	if(""!=backData){
		$.ajax({
			url : backurl,
			data : {
				"formId":backData
			},
			success : function(data) {
				$("#content").html(data);
			}
			});
	}else{
		if(""==backurl){
			backurl = "/manage/form/lists";
		}
		$.ajax({
			url : backurl,
			success : function(data) {
				$("#content").html(data);
			}
			});
	}
	var backur2 = backurl;
	var backData2 = backData;
	backurl = backurl1;
	backData = backData1;
	backurl1 = backur2;
	backData1= backData2;
	
	//window.history.go(-1);
//	window.location.reload();
}
</script>
</body>
</html>
