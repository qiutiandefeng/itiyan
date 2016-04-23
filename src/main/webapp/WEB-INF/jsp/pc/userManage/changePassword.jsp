<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link
	href="<%=request.getContextPath()%>/css/gonggong_gerenzhongxin.css"
	type="text/css" rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/css/pc/zhanghu_mima.css"
	type="text/css" rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/css/pc/zhangh_xiugaichenggong.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/images/pc/logo2.png" type="image/x-icon" rel="shortcut icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的爱体验-修改密码</title>
</head>
<body>
	<input type="hidden" id="yfhl_user" value="${yfhl_user.uid}" />
	<div>
		<!--hander -->
		<c:set value="${model.condition}" var="condition"></c:set>
		<%@include file="../partpage/hander.jsp"%>
	</div>
	<div class="nav_bottom"></div>
	<!--
        	作者：offline
        	时间：2015-12-28
        	描述：交易——收藏
        -->
	<p class="shoucang_p">
		<a href="#">首页</a> > <a href="#">个人中心</a> > <a href="#">账户中心</a> > <a
			href="<%=path%>/userManage/gotoUserManagePC.do">编辑个人信息</a>
	</p>
	<div class="shoucang">
		<div class="shoucang_left left">
			<div class="shoucang_left_div1">
				<div class="shoucang_left_div1_div1 left">
					<c:if test="${yfhl_user.avatar=='' || yfhl_user.avatar=='null'}">
						<img src="<%=request.getContextPath()%>/images/pc/defalut_useravator.png" />
					</c:if>
					<c:if test="${yfhl_user.avatar!='' && yfhl_user.avatar!='null'}">
						<img src="<%=request.getContextPath()%>/upload/uploadImg/user/${yfhl_user.avatar}" />
					</c:if>
				</div>
				<div class="shoucang_left_div1_div2 left">
					<p class="shoucang_left_div1_div2_p1">${yfhl_user.username}</p>
					<p class="shoucang_left_div1_div2_p2">
						<a href="<%=path%>/userManage/gotoUserManagePC.do">编辑个人信息</a>
					</p>
				</div>
			</div>
			<div class="shoucang_left_div2">
				<p class="shoucang_left_div2_p1">交易中心</p>
				<ul class="shoucang_left_div2_ul1">
					<li><a href="<%=path%>/tradeManage/queryListPC.do">我的订单</a></li>
					<li><a href="<%=path%>/modelCollectionController/queryList.do">我的收藏</a></li>
					<li><a href="<%=path%>/userManage/gotoGoodsBackPagePC.do">退换货</a></li>
				</ul>
				<p class="shoucang_left_div2_p1">账户中心</p>
				<ul class="shoucang_left_div2_ul1">
					<li><a href="#">编辑个人信息</a></li>
					<li><a href="<%=request.getContextPath()%>/userManage/gotochangePwdPC.do" class="a1">修改密码</a></li>
					<li><a
						href="<%=path%>/userAddressController/queryUserAddress.do">收货地址</a></li>
				</ul>
			</div>
			<div class="dongde"></div>
		</div>
		<div class="mima_right left" id="right">
			<p class="mima_right_p1">【修改密码】</p>
			<p class="mima_right_p2">必填信息</p>
			<div class="mima_right_div1">
				<span>旧密码</span> <input type="password" id="oldpwd" value="" onblur="checkoldPwd()"/><img class="mima_right_div4_img1" src="<%=request.getContextPath()%>/images/pc/login/7.png" />
			</div>
			<div class="mima_right_div4"><span class="mima_right_div4_sp1"></span></div>
			<div class="mima_right_div2">
				<span>新密码</span> <input type="password" id="newpwd" value="" onblur="checkNewpwd()"/><img class="mima_right_div4_img2" src="<%=request.getContextPath()%>/images/pc/login/7.png" />
			</div>
			<div class="mima_right_div4"><span class="mima_right_div4_sp2"></span></div>
			<div class="mima_right_div3">
				<span>确认密码</span> <input type="password" id="newpwd_sure" value="" onblur="checkpwdSame()"/><img class="mima_right_div4_img3" src="<%=request.getContextPath()%>/images/pc/login/7.png" />
			</div>
			<div class="mima_right_div4"><span class="mima_right_div4_sp3"></span></div>
			<a href="###" class="mima_right_btn1" onclick="checkSubmit()">保存</a>
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
<script type="text/javascript">
	//提交验证
	function checkSubmit() {
		//1.判断用户是否登录，若没有登录，先登录；  
	    var uid=$("#yfhl_user").val();
	    if(uid=="" || uid==null){
	    	window.location.href="<%=path%>/login/gotoIndexPC.do";
	    	 return false;
	    }
		   //2.验证旧密码
		   if(!checkoldPwd()){
			   return false;
		   }
		   //3.验证新密码
		   if(!checkNewpwd()){
			   return false;
		   }
		   //4.验证确认密码
		   if(!checkpwdSame()){
			   return false;
		   }
		  var newpwd=$("#newpwd").val();
		  
			//验证通过，提交保存
			$.ajax({
				type : "post",
				url : '<%=request.getContextPath()%>/userManage/changePwdPC.do',
						data : {
							uid: uid,
							pwd : newpwd
						},
						async : false,
						dataType : 'json',
						success : function(data) {
						 
							if(data==1){//修改密码成功
								$("#right").html('<p class="xiugai_right_p1">【修改密码信息】</p><img class="xiugai_right_img1" src="../images/pc/034.gif" />');
							}else{
								alert("修改密码失败！");
							}
						},
						error : function() {
							alert('网络故障');
						}
					});
	     
	}
	//2.1验证旧密码
	function checkoldPwd(){
		//1.判断用户是否登录，若没有登录，先登录；  
	    var uid=$("#yfhl_user").val();
	    if(uid=="" || uid==null){
	    	window.location.href="<%=path%>/login/gotoIndexPC.do";
	    	 return false;
	    }
		var result=0;
		var oldpwd=$("#oldpwd").val();
		var index1=/^[a-zA-Z0-9]{6,20}$/
		if(oldpwd==""){
			return false;
		}else if(!index1.test(oldpwd)){
			$(".mima_right_div4_sp1").css({color:"red"});
			$(".mima_right_div4_sp1").text("旧密码不正确");
			$(".mima_right_div4_img1").css({"display":"none"});
			return false;
		}else{
			 
			$.ajax({
				type : "post",
				url : '<%=request.getContextPath()%>/userManage/checkoldPwdPC.do',
						data : {
							uid: uid,
							pwd : oldpwd
						},
						async : false,
						dataType : 'json',
						success : function(data) {
							 
							result=data;
						},
						error : function() {
							alert('网络故障');
						}
					});
			if(result==1){//旧密码验证成功
				$(".mima_right_div4_sp1").css({color:"#01DEBD"});
				$(".mima_right_div4_sp1").text("");
				$(".mima_right_div4_img1").css({"display":"block"});
				return true;
			}else{
				$(".mima_right_div4_sp1").css({color:"red"});
				$(".mima_right_div4_sp1").text("旧密码不正确");
				$(".mima_right_div4_img1").css({"display":"none"});
				return false;
			}
		}
	}
	//2.2验证密码格式是否正确
	function checkNewpwd(){
		//1.判断用户是否登录，若没有登录，先登录；  
	    var uid=$("#yfhl_user").val();
	    if(uid=="" || uid==null){
	    	window.location.href="<%=path%>/login/gotoIndexPC.do";
	    	 return false;
	    }
		var index=$("#newpwd").val();
		var index1=/^[a-zA-Z0-9]{6,20}$/
		
		if(index==""){
			$(".mima_right_div4_sp2").css({color:"red"});
			$(".mima_right_div4_sp2").text("密码不能为空！");
			$(".mima_right_div4_img2").css({"display":"none"});
			return false;
		}else if(!index1.test(index)){
			$(".mima_right_div4_sp2").css({color:"red"});
			$(".mima_right_div4_sp2").text("密码由6-20位英文字母、数字或符号组成！");
			$(".mima_right_div4_img2").css({"display":"none"});
			return false;
		}else{
			$(".mima_right_div4_sp2").css({color:"#01DEBD"});
			$(".mima_right_div4_sp2").text("");
			$(".mima_right_div4_img2").css({"display":"block"});
			return true;
		}
	}
	//2.3验证确认密码
	function checkpwdSame(){
		var index=$("#newpwd").val();
		var index1=$("#newpwd_sure").val();
		if(index==""){
			return false;
		}else if(index1==""){
			$(".mima_right_div4_sp3").css({color:"red"});
			$(".mima_right_div4_sp3").text("请输入确认密码！");
			$(".mima_right_div4_img3").css({"display":"none"});
			return false;
		}else if(index!=index1){
			$(".mima_right_div4_sp3").css({color:"red"});
			$(".mima_right_div4_sp3").text("两次输入的密码不一致，请重新输入！");
			$(".mima_right_div4_img3").css({"display":"none"});
			return false;
		}else{
			
			$(".mima_right_div4_sp3").css({color:"#01DEBD"});
			$(".mima_right_div4_sp3").text("");
			$(".mima_right_div4_img3").css({"display":"block"});
			return true;
		}
	}
</script>
</html>