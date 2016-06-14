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
<title>资源库</title>
<script type="text/javascript" src="../../static/base/js/jquery.page2.js"></script>
<link rel="stylesheet" href="../../static/base/css/page.css" />
</head>
<body>
<div class="lib">
		<div class="mylib_top">
			<div class="mylib_top_inner">
				<div class="cityArea">
					<span>${address.province}</span>
					<a href="javascript:;" class="cityChange">【切换城市】</a>
				</div>
				<div class="lib_head">
					<c:choose>
							<c:when test="${null!=account.logoUrl&&''!=account.logoUrl}">
								<img src="${fsever}${account.logoUrl}" alt=""  style="width: 50px;height: 50px;"/>
							</c:when>
							<c:otherwise>
								<img src="../../static/base/images/p_head_pic.jpg" alt="" />
							</c:otherwise>
						</c:choose>
					<dl class="lib_dl">
						<dt> ${account.nickName} </dt>
						<dd>
							<a href="javascript:;" class="lib_login_off" onclick="logout();">注销</a>
						</dd>
					</dl>
				</div>
				<div class="lib_filter">
					<div class="lf_sel smiSel" id="cityselect">
					
						<span>请选择</span>
						<ul>
						<c:forEach var="cityelist" items="${citys}">
						<li id="${cityelist.pid}">${cityelist.name}</li>
						</c:forEach>
						</ul>
					</div>
					<div class="lf_sel smiSel" id="countyselect">
						<span>中关村</span>
						<ul>
						<!-- 	<li id="1">中关村</li> -->
						</ul>
					</div>
					<div class="lf_inp smiInput" id="commintyselect">
						<span></span>
						<input type="text" class="placeholder" data-value="小区名称、开发商等关键词" id="commintyselectulinput"/>
						<ul class="lf_inp_ul" id="commintyselectul">
							<!-- <li>保利花园</li>
							<li>保利花园A</li>
							<li>保利花园A1户型</li>
							<li>保利花园B2户型</li>
							<li>保利花园C3</li> -->
						</ul>
					</div>
				</div>
				<div class="lib_top_btns">
					<a href="javascript:;" class="createNew">新绘制</a>
				</div>
				
			</div>
		</div>
		<div class="mylib_main">
			<h2 class="lm_title">
				<b>保利花园</b>
				<div class="lm_cho smiSel" id="apartmentselect">
					<span>全部</span>
					<ul class="lm_choice" id="apartmentselectlist">
						<li>全部</li>
						<li>A1户型</li>
						<li>A2户型</li>
						<li>B1户型</li>
						<li>B2户型</li>
						<li>C1户型</li>
						<li>C2户型</li>
						<li>C3户型</li>
					</ul>
				</div>
				
			</h2>
			<div class="lib_list">
				<ul class="clearfloat" id="casess">
				</ul>
			</div>
			
			<div class="page"></div>
		</div>
	</div>
	
	<script type="text/javascript">
	
	var isfirst = true;
	
	var tokken = "${account.token}";
	var cityid ="${address.cityid}";
	var cityname ="${address.city}";
	var countyid = "${address.countyid}";
	var countyname = "${address.county}";
	
	var comminutyid;
	var apartidselec;
	
	$(function(){
		
		if(""!=cityid){
			$("#cityselect span").text(cityname);
			selectsban("cityselect",cityid);
			cityid = "";
		}
	});
	
	function selectsban(typeid,selectid){
		
		if("cityselect"==typeid){
			$("#commintyselectul").html("");
			$("#apartmentselectlist").html("");
			getCountys(selectid);
		}else if("countyselect"==typeid){
			$("#apartmentselectlist").html("");
			//获取小区
			getCommunitys(selectid);
		}else if("commintyselect"==typeid){
			comminutyid = selectid;
			getHouseAparts(selectid);
		}else if("apartmentselect"==typeid){
			getCases(selectid,1);
		}
	}
	
		function getCountys(cityid) {
			$.ajax({
				type : 'POST',
				url : "/houseapartselect/countys",
				data : {
					"cityid" : cityid
				},
				success : function(data) {
					if (null != data && 0 != data.length) {
						var htmls = '';
						for (var i = 0; i < data.length; i++) {
							htmls = htmls + '<li id="'+data[i].pid+'">'
									+ data[i].name + '</li>';
						}
						$("#countyselect ul").html(htmls);
					}else{
						$("#countyselect ul").html("");
					}
					if ("" != countyid) {
						$("#countyselect span").text(countyname);
						getCommunitys(countyid);
						countyid = "";
					}
				}
			});
		}

		function getCommunitys(countyid) {
			$.ajax({
				type : 'POST',
				url : "/houseapartselect/communitys",
				data : {
					"countyid" : countyid
				},
				success : function(data) {
					if (null != data && 0 != data.length) {
						
						var htmls = '';
						for (var i = 0; i < data.length; i++) {
							htmls = htmls + '<li id="'+data[i].pid+'">'
									+ data[i].name + '</li>';
						}
						$("#commintyselectul").html(htmls);
						
						if(isfirst){
							$("#commintyselectulinput").val(data[0].name);
							getHouseAparts(data[0].pid);
						}
					}else{
						$("#commintyselectul").html("");
					}
				}
			});
		}

		function getHouseAparts(communityid) {
			$.ajax({
				type : 'POST',
				url : "/houseapartselect/houseApartments",
				data : {
					"communityid" : communityid
				},
				success : function(data) {
					if (null != data && 0 != data.length) {
						var htmls = '<li id="all">全部</li>';
						for (var i = 0; i < data.length; i++) {
							htmls = htmls + '<li id="'+data[i].pid+'">'
									+ data[i].name + '</li>';
						}
						$("#apartmentselectlist").html(htmls);
						if(isfirst){
							isfirst = false;
							comminutyid = communityid;
							getCases("all",1);
						}
					}else{
						$("#apartmentselectlist").html("");
					}
				}
			});
		}
		
		function getCases(apartid,page){
			apartidselec = apartid;
			var data;
			if("all"==apartid){
				data = {
					token:tokken,
					rows:8,
					page:page,
					commintyid:comminutyid
				};
			}else{
				data = {
						token:tokken,
						page:page,
						rows:8,
						commintyid:comminutyid,
						aprtid:apartid
				};
			}
			$.ajax({
				type : 'POST',
				url : "/roomcase/listsApart",
				data : data,
				success : function(data) {
					if(null!=data){
						if (null != data.page.result&& 0 != data.page.result.length) {
							var htmls = "";
							for (var i = 0; i < data.page.result.length; i++) {
								htmls = htmls
													+ '<li class="lib_item">'
													+ '<a href="javascript:;" class="lib_item_sample">'
													+ '<img src="'+fserver+data.page.result[i].logoUrl+'" style= "width: 245px;height: 178px;" alt="" />'
													+ '<p>居室'
													+ data.page.result[i].apartment.roomSum
													+ '室'
													+ data.page.result[i].apartment.hallSum
													+ '厅'
													+ data.page.result[i].apartment.kitchenSum
													+ '厨'
													+ data.page.result[i].apartment.bathRoomSum
													+ '卫   楼建筑面积：'
													+ data.page.result[i].apartment.area
													+ 'm²</p>'
													+ '</a>'
													+ '<div class="lib_item_des">'
													+ '<img style= "width: 50px;height: 50px;" src="'+fserver+data.page.result[i].createuser.logoUrl+'" alt="" />'
													+ '<h4>'
													+ data.page.result[i].name
													+ '</h4>' + '<font>'
													+ data.page.result[i].downSum
													+ '人下载</font>' + '</div>'
													+ '</li>';
							}
							$("#casess").html(htmls);
							}else{
								$("#casess").html("");
							}
						createPage(data.page.totalPages, data.page.pageNo, data.page.totalCount);
						
						}
					}
				});
			}

		function logout() {
			$.ajax({
				type : 'POST',
				url : "/login/user/logout",
				data : {
					"token" : tokken
				},
				success : function(data) {
					if (true == data.success) {
						alert("退出成功！");
						window.location.href = "/";
					} else {
						alert(data.message);
					}
				}
			});
		}
		
		/*
		* 创建分页
		*/
		function createPage(totalPages,pageNo,totalCount){
			createPageNew({
				pageCount : parseInt(totalPages),
				current : parseInt(pageNo),
				sum : parseInt(totalCount), 
				backFn : function(p) { //单击回调方法，p是当前页码
					getCases(apartidselec,p)
				}
			});
		}
		
	</script>
</body>
</html>
