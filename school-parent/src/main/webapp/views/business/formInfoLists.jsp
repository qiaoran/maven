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
	<div class="mm_con" style="margin-left: -8px;">


		<table width="100%" border="0" cellspacing="0" cellpadding="0">

			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="62" background="../../static/base/images/nav04.gif">&nbsp;</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td><table id="subtree1" style="DISPLAY:" width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="95%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="20"><span style="font-family: '宋体';font-size: 13px;font-weight: bold;color: #174B73;text-decoration: none;">发票信息查看</span></td>
									</tr>
									<tr style="height: 50px;">
										<td>
										<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
										<tr>
										<td nowrap align="right" width="9%">编号：</td>
										<td width="20%"><input name="number" id="searchNumber" type="text" value="${forminfo.number}" class="input" onkeyup="value=value.replace(/[\W]/g,'') " onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">
										<td width="9%"><div align="right">报销人：</div></td>
										<td width="20%"><input name="money" id="searchMoney" type="text" value="${forminfo.money}" class="input" >
										<td align="left"><input type="button"value="查询" class="button" onclick="searchList();"/>　</td>
										</tr>
										</table>
										</td>
									</tr>
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" style="font-family: '宋体'; font-size: 12px;color: #000000;text-decoration: none;border:1px solid #6795B4" >
												<tr style="background: #6795B4;padding: 5px;text-align: left;color: #FFFFFF;font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;height: 30px;" >
													<td height="22" colspan="8" align="center"
														style="font-size: 16px">报销信息列表</td>
												</tr>
												<tr bgcolor="#EEEEEE" style="height: 30px;">
													<td width="10%" align="center" height="30">编号</td>
													<td width="20%" align="center">报销人</td>
													<td width="20%" align="center">报销金额</td>
													<td width="25%" align="center">报销时间</td>
													<td width="25%" align="center">操作</td>
												</tr>

												<c:forEach var="formList" items="${result.result}">

													<tr bgcolor="#FFFFFF"  style="height: 30px;">
														<td width="20%" style="text-align: center;">
															<p class="p_name">${formList.number}</p>
														</td>
														<td width="20%" style="text-align: center;">
															<p class="p_name">${formList.rebursUser}</p>
														</td>
														<td width="15%" style="text-align: center;">
															<p class="p_name">${formList.money}</p>
														</td>
														<td width="25%" style="text-align: center;">
															<p class="p_name">${formList.formReimViem}</p>
														</td>
														<td width="20%" style="text-align: center;"><a
															href="javascript:;" style="text-decoration: none;color: #003288;"
															onclick="opeanInfo(${formList.pid});">查看详情</a>&nbsp;
															<a href="javascript:;" style="text-decoration: none;color: #003288;"
															onclick="updateInfo(${formList.pid});">编辑</a>&nbsp;
															<a href="javascript:;" style="text-decoration: none;color: #003288;"
															onclick="deleteInfo(${formList.pid});">删除</a></td>
													</tr>
												</c:forEach>
											</table>
										</td>
									</tr>
								</table></td>
						</tr>
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
	}
});

function searchList(){
	var sc = "${pageDate}";
	if(""!=$("#searchNumber").val()){
		sc = sc +"&number="+$("#searchNumber").val();
	}
	if(""!=$("#searchMoney").val()){
		sc = sc +"&rebursUser="+$("#searchMoney").val();
	}
	openFormList(sc);
}

function deleteInfo(formid){
	if(confirm("确认删除吗")){
		$.ajax({
			type : 'POST',
			url : "/manage/form/delete",
			data : {
				"formId":formid
			},
			success : function(data) {
				if(data.success){
					alert("删除成功");
					openFormList("${pageDate}");
				}else{
					alert("删除失败");
				}
			}
		});
		  };
}

</script>
</body>
</html>
