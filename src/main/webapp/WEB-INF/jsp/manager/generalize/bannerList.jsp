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
	src="<%=path%>/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/js/jquery-1.8.2.js"></script>
<script type="text/javascript"
	src="<%=path%>/js/global.js"></script>
<script type="text/javascript"
	src="<%=path%>/js/layer/layer.js"></script>
<script type="text/javascript"
	src="<%=path%>/js/dialog/dialog.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/js/dialog.js"></script>
<link href="<%=path%>/css/bootstrap.min.css"
	type="text/css" rel="stylesheet">
<link href="<%=path%>/css/bootstrap-theme.min.css"
	type="text/css" rel="stylesheet">
<link href="<%=path%>/css/style.css" type="text/css"
	rel="stylesheet">
<link href="<%=path%>/css/newWell.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>广告管理页</title>

</head>
<body>
	<h1 class="narrow" style="margin-top: 0">
		<img src="../images/icon_29.png"
			style="float: left; margin-top: 10px;">&nbsp;运营推广-banner
	</h1>
	<div class="container-fluid" style="margin-left: -14px;">
		<form id="sform" action="queryListByPage.do" method="post"
			class="newWell form-inline" style="margin-top: -5px;">
			<input type="text" placeholder="banner名称" name="condition"
				style="margin-top: 0px;" id="condition" value="${banner.condition}"
				class="nav-search-input"> &nbsp;&nbsp;&nbsp;显示位置 <select
				id="station_sel" style="margin-left: 5px;" onchange="onchangeSel()">
				<c:if test="${banner.banStation_sel!=1 && banner.banStation_sel!=2}">
					<option id="-1" selected="selected">-所有-</option>
					<option id="1">PC端</option>
					<option id="2">微信移动端</option>
				</c:if>
				<c:if test="${banner.banStation_sel==1}">
					<option id="-1">-所有-</option>
					<option id="1" selected="selected">PC端</option>
					<option id="2">微信移动端</option>
				</c:if>
				<c:if test="${banner.banStation_sel==2}">
					<option id="-1">-所有-</option>
					<option id="1">PC端</option>
					<option id="2" selected="selected">微信移动端</option>
				</c:if>
			</select> <input type="submit" onclick="checkSubmit()" id="selectLick"
				value="查询" class="btn btn-primary btn-sm" style="margin-left: 5px;">&nbsp;
			<input type="button" onclick="bannerManage(1,0);" value="新增"
				class="btn btn-primary btn-sm" style="margin-left: 5px;"> <input
				type="hidden" id="pageIndex" name="pageIndex"
				value="${banner.pageInfo.pageIndex}" /> <input type="hidden"
				id="banStation_sel" name="banStation_sel"
				value="${banner.banStation_sel}" />
		</form>
		<table class="table table-bordered table-striped table-hover"
			style="margin-top: -4px;">
			<thead>
				<tr class=" alert-info">
					<th>显示</th>
					<th>排序</th>
					<th>banner图片</th>
					<th>banner名称</th>
					<th>状态</th>
					<th>上线时间</th>
					<th colspan="3">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bannerList}" var="banners" varStatus="i">
					<tr>
						<td><c:if test="${banners.banStation==1}">PC</c:if> <c:if
								test="${banners.banStation==2}">微信</c:if></td>
						<td>${banners.banOrder}</td>
						<td><img id="imagez"
							src="<%=path%>/upload/uploadImg/banner/${banners.banImgurl}"
							style="width: 80px; height: 80px;" /></td>
						<td>${banners.banName}</td>
						<td><c:if test="${banners.banState==1}">展示中</c:if> <c:if
								test="${banners.banState==2}">不展示</c:if></td>
						<td><fmt:formatDate value="${banners.banAddtime}"
								pattern="yyyy-MM-dd HH:SS:MM" /></td>
						<td colspan="3"><a
							href="javascript:bannerManage(3,${banners.bannerid});"
							style="color: blue;">查看详情</a> &nbsp;<a
							href="javascript:bannerManage(2,${banners.bannerid});"
							style="color: blue;">编辑</a> &nbsp;<a
							href="javascript:bannerDel(${banners.bannerid});"
							style="color: blue;">删除</a>&nbsp; <c:if
								test="${banners.banState==1}">
								<a href="javascript:bannerShow(2,${banners.bannerid});"
									style="color: blue;">取消展示</a>
							</c:if> <c:if test="${banners.banState==2}">
								<a href="javascript:bannerShow(1,${banners.bannerid});"
									style="color: blue;">展示</a>
							</c:if></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="page-paging2" style="margin-left: 15px;">
		<!-- 分页 -->
		<c:set value="${banner.pageInfo}" var="pageInfo"></c:set>
		<%@include file="../template/pageTemplate.jsp"%>
	</div>
</body>

<script type="text/javascript">
    //提交验证
	function checkSubmit() {
		//1.搜索框去掉前后空格
		var condition = $.trim($("#condition").val());
		$("#condition").val(condition);
		//2.获取状态:状态为空默认赋值为：-1
		var banStation_sel=$("#banStation_sel").val();//
		if(banStation_sel==''){
			  $("#banStation_sel").val('-1');
		}
		  return true;
	}
    //根据下拉框动态修改隐藏标记值
   function onchangeSel(){
	  
		   var banStation_sel=$("#station_sel").find("option:selected").attr("id");
		   $("#banStation_sel").val(banStation_sel);//保存到动态隐藏值中 
		  
	  
   }
	//添加banner:type:1添加；2编辑;3:查看;bannerid:bannerid;
	function bannerManage(type,bannerid){
		var pageIndex=$("#pageIndex").val();
		var condition = $.trim($("#condition").val());
		var banStation_sel=$("#banStation_sel").val();
	    
		window.location.href="<%=request.getContextPath()%>/bannerController/gotobannerManage.do?pageInfo.pageIndex="
				+ pageIndex+ "&bannerid="+bannerid+"&markManage="+type+"&condition="+condition+"&banStation_sel="+banStation_sel;
	}
	//删除banner
	function bannerDel(bannerid){
		var pageIndex=$("#pageIndex").val();
		var condition = $.trim($("#condition").val());
		var banStation_sel=$("#banStation_sel").val();
		if(window.confirm("确定要删除该banner吗？")){
			window.location.href="<%=request.getContextPath()%>/bannerController/delBanner.do?pageInfo.pageIndex="
					+ pageIndex + "&bannerid=" + bannerid+"&condition="+condition+"&banStation_sel="+banStation_sel;
         } 
		
	}
	 
	//控制显示操作
	function bannerShow(type,bannerid){
		var pageIndex=$("#pageIndex").val();
		var condition = $.trim($("#condition").val());
		var banStation_sel=$("#banStation_sel").val();
		 
		window.location.href="<%=request.getContextPath()%>/bannerController/setBannerShow.do?pageInfo.pageIndex="
					+ pageIndex + "&bannerid=" + bannerid+"&condition="+condition+"&banStation_sel="+banStation_sel+"&banState="+type;
         
	}
	 
 
</script>
</html>