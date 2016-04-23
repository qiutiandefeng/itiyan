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
				<span class="s1">关于我们</span> <span class="s2">ABOUT US.</span>
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
				href="<%=request.getContextPath()%>/turncenterController/turnBottom.do?markerPage=1"
				class="a1">关于我们</a></li>
			<li><a
				href="<%=request.getContextPath()%>/turncenterController/turnBottom.do?markerPage=2">加入我们</a></li>
			<li><a
				href="<%=request.getContextPath()%>/turncenterController/turnBottom.do?markerPage=3">合作伙伴</a></li>
			<li><a
				href="<%=request.getContextPath()%>/turncenterController/turnBottom.do?markerPage=4">帮助中心</a></li>
		</ul>
	</div>

	<!--
        	作者：offline
        	时间：2015-12-02
        	描述：文字
        -->
	<div class="two_cont">
		<div class="two_con">
			<dl class="two_cont1">
				<dt>我们是爱体验网！WHO.</dt>
				<dd class="dd1">爱体验网是提供制化服务的电子商务平台———将3D打印技术和传统技术相结合，集聚国内一流3D打印生产力和优秀独立设</dd>
				<dd class="dd2">计师，提供专业的指定化产品及服务，打造极致用户体验</dd>
				<dd class="dd3">We are a e-commerce platform to provide
					customized service.</dd>
			</dl>
		</div>
		<div class="two_con1">
			<dl class="two_cont2">
				<dt>我们做了什么？WE DO.</dt>
				<dd class="dd4">服务</dd>
				<dd class="dd5">爱体验网为客户提供从设计到3D打印生产的专业服务，兼顾品质和效率，致力打造极致的客户体验，让定制变得
					简单快捷。</dd>
				<dd class="dd6">UItimate user experience ,making personal
					custorm simple.</dd>
				<dd class="dd7">优势资源</dd>
				<dd class="dd8">与十余家业界顶尖3D打印供应商成为战略伙伴,</dd>
				<dd class="dd9">Top 3D printing suppliers.</dd>
				<dd class="dd10">掌握多材料结合打印的核心技术，让设计更加自由。</dd>
				<dd class="dd11">Master core material combined with printing
					technology ,make a design more freedom</dd>
				<dd class="dd12">全球优秀设计师的聚集地。</dd>
				<dd class="dd13">Excellent desigbers.</dd>
			</dl>
		</div>
		<div class="two_con2">
			<dl class="two_cont3">
				<dt>我们在哪里？WHERE.</dt>
				<dd class="dd14">北京市朝阳区望京街与阜安西路交叉路口</dd>
				<dd class="dd15">望京SOHO 塔A-1106</dd>
			</dl>
		</div>
		<div class="two_con3">
			<dl class="two_cont4">
				<dt>联系我们.CONTACT US.</dt>
				<dd class="dd16">4008908097</dd>
				<dd class="dd17">service@3dcreation.com</dd>
			</dl>
		</div>
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