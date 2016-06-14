<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>404页面找不到了-轻松装修 中美家</title>

	<meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
	<meta name="renderer" content="webkit">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link href="${zmjurl}/static/images/baselayout/favicon.ico" rel="shortcut icon">
    <link rel="stylesheet" type="text/css" href="${zmjurl}/static/css/404/404-500.css">
	<script>
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			hm.src = "//hm.baidu.com/hm.js?46e38cab694c07d6145e39a9e22df62c";
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})();
	</script>

</head>

<body>
	<div class="unssssssd" >
	<div class="header-nav">
    	<div class="header-box">
        	<p> 
            	<span class="nav-left">
                	<a href="/">首页</a> 
                	<a href="/company/initcompanys">装修公司</a>
                	<a href="/elite/designer/index">装修精英</a>
                	<a href="/shop/toshop">建材家居城</a>
                	<a href="/case/renderings/index">成功案例</a>
                	<a href="/material/index">知识库</a>
                </span>
            	<span class="nav-right">
                    <span>
                        <a href="/register/new/reg/login">登录</a>
                    	<a href="/register/new/reg/index">注册</a>
                    </span>
                	<span>
                    	<a href="/help">帮助中心</a>
                    </span>
                    
                    <a href="javascript:;" class="phone-number">4000380515</a>
                </span>
            </p>
        </div>
    </div>
  </div> 
	<div class="container">
		<div class="cont">
			<a href="javascript:;" target="_blank"><span class="cont_bg logo"></span></a>
			<div class="img_box">
				<img src="/static/images/404-500/404.png" alt="">
				<div class="clock_box">
					<img src="/static/images/404-500/clock.png" alt="">
				</div>
				<div class="clock_box min">
					<img src="/static/images/404-500/min.png" alt="" id="img_min">
				</div>
				<span>很抱歉，您来晚了一步，它已经任性地消失了... 你要坚强些，继续发掘别的页面去吧。</span>
				<div class="line"></div>
			</div>
			
		</div>
	</div>	
	<div class="footer">
		<div class="cont_box">
		<div class="f_footer">
			<div class="footer_cont">		        
		        陕ICP备16000234号-1<br>
		        <span>© 2015-2016 58zmj.com 版权所有</span>
		     </div>
		</div>
			
		</div>
	</div>
	
	<script src="/static/js/baselayout/jquery.js"></script>
    <script src="/static/js/jquery.rotate.min.js"></script>
    <script src="/static/js/jquery.easing.1.3.js"></script>
    <script src="/static/js/404-500/404-500.js"></script>

</body>
</html>
