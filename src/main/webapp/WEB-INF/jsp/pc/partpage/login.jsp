<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pc/dengluzhuce.js"></script>

<link href="<%=request.getContextPath()%>/css/pc/Common_style.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/pc/dengluzhuce.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/images/pc/logo2.png" type="image/x-icon"
	rel="shortcut icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱体验网-登录注册</title>
</head>
<body onload="onload()">
	<input type="hidden" id="beforePath" value="${beforePath}" />
	<input type="hidden" id="marker_time" value=""/>
	
	<div class="denglu_waitao">
		<div class="denglu">
			<form action="<%=request.getContextPath()%>/login/loginDesignPC.do" method="post" id="login">
				<input type="hidden" id="remember_pwd" value="2" />
				<div class="denglu_div1 left">
					<p class="denglu_div1_p1">
						<a class="denglu_div1_p1_a1" href="#">登陆</a> | <a
							class="denglu_div1_p1_zhuanhuan" href="#">注册</a>
					</p>
					<p class="denglu_div1_p2">
						<span>请输入正确的用户名/密码！</span>
					</p>
					<input class="denglu_div1_input1" type="text" id="username_login"
						value="${yfhl_user.email}" placeholder="请输入手机号或邮箱" />
					<p class="denglu_div1_p4" id="username_log">
						<span class="denglu_div1_p4_sp1">请输入正确的手机号</span><span
							class="denglu_div1_p4_sp2">请输入正确的邮箱号</span>
					</p>
					<input class="denglu_div1_input2" type="password"
						id="password_login" value="" placeholder="请输入密码" />
					<p class="denglu_div1_p5">
						<span id="pwd_log">请输入密码</span>
					</p>
					<p class="denglu_div1_p3">
						<a class="denglu_div1_p3_a1 left" href="###"> <img
							class="denglu_div1_p3_img1 left" src="<%=request.getContextPath()%>/images/pc/login/099.gif" />
							<img class="denglu_div1_p3_img2 left"
							src="<%=request.getContextPath()%>/images/pc/login/098.gif" /> &nbsp;&nbsp;记住密码
						</a> <a class="denglu_div1_p3_a2 right" href="###" onclick="backPwd()">忘记密码？</a>
					</p>
					<a class="denglu_div1_a1" href="#" onclick="submitViewBylogin()">登陆</a>
				</div>
				<div class="denglu_div2 left">
					<p class="denglu_div2_p1">其他账号登陆</p>
					<a href="#"><img class="denglu_div2_img1"
						src="<%=request.getContextPath()%>/images/pc/login/095.gif" /></a> <a href="###"><img
						class="denglu_div2_img2" src="<%=request.getContextPath()%>/images/pc/login/096.gif" /></a>
				</div>
			</form>
		</div>
		<div class="zhuce">
			<form action="<%=request.getContextPath()%>/login/loginDesignPC.do" method="post" id="register">
				<input type="hidden" id="agree_message" value="1" />
				<p class="zhuce_p1">
					<a class="zhuce_p1_zhuanhuan" href="###">登陆</a> | <a
						class="denglu_div1_p1_a1" href="###">注册</a>
				</p>
				<input class="zhuce_input1" type="text" placeholder="请输入你的邮箱"
					id="username_register"/>	<img class="zhuce_img1" src="<%=request.getContextPath()%>/images/pc/login/7.png" />
				<p class="zhuce_p2">
					<span id="register_logname"></span>
				</p>
				<input class="zhuce_input2" type="password" placeholder="请输入密码"
					id="password_register" />	<img class="zhuce_img2" src="<%=request.getContextPath()%>/images/pc/login/7.png" />
				<p class="zhuce_p3"><span id="register_logpwd">密码由6-20位英文字母、数字或符号组成</span></p>
				 
				<input class="zhuce_input3" type="password" id="password_confirm" placeholder="确认密码" />
				<img class="zhuce_img3" src="<%=request.getContextPath()%>/images/pc/login/7.png" />
				<p class="zhuce_p5" > 	
				<span id="register_logpwdc">请再次输入密码</span></p>
				 
				<a class="zhuce_a1" href="#" onclick="submitViewByRegister()" id="submitRegitser" >注册爱体验</a>
				<div class="zhuce_div1">
					<a class="left  zhuce_div1_a1" href="###"><img
						class="left zhuce_div1_img1" src="<%=request.getContextPath()%>/images/pc/login/099.gif" />
						<img class="left zhuce_div1_img2" src="<%=request.getContextPath()%>/images/pc/login/098.gif" />
						&nbsp;&nbsp;我同意注册合同
					</a>
				</div>
			</form>
		</div>

	</div>

</body>
<script type="text/javascript">
	 
	//登录提交验证
	function submitViewBylogin(){
		  var username=$("#username_login").val();
		  var password=$("#password_login").val();
		  var remember=$("#remember_pwd").val();
		  if(username=="" || password==""){
			  return false;
		  }
	  $.ajax({
          type: "POST",
          url: "<%=request.getContextPath()%>/login/loginDesignPC.do",
			data : {
				yfhl_username : username,
				yfhl_password : password,
				yfhl_type : 1,
				remember_pwd : remember
				
			},
			dataType : "json",
			success : function(data) {
				if(data.state=="0"){
					if(data.type==1){
						$("#username_log").text(data.value);
						$("#pwd_log").text("");
					}else if(data.type==2){
						$("#username_log").text("");
						$("#pwd_log").text(data.value);
						$(".denglu_div1_p5 span").css({"display":"block"});
					}
				}else{
					//登录成功
					var beforePath=$("#beforePath").val();
					if(beforePath==null || beforePath=="" || beforePath=="/login/index.do"){
						
						beforePath="/modelController/gotoModelPC.do";
					}
					window.location.href="<%=request.getContextPath()%>" + beforePath;
				}
			},
			error : function(error) {
				alert("error");
			}
		});

	}
	//注册提交验证
	function submitViewByRegister(){
		var username=$("#username_register").val();
		var password=$("#password_register").val();
		  //验证用户名
		  if(!checkRegisterName()){
			  return false;
		  }
		  //验证密码
		  if(!checkRegisterpwd()){
			  return false;
		  }
		  //验证确认密码
		  if(!checkRegisterpwdSame()){
			  return false;
		  }
		  //判断是否同意注册协议
		  var agree_message=$("#agree_message").val();
		  if(agree_message==2){
			  return false;
		  }
         //暂时去除注册按钮的点击事件
         $("#submitRegitser").removeAttr('onclick');
	  $.ajax({
          type: "POST",
          url: "<%=request.getContextPath()%>/login/loginDesignPC.do",
			data : {
				yfhl_username : username,
				yfhl_password : password,
				yfhl_type : 2
				
			},
			dataType : "json",
			success : function(data) {
				if(data.state=="0"){
					if(data.type==1){
						$("#username_log").text(data.value);
					}else{
						$("#pwd_log").text(data.value);
					}
				}else{
					//注册成功
					//alert(data.email);
					window.location.href="<%=request.getContextPath()%>/login/gotoEmailCount.do?emailCount="+data.email;
				}
			},
			error : function(error) {
			}
		});

	}
	//判断是否记住密码
	function onload() {
		var pwd = $("#password_login").val();
		if (pwd != "") {
			$(".denglu_div1_p3_img1").css({
				"display" : "none"
			});
			$(".denglu_div1_p3_img2").css({
				"display" : "block"
			});
		}

	}
	//判断手机号/邮箱是否已经注册
	function checkSame(){
		var username=$("#username_register").val();
		  $.ajax({
	          type: "POST",
	          url: "<%=request.getContextPath()%>/login/checkSameName.do",
			data : {
				yfhl_username : username

			},
			dataType : "json",
			success : function(data) {
				if (data.state == "0") {
					$("#register_logname").text("");
					$(".zhuce_img1").css({"display":"inline-block"});
					return true;
				} else {
					$("#register_logname").css({color:"red"});
					$("#register_logname").text("该邮箱已经被注册，您可以尝试找回密码！");
					$(".zhuce_img1").css({"display":"none"});
					return false;
				}
			}
		});
	}
	
	//2.注册验证
	//2.1验证注册时用户名格式是否正确
	function checkRegisterName(){
		var index=$(".zhuce_input1").val();
		var index1=/^([a-zA-Z0-9_\.\-]+)@([a-zA-Z0-9_\.\-]+)\.[c]{1}[o]{1}[m]{1}$/;
		var index2=/^[1][3,5,7,8]{1}[0-9]{9}$/;
		if(index.match("@")=="@"){
			//alert("邮箱号")
			if(index==""){
				$(".zhuce_p2 span").text("注册邮箱不能为空，请输入邮箱！");
				$(".zhuce_p2 span").css({color:"red"});
				$(".zhuce_img1").css({"display":"none"});
				return false;
			}else if(!index1.test(index)){
				$(".zhuce_p2 span").text("邮箱格式不正确，请重新输入！");
				$(".zhuce_p2 span").css({color:"red"});
				$(".zhuce_img1").css({"display":"none"});
				//alert("假1")
				return false;
				
			}else{
				checkSame();
				if($(".zhuce_p2 span").text()==""){
					$(".zhuce_p2 span").text("");
					$(".zhuce_p2 span").css({color:"green"});
					$(".zhuce_img1").css({"display":"inline-block"});
					return true;
				}else{
					$(".zhuce_img1").css({"display":"none"});
					return false;
				}
			}
		}else{
 			if(index==""){
				$(".zhuce_p2 span").css({color:"red"});
				$(".zhuce_p2 span").text("注册邮箱不能为空，请输入邮箱！");
				$(".zhuce_img1").css({"display":"none"});
				return false;
			}else if(!index1.test(index)){
				$(".zhuce_p2 span").css({color:"red"});
				$(".zhuce_p2 span").text("邮箱格式不正确，请重新输入！");
				$(".zhuce_img1").css({"display":"none"});
				//alert("假1")
				return false;
				
			}else{
				checkSame();
				if($(".zhuce_p2 span").text()==""){
					$(".zhuce_p2 span").text("");
					$(".zhuce_p2 span").css({color:"#01DEBD"});
					$(".zhuce_img1").css({"display":"inline-block"});
					return true;
				}else{
					$(".zhuce_img1").css({"display":"none"});
					return false;
				}
			}
//			//alert("手机号")
//			if(index2.test(index)){
//				$(".zhuce_p2 span").css({"display":"none"})
//				//alert("真")
//				return true;
//			}else{
//				$(".zhuce_p2 span").css({"display":"block"})
//				//alert("假")
//				return false;
//			}
		}
		
	}
	//2.2验证注册时密码格式是否正确
	function checkRegisterpwd(){
		var index=$(".zhuce_input2").val()
		var index1=/^[a-zA-Z0-9]{6,20}$/
		
		if(index==""){
			$(".zhuce_p3 span").css({color:"red"});
			$(".zhuce_p3 span").text("密码不能为空！");
			$(".zhuce_img2").css({"display":"none"});
			return false;
		}else if(!index1.test(index)){
			$(".zhuce_p3 span").css({color:"red"});
			$(".zhuce_p3 span").text("密码由6-20位英文字母、数字或符号组成！");
			$(".zhuce_img2").css({"display":"none"});
			return false;
		}else{
			$(".zhuce_p3 span").css({color:"#01DEBD"});
			$(".zhuce_p3 span").text("");
			$(".zhuce_img2").css({"display":"inline-block"});
			return true;
		}
	}
	//2.3验证注册时确认密码
	function checkRegisterpwdSame(){
		var index=$(".zhuce_input2").val();
		var index1=$(".zhuce_input3").val();
		if(index==""){
			return false;
		}else if(index1==""){
			$(".zhuce_p5 span").css({color:"red"});
			$(".zhuce_p5 span").text("请输入确认密码！");
			$(".zhuce_img3").css({"display":"none"});
			return false;
		}else if(index!=index1){
			$(".zhuce_p5 span").css({color:"red"});
			$(".zhuce_p5 span").text("两次输入的密码不一致，请重新输入！");
			$(".zhuce_img3").css({"display":"none"});
			return false;
		}else{
			$(".zhuce_p5 span").css({color:"#01DEBD"});
			$(".zhuce_p5 span").text("");
			$(".zhuce_img3").css({"display":"inline-block"});
			return true;
		}
	}
//找回密码
function backPwd(){
	window.location.href="<%=request.getContextPath()%>/login/gotobackPwd.do";
}

	
</script>
</html>