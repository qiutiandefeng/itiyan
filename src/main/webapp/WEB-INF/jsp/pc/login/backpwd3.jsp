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
<form action="resetPwd.do" method="post" id="sform">
<input type="hidden" name="uid" value="${uid}"/>
<img class="zhaohui_img1" src="<%=request.getContextPath()%>/images/pc/login/109.gif" />
		<p class="zhaohui_p1">
			<span class="zhaohui_p1_sp1">找回密码</span>
			<span class="zhaohui_p1_sp2 hei">身份验证</span>
			<span class="zhaohui_p1_sp3 hei">重置密码</span>
		</p>
		<div class="zhaohui3_div1">
			<input class="zhaohui3_div1_in1" type="password" id="password_reset" name="pwd" onblur="checkpwd()" placeholder="新密码"/>
			<img class="zhaohui_img3" src="<%=request.getContextPath()%>/images/pc/login/7.png"/> 
			<p class="zhaohui3_div1_p1"><span id="reset_logpwd"></span></p>
			<input class="zhaohui3_div1_in2" type="password" id="password_confirm"  onblur="checkpwdSame()" placeholder="确认密码"/>
			<img class="zhaohui_img4" src="<%=request.getContextPath()%>/images/pc/login/7.png"/>
			<p class="zhaohui3_div1_p2"><span id="reset_logpwdc"></span></p>
			<a class="zhaohui3_div1_a1" href="#" onclick="checkSubmit()">重置</a>
		</div>
		</form>
</body>
<script type="text/javascript">
//1提交验证
function checkSubmit(){
	//1.验证密码
	if(!checkpwd()){
		return false;
	}
	//2.验证确认密码
	if(!checkpwdSame()){
		return false;
	}
	//提交
	$("#sform").submit();
}
//2.验证密码
//2.2验证注册时密码格式是否正确
function checkpwd(){
	var index=$("#password_reset").val();
	var index1=/^[a-zA-Z0-9]{6,20}$/
	
	if(index==""){
		 
		$("#reset_logpwd").css({color:"red"});
		$("#reset_logpwd").text("请输入新密码！");
		$(".zhaohui_img3").css({"display":"none"});
		return false;
	}else if(!index1.test(index)){
		$("#reset_logpwd").css({color:"red"});
		$("#reset_logpwd").text("密码由6-20位英文字母、数字或符号组成！");
		$(".zhaohui_img3").css({"display":"none"});
		return false;
	}else{
		$("#reset_logpwd").css({color:"#01DEBD"});
		$("#reset_logpwd").text("");
		$(".zhaohui_img3").css({"display":"inline-block"});
		return true;
	}
}
//2.3验证注册时确认密码
function checkpwdSame(){
	var index=$("#password_reset").val();
	var index1=$("#password_confirm").val();
	if(index==""){
		return false;
	}else if(index1==""){
		$("#reset_logpwdc").css({color:"red"});
		$("#reset_logpwdc").text("请再次输入密码！");
		$(".zhaohui_img4").css({"display":"none"});
		return false;
	}else if(index!=index1){
		$("#reset_logpwdc").css({color:"red"});
		$("#reset_logpwdc").text("两次输入的密码不一致，请重新输入！");
		$(".zhaohui_img4").css({"display":"none"});
		return false;
	}else{
		$("#reset_logpwdc").css({color:"#01DEBD"});
		$("#reset_logpwdc").text("");
		$(".zhaohui_img4").css({"display":"inline-block"});
		return true;
	}
}


</script>
</html>