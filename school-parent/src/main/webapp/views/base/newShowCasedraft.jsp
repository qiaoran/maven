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
<title>新增案例</title>
<script type="text/javascript" src="../../static/upload/imgUpload.js"></script>
</head>

<body>
	<div class="createLayer">
		<h3 class="cr_h3">
			<a href="javascript:;" class="cr_close"></a> 新建设计
		</h3>
		<div class="cr_main">

			<ul>
				<li class="cr_li"><label>设计名称：</label>
					<div class="cr_right">
						<c:choose>
							<c:when test="${null!=showRoomCase&&''!=showRoomCase}">
								<input type="text" class="cr_inp" id="casename" name="name"
									value="${showRoomCase.name}" />
							</c:when>
							<c:otherwise>
								<input type="text" class="cr_inp" id="casename" name="name" />
							</c:otherwise>
						</c:choose>
					</div></li>
				<li class="cr_li"><label></label>
					<div class="cr_right">
						<img src="" alt="" />
						<div class="cr_photo">
							<img src="" alt="" class="cr_img" id="logoimage" /> <input
								type="file" class="cr_upload" />
						</div>
						<p class="cr_pho_p">暂无户型图</p>
					</div></li>
			</ul>
			<a class="cr_certain" onclick="newShowCase();">确定</a>
		</div>
	</div>
	<script type="text/javascript">
	var tokken = "${token}";
	var listsrcs="/afdsaf;asfdsaf/";
	var logoUrl ="/safdsalf";
	var pid = "${showRoomCase.pid}";
	function newShowCase(){
		var data;
		if(null!=pid&&""!=pid){
			data = {
					"token" : tokken,
					"listsrcs":listsrcs,
					"logoUrl":logoUrl,
					"name":$("#casename").val(),
					"pid":pid
				};
		}else{
			data ={
					"token" : tokken,
					"listsrcs":listsrcs,
					"logoUrl":logoUrl,
					"name":$("#casename").val()
				};
		}
		
		$.ajax({
			type : 'POST',
			url : "/roomcase/save",
			data :data,
			success : function(data) {
				if(true==data.success){
					alert("保存成功！");
					window.location.href="/";
				}else{
					alert(data.message);
				}
			}
		});
	}
	</script>
</body>
</html>
