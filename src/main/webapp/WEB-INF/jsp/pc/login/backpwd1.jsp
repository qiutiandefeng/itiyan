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
<link href="<%=request.getContextPath()%>/css/pc/zhaohuimima.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/images/pc/logo2.png" type="image/x-icon" rel="shortcut icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱体验网-找回密码</title>
</head>
<body>
	<form action="backPwd.do" method="post" id="sform">
		<img class="zhaohui_img1" src="<%=request.getContextPath()%>/images/pc/login/107.gif" />
		<p class="zhaohui_p1">
			<span class="zhaohui_p1_sp1">找回密码</span> <span class="zhaohui_p1_sp2">身份验证</span>
			<span class="zhaohui_p1_sp3">重置密码</span>
		</p>
		<div class="zhaohui_div1">
			<input class="zhaohui_div1_input1" type="text" name="emailCount"
				id="emailCount" placeholder="注册爱体验的邮箱" onblur="checkEmail()"/> <img class="zhaohui_img2"
				src="<%=request.getContextPath()%>/images/pc/login/7.png" /><p class="zhaohui_div1_p1"><span id="emailCount_log"></span></p>
			<a class="zhaohui_div1_a1" href="#" onclick="findpwd()">找回密码</a> <a
				class="zhaohui_div1_a2" href="#" onclick="backLogin()">想起密码去登陆></a>
		</div>
	</form>
</body>
<script type="text/javascript">
	//返回登录
	function backLogin() {
		window.location.href = "<%=request.getContextPath()%>/login/gotoIndexPC.do";
	}
	//提交
	function findpwd() {
		
		 if(!checkEmail()){
			 return false;
		 }else{
			 $("#sform").submit();
		 }
		 
	}
	//验证邮箱
	function checkEmail(){
		var emailCount = $("#emailCount").val();
		var index1=/^([a-zA-Z0-9_\.\-]+)@([a-zA-Z0-9_\.\-]+)\.[c]{1}[o]{1}[m]{1}$/;
			if(emailCount==""){
				$(".zhaohui_img2").css({"display":"none"});
				$(".zhaohui_div1 span").css({color:"red"});
				$(".zhaohui_div1 span").text("请输入注册邮箱！");
				return false;
			}else if(!index1.test(emailCount)){
				$(".zhaohui_img2").css({"display":"none"});
				$(".zhaohui_div1 span").css({color:"red"});
				$(".zhaohui_div1 span").text("邮箱格式不正确，请重新输入！");
				return false;
				
			}else{
				checkSame();
				if($(".zhaohui_div1 span").text()==""){
					$(".zhuce_p2 span").text("");
					$(".zhaohui_div1 span").css({color:"green"});
					$(".zhaohui_img2").css({"display":"inline-block"});
					return true;
				}else{
					$(".zhaohui_img2").css({"display":"none"});
					return false;
				}
			}
	}
	//判断手机号/邮箱是否已经注册
	function checkSame(){
		var emailCount=$("#emailCount").val();
		  $.ajax({
	          type: "POST",
	          url: "<%=path%>/login/checkSameName.do",
			data : {
				yfhl_username : emailCount

			},
			dataType : "json",
			success : function(data) {
				if (data.state == "0") {
					$("#emailCount_log").css({
						color : "red"
					});
					$("#emailCount_log").text("该邮箱还没有被注册！");
					$(".zhaohui_img2").css({
						"display" : "none"
					});
					return false;

				} else {
					$("#emailCount_log").text("");
					$(".zhaohui_img2").css({
						"display" : "inline-block"
					});
					return true;
				}
			}
		});
	}
</script>
</html>