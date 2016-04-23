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
<script type="text/javascript" src="<%=path%>/js/pay/jquery.min.js"></script>
<script type="text/javascript" src="/WeixinApi.js"></script>
<script type="text/javascript" charset="UTF-8" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
  <style>
	.choose{width:500px;height:300px;margin:0 auto;background:#FCF;margin-top:150px;text-align:center;padding-top:100px;}
  </style>
 </head>
<%

String body = (String)request.getAttribute("body");
%>
 <body>
	
	<div align="center">
		<p >请注意，微信公众平台的授权目录一定要配置到这也页面所在的目录哦</p>
	</div>
	
	<div class="choose" >
		Click me to pay!
	</div>
 </body>

 <script>
 	$(document).ready( function(){
		//点击测试,注意参数是demo中生成的package
		$(".choose").click(function(){
		    WeixinJSBridge.invoke('getBrandWCPayRequest',{<%=body%>},
		    function(res){
		       //支付成功或失败前台判断
    	       if(res.err_msg=='get_brand_wcpay_request:ok'){
    	    	   alert('恭喜您，支付成功!');
    	       }else{
    	    	   alert('支付失败');
    	       }
		     });
	    
	    });
  });
 </script>
</html>
