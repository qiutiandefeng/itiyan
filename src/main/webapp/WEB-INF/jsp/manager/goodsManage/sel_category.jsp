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
<title>选择商品类目页面</title>

</head>
<body>
	<h1 class="narrow" style="margin-top: 0">
		<img src="../images/icon_29.png"
			style="float: left; margin-top: 10px;">&nbsp;选择商品类目
	</h1>
	<div class="container-fluid" style="margin-left: -14px;position:absolute; height:600px; width:450px; overflow:auto">
		<form id="sform" action="queryCategory_sel.do" method="post"
			class="newWell form-inline" style="margin-top: -5px;">
			<input type="text" placeholder="类目名称" name="condition"
				style="margin-top: 0px;" id="condition"
				value="${category.condition}" class="nav-search-input"> <input
				type="submit" onclick="checkSubmit();" id="selectLick" value="查询"
				class="btn btn-primary btn-sm" style="margin-left: 5px;"> <input
				type="button" onclick="back();" id="selectLick" value="取消"
				class="btn btn-primary btn-sm" style="margin-left: 5px;"> <input
				type="button" onclick="sure();" id="selectLick" value="确定"
				class="btn btn-primary btn-sm" style="margin-left: 5px;"> <input
				type="hidden" id="categoryName" value="" /> <input type="hidden"
				id="categoryId" value="" /><input type="hidden" id="markCategory" value=""/>
				<input type="hidden" id="parentId" value=""/>
		</form>
		<table class="table table-bordered table-striped table-hover"
			style="margin-top: -4px;">
			<thead>
				<tr class=" alert-info">
					<th>选择</th>
					<th>分类</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="categy" varStatus="i">
					<tr><td></td>
						<td>${categy.title}</td>
					</tr>
					<c:forEach items="${categy.list}" var="catey" varStatus="j">
						<tr onclick="onclickTr('radio${i.count}_${j.count}',2,'${catey.categoryId}','${catey.title}','${categy.categoryId}','${categy.title}')">
							<td><input type="radio" name="radio" id="radio${i.count}_${j.count}"/></td>
							<td>&nbsp;&nbsp;&nbsp;${catey.title}</td>
						</tr>
					</c:forEach>

				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script type="text/javascript">
	//行点击事件
	function onclickTr(radioid,type,categoryId,title,cateyId,tit){
		//清空已经选中的
		cancelAllCheck();
		//设置为选中状态
		document.getElementById(radioid).checked=true;
		 if(type==1){//按照父类
			 $("#categoryId").val(categoryId);
		     $("#categoryName").val(title);
		 }else if(type==2){//按照子类
			 $("#categoryId").val(categoryId);
		     $("#categoryName").val(tit+"/"+title);
		 }
		     $("#markCategory").val(type);
		     $("#parentId").val(cateId);
	}
	//点击确定的事件
	function sure(){
		var categoryName=$("#categoryName").val();//商品类别名称
		var categoryId=$("#categoryId").val();//商品类别ID
		var markCategory=$("#markCategory").val();//标记查询字段
		var parentId=$("#parentId").val();//父节点ID
		if(categoryName.length==0){
			alert("还没有选中商品类别哦！");
			return false;
		}
 
		//参数传回页面
		window.opener.setCategory(markCategory,categoryId,categoryName,parentId);

		window.close();
	}
	//取消事件
	function back(){
		window.close();
	}
	//清除所有选中状态
	function cancelAllCheck(){
		var radioArray = document.getElementsByName("radio");
		for(var i=0;i<radioArray.length;i++){
			radioArray[i].checked=false;
			
		}
	}
</script>

</html>