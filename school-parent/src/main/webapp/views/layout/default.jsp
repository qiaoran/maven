<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
<meta name="renderer" content="webkit">
<title><sitemesh:write property='title' /></title>
<jsp:include page="../common/static.jsp"/>
<sitemesh:write property='head' />
</head>
<jsp:include page="../common/header.jsp"/>
<sitemesh:write property='body' />
<jsp:include page="../common/footer.jsp"/>

<script type="text/javascript" src="/static/base/js/jquery-1.12.0.min.js"></script>
</html>