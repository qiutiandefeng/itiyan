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

<script type="text/javascript">

 function onClickQueding(){
	 
	 var cancel = $("#cancel").val();
	 var receipt = $("#receipt").val();
	 
	 if(confirm("您确认要设置收货和取消订单时间吗，是否确认？"))
		{
		 $("#msg").html("");
		 $.ajax({
             cache: true,
             type: "POST",
             url:'<%=path%>/systemTools/quartzSwitching.do',
             data:{cancel:cancel,receipt:receipt},// 你的formid
             async: false,
             error: function(request) {
                 alert("Connection error");
             },
             success: function(data) {
                 var ajaxobj=eval("("+data+")");  
                 alert(ajaxobj.state);
             }
         });
		 
		}
 }

</script>


</head>
<body>
	<form id="form1" name="form1" method="post" action="<%=path %>/systemTools/databaseBackup.do">
	<table>
		<tr>
		<font color="red" id="msg" size="2">${msg}</font> 
		<td>
			设置自动取消订单时间
		</td>
		<td>
			设置自动收货时间
		</td>
		</tr>
			<tr>
			<td><input type="text" name="cancel" id="cancel"/></td>
			<td><input type="text" name="receipt" id="receipt"/></td>
			</tr>
	</table>
	<div align="center">
		<input type="button" id="quartz" name="quzrtz" onclick="onClickQuartz()" value="确定"/>
	</div>
	</form>
</body>
</html>