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
<form name="formFrom" method="post" >
<div class="MainDiv" style="height: 600px;">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >发票信息录入</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:80%" align="center">
		<tr><td align="left">
		<input type="button"value="保存" class="button" onclick="fromValidate();"/>　
		<input type="reset" value="返回" class="button" onclick="gobackFunct();"/>
		</td></tr>
		
		<input name="pid" type="text" value="${forminfo.pid}" disabled="disabled" style="display: none;"/>
		
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>发票信息</legend>
				<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
				<tr style="height: 30px;">
					<td nowrap align="right" width="9%">编号：</td>
					<td width="38%"><input name="number" type="text" value="${forminfo.number}" class="input" onkeyup="value=value.replace(/[\W]/g,'') " onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">
					<span class="red">*</span></td>
					<td width="12%"><div align="right">金额：</div></td>
					<td width="39%"><input name="money" type="text" value="${forminfo.money}" class="input"   onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<span class="red">*</span></td> 
				</tr>
				<tr style="height: 30px;">
					<td nowrap align="right" width="9%">报销人：</td>
					<td><input name="rebursUser" type="text" class="input" value="${forminfo.rebursUser}"><span class="red">*</span></td>
					<td><div align="right">报销时间：</div></td>
					<td><input name="formReim" type="text" class="easyui-datebox" value="${forminfo.formReim}">
					<span class="red">*</span></td>
				</tr >
				<tr >
					<td width="9%" nowrap align="right">图片：</td>
					<td colspan="3">
						<div class="inputcontlist">
                            <input type="button" value="选择" class="adbutsun" id="browse"/><br>
                            <div id="styleinfo3" class="promptsund error_info"></div>
                         </div>
                     </td>
				</tr>
				<tr>
				    <td width="9%" nowrap align="right"></td>
					<td colspan="3">
					 	<div class="inpuimg_cover" id="imagesLists">
                           <c:forEach var="imagelist" items="${forminfo.images}">
                           		<img id="${imagelist.pid}" src="${fsever}${imagelist.imageUrl}" width="120" height="120" alt="" class="imagess" onclick="removimeg(this);"/>
                           </c:forEach>
                         </div>
					</td>
				</tr>
				<tr style="height: 30px;">
					<td width="9%" nowrap align="right">摘要：</td>
					<td colspan="3">
					<textarea name="formAbstract" cols="100" rows="6" class="input" id="formAbstract">${forminfo.formAbstract}</textarea></td>
				</tr>
				<tr style="height: 30px;">
					<td width="9%" nowrap align="right">备注：</td>
					<td colspan="3">
					<textarea name="remark" cols="100" rows="6" class="input" id="remark">${forminfo.remark}</textarea></td>
				</tr>
				
				</table>
				</fieldset>		
			</TD>
			
		</TR>
		</TABLE>
	 </td>
  </tr>
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="button"value="保存" class="button" onclick="fromValidate();"/>　
			<input type="reset" value="返回" class="button" onclick="gobackFunct();"/>
		</TR>
		</TABLE>	
</div>
</form>

<script type="text/javascript">

$(function(){
	initsqUpload(function () {
            var uploader = getUploader("browse", true);
            fileUploaded(uploader, function (url) {
                $("#imagesLists").append('<img id="'+url+'" src="'+fserver+url+'" width="120" height="120" alt="" class="imagess" onclick="removimeg(this);"/>');
            });
            fileUploadeAdded(uploader, function (upload, files) {
            	upload.setOption("multipart_params",{"size":"360*360"});
            	upload.start();
            });
        });
})
/**
 * 提交校验
 */
function fromValidate(){

	if(formFrom.number.value==""){
		alert("编号不能为空");		
		formFrom.number.focus();
		return false;
	}
	
	if(formFrom.money.value==""){
		alert("报销金额不能为空");		
		formFrom.money.focus();
		return false;
	}
	
	if(formFrom.rebursUser.value==""){
		alert("报销人不能为空");		
		formFrom.rebursUser.focus();
		return false;
	}
	
	if(formFrom.formReim.value==""){
		alert("报销时间不能为空");		
		formFrom.formReim.focus();
		return false;
	}else{
		$.ajax({
			type : 'POST',
			url : "/manage/form/check",
			data : {
				"pid":formFrom.pid.value,
				"number":formFrom.number.value,
				"newDate":formFrom.formReim.value
			},
			success : function(data) {
				if(true!=data.success){
					alert("编号已经存在");		
					formFrom.number.focus();
					return false;
				}else{
					var images = '';
					var iamges = $("#imagesLists img");
					if(iamges.length>0){
						for(var i=0;i<iamges.length;i++){
							if(''==images){
								images = iamges[i].id;
							}else{
								images = images +","+iamges[i].id;
							}
						}
					}
					
					$.ajax({
						type : 'POST',
						url : "/manage/form/save",
						data : {
							"pid" : formFrom.pid.value,
							"number" : formFrom.number.value,
							"money":formFrom.money.value,
							"rebursUser":formFrom.rebursUser.value,
							"newDate":formFrom.formReim.value,
							"formAbstract":formFrom.formAbstract.value,
							"remark":formFrom.remark.value,
							"imagearrsy":images
						},
						success : function(data) {
							if(data.success){
								alert("保存成功");	
								//window.location.reload();
								reCreateYear();
								gobackFunct();
							}else{
								alert(data.message);
							}
						}
					});
				}
			}
		});
	}
}

function removimeg(obj){
	obj.parentNode.removeChild(obj); 
}

</script>
</body>
</html>
