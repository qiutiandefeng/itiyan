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
<title>选择设计师页面</title>

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
		var condition = $.trim($("#condition").val());//搜索框去掉前后空格
		$("#condition").val(condition);
	}
	//用户来源设置
	function userFrom(type) {
		$("#markUserfrom").val(type);//设置用户来源
		checkSubmit();//表单验证
		$("#sform").submit();//提交表单

	}
	//行点击事件
	function onclickTr(designerId, designerName) {
		$("#designerId").val(designerId);
		$("#designerName").val(designerName);

	}
	//点击确定的事件
	function sure() {
		var designerId = $("#designerId").val();//设计师ID
		var designerName = $("#designerName").val();//设计师名称
		if (designerId.length == 0) {
			alert("还没有选中设计师哦！");
			return false;
		}
		//参数传回页面
		window.opener.setDesigner(designerId,designerName);

		window.close();
	}
	//取消事件
	function back() {
		window.close();
	}
</script>
</head>
<body>
	<h1 class="narrow" style="margin-top: 0">
		<img src="../images/icon_29.png"
			style="float: left; margin-top: 10px;">&nbsp;选择设计师
	</h1>
	<div class="container-fluid" style="margin-left: -14px;">
		<form id="sform" action="queryList.do" method="post"
			class="newWell form-inline" style="margin-top: -5px;">
			<input type="text" placeholder="设计师/邮箱/手机号" name="condition"
				style="margin-top: 0px;" id="condition" value="${user.condition}"
				class="nav-search-input"> <input type="submit"
				onclick="checkSubmit()" id="selectLick" value="查询"
				class="btn btn-primary btn-sm" style="margin-left: 5px;">&nbsp;
			<a href="#" onclick="userFrom(1);">所有（${user.sumCount}）</a>&nbsp;&nbsp;<a
				href="#" onclick="userFrom(2);">平台（${user.pCount}）</a>&nbsp; &nbsp;<a
				href="#" onclick="userFrom(3);">微信（${user.wCount}）</a> <input
				type="button" onclick="back();" id="selectLick" value="取消"
				class="btn btn-primary btn-sm" style="margin-left: 5px;"> <input
				type="button" onclick="sure();" id="selectLick" value="确定"
				class="btn btn-primary btn-sm" style="margin-left: 5px;"> <input
				type="hidden" id="pageIndex" name="pageIndex" value="1" /> <input
				type="hidden" id="groupId" name="groupId" value="${user.groupId}" />
			<input type="hidden" name="markUserfrom" id="markUserfrom"
				value="${user.markUserfrom}" /> <input type="hidden"
				name="markSelect" value="1" /> <input type="hidden" id="designerId"
				value="" /> <input type="hidden" id="designerName" value="" />

		</form>
		<table class="table table-bordered table-striped table-hover"
			style="margin-top: -4px;">
			<thead>
				<tr class=" alert-info">
					<th>来源</th>
					<th>用户编号</th>
					<th>用户名</th>
					<th>邮箱</th>
					<th>电话</th>
					<th>真实姓名</th>
					<c:if test="${user.groupId==4}">
						<th>状态</th>
					</c:if>
					<th>所在地</th>
					<th>最后登录</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="user" varStatus="i">
					<tr onclick="onclickTr('${user.uid}','${user.username}');">
						<c:choose>
							<c:when test="${user.wxOpenid==null}">
								<td>平台</td>
							</c:when>
							<c:when test="${user.wxOpenid!=null}">
								<td>微信</td>
							</c:when>
						</c:choose>

						<td>${user.uid}</td>
						<td>${user.username}</td>
						<td>${user.email}</td>
						<td>${user.phone}</td>
						<td>${user.realname}</td>
						<c:if test="${user.groupId==4}">
							<c:choose>
								<c:when test="${user.studioStatus==1}">
									<td>申请中</td>
								</c:when>
								<c:when test="${user.studioStatus==2}">
									<td>已签约</td>
								</c:when>
								<c:when test="${user.studioStatus==3}">
									<td>未签约</td>
								</c:when>
								<c:when test="${user.studioStatus==4}">
									<td>未通过</td>
								</c:when>
								<c:otherwise>
									<td>无</td>
								</c:otherwise>
							</c:choose>
						</c:if>
						<td>${user.city}</td>
						<td><fmt:formatDate value="${user.regTime}"
								pattern="yyyy-MM-dd:HH:mm" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="page-paging2 " style="margin-left: 15px;">
		<!-- 分页 -->
		<c:set value="${user.pageInfo}" var="pageInfo"></c:set>
		<%@include file="../template/pageTemplate.jsp"%>
	</div>



</body>
</html>