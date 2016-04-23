<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<link href="<%=request.getContextPath()%>/images/pc/logo2.png" type="image/x-icon"
	rel="shortcut icon" />
<meta charset="utf-8">
<title>爱体验网-支付</title>
<link rel="stylesheet" href="<%=path%>/css/pc/Common_style.css" />
<link rel="stylesheet" href="<%=path%>/css/paycss/payment.css" />
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="<%=path%>/js/pay/payment.js"></script>
<script type="text/javascript" src="<%=path%>/js/pay/qrcode.js"></script>
<style>
	.choose{width:500px;height:300px;margin:0 auto;background:#FCF;margin-top:150px;text-align:center;padding-top:100px;}
  	#qrcode{width:100%;height:100%;background:rgba(0,0,0,0.5);position:fixed;top:0;left:0;display:none;z-index:100}
  	#qrcode img{margin-top:200px;}
  </style>
<style>
*{margin:0;padding:0;}
.tankuang{position:fixed;width:100%;height:100%;background:rgba(0,0,0,0.5)}
.tankuang_div1{width:300px;height:300px;border-radius: 30px;background:#fff;margin:0 auto;margin-top:100px}
.tankuang_div1 img{display: block;height:200px;width:200px;margin:0 auto;padding-top:30px}
.tankuang_div1 div{padding:0 50px;text-align: center;margin-top:10px;color:#00DEBD}
	</style>
</head>

<body>
	<input type="hidden" id="yfhl_user" value="${yfhl_user.uid}" />
	<div>
		<!--hander -->
		<c:set value="${model.condition}" var="condition"></c:set>
		<%@include file="../partpage/hander.jsp"%>
	</div>
	<div class="nav_bottom"></div>
	<!--
        	作者：offline
        	时间：2015-12-11
        	描述：付款 跳轉
        -->
	<p class="payment_text">
		<a href="#">首页</a> > <a href="#">产品</a> > <a href="#">付款</a>
	</p>
	<div class="payment">
		<p class="payment_p1">付款</p>
		<p class="payment_p2">payment</p>
		<img class="payment_img1" src="<%=path%>/images/pc/pay/021.gif" />
		<ul class="payment_ul1">
			<li class="payment_ul1_li1">查看购物车</li>
			<li class="payment_ul1_li2">填写订单</li>
			<li class="payment_ul1_li3">付款，完成购买</li>
		</ul>
		<p class="payment_p3">【在线支付】</p>
		<div class="payment_div1">
			<p class="payment_div1_p1">您的订单已生成成功，现在就去付款吧~</p>
			<p class="payment_div1_p3">共有${tradeCount}笔订单</p>
			<p class="payment_div1_p4">
				应付金额：<span>${totalprice}</span>元
			</p>
			<p class="payment_div1_p5">
				<span></span>支付方式：在线支付
			</p>
		</div>
		<div class="payment_div2">
			<div class="payment_div2_div1 left">
				<img class="payment_div2_div1_img1"
					src="<%=path%>/images/pc/pay/023.gif" /><img
					class="payment_div2_div1_img2"
					src="<%=path%>/images/pc/pay/022.gif" />
			</div>
			<div class="payment_div2_div2 left">
				<img class="payment_div2_div2_img1"
					src="<%=path%>/images/pc/pay/025.gif" /><img
					class="payment_div2_div2_img2"
					src="<%=path%>/images/pc/pay/024.gif" />
			</div>
			<a class="payment_div2_a1"  onclick="submitPaymoney()">使用支付宝付款</a> <input type="hidden"
				id="payType" value="1" />
		</div>
		<div class="yinying"></div>
	</div>
	<div align="center" id="qrcode"></div>
	<form action="<%=request.getContextPath()%>/alipayApi.do" method="post" id="ailipay">
		<input type="hidden" size="30" id="WIDout_trade_no"
			name="WIDout_trade_no" value="${tradeid}" /> <input type="hidden"
			size="30" id="WIDsubject" name="WIDsubject" value="爱体验商品" /> <input
			type="hidden" type="hidden" id="WIDtotal_fee" name="WIDtotal_fee"
			value="${totalprice}" /> <input type="hidden" size="30" id="WIDbody"
			name="WIDbody" value="${tradeid}" /> 
	</form>
	<div>
		<!--bottom -->
		<%@include file="../partpage/bottom.jsp"%>
	</div>
	<div class="logincalss">
		<!--login -->
		<%@include file="../partpage/login.jsp"%>
	</div>
	<!-- 微信支付二维码显示位置 -->
	<div class="tankuang">
			<div class="tankuang_div1">
				<img src="" id="weixinPayStation"/>
				<div>使用微信扫描屏幕上的二维码即可进行支付</div>
			</div>
		</div>
</body>

<script type="text/javascript">
	//去登录页面
	function gotoLogin() {
		window.location.href = "<%=request.getContextPath()%>/login/gotoIndexPC.do";
	}
	//去支付
	function submitPaymoney(){
		var payType=$("#payType").val();
		
		if(payType=="1"){//支付宝支付
			$("#ailipay").submit();
		}else if(payType=="2"){//微信支付
			 var WIDout_trade_no = $("#WIDout_trade_no").val();
			 var WIDtotal_fee = $("#WIDtotal_fee").val();
			 $.ajax({
			     type: "POST",
			     url: "<%=path%>/tradeManage/wxpay.do",
			     data: {WIDout_trade_no:WIDout_trade_no,WIDtotal_fee:WIDtotal_fee},
			     dataType: "json",
			     success: function(data){
		    	 	var url = data;
		    		//参数1表示图像大小，取值范围1-10；参数2表示质量，取值范围'L','M','Q','H'
		    		var qr = qrcode(10, 'M');
		    		qr.addData(url);
		    		qr.make();
		    		var dom=document.createElement('DIV');
		    		dom.innerHTML = qr.createImgTag();
		    		var element=document.getElementById("qrcode");
		    		element.appendChild(dom);
		    		disBlock();
			     }
			 });
		 
		}
	}
	function disBlock(){
		$("#qrcode").css({"display":"block"});
		$("#qrcode img").css({"width":"200px","height":"200px"})
	}
	$("#qrcode").click(function(){
		$("#qrcode").html(" ");
		$("#qrcode").css({"display":"none"});
	})
</script>
</html>
