<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.js"></script>
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>用户总量：</td>
			<td>${objMap.countUserAll }</td>
			<td>新增用户量:</td>
			<td>${objMap.countUser }</td>
		</tr>
		<tr>
			<td>订单总量：</td>
			<td>${objMap.countTradeAll }</td>
			<td>新增订单量：</td>
			<td>${objMap.countTrade }</td>
		</tr>
		<tr>
			<td>商品总量：</td>
			<td>${objMap.countModelAll }</td>
			<td>新增商品量：</td>
			<td>${objMap.countModel }</td>
		</tr>
		<tr>
			<td>设计师总量：</td>
			<td>${objMap.countDesignerUserAll }</td>
			<td>新增设计师量：</td>
			<td>${objMap.countDesignerUser }</td>
		</tr>
		<tr>
			<td>java运行环境：</td>
			<td>${objMap.JAVA_VERSION }</td>
			<td>系统信息：</td>
			<td>${objMap.OS_NAME }</td>
			<td>数据库信息：</td>
			<td>${objMap.mysqlProductName }</td>
		</tr>
	
	</table>
</body>
</html>