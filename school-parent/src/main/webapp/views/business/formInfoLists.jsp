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
	<script type="text/javascript"
		src="../../static/base/js/jquery.page.js"></script>
	<link rel="stylesheet" href="../../static/base/css/page.css" />
	<div class="mm_con">
	
	
	
		<table cellspacing="0" cellpadding="0" class="mm_table">
			<tr>
				<th width="40%">
					<p class="p_name_title">名称</p>
				</th>
				<th width="25%">编辑</th>
				<th width="35%">操作</th>
			</tr>
			<c:forEach var="showRoomCase" items="${page.result}">

				<tr>
					<td>
						<p class="p_name">${showRoomCase.name}</p>
					</td>
					<td>
						<p class="mm_type" name="${showRoomCase.pid}"
							onclick="getshowRoomCase(${showRoomCase.pid})">户型</p>
					</td>
					<td><a href="javascript:;" class="mm_delete"
						name="${showRoomCase.pid}"
						onclick="deleteCase(${showRoomCase.pid});">删除</a></td>
				</tr>
			</c:forEach>

		</table>
		<div class="page"></div>
	</div>
	<script type="text/javascript">
$(".page").createPage({
	pageCount : parseInt("${page.totalPages}"),
	current : parseInt("${page.pageNo}"),
	sum : parseInt("${page.totalCount}"),
	backFn : function(p) { //单击回调方法，p是当前页码
		url = "/roomcase/lists?token=${account.token}&page=" + p;
		location.href = url;
	}
});
</script>
</body>
</html>
