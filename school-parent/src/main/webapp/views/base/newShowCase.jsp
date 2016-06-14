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
  </head>

 <body>
	<div class="createLayer" >
		<h3 class="cr_h3">
			<a href="javascript:;" class="cr_close"></a>
			新建设计
		</h3>
		<div class="cr_main">
			
			<ul>
				<li class="cr_li">
					<label></label>
					<div class="cr_right">
						<div class="cr_selection">
							<input type="radio" name="c-area" value="真实小区" checked="checked" />真实小区
							<input type="radio" name="c-area" value="虚拟小区" />虚拟小区
						</div>
					</div>
				</li>
				<li class="cr_li">
					<label>设计师名称：</label>
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
					</div>
				</li>
				<li class="cr_li">
					<label>地址：</label>
					<div class="cr_right clearfloat">
						<div class="cr_sel smiSel" style="border-right:0 none;" id="cityselect">
					
						<span>请选择</span>
						<ul>
						<c:forEach var="cityelist" items="${citys}">
						<li id="${cityelist.pid}">${cityelist.name}</li>
						</c:forEach>
						</ul>
						</div>
						<div class="cr_sel smiSel" style="border-right:0 none;" id="countyselect">
						<span>中关村</span>
						<ul>
						<!-- 	<li id="1">中关村</li> -->
						</ul>
						</div>
						<div class="cr_sel smiSel" id="commintyselectul">
							<span>西三旗</span>
							<ul>
							</ul>
						</div>
					</div>
				</li>
				<li class="cr_li">
					<label>小区名称：</label>
					<div class="cr_right">
						<div class="crInputOuter smiInput">
							<input type="text" class="cr_inp" />
							<ul class="lf_inp_ul">
								<li>保利花园</li>
								<li>保利花园A</li>
								<li>保利花园A1户型</li>
								<li>保利花园B2户型</li>
								<li>保利花园C3</li>
							</ul>
						</div>
						<a href="javascript:;" class="cr_area_link">选择</a>
					</div>
				</li>
				<li class="cr_li">
					<label></label>
					<div class="cr_right">
						<div class="cr_sel w161 smiSel">
							<span>F2 三室两厅 89平</span>
							<ul>
								<li>F2 三室两厅 89平</li>
							</ul>
						</div>
						<input type="text" class="cr_inp2" />
						室
						<input type="text" class="cr_inp2" />
						厅
						<input type="text" class="cr_inp2" />
						卫
					</div>
				</li>
				<li class="cr_li">
					<label></label>
					<div class="cr_right">
						<img src="" alt="" />
						<div class="cr_photo">
							<img src="" alt="" class="cr_img" />
							<input type="file" class="cr_upload" />
						</div>
						<p class="cr_pho_p">暂无户型图</p>
					</div>
				</li>
			</ul>
			<a href="javascript:;" class="cr_certain">确定</a>
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
