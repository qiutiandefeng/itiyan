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
<title>品牌管理页</title>


</head>
<body>
	<h1 class="narrow" style="margin-top: 0">
		<img src="../images/icon_29.png"
			style="float: left; margin-top: 10px;">&nbsp;选择品牌
	</h1>
	<div class="container-fluid"
		style="margin-left: -14px; position: absolute; height: 600px; width: 450px; overflow: auto;">
		<form id="sform" action="queryBrand.do" method="post"
			class="newWell form-inline" style="margin-top: -5px;">
			<input type="text" placeholder="品牌名称" name="condition"
				style="margin-top: 0px;" id="condition" value="${condition}"
				class="nav-search-input"> <input type="submit"
				onclick="checkSubmit();" id="selectLick" value="查询"
				class="btn btn-primary btn-sm" style="margin-left: 5px;"> <input
				type="button" onclick="back();" id="selectLick" value="取消"
				class="btn btn-primary btn-sm" style="margin-left: 5px;"> <input
				type="button" onclick="sure();" id="selectLick" value="确定"
				class="btn btn-primary btn-sm" style="margin-left: 5px;"> <input
				type="hidden" id="brand" value="" /> <input type="hidden"
				id="designername" value="" /> <input type="hidden" id="designerid"
				value="" />
		</form>
		<table class="table table-bordered table-striped table-hover"
			style="margin-top: -4px;">
			<thead>
				<tr class=" alert-info">
					<th>选择</th>
					<th>品牌名称</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${brandList}" var="brand" varStatus="i">
					<tr
						onclick="onclickTr('radio${i.count}','${brand.dBrand}','${brand.username}','${brand.uid}')">
						<td><input type="radio" name="radio"
							id="radio${i.count}" /></td>
						<td>${brand.dBrand}</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script type="text/javascript">
	//行点击事件
	function onclickTr(radioid,brand, designername) {
		//清空已经选中的
		cancelAllCheck();
		//设置为选中状态
		document.getElementById(radioid).checked = true;
		$("#brand").val(brand);
		$("#designername").val(designername);

	}
	//点击确定的事件
	function sure() {
		var brand = $("#brand").val();//品牌名称
		var designername = $("#designername").val();//设计师姓名
		var designerid = $("#designerid").val();//设计师ID
		if (designername.length == 0) {
			alert("还没有选中品牌哦！");
			return false;
		}

		//参数传回页面
		window.opener.setbrand(brand, designername, designerid);
		window.close();
	}
	//取消事件
	function back() {
		window.close();
	}
	//清除所有选中状态
	function cancelAllCheck() {
		var radioArray = document.getElementsByName("radio");
		for (var i = 0; i < radioArray.length; i++) {
			radioArray[i].checked = false;

		}
	}
</script>
</html>