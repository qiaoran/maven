<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style>
	.boxsharebox{width:220px; height:auto; position:absolute; display:none; left:0px; top:0px; padding-top:30px; left:-20px; z-index: 999;}
	.boxshare{ width:200px; height: auto;  position:relative; background:#f6f5f5;  box-shadow:0 2px 6px 2px #d8d8d8; border:1px #F6F6F6 solid; padding:10px; border-radius:6px;}
	.boxinstructions{ width:16px; height:16px; transform:rotate(45deg); -ms-transform:rotate(45deg); -o-transform:rotate(45deg); -webkit-transform:rotate(45deg); -moz-transform:rotate(45deg); position:absolute; border:1px #F6F6F6 solid; background:#f6f5f5; top:-10px; left:20px;}
	.bdsharebuttonbox{ width:195px; position:relative;}
	.bdsharebuttonbox a{ position:relative; margin-bottom:30px; margin-left:20px; margin-right:20px;}
	.bdsharebuttonbox a span{ position:absolute; display:block; text-align:center; width:60px; font-size:12px; color:#333; top:28px; left:-18px;}
</style>
<script>
	$(function(){
		$(".share").mouseenter(function(){
			$(".boxsharebox").fadeIn(200);
		}).mouseleave(function(){
			$(".boxsharebox").fadeOut(200);
		});
	});
</script>

<%-- 此处添加展示按钮 --%>

	<div class="boxsharebox">
		<div class="boxshare">
			<div class="boxinstructions"></div>
			<div class="bdsharebuttonbox" data-tag="share_1">
				<a class="bds_tsina" data-cmd="tsina"> <span>微博</span>
				</a> <a class="bds_baidu" data-cmd="baidu"> <span>人人网</span>
				</a> <a class="bds_renren" data-cmd="renren"> <span>QQ空间</span>
				</a> <a class="bds_tqq" data-cmd="tqq"> <span>腾讯微博</span>
				</a> <a class="bds_qzone" data-cmd="qzone"> <span>QQ空间</span>
				</a> <a class="bds_renren" data-cmd="renren"> <span>QQ空间</span>
				</a> <a class="bds_tqq" data-cmd="tqq"> <span>QQ空间</span>
				</a>
			</div>
		</div>
	</div>
<script type="text/javascript" src="${zmjurl}/static/base/js/share.js"></script>