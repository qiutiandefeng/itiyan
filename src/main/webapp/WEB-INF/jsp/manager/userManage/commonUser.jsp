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
<link href="<%=request.getContextPath()%>/css/style.css" type="text/css"
	rel="stylesheet">
<link href="<%=path%>/css/newWell.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/birthday.js"></script>
<link href="<%=request.getContextPath()%>/css/zhuanghu_geren.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/luans.css" type="text/css"
	rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理页</title>


</head>
<body>
	<h1 class="narrow" style="margin-top: 0">
		<img src="../images/icon_29.png"
			style="float: left; margin-top: 10px;">&nbsp;用户管理-
		<c:if test="${user.markManage==1}">新增普通用户</c:if>
		<c:if test="${user.markManage==2}">编辑普通用户</c:if>
	</h1>

	<form id="sform" action="userManage.do" method="post" align="center"
		style="margin-top: 30px;">
		<div class="geren_right left" id="right">
			<input type="hidden" id="uid" value="${user.uid}" />
			<c:if test="${user.markManage==1}">【新增普通用户】</c:if>
			<c:if test="${user.markManage==2}">
				<p class="geren_p1">【编辑普通用户】</p>
			</c:if>

			<p class="geren_right_p1">
				 
			</p>
			<p class="geren_right_p2">
				<span>用户名：</span><input type="text" name="username" id="username"
					value="${user.username}" />
			</p>
			<div class="geren_right_div1">
				<p class="left">头像：</p>
				<div class="left geren_right_div1_div1">
					<img id="imagez" src="<%=path%>/upload/uploadImg/user/${user.avatar}"
						style="width: 80px; height: 80px;" />
				</div>
				<div class="left">
					<p class="geren_right_div1_div2_p1">
						<a href="#" class="file">上传头像 <input type="file" id=""
							onchange="selectImagez(this);" />
						</a> <input type="hidden" id="avatar" name="avatar"
							value="${user.avatar}" />
					</p>
					<p>建议图片尺寸150*150像素，300k以内，格式要求:jpg,gif,png</p>
				</div>
				<input type="hidden" id="oldImg" value="${user.avatar}" />
			</div>
			<div class="geren_right_div6">
				<span>真实姓名：</span> <input type="text" placeholder="请填写您真实姓名"
					name="realname" id="realname" value="${user.realname}" />
			</div>
			<div class="geren_right_div2">
				<span class="geren_right_div2_sp1">性别：</span>
				<c:if test="${user.sex==1}">
					<span>男</span>
					<input type="radio" name="sex" value="1" checked="checked" />
					<span>女</span>
					<input type="radio" name="sex" value="2" />
					<span>这是个秘密</span>
					<input type="radio" name="sex" value="3" />
				</c:if>
				<c:if test="${user.sex==2}">
					<span>男</span>
					<input type="radio" name="sex" value="1" />
					<span>女</span>
					<input type="radio" name="sex" value="2" checked="checked" />
					<span>这是个秘密</span>
					<input type="radio" name="sex" value="3" />
				</c:if>
				<c:if test="${user.sex!=1 && user.sex!=2}">
					<span>男</span>
					<input type="radio" name="sex" value="1" />
					<span>女</span>
					<input type="radio" name="sex" value="2" />
					<span>这是个秘密</span>
					<input type="radio" name="sex" value="3" checked="checked" />
				</c:if>
			</div>
			<div class="geren_right_div3">
				<span class="geren_right_div3_sp1">生日：</span> <span>年</span> <select
					class="geren_right_div3_select1" id="select_year"
					rel="${user.uBirthYear}">

				</select> <span>月</span> <select class="geren_right_div3_select2"
					id="select_month" rel="${user.uBirthMoth}">

				</select> <span>日</span> <select class="geren_right_div3_select3"
					id="select_day" rel="${user.uBirthDay}">

				</select>
			</div>
			<div class="geren_right_div4">
				<span>邮箱：</span> <input type="text" name="email" id="email"
					value="${user.email}" />
			</div>
			<div class="geren_right_div5">
				<span>手机：</span> <input type="text" name="phone" id="phone"
					value="${user.phone}" />
			</div>

			<a href="#" class="geren_right_btn1" onclick="checksubmit()">保存</a>
		</div>
	</form>
</body>
<script type="text/javascript">

$(function() {
    $.ms_DatePicker({
        YearSelector: "#select_year",
        MonthSelector: "#select_month",
        DaySelector: "#select_day"
    });
    $.ms_DatePicker({
        YearSelector: "#select_year2",
        MonthSelector: "#select_month2",
        DaySelector: "#select_day2"
    });
});
	//提交验证
	function checksubmit() {
		
		
		var result=0;
		//1.验证邮箱
		var email = $("#email").val();//邮箱
		var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if (email != null && email != '' && !reg.test(email)) {
			alert("对不起，您输入的邮箱格式不正确!");
			 $("#email").focus();
			result=1;
		} 
		//2.验证手机号
		var phone = $("#phone").val();//手机号
		if (phone != '' && isNaN(phone)) {
			alert("对不起，手机号只能为数字！");
			$("#phone").focus();
			result=1;
		}
	    if(result==0){
	     
			var username=$("#username").val();//用户名
			var avatar=$("#avatar").val();//头像
			var realname=$("#realname").val();//真实姓名
			var sex=$('input:radio[name="sex"]:checked').val();//性别
			var year=$("#select_year").val();//年
			var month=$("#select_month").val();//月
			var day=$("#select_day").val();//天
			var oldImg=$("#oldImg").val();//old头像路径
			if(oldImg==avatar){
				 oldImg=null;
			}
		    var uid=$("#uid").val();
			//验证通过，提交保存
			$.ajax({
				type : "post",
				url : '<%=request.getContextPath()%>/userManage/updateUserManagePC.do',
						data : {
							uid: uid,
							username : username,
							avatar: avatar,
							realname: realname,
							sex: sex,
							uBirthYear: year,
							uBirthMoth: month,
							uBirthDay: day,
							email: email,
							phone: phone,
							oldImg : oldImg
						},
						async : false,
						dataType : 'json',
						success : function(data) {
							if(data==1){//保存成功
								$("#right").html('<p class="xiugai_right_p1">【编辑个人信息】</p><img class="xiugai_right_img1" src="../images/pc/034.gif" />');
							}
						},
						error : function() {
							alert('网络故障');
						}
					});
	    } else{
	    	return false;
	    }
	}
	//上传头像
	function selectImagez(file) {
		if (!file.files || !file.files[0]) {
			return;
		}
		var image = '';
		var reader = new FileReader();
		reader.onload = function(evt) {
			document.getElementById('imagez').src = evt.target.result;
			image = evt.target.result;
			$.ajax({
					 type : "post",
					 url : '<%=request.getContextPath()%>/imageController/updateImg.do',
						data : {
							image : image,
							oldImg : file.id,
							path : "upload/uploadImg/user/"
						},
						async : false,
						dataType : 'json',
						success : function(data) {
							//alert(data);//返回上传图片的名字
							$("#avatar").val(data);
							file.id = data;
						},
						error : function(err) {
							alert(err)
							alert('网络故障');
						}
					});
		}
		reader.readAsDataURL(file.files[0]);
	}
</script>
</html>