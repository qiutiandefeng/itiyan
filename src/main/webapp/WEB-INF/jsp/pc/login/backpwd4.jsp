<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.js"></script>
<link href="<%=request.getContextPath()%>/css/pc/zhaohuimima.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/images/pc/logo2.png" type="image/x-icon" rel="shortcut icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱体验网-找回密码</title>
</head>
<body>
	<img class="zhaohui_img1" src="<%=request.getContextPath()%>/images/pc/login/109.gif" />
	<p class="zhaohui_p1">
		<span class="zhaohui_p1_sp1">找回密码</span> <span
			class="zhaohui_p1_sp2 hei">身份验证</span> <span
			class="zhaohui_p1_sp3 hei">重置完成</span>
	</p>
	<div class="zhaohui3_div2">
		<p class="zhaohui3_div2_p1">恭喜您已成功重置了密码！</p>
		<a class="zhaohui3_div2_a1" href="###" onclick="gotoLogin()">马上登陆</a>
	</div>
	<form action="" method="post" id="sform">
		<input type="hidden" name="yfhl_username" id="yfhl_username"
			value="${yfhl_username}"/>
	</form>
</body>
<script type="text/javascript">
	//去登陆页面
	function gotoLogin() {
		window.location.href = "<%=request.getContextPath()%>/login/gotoIndexPC.do";
	}
</script>
</html>