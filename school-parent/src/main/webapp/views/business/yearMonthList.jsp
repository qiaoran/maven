<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
<meta name="renderer" content="webkit">
<title>center</title>
<body>
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
</body>
</html>
