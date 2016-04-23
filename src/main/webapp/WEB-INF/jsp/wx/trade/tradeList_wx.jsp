<%@ page language="java" import="java.util.*,com.yfhl.entity.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>爱体验—订单</title>
<link rel="stylesheet" href="/3dcreatia/css/wx/gerendingdan.css" />
<!-- 微信 -->
<script type="text/javascript"
	src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript" src="<%=path%>/js/wx/gongGong.js"></script>
<script type="text/javascript" src="<%=path%>/js/wx/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/pay/qrcode.js"></script>

<%
	String appid = (String)request.getAttribute("appId");
	String timestamp = (String)request.getAttribute("timestamp");
	String nonceStr = (String)request.getAttribute("nonceStr");
	String signature = (String)request.getAttribute("signature");
%>
<!-- 微信分享接口 -->
<script type="text/javascript">

//https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx66f9db2c0482ac07&redirect_uri=http://aishaimi.cn/campusambassador/users/share?uid=dbe22b1a-77e6-4f45-9872-f6e5248fdc17&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect
     	var uurl = location.href.split('#')[0];
     	var appId = '<%= appid%>';
     	var url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appId+"&redirect_uri="+uurl+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
     	var timestamp = '<%= timestamp%>';
     	var nonceStr = '<%= nonceStr%>';
     	var signature = '<%= signature%>';
     	var imgUrl = 'http://javali.cn/3dcreatia/images/pc/051.gif';
     	
     	//alert(timestamp+","+nonceStr+","+signature+","+appId);
         //微信权限设置
		wx.config({
		    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
		    appId:  appId, // 必填，公众号的唯一标识<>
		    timestamp: timestamp, // 必填，生成签名的时间戳
		    nonceStr: nonceStr, // 必填，生成签名的随机串
		    signature: signature,// 必填，签名，见附录1
		    jsApiList: ['onMenuShareTimeline','onMenuShareAppMessage'] // 必填，需要使,用的JS接口列表，所有JS接口列表见附录2
		});
         // 开启Api的debug模式
         //WeixinApi.enableDebugMode();
         
         wx.ready(function(){
         	//alert("微信开始");
         	
         	//分享给朋友圈
            wx.onMenuShareTimeline({
              imgUrl :imgUrl,
              link : url,
              title : '爱体验网',
              desc : "一起嗨起来~~~",
              type :"link",
               success: function () { 
                    // 用户确认分享后执行的回调函数
                    alert("分享成功");
                },
                cancel: function () { 
                    // 用户取消分享后执行的回调函数
                    alert("分享失败");
                }
            });
          //分享给好友
            wx.onMenuShareAppMessage({
            	title : '爱体验网',
                desc : "一起嗨起来~~~",
                link: url, // 分享链接
                imgUrl: imgUrl, // 分享图标
                type: 'link', // 分享类型,music、video或link，不填默认为link
                success: function () { 
                    // 用户确认分享后执行的回调函数
                	alert("分享成功");
                },
                cancel: function () { 
                    // 用户取消分享后执行的回调函数
                	alert("分享失败");
                }
            });
            
         	
         });
         
         wx.error(function(res){
        	 
        	 alert("微信失败:" + res);
         });
         
</script>
<style>
.tankuang {
	position: fixed;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.5)
}

.tankuang_div1 {
	width: 300px;
	height: 300px;
	border-radius: 30px;
	background: #fff;
	margin: 0 auto;
	margin-top: 100px
}

.tankuang_div1 img {
	display: block;
	height: 200px;
	width: 200px;
	margin: 0 auto;
	padding-top: 30px
}

.tankuang_div1 div {
	padding: 0 50px;
	text-align: center;
	margin-top: 10px;
	color: #00DEBD
}

.divsss {
	width: 100%;
	height: 100%;
	position: fixed;
	top: 0;
	left: 0;
	background: rgba(0, 0, 0, 0.5);
	z-index: 100;
	display: none
}

.div1s {
	width: 100%;
}

.div1s img {
	display: block;
	width: 200px;
	height: 200px;
	margin: 0 auto;
	margin-top: 30%;
}

.div2s {
	color: #00debd;
	font-size: 1rem;
	width: 80%;
	margin-left: 10%;
	margin-top: 10%
}
</style>

</head>
<body>
	<input type="hidden" id="yfhl_user" value="${yfhl_user.uid}" />
	<input type="hidden" id="markstate" value="${trade.state}" />
	<div class="head">我的订单</div>
	<!--
        	作者：offline
        	时间：2016-03-04
        	描述：nav
        -->
	<div class="nav">
		<c:choose>
			<c:when test="${trade.state==1}">
				<div onclick="gotoTrade(0)">全部</div>
				<div class="divBlue" onclick="gotoTrade(1)">
					待付款<span>${trade.state1Count}</span>
				</div>
				<div onclick="gotoTrade(2)">
					待发货<span>${trade.state2Count}</span>
				</div>
				<div onclick="gotoTrade(3)">
					待确认<span>${trade.state3Count}</span>
				</div>
			</c:when>
			<c:when test="${trade.state==2}">
				<div onclick="gotoTrade(0)">全部</div>
				<div onclick="gotoTrade(1)">
					待付款<span>${trade.state1Count}</span>
				</div>
				<div class="divBlue" onclick="gotoTrade(2)">
					待发货<span>${trade.state2Count}</span>
				</div>
				<div onclick="gotoTrade(3)">
					待确认<span>${trade.state3Count}</span>
				</div>
			</c:when>
			<c:when test="${trade.state==3}">
				<div onclick="gotoTrade(0)">全部</div>
				<div onclick="gotoTrade(1)">
					待付款<span>${trade.state1Count}</span>
				</div>
				<div onclick="gotoTrade(2)">
					待发货<span>${trade.state2Count}</span>
				</div>
				<div class="divBlue" onclick="gotoTrade(3)">
					待确认<span>${trade.state3Count}</span>
				</div>
			</c:when>
			<c:otherwise>
				<div class="divBlue" onclick="gotoTrade(0)">全部</div>
				<div onclick="gotoTrade(1)">
					待付款<span>${trade.state1Count}</span>
				</div>
				<div onclick="gotoTrade(2)">
					待发货<span>${trade.state2Count}</span>
				</div>
				<div onclick="gotoTrade(3)">
					待确认<span>${trade.state3Count}</span>
				</div>

			</c:otherwise>
		</c:choose>

	</div>

	<!--
        	作者：offline
        	时间：2016-03-04
        	描述：订单状态
        -->
	<c:if test="${tradeList.size()==0}">
		<div class="tishi">
			<p>您还没有订单~</p>
			<p>
				<a href="###" onclick="gotoFirstPage()">去逛逛</a>
			</p>
		</div>

	</c:if>
	<c:if test="${tradeList.size()!=0}">
		<c:forEach items="${tradeList}" var="trades" varStatus="i">
			<c:if test="${trades.marker_state!=2}">
				<div class="state">
					<div class="state_div1">
						<span class="state_div1_sp1">${trades.tradeTitle}</span>
						<c:choose>
							<c:when test="${trades.status==1}">
								<span class="state_div1_sp2">等待付款</span>
							</c:when>
							<c:when test="${trades.status==2}">
								<span class="state_div1_sp2">等待发货</span>
							</c:when>
							<c:when test="${trades.status==3}">
								<span class="state_div1_sp2">等待收货</span>
							</c:when>
							<c:when test="${trades.status==4}">
								<span class="state_div1_sp3">交易完成</span>
							</c:when>
							<c:when test="${trades.status==5}">
								<span class="state_div1_sp3">交易关闭</span>
							</c:when>
						</c:choose>
					</div>
					<c:forEach items="${trades.tradeDetailList}" var="tradeDetail"
						varStatus="j">
						<div class="state_div2">
							<img class="state_div2_img1"
								src="/upload/uploadImg/model/${tradeDetail.tradeDetailImg}" />
							<div class="state_div2_div1">
								<p>${tradeDetail.name}</p>
								<p class="state_div2_div1_p2">${tradeDetail.modtTextture}/${tradeDetail.modtSize}</p>
							</div>
							<div class="clearBoth"></div>
						</div>
					</c:forEach>
					<div class="state_div3">
						<div class="state_div3_div1">
							实付款：￥<span>${trades.totalPrice}</span>
						</div>
						<div class="state_div3_div2">
							<c:choose>
								<c:when test="${trades.status==1}">
									<div class="state_div3_div2_div1"
										onclick="fastTopay('${trades.totalPrice}','${trades.tradeNo}')">付款</div>
									<div class="state_div3_div2_div2"
										onclick="cancelTrade('${trades.id}')">取消</div>
								</c:when>
								<c:when test="${trades.status==2}">
									<span class="state_div3_div2_div1"></span>
								</c:when>
								<c:when test="${trades.status==3}">
									<span class="state_div3_div2_div1"
										onclick="makesureTreade('${trades.id}')">确认收货</span>
								</c:when>
								<c:when test="${trades.status==4}">
									<img class="state_div3_div2_div5"
										src="<%=path %>/images/wx/029.gif"
										onclick="delTrade('${trades.id}')" />

								</c:when>
								<c:when test="${trades.status==5}">
									<img class="state_div3_div2_div5"
										src="<%=path %>/images/wx/029.gif"
										onclick="delTrade('${trades.id}')" />

								</c:when>
							</c:choose>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${trades.marker_state==2}">
				<div class="state shixiao">
					<div class="state_div1">
						<span class="state_div1_sp1"><span
							class="state_div1_sp1_sp1">失效</span>【3DCREATIA】</span> <span
							class="state_div1_sp2 state_div1_sp2_555">未付款订单已失效，交易关闭</span>

					</div>
					<c:forEach items="${trades.tradeDetailList}" var="tradeDetail"
						varStatus="j">
						<div class="state_div2">
							<img class="state_div2_img1"
								src="/upload/uploadImg/model/${tradeDetail.tradeDetailImg}" />
							<div class="state_div2_div1">
								<p>${tradeDetail.name}</p>
								<p class="state_div2_div1_p2">${tradeDetail.modtTextture}/${tradeDetail.modtSize}</p>
							</div>
							<div class="clearBoth"></div>
						</div>
					</c:forEach>
					<div class="state_div3">
						<div class="state_div3_div1">
							实付款：￥<span>${trades.totalPrice}</span>
						</div>
						<div class="state_div3_div2">
							<img class="state_div3_div2_div5"
								src="<%=path %>/images/wx/029.gif"
								onclick="delTrade('${trades.id}')" />
						</div>
					</div>
				</div>
			</c:if>
		</c:forEach>
	</c:if>
	<div class="foot">没有更多订单了~</div>
	<div class="divsss">
		<div class="div1s" id="div1s"></div>
		<div class="div2s">长按识别屏幕上的二维码，即可完成支付</div>
	</div>

</body>
<script type="text/javascript">
	//立即付款
	function fastTopay(totalPrice,tradeNo) {
		 $.ajax({
		     type: "POST",
		     url: "<%=path%>/wxtrade/wxfastTopay.do",
		     data: {
		    	 totalPrice : totalPrice,
		    	 tradeNo : tradeNo
		    	 },
		     dataType: "json",
		     success: function(data){
		    	 alert(data+"---");
         	 	var url = data;
		    		//参数1表示图像大小，取值范围1-10；参数2表示质量，取值范围'L','M','Q','H'
		    		var qr = qrcode(10, 'M');
		    		qr.addData(url);
		    		qr.make();
		    		var dom=document.createElement('DIV');
		    		dom.innerHTML = qr.createImgTag();
		    		var element=document.getElementById("div1s");
		    		element.appendChild(dom);
		    		tanchus();
		     }
		 });
	}
	function tanchus(){
		$(".divsss").css({"display":"block"});
	}
	//订单查询
	function gotoTrade(type) {
		document.write('<form action="<%=path %>/wxtrade/wxtradeList.do" method="post" name="formx2" style="display:none">');
		document.write('<input type="hidden" name="state" value="'+type+'"/>');
		document.write("</form>");
		document.formx2.submit();
	}
	//去首页
	function gotoFirstPage() {
		window.location.href = "/3dcreatia/wxModel/wxgotoModelIndex.do";
	}
	//取消订单
	function cancelTrade(tid) {
		if (window.confirm("确定要取消该订单吗？")) {
			document
					.write('<form action="/3dcreatia/wxtrade/wxcancelTrade.do" method="post" name="formx3" style="display:none">');
			document.write('<input type="hidden" name="id" value="'+tid+'"/>');
			document.write("</form>");
			document.formx3.submit();
		}

	}
	//删除订单
	function delTrade(tid) {
		if (window.confirm("确定要删除该订单吗？")) {
			document.write('<form action="/3dcreatia/wxtrade/wxdelTrade.do" method="post" name="formx4" style="display:none">');
			document.write('<input type="hidden" name="id" value="'+tid+'"/>');
			document.write("</form>");
			document.formx4.submit();
		}
	}
	//确认收货
	function makesureTreade(tid) {
		if (window.confirm("确认收货后您的预付款将会打到卖家平台，请确认您是否已收到货品！")) {
			document
					.write('<form action="/3dcreatia/wxtrade/wxmakeSureTreadePC.do" method="post" name="formx5" style="display:none">');
			document.write('<input type="hidden" name="id" value="'+tid+'"/>');
			document.write("</form>");
			document.formx5.submit();
		}
	}
</script>
</html>