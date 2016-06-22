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
<title>lift</title>
 <body class="ContentBody">
 <link rel="stylesheet" rev="stylesheet" href="../../static/base/css/style.css " type="text/css" media="all" />
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >发票信息详情</th>
  </tr>
  <tr>
    <td class="CPanel">
		<table border="0" cellpadding="0" cellspacing="0" style="width:80%" align="center">
		<tr>
			<td width="100%">
				<fieldset style="height:100%;">
				<legend>发票信息详情</legend>
					  <table border="0" cellpadding="8" cellspacing="1" style="width:100%">
					  <tr style="height: 31">
					    <td nowrap align="right" width="11%"  style="height: 31px;">发票编号：</td>
					    <td width="89%"  style="height: 31px;">${formInfo.number}</td>
					    </tr>
					  <tr  style="height: 31">
					    <td nowrap align="right" width="11%" style="height: 31px;">金额：</td>
					    <td style="height: 31px;">${formInfo.money}</td>
					    </tr>
					  <tr  style="height: 31">
					    <td width="11%" nowrap align="right" style="height: 31px;">报销人：</td>
					    <td style="height: 31px;">${formInfo.rebursUser}</td>
					  </tr>
					  <tr style="height: 31">
					    <td width="11%" nowrap align="right" style="height: 31px;">报销时间：</td>
					    <td style="height: 31px;">${formInfo.formReim}</td>
					  </tr>
					  <tr style="height: 31">
					    <td width="11%" nowrap align="right" style="height: 31px;">摘要：</td>
					    <td style="height: 31px;">${formInfo.formAbstract}</td>
					  </tr>
					  <tr style="height: 31">
					    <td width="11%" nowrap align="right" style="height: 31px;">备注：</td>
					    <td style="height: 31px;">${formInfo.remark}</td>
					  </tr>
					  <tr>
					    <td width="11%" nowrap align="right" >图片：</td>
					    <td> <c:forEach var="imagelist" items="${formInfo.images}">
                           		<img id="${imagelist.pid}" src="${fsever}${imagelist.imageUrl}" alt="" />
                           </c:forEach></td>
					  </tr>
					  <tr  style="height: 31">
   							 <td height="22" colspan="2" align="center" style="height: 41px;">
   							 <input type="reset" value="修改" class="button" onclick="updateInfo(${formInfo.pid});" />&nbsp;&nbsp;
   							 <input type="reset" value="返回" class="button" onclick="gobackFunct();"/>
   							 </td>
 					  </tr>
					  </table>
				</fieldset>	
			</td>
		</tr>
		</table>
	 </td>
  </tr>
</table>	
</div>
</body>
</html>
