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
	 
	 var name = $("#name").val();
	 var size = $("#preBoundSize").val();
	 if (size == ''){
		 $("#msg").html("");
		 $("#msg").html("大小不能为空");
		 return;
	 } 
	 if (name == ''){
		 $("#msg").html("");
		 $("#msg").html("数据库名不能为空");
		 return;
	 } 
	 
	 if(confirm("您确认数据库备份吗，是否确认？"))
		{
		 $("#msg").html("");
		 $.ajax({
             cache: true,
             type: "POST",
             url:'<%=path%>/systemTools/databaseBackup.do',
             data:{name:name,preBoundSize:size},// 你的formid
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
			数据库备份大小
		</td>
		<td>
			数据库备份名称
		</td>
		</tr>
			<tr>
			<td><input type="text" name="preBoundSize" id="preBoundSize"/></td>
			<td><input type="text" name="name" id="name"/></td>
			</tr>
	</table>
	<div align="center">
		<input type="button" id="queding" name="queding" onclick="onClickQueding()" value="确定"/>
	</div>
	</form>
</body>
</html>