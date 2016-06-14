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
<title>我的设计案例</title>
<script type="text/javascript" src="../../static/base/js/jquery.page.js"></script>
<link rel="stylesheet" href="../../static/base/css/page.css" />
</head>
<body>
	<div class="plat">
		<div class="myplat_top">
			<div class="myplat_top_inner">
				<div class="mt_right">
					<dl class="mt_dl">
						<dt>
							<b>530</b>个
						</dt>
						<dd>上传模型</dd>
					</dl>
					<dl class="mt_dl">
						<dt>
							<b>530</b>个
						</dt>
						<dd>上传户型</dd>
					</dl>
					<dl class="mt_dl">
						<dt>
							<b>530</b>元
						</dt>
						<dd>累计收益</dd>
					</dl>
				</div>
				<div class="mt_left">
					<dl class="mt_dl">
						<dt>
							<b>${casenum} </b>
						</dt>
						<dd>设计数量</dd>
					</dl>
					<dl class="mt_dl">
						<dt>
							<b>${shownum} </b>
						</dt>
						<dd>已发布</dd>
					</dl>
					<dl class="mt_dl">
						<dt>
							<b>${noshownum} </b>
						</dt>
						<dd>未发布</dd>
					</dl>
				</div>
				<div class="mt_con">
					<div class="mt_head">
						<c:choose>
							<c:when test="${null!=account.logoUrl&&''!=account.logoUrl}">
								<img src="${fsever}${account.logoUrl}" alt=""  style="width: 50px;height: 50px;"/>
							</c:when>
							<c:otherwise>
								<img src="../../static/base/images/p_head_pic.jpg" alt="" />
							</c:otherwise>
						</c:choose>
					</div>
					<label class="mt_name"> ${account.nickName} <span
						class="mt_level"> LV. <font>12</font>
					</span>
					</label>
					<div class="mt_balance">
						我的余额：<font>530元</font>
					</div>
					<a href="javascript:;" class="mt_logOff" onclick="logout();">注销</a>
				</div>
			</div>
		</div>
		<div class="myplat_main">
			<div class="mm_top">
				<div class="mm_top_inner">
					<div class="mm_operation">
						<a href="javascript:;" class="new_design" onclick="newHouseDesign()">新设计</a>
					</div>
					<ul class="mm_tabs">
						<li class="tab_chosen">我的户型</li>
					</ul>
				</div>
			</div>
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
								<p class="mm_type" name="${showRoomCase.pid}" onclick="getshowRoomCase(${showRoomCase.pid})">户型</p>
							</td>
							<td><a href="javascript:;" class="mm_delete"
								name="${showRoomCase.pid}"
								onclick="deleteCase(${showRoomCase.pid});">删除</a></td>
						</tr>
					</c:forEach>

				</table>
				<div class="page"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	var tokken = "${account.token}";
	
	$(".page").createPage({
		pageCount : parseInt("${page.totalPages}"),
		current : parseInt("${page.pageNo}"),
		sum : parseInt("${page.totalCount}"),
		backFn : function(p) { //单击回调方法，p是当前页码
			url = "/roomcase/lists?token=${account.token}&page=" + p;
			location.href = url;
		}
	});
	
	
	function deleteCase(id){
		$.ajax({
			type : 'POST',
			url : "/roomcase/delete",
			data : {
				"token" : tokken,
				"caseid":id
			},
			success : function(data) {
				if(true==data.success){
					alert("删除成功！");
					window.location.href="/roomcase/lists?token="+tokken;
				}else{
					alert(data.message);
				}
			}
		});
	}
	
	function logout(){
		$.ajax({
			type : 'POST',
			url : "/login/user/logout",
			data : {
				"token" : tokken
			},
			success : function(data) {
				if(true==data.success){
					alert("退出成功！");
					window.location.href="/";
				}else{
					alert(data.message);
				}
			}
		});
	}
	function getshowRoomCase(id){
		//alert(id);
		//c++接口
		if(typeof(htmlOperateObject)!='undefined' ){
			htmlOperateObject.jsOpenHouseDesign(id);
		}
		//测试代码
		 $.ajax({
			 type : 'POST',
			 url:'/roomcaseInterFace/info',
			 data:{'token':201605171417279401,'shcaseid':1},
			 success:function(){
				
			 }
		 });
		
	}
	function newHouseDesign(){
		//c++接口
		if(typeof(htmlOperateObject)!='undefined' ){
			htmlOperateObject.jsNewHouseDesign();
		}
		
	}
	//c++回调函数
	function getdata(fileUrlList){
		alert(fileUrlList);
	}
    
	</script>

</body>
</html>
