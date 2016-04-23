<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
<%
    String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>    
<!doctype html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="<%=path%>/css/login.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.js"></script>
     <script type="text/javascript" src="<%=path%>/js/Regular.js"></script>
	<title>后台登陆</title>	
	<script type="text/javascript">
	
		
	  if(top!=self){
               top.location=self.location;
     	}
		
		$(function(){
			var roleId ="${groupId}";
	  		$("#groupId option").each(function() {
				if ($(this).val() == roleId) {
					$(this).prependTo($("#groupId"));
					$(this).attr("selected", "selected");
				}
			});
	  					
		})
		function validate(){ 
			var select =$("#groupId").val();
			
			if(select==2){
				var password=$("#pwd").val();
				if(password.length==""){
					$("#msg").html("");
			    	$("#msg").html("密码不能为空");
				}else if(!passwordReg(password)){
			    	 $("#msg").html("");
			    	 $("#msg").html("密码格式错误");
			    }else{
				  		with(document.sform){
							 action="<%=path%>/login/login.do"; //修改跳转的路径
							 submit();
						}    
				 }
			}
		}
		
		function myclear(){
		 $("#msg").html("");
		}
		function changeImg(){     
		    var imgSrc = $("#imgObj");     
		    var src = imgSrc.attr("src");     
		    imgSrc.attr("src",chgUrl(src));     
		}     
		//时间戳     
		//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳     
		function chgUrl(url){     
		    var timestamp = (new Date()).valueOf();     
		    urlurl = url.substring(0,17);     
		    if((url.indexOf("&")>=0)){     
		        urlurl = url + "×tamp=" + timestamp;     
		    }else{     
		        urlurl = url + "?timestamp=" + timestamp;     
		    }
		   
		    return url;     
		}     

		function callback(data){     
		    $("#info").html(data);     
		}  
	</script>
	
</head>
<body>
	<div id="login_top">
		<div id="welcome">
			欢迎使用爱体验科技管理系统
		</div>
	</div>
	<div id="login_center">
		<div id="login_area">
			<div id="login_form">
				<form action="#" method="post"  id="sform" name="sform">
					<div id="login_tip">
						用户登录&nbsp;&nbsp; <font color="red" id="msg" size="2">${msg}</font> 
					</div>
					<div>&nbsp;&nbsp;用户名&nbsp;&nbsp;
					<input  class="username" name="username" id="username"> 	
					</div>
					
					<div id="role">
					<span id="rolepwd" >&nbsp;&nbsp;&nbsp;密 码</span>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="password" class="pwd" name="pwd" id="pwd" onclick="myclear()">
					<input type="hidden" id="groupId" name="groupId" value="2">
					</div>
					
					<div id="role"><!-- request.getContextPath() -->
					<span id="roleyanzhengma">&nbsp;&nbsp;验证码&nbsp;&nbsp;</span>
					<input name="validateCode" id="validateCode" class="yanzheng"/>
					<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<img id="imgObj"  alt="" class="imgObj" src="<%=request.getContextPath() %>/xuan/verifyCode.do"/>       
        				<a href="<%=request.getContextPath() %>/login/login.do" onclick="changeImg()">换一张</a>  
					</div>
					
					<div id="btn_area">
                        <input type="submit" name="submit" id="sub_btn" value="登&nbsp;&nbsp;录" onclick="validate();return false;">
					</div>
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>
 