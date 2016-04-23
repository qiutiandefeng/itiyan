<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付</title>
<script type="text/javascript" src="<%=path%>/js/pay/qrcode.js"></script>
  <style>
	.choose{width:500px;height:300px;margin:0 auto;background:#FCF;margin-top:150px;text-align:center;padding-top:100px;}
  </style>
	<%
		String body = (String)request.getAttribute("body");
	%>
 </head>
<body>
	
	<div align="center" id="qrcode">
		<p >
		扫我，扫我
		<br><br>
		QQ:553018567
		</p>
	</div>
 </body>

 <script>
 	//这个地址是Demo.java生成的code_url,这个很关键
	var url = '<%=body%>';
	
	//参数1表示图像大小，取值范围1-10；参数2表示质量，取值范围'L','M','Q','H'
	var qr = qrcode(10, 'M');
	qr.addData(url);
	qr.make();
	var dom=document.createElement('DIV');
	dom.innerHTML = qr.createImgTag();
	var element=document.getElementById("qrcode");
	element.appendChild(dom);
 </script>
</html>

