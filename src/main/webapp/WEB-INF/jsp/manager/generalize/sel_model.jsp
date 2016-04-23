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
<title>选择商品页面</title>
<script type="text/javascript">
  
	//点击确定的事件
	function sure(){
		 var count=0;
		 var modelids="http://localhost:8080/3dcreatia/modelController/gotoBannerList.do?modelids=";
		 var sel_checkboxArray=document.getElementsByName("sel_checkbox");
		 for(var i=0;i<sel_checkboxArray.length;i++){
			 if(sel_checkboxArray[i].checked){
				 count=count+1;
				 modelids=modelids+sel_checkboxArray[i].id+";";
			 }
		 }
		if(count==0){
			alert("还没有选择商品哦！");
			return false;
		}else if(count>50){
			alert("选择商品太过，数量不能超过50款！");
		}
		modelids=modelids.substring(0,modelids.length-1);
		//参数传回页面
		window.opener.setModelCount(count,modelids);

		window.close();
	}
	//全选按钮
	function setchecked(){
		 var sel_checkboxArray=document.getElementsByName("sel_checkbox");
		if(document.getElementById("sel_all").checked){
			 for(var i=0;i<sel_checkboxArray.length;i++){
				sel_checkboxArray[i].checked = true;
			 }
		}else{
			 for(var i=0;i<sel_checkboxArray.length;i++){
					sel_checkboxArray[i].checked = false;
				 }
		}
	}
	//取消事件
	function back(){
		window.close();
	}
	//修改banner时，还原已经选中的状态
	function uploadset(){
		var oldmodelids=$("#oldmodelids").val();
		oldmodelids=oldmodelids.substring(oldmodelids.indexOf("=")+1,oldmodelids.length);
		if(oldmodelids==""){
			return false;
		}
		var oldmodelidsArray=oldmodelids.split(";");
		var sel_checkboxArray=document.getElementsByName("sel_checkbox");
		for(var j=0;j<oldmodelidsArray.length;j++){
				 for(var i=0;i<sel_checkboxArray.length;i++){
					 if(oldmodelidsArray[j]==sel_checkboxArray[i].id){
						 
					  sel_checkboxArray[i].checked = true;
					 }
				 }
			 
			
		}
	}
</script>
</head>
<body onload="uploadset()">
	<h1 class="narrow" style="margin-top: 0">
		<img src="../images/icon_29.png"
			style="float: left; margin-top: 10px;">&nbsp;选择商品
	</h1>
	<div class="container-fluid" style="margin-left: -14px;position:absolute; height:650px; overflow:auto">
	   <input type="hidden" id="oldmodelids" value="${oldmodelids}"/>
		<form id="sform" action="queryModelsel.do" method="post"
			class="newWell form-inline" style="margin-top: -5px;">
			<input type="text" placeholder="商品名称/品牌" name="condition"
				style="margin-top: 0px;" id="condition"
				value="${condition}" class="nav-search-input"> <input
				type="submit" onclick="checkSubmit();" id="selectLick" value="查询"
				class="btn btn-primary btn-sm" style="margin-left: 5px;"> <input
				type="button" onclick="back();" id="selectLick" value="取消"
				class="btn btn-primary btn-sm" style="margin-left: 5px;"> <input
				type="button" onclick="sure();" id="selectLick" value="确定"
				class="btn btn-primary btn-sm" style="margin-left: 5px;">
		</form>
		<table class="table table-bordered table-striped table-hover"
			style="margin-top: -4px;">
			<thead>
				<tr class=" alert-info">
				    <th><input type="checkbox" name="sel_all" id="sel_all" onclick="setchecked()"/>全选</th>
					<th>商品名称</th>
					<th>品牌</th>
					<th>品类</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${modelList}" var="model" varStatus="i">
					<tr>
					    <td><input type="checkbox" name="sel_checkbox" id="${model.mid}"/></td>
						<td>${model.title}</td>
						<td>${model.brand}</td>
						<td>${model.categoryName}</td>
					</tr>
					 

				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>