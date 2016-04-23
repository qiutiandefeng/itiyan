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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册激活成功页面</title>
</head>
<body>
	<img class="zhaohui_img1" src="<%=request.getContextPath()%>/images/pc/login/109.gif" />
	<p class="zhaohui_p1">
		 
	</p>
	<div class="zhaohui3_div2">
		<p class="zhaohui3_div2_p1">恭喜您成功注册爱体验账户！</p>
		<a class="zhaohui3_div2_a1" href="#" onclick="gotoLogin()">马上登录</a>
	</div>
	<form action="" method="post" id="sform">
		<input type="hidden" name="urlPath" id="urlPath"
			value="${urlPath}" />
	</form>
</body>
<script type="text/javascript">
	//去登陆页面
	function gotoLogin() {
		 
			window.location.href = "<%=request.getContextPath()%>/login/gotoIndexPC.do";
	 
	}
</script>
</html>