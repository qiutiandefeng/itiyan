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
	src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/global.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/layer/layer.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/dialog/dialog.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/dialog.js"></script>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/style.css" type="text/css"
	rel="stylesheet">
<link href="<%=path%>/css/newWell.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/luans.css" type="text/css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理页</title>


</head>
<body>
	<h1 class="narrow" style="margin-top: 0">
		<img src="../images/icon_29.png"
			style="float: left; margin-top: 10px;">&nbsp;用户管理-
		<c:if test="${user.markManage==1}">设计师申请</c:if>
		<c:if test="${user.markManage==2}">编辑设计师</c:if>
	</h1>

	<form id="sform" action="userManage.do" method="post" align="center"
		style="margin-top: 0px;">
		<input type="hidden" name="markManage" id="markManage"
			value="${user.markManage}" /> <input type="hidden"
			name="markUserfrom" id="markUserfrom" value="${user.markUserfrom}" /><input
			type="hidden" id="pageIndex" name="pageInfo.pageIndex"
			value="${user.pageInfo.pageIndex}" /> <input type="hidden"
			id="groupId" name="groupId" value="${user.groupId}" /> <input
			type="hidden" name="uid" id="uid" value="${user.uid}" /> <input
			type="hidden" name="condition" id="condition"
			value="${user.condition}" />
		<table align="center" height="90%">
			<tr height="13px">
				<td align="center">品牌名：</td>
				<td><c:if test="${user.markManage==1 || user.markManage==2}">
						<input type="text" placeholder="不能为空" id="applydBrand"
							name="applydBrand" style="margin-top: 0px;"
							value="${designerApply.applydBrand}" class="nav-search-input">
					</c:if> <c:if test="${user.markManage==3}">${designerApply.applydBrand}</c:if></td>
			</tr>
			<tr>
				<td>品牌logo：</td>
				<td><img id="imagez"
					src="<%=path%>/upload/uploadImg/user/${designerApply.applydAvatar}"
					style="width: 80px; height: 80px;" /> <c:if
						test="${user.markManage==1 || user.markManage==2}">
						<a href="#" class="file">上传logo <input type="file"
							onchange="selectImagez(this);" />
						</a>
						<input type="hidden" id="applydAvatar" name="applydAvatar"
							value="${designerApply.applydAvatar}" />
						<input type="hidden" name="oldImg" id="oldImg"
							value="${designerApply.applydAvatar}" disabled="disabled" />
					</c:if></td>
			</tr>
			<tr>
				<td>品牌标签：</td>
				<td><c:if test="${user.markManage==1 || user.markManage==2}">
						<input type="text" name="applydDtag" placeholder="多个请以中文、隔开"
							style="margin-top: 0px;" id="dTag"
							value="${designerApply.applydDtag}" class="nav-search-input">
					</c:if> <c:if test="${user.markManage==3}">${designerApply.applydDtag}</c:if></td>
			</tr>
			<tr>
				<td>品牌故事：</td>
				<td><c:if test="${user.markManage==1 || user.markManage==2}">
						<textarea id="applyReason" name="applyReason">${designerApply.applyReason}</textarea>
					</c:if> <c:if test="${user.markManage==3}">${designerApply.applyReason}</c:if></td>
			</tr>
			<tr>
				<td>品牌所在地：</td>
				<td><c:if test="${user.markManage==1 || user.markManage==2}">
						<input type="text" name="applydAddress" style="margin-top: 0px;"
							id="dAddress" value="${designerApply.applydAddress}"
							class="nav-search-input">
					</c:if> <c:if test="${user.markManage==3}">${designerApply.applydAddress}</c:if></td>
			</tr>
			<tr height="13px">
				<td align="center">设计师名：</td>
				<td><c:if test="${user.markManage==1 || user.markManage==2}">
						<input type="text" placeholder="不能为空" id="applydDname"
							name="applydDname" style="margin-top: 0px;"
							value="${designerApply.applydDname}" class="nav-search-input">
					</c:if> <c:if test="${user.markManage==3}">${designerApply.applydDname}</c:if></td>
			</tr>
			<tr height="13px">
				<td align="center">用 户 名：</td>
				<td><c:if test="${user.markManage==1 || user.markManage==2}">
						<input type="text" placeholder="不能为空" id="applydUsername"
							name="applydUsername" onblur="checkView(this);"
							onfocus="getfocus(this);" style="margin-top: 0px;"
							value="${designerApply.applydUsername}" class="nav-search-input">
					</c:if> <c:if test="${user.markManage==3}">${designerApply.applydUsername}</c:if></td>
			</tr>
			<tr>
				<td>真实姓名：</td>
				<td><c:if test="${user.markManage==1 || user.markManage==2}">
						<input type="text" name="realname" style="margin-top: 0px;"
							id="realname" value="${designerApply.realname}"
							class="nav-search-input">
					</c:if> <c:if test="${user.markManage==3}">${designerApply.realname}</c:if></td>
			</tr>
			<tr>
				<td>手 机 号：</td>
				<td><c:if test="${user.markManage==1 || user.markManage==2}">
						<input type="text" name="phone" style="margin-top: 0px;"
							id="phone" value="${designerApply.phone}"
							onblur="checkView(this)" onfocus="getfocus(this)"
							class="nav-search-input">
					</c:if> <c:if test="${user.markManage==3}">${designerApply.phone}</c:if></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><c:if
						test="${user.markManage!=3}">
						<input type="submit" value="提交申请" class="btn btn-primary btn-sm" />
						&nbsp;&nbsp;<input type="button" onclick="back(1)" value="返回"
							class="btn btn-primary btn-sm" />
					</c:if> <c:if test="${user.markManage==3}">
						<input type="button" value="通过" class="btn btn-primary btn-sm"
							onclick="checkPass(3,${designerApply.id},${designerApply.uid})" />&nbsp;
						<input type="button" value="不通过" class="btn btn-primary btn-sm"
							onclick="checkPass(4,${designerApply.id},${designerApply.uid})" />
					</c:if> &nbsp;&nbsp;<input type="button" onclick="back(2)" value="返回"
					class="btn btn-primary btn-sm" /></td>

			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
   
    //提交验证
	function checkSubmit() {
		//1.验证用户名
		var applydUsername = $("#applydUsername");
		if (applydUsername.val() == null || applydUsername.val() == '') {
			alert("用户名不能为空！");
			applydUsername.focus();
			return false;
		}
		//2.验证电子邮箱
		var applydEmail = $("#applydEmail");
		var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if (applydEmail.val() == null || applydEmail.val() == '') {
			alert("电子邮箱不能为空！");
			applydEmail.focus();
			return false;
		} else if (!reg.test(applydEmail.val())) {
			alert("对不起，您输入的邮箱格式不正确!");
			applydEmail.focus();
			return false;
		}
		//3.验证手机号
		var phone = $("#phone");
		if (phone.val() != '' && isNaN(phone.val())) {
			alert("对不起，手机号只能为数字！");
			phone.focus();
			return false;
		}
		//4.验证QQ号
		var qq = $("#qq");
		if (qq.val() != '' && isNaN(qq.val())) {
			alert("对不起，QQ号只能为数字！");
			qq.focus();
			return false;
		}
		return true;
	}
	//添加用户:1添加；2编辑
	function userManage(type){
		
		var groupId=$("#groupId").val();//获取操作的是普通用户还是设计师：1普通用户；4设计师
		var pageIndex=$("#pageIndex").val();
		window.location.href="<%=request.getContextPath()%>/userManage/gotoUserManage.do?pageInfo.pageIndex="
				+ pageIndex + "&markManage=" + type + "&groupId=" + groupId;
	}
	//输入信息验证
	function checkView(obj) {
		var val = $.trim(obj.value);//值去掉前后空格
		var content;//提示信息

		if (obj.id == 'applydUsername') {
			content = "用户名不能为空";
		} else if (obj.id == 'applydEmail') {
			content = "电子邮箱不能为空";
		} else if (obj.id == 'phone') {
			content = '对不起，手机号只能为数字！';
		} else if (obj.id == 'qq') {
			content = '对不起，QQ号只能为数字！';
		}
		//非空验证
		if ((val == '' || val == null) && obj.id != 'phone' && obj.id != 'qq') {
			obj.style.color = "red";
			obj.placeholder = content;
		} else {
			obj.style.color = "black";
		}
		//邮箱验证
		if (val != '' && obj.id == 'applydEmail') {
			var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
			if (!reg.test(val)) {
				alert("对不起，您输入的邮箱格式不正确!");
				obj.focus();
			}
		}
		//手机号验证
		if (val != '' && (obj.id == 'phone' || obj.id == 'qq') && isNaN(val)) {
			alert(content);
			obj.focus();
		}
	}
	//获得焦点事件
	function getfocus(obj) {
		obj.style.color = "black";
	}
	//设计师审核:3：通过 4：不通过
	function checkPass(type,id,uid) {
		var pageIndex = $("#pageIndex").val();
		var markUserfrom=$("#markUserfrom").val();
		var condition=$("#condition").val();
		window.location.href="<%=request.getContextPath()%>/designerApplyController/checkDensignerApply.do?pageInfo.pageIndex="
				+ pageIndex + "&id="+id+"&uid="+uid+"&applydState="+type+"&markUserfrom="+markUserfrom+"&condition="+condition;
	}
	//返回事件
	function back(type){
		var pageIndex = $("#pageIndex").val();
		var markUserfrom=$("#markUserfrom").val();
		var condition=$("#condition").val();
		var url="";
		if(type==1){
			url="<%=request.getContextPath()%>/userManage/queryList.do?pageInfo.pageIndex="+ pageIndex
					+"&groupId=4&markUserfrom="+markUserfrom+"&condition="+condition;
		}else if(type==2){
			url="<%=request.getContextPath()%>/designerApplyController/queryList.do?pageInfo.pageIndex="
					+ pageIndex+"&condition="+condition;
		}
		window.location.href=url;
	}
	//上传头像
	function selectImagez(file) {
		//控制显示oldImg路径
		$('#oldImg').attr("disabled",false); 
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
							$("#applydAvatar").val(data);
							file.id=data;
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