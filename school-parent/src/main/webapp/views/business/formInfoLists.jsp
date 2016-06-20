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
				<th width="20%">
					编号
				</th>
				<th width="20%">报销人</th>
				<th width="15%">报销金额</th>
				<th width="25%">报销时间</th>
				<th width="20%">操作</th>
			</tr>
			<c:forEach var="formList" items="${result.result}">

				<tr  style="text-align: center;">
					<td width="20%"  style="text-align: center;">
						<p class="p_name">${formList.number}</p>
					</td>
					<td width="20%"  style="text-align: center;">
						<p class="p_name">${formList.rebursUser}</p>
					</td>
					<td width="15%"  style="text-align: center;">
						<p class="p_name">${formList.money}</p>
						</td>
					<td width="25%"  style="text-align: center;">
						<p class="p_name">${formList.formReimViem}</p>
					</td>
					<td width="20%"  style="text-align: center;"><a href="javascript:;" class="mm_delete"
						onclick="opeanInfo(${formList.pid});">查看详情</a></td>
				</tr>
			</c:forEach>

		</table>
		<div class="page"></div>
	</div>
<script type="text/javascript">
$(".page").createPage({
	pageCount : parseInt("${result.totalPages}"),
	current : parseInt("${result.pageNo}"),
	sum : parseInt("${result.totalCount}"),
	backFn : function(p) { //单击回调方法，p是当前页码
		openFormList("${pageDate}"+"&page=" + p);
		/* url = "/manage/form/lists?date="+date+"&page=" + p;
		location.href = url; */
	}
});

function opeanInfo(formid){
	
}
</script>
</body>
</html>
