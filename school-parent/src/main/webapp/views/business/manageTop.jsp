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
<link href="../../static/base/css/manageTop.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="../../static/base/js/login.js"></script>
</head>
<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="59" background="../../static/base/images/top.gif"><table
					width="99%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="35%"><span class="STYLE1">发票电子</spa里n></td>
						<td width="10%" align="right"
							style="font-size: 12px; vertical-align: bottom;">&nbsp;</td>
						<td width="30%" align="right">名称： 
						<c:choose>
								<c:when test="${null!=sessionScope.loginAccount.nickName&&''!=sessionScope.loginAccount.nickName}">
							${sessionScope.loginAccount.nickName}
							</c:when>
								<c:otherwise>
							${sessionScope.loginAccount.account}
							</c:otherwise>
							</c:choose>
						</td>
						<td width="25%" align="right">退出</td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>
