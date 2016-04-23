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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品类别操作页</title>

<script type="text/javascript">
	//屏蔽点击键盘Backspace键，页面向后跳转
	window.onload = function() {

		//获取事件对象  
		var elem = event.relatedTarget || event.srcElement || event.target
				|| event.currentTarget;

		if (event.keyCode == 8) {//判断按键为backSpace键  

			//获取按键按下时光标做指向的element  
			var elem = event.srcElement || event.currentTarget;

			//判断是否需要阻止按下键盘的事件默认传递  
			var name = elem.nodeName;

			if (name != 'INPUT' && name != 'TEXTAREA') {
				return _stopIt(event);
			}
			var type_e = elem.type.toUpperCase();
			if (name == 'INPUT'
					&& (type_e != 'TEXT' && type_e != 'TEXTAREA'
							&& type_e != 'PASSWORD' && type_e != 'FILE')) {
				return _stopIt(event);
			}
			if (name == 'INPUT'
					&& (elem.readOnly == true || elem.disabled == true)) {
				return _stopIt(event);
			}
		}

	}
	function _stopIt(e) {
		if (e.returnValue) {
			e.returnValue = false;
		}
		if (e.preventDefault) {
			e.preventDefault();
		}

		return false;
	}
	//提交验证
	function checkSubmit() {
		checkView($("#title"));//用户名验证 
	}
	//输入信息验证
	function checkView(obj) {
		var val = $.trim(obj.value);//值去掉前后空格
		var content;//提示信息

		if (obj.id == 'title') {
			content = "类别名称不能为空";
		}
		//非空验证
		if (val == '' || val == null) {
			obj.style.color = "red";
			obj.placeholder = content;
		} else {
			obj.style.color = "black";
		}
	}
	//获得焦点事件
	function getfocus(obj) {
		obj.style.color = "black";
	}
</script>
</head>
<body>
	<h1 class="narrow" style="margin-top: 0">
		<img src="../images/icon_29.png"
			style="float: left; margin-top: 10px;">&nbsp;商品类别管理-
		<c:if test="${category.markManage==1}">新增商品类别</c:if>
		<c:if test="${category.markManage==2}">编辑商品类别</c:if>
	</h1>

	<form id="sform" action="categoryManage.do" method="post"
		align="center" style="margin-top: 30px;">
		<input type="hidden" name="parentId" id="parentId"
			value="${category.parentId}" /> <input type="hidden"
			name="categoryId" id="categoryId" value="${category.categoryId}" />
		<input type="hidden" name="markManage" id="markManage"
			value="${category.markManage}" /><input type="hidden" name="cgOrder"
			id="cgOrder" value="${category.cgOrder}" />
		<table align="center" height="90%">
			<tr height="13px">
				<td align="center">类别名称：</td>
				<td><input type="text" placeholder="不能为空" id="title"
					name="title" onblur="checkView(this);" onfocus="getfocus(this);"
					style="margin-top: 0px;" value="${category.title}"
					class="nav-search-input"></td>
			</tr>
			<tr height="13px">
				<td align="center"></td>
				<td colspan="2"><input type="submit"
					class="btn btn-primary btn-sm" value="保存" onclick="checkSubmit()"></td>
			</tr>
		</table>
	</form>




</body>
</html>