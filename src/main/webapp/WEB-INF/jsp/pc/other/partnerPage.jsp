<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.js"></script>
<link href="<%=request.getContextPath()%>/css/pc/Common_style.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/pc/bottomtext.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/images/pc/logo2.png" type="image/x-icon"
	rel="shortcut icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱体验网</title>
</head>
<body>
	<div>
		<!--hander -->
		<c:set value="${model.condition}" var="condition"></c:set>
		<%@include file="../partpage/hander.jsp"%>
	</div>
	<div class="nav_bottom"></div>
	<div class="banner">
		<img src="<%=request.getContextPath()%>/images/pc/1.png" />
		<div class="banner_div">
			<div>
				<span class="s1">合作伙伴</span> <span class="s2">COOPERATION.</span>
			</div>
		</div>
	</div>
	<!--
        	作者：offline
        	时间：2015-12-02
        	描述：文字链接
        -->
	<div class="two_nav1">
		<ul class="two_nav">
			<li><a
				href="<%=request.getContextPath()%>/turncenterController/turnBottom.do?markerPage=1">关于我们</a></li>
			<li><a
				href="<%=request.getContextPath()%>/turncenterController/turnBottom.do?markerPage=2">加入我们</a></li>
			<li><a
				href="<%=request.getContextPath()%>/turncenterController/turnBottom.do?markerPage=3"
				class="a1">合作伙伴</a></li>
			<li><a
				href="<%=request.getContextPath()%>/turncenterController/turnBottom.do?markerPage=4">帮助中心</a></li>
		</ul>
	</div>

	<!--
        	作者：offline
        	时间：2016-03-22
        	描述：合作
        -->
	<div class="hezuo_div1">
		<img src="<%=request.getContextPath()%>/images/pc/123.png" />
	</div>
	<div>
		<!--bottom -->
		<%@include file="../partpage/bottom.jsp"%>
	</div>
	<div class="logincalss">
		<!--login -->
		<%@include file="../partpage/login.jsp"%>
	</div>
</body>
</html>