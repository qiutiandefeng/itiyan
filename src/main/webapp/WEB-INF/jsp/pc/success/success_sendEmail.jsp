<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pc/tiaozhuanyouxiang.js"></script>
<link href="<%=request.getContextPath()%>/css/pc/zhaohuimima.css"
	type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>激活邮件发送成功页面</title>
</head>
<body>
<img class="zhaohui_img1" src="<%=request.getContextPath()%>/images/pc/login/108.gif" />
		<p class="zhaohui_p1">
			 
		</p>
		<div class="zhaohui2_div1">
			<p class="zhaohui2_div1_p1">注册很快就成功了</p>
			<p class="zhaohui2_div1_p2">激活邮件已发送到<span class="zhaohui2_div1_p2_sp1">${emailCount}</span>,</p>
			<p class="zhaohui2_div1_p3">点击邮件里的确认链接即可激活成功!</p>
			<a class="zhaohui2_div1_a1" href="#">去我的邮箱</a>
		</div>
</body>
</html>