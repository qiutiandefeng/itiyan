<%@ page language="java" import="java.util.*,com.yfhl.entity.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>爱体验—商品详情</title>
<link rel="stylesheet" href="/3dcreatia/css/wx/xiangqingye.css" />
<link rel="stylesheet" href="/3dcreatia/css/wx/swiper1.3.1.7.min.css" />
<script type="text/javascript"
	src="/3dcreatia/js/wx/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="/3dcreatia/js/wx/swiper.3.1.7.min.js"></script>
<script type="text/javascript" src="/3dcreatia/js/wx/xiangqingye.js"></script>
<script charset="utf-8"
	src="/3dcreatia/js/kindeditor-4.1.10/kindeditor.js"></script>
<script charset="utf-8"
	src="/3dcreatia/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script charset="utf-8"
	src="/3dcreatia/js/kindeditor-4.1.10/plugins/code/prettify.js"></script>
<link rel="stylesheet"
	href="/3dcreatia/js/kindeditor-4.1.10/themes/default/default.css" />
<link rel="stylesheet"
	href="/3dcreatia/js/kindeditor-4.1.10/plugins/code/prettify.css" />
<!-- 微信 -->
<script type="text/javascript"
	src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>

<%
	
	Model model = (Model)request.getAttribute("model");
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
              title : '爱体验网—<%=model.getTitle()%>',
              desc : 'Come on 一 起 嗨 ~~~',
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
            	title : '爱体验网—<%=model.getTitle()%>',
                desc : 'Come on 一 起 嗨 ~~~',
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


</head>
<body>
	<input type="hidden" id="yfhl_user" value="${yfhl_user.uid}" />
	<input type="hidden" id="modelid" value="${model.mid}" />
	<input type="hidden" id="modRepertory" value="${model.modRepertory}" />
	<input type="hidden" id="modelname" value="${model.title}" />
	<input type="hidden" id="autherID" value="${model.author}" />
	<input type="hidden" id="brand" value="${model.brand}" />
	<input type="hidden" id="modSelfDesigner"
		value="${model.modSelfDesigner}" />
	<input type="hidden" id="val_textture" value="" />
	<input type="hidden" id="val_size" value="" />
	<!--
        	作者：offline
        	时间：2016-02-17
        	描述：头部（部分统一）
        -->
	<div class="heads">
		<div class="head" onclick="gotoShopping()">
			<a href="###"><img src="../images/wx/005.png" /></a>
			<div>
				<a href="###"><span id="shoppingCount">${yfhl_user.shoppingCount}</span></a>
			</div>

		</div>
	</div>

	<!--
        	作者：offline
        	时间：2016-02-23
        	描述：banner轮播
        -->
	<div class="banner">
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<c:forEach items="${model.imgList}" var="img" varStatus="i">
					<c:if test="${i.count<5}">
						<div class="swiper-slide">
							 <img src="/upload/uploadImg/model/${img}"
								id="modelImg${i.count}" /> 
						</div>
					</c:if>
				</c:forEach>
			</div>
			<div class="swiper-pagination" id="swiper-pagination"></div>
		</div>


	</div>


	<!--
        	作者：offline
        	时间：2016-02-23
        	描述：详细信息
        -->
	<div class="show">
		<div class="show_div1">
			<p class="show_div1_p1">${model.title}</p>
			<p class="show_div1_p2">
				￥<span id="modelPrice_show">${model.price}</span>
			</p>
			<div class="show_div1_div1">
				<div class="show_div1_div1_div1">
					<span>${model.favoriteNum}</span> <img
						src="/3dcreatia/images/wx/008.gif" />
				</div>
				<div class="show_div1_div1_div2">
					运费:￥<span id="msModtransport">0.00</span>
				</div>
			</div>
		</div>
		<div class="show_div2">
			<img src="/upload/uploadImg/user/${model.designerAvatar}" />
			<p class="show_div2_p1">${model.designerName}</p>
			<p class="show_div2_p2">${model.designerBrand}</p>
			<a class="show_div2_a1" href="###">more</a>
		</div>
		<div class="show_div3">
			<p>
				货品产地：<span>${model.modFrom}</span>
			</p>
			<p>
				品牌属地：<span>${model.brandPlace}</span>
			</p>
			<p>
				重量：<span>${model.modWeight}</span>
			</p>
			<p>
				成分：<span>${model.modElement}</span>
			</p>
			<p>
				尺码：<span>${model.modSize}</span>
			</p>
			<p>
				温馨提示：<span>${model.modServe}</span>
			</p>
		</div>
		<div class="show_div4">${model.modDetail}</div>
		<div class="show_div5">
			<div class="show_div5_div1">
				<div class="show_div5_div1_div2">特殊说明</div>
				<div class="show_div5_div1_div3">售后</div>
			</div>
			<div class="twoPx"></div>
			<div class="show_div5_div3">
				<p class="show_div5_div3_p1">佩戴保养</p>
				<p class="show_div5_div3_p2">不要带着洗澡，不佩戴请清洁好放密封袋里，避免化学品特别是海水、温泉。</p>
				<p class="show_div5_div3_p1">如果氧化</p>
				<p class="show_div5_div3_p2">请用擦银布清洁，布不能碰水，严重的可用一点牙膏清洁</p>
				<p>
					<a class="show_div5_div3_p5_a1" href="###"></a>
				</p>
			</div>
			<div class="show_div5_div4">
				<p>${model.modServe}</p>
			</div>
		</div>
		<div class="show_div6">
			<p>爱体验推荐</p>
			<div>

				<c:forEach items="${modelRecommendList}" var="modelRecommend"
					varStatus="i">
					<a href="###"><img
						src="/upload/uploadImg/model/${modelRecommend.img}"
						onclick="gotoModelDetail('${modelRecommend.mid}')" /></a>
				</c:forEach>
				<div class="clearBoth"></div>
			</div>
		</div>
		<div class="tianchong"></div>
	</div>
	<div class="show_div7">
		<a class="show_div7_a1" href="###"><img
			src="/3dcreatia/images/wx/015.gif" /></a> <a class="show_div7_a2"
			href="###"><span class="sp1">￥<span>${model.price}</span></span></a>
		<input type="hidden" id="mark_type" value="" />
	</div>
	<!--
        	作者：offline
        	时间：2016-02-23
        	描述：品牌简介，特殊事件，售后的模态窗口
        -->
	<div class="mohu"></div>
	<div class="motai_div1">
		<img class="motai_div1_img1" src="/3dcreatia/images/wx/3.png" /> <img
			class="motai_div1_img2" src="/3dcreatia/images/wx/1.png" />
		<p class="motai_div1_p1">3DCREATIA</p>
		<p class="motai_div1_p2">${model.description}</p>
	</div>
	<div class="motai_div2">
		<img class="motai_div2_img1" src="/3dcreatia/images/wx/3.png" /> <img
			class="motai_div2_img2" src="/3dcreatia/images/wx/1.png" />
		<p class="motai_div2_p1">特殊说明</p>
		<p class="motai_div2_p2">无</p>
	</div>
	<div class="motai_div3">
		<img class="motai_div3_img1" src="/3dcreatia/images/wx/3.png" /> <img
			class="motai_div3_img2" src="/3dcreatia/images/wx/1.png" />
		<p class="motai_div3_p1">售后</p>
		<p class="motai_div3_p2">${model.modServe}</p>
	</div>
	<!--
        	作者：offline
        	时间：2016-02-29
        	描述：购买选项
        -->
	<div class="options"></div>

	<div class="options_div1">
		<div>
			<img class="options_div1_img1"
				src="/upload/uploadImg/model/${model.img}" /> 
		</div>
		<div class="options_div1_div1">
			<p class="options_div1_div1_p1">
				￥<span id="modelPrice">${model.price}</span>
			</p>
			<p class="options_div1_div1_p2">${model.title}</p>
			<p class="options_div1_div1_p3">
				被摸了<span>${model.favoriteNum}</span>次
			</p>
		</div>
		<div class="options_div1_div2">
			<div class="options_div1_div2_div1">材料:</div>
			<div class="options_div1_div2_div2">
				<c:forEach items="${model.texttrueList}" var="modelTypeTextture"
					varStatus="i">
					<c:if test="${modelTypeTextture.modtImg!='url_null'}">
						<img class="options_div1_div2_div2_img"
							src="/upload/uploadImg/textture/${modelTypeTextture.modtImg}"
							onclick="setModeltype(1,'${modelTypeTextture.modtTexture}')" />
					</c:if>
					<c:if test="${modelTypeTextture.modtImg=='url_null'}">
						<span class="options_div1_div2_div2_sp"
							onclick="setModeltype(1,'${modelTypeTextture.modtTexture}')">${modelTypeTextture.modtTexture}</span>
					</c:if>
				</c:forEach>
			</div>
			<div class="clearBoth"></div>
		</div>
		<div class="options_div1_div3">
			<div class="options_div1_div3_div1">尺寸:</div>
			<div class="options_div1_div3_div2">
				<c:forEach items="${model.sizeList}" var="modelTypeSize">
					<span class="options_div1_div3_div2_sp"
						onclick="setModeltype(2,'${modelTypeSize.modtSize}')">${modelTypeSize.modtSize}</span>
				</c:forEach>
			</div>
			<div class="clearBoth"></div>
		</div>
		<div class="options_div1_div4">
			<div class="options_div1_div4_div1">数量:</div>
			<div class="options_div1_div4_div2">
				<img class="options_div1_div4_div2_im1"
					src="/3dcreatia/images/wx/019.gif" onclick="checkNumber(1)" /> <span
					class="options_div1_div4_div2_sp" id="modelcount">1</span> <img
					class="options_div1_div4_div2_im2"
					src="/3dcreatia/images/wx/020.gif" onclick="checkNumber(2)" />
			</div>
			<div class="clearBoth"></div>
		</div>
		<div class="options_div1_div5" onclick="checkSubmit()">
			<img src="/3dcreatia/images/wx/021.gif" />
		</div>
	</div>
	<div class="cars_div1">1</div>
	<img class="imgTop" src="/3dcreatia/images/wx/035.png" />
</body>
<script type="text/javascript">
	//操作数量:type:操作类型；allCount:库存量
	function checkNumber(type, allCount) {
		var modRepertory = Number($("#modRepertory").val());
		var count = Number($(".options_div1_div4_div2_sp").text());
		if (type == 1) {
			count = count - 1;
		} else if (type == 2) {
			count = count + 1;
		}
		if (count < 1) {
			count = 1;
		}
		if (count > modRepertory) {
			alert("已经到达库存上线了！");
			return false;
		}
		$(".options_div1_div4_div2_sp").text(count);

	}
	//确认按钮操作
	function checkSubmit() {
		var type = Number($("#mark_type").val());//操作类别
		var uid = $("#yfhl_user").val();
		//商品Id
		var modelid = $("#modelid").val();
		//商品名称
		var modelname = $("#modelname").val();
		//商品品牌
		var brand = $("#brand").val();
		//商品图片
		var modelimg = $("#modelImg1")[0].src;
		modelimg = modelimg.substring(modelimg.lastIndexOf("/") + 1,modelimg.length);
		//商品材质
		var val_textture = $("#val_textture").val();
		if (val_textture == '') {
			alert("请选择商品材质");
			return false;
		}
		//尺寸
		var val_size = $("#val_size").val();
		if (val_size == '') {
			alert("请选择商品尺寸");
			return false;
		}
		//数量
		var modelcount = $("#modelcount").text();
		//alert(modelcount);
		//价格
		var modelPrice = $("#modelPrice").text();
		//alert(modelPrices);
		//运费
		var msModtransport = $("#msModtransport").text();
		//alert(msModtransport);
		//设计师ID
		var autherID = $("#autherID").val();
		//商品来源
		var modSelfDesigner = $("#modSelfDesigner").val();
		if (type == 1) {//加入购物车
			$.ajax({
						type : "post",
						url : "/3dcreatia/wxModelShoppingController/wxModelShopping.do",
						data : {
							msModelid : modelid,
							msModelname : modelname,
							msModelbrand : brand,
							msModelimg : modelimg,
							msModtexture : val_textture,
							msModsize : val_size,
							msModcount : modelcount,
							msModprice : modelPrice,
							msModtransport : msModtransport,
							msUid : uid,
							msSelfDesigner : modSelfDesigner

						},
						dataType : 'text',
						success : function(result) {
							if (result != 0) {

								$(".options_div1").removeClass("options_div2")
										.addClass("options_div3");
								$(".imgTop").css({
									"display" : "block"
								});
								$(".options").fadeOut(100);
								$(".cars_div1").fadeIn(100);
								$(".cars_div1").addClass("cars_div2");

								$("#shoppingCount").text(result);
							} else {
								alert("添加购物车失败");
							}

						},
						error : function() {
							alert("失败！");
						}

					});

		} else if (type == 2) {//立即购买	
			var modRepertory = Number($("#modRepertory").text());
			if (modRepertory == 0) {
				alert("对不起，该商品库存不足啦，您可以先添加都购物车中哦！！");
				return false;
		  		 }
			//提交
			document
					.write('<form action="/3dcreatia/wxModelShoppingController/wxSettleCountByDetail.do" method="post" name="formx1" style="display:none">');
			document
					.write('<input type="hidden" name="msUid" value="'+uid+'"/>');
			document
					.write('<input type="hidden" name="msModelid" value="'+modelid+'"/>');
			document
					.write('<input type="hidden" name="msModelname" value="'+modelname+'"/>');
			document
					.write('<input type="hidden" name="msModelbrand" value="'+brand+'"/>');
			document
					.write('<input type="hidden" name="msModelimg" value="'+modelimg+'"/>');
			document
					.write('<input type="hidden" name="msModtexture" value="'+val_textture+'"/>');
			document
					.write('<input type="hidden" name="msModsize" value="'+val_size+'"/>');
			document
					.write('<input type="hidden" name="msModcount" value="'+modelcount+'"/>');
			document
					.write('<input type="hidden" name="msModprice" value="'+modelPrice+'"/>');
			document
					.write('<input type="hidden" name="msModtransport" value="'+msModtransport+'"/>');
			document
					.write('<input type="hidden" name="msSelfDesigner" value="'+modSelfDesigner+'"/>');
			document.write("</form>");
			document.formx1.submit();
		}

	}
	//设置商品规格信息:type:1:材质；2s:尺寸
	function setModeltype(type, val) {
		//设置隐藏值
		if (type == 1) {
			$("#val_textture").val(val);
		} else if (type == 2) {
			$("#val_size").val(val);
		}

		//异步查询价格信息
		//商品材质
		var val_textture = $("#val_textture").val();
		if (val_textture == '') {
			return false;
		}
		//尺寸
		var val_size = $("#val_size").val();
		if (val_size == '') {
			return false;
		}
		//商品Id
		var modelid = $("#modelid").val();
		$.ajax({
			type : "post",
			url : "/3dcreatia/wxModelTypeController/wxQueryModelTypeByself.do",
			data : {
				modtModid : modelid,
				modtTexture : val_textture,
				modtSize : val_size

			},
			dataType : 'text',
			success : function(result) {
				if (result != "") {
					var ret = JSON.parse(result);
					//alert("价格:"+ret.modtPrice.toFixed(2));
					$("#modelPrice").text(ret.modtPrice.toFixed(2));
					$("#modelPrice_show").text(ret.modtPrice.toFixed(2));
					$("#modRepertory").text(ret.modtRepertory);
					//alert($("#modRepertory").text());

				} else {
					alert("暂无商品型号");
				}

			},
			error : function() {
				alert("失败！");
			}

		});

	}

    //去购物车
    function gotoShopping(){
    	window.location.href="<%=path%>/wxModelShoppingController/wxGetModelCartList.do";
    }
    //去商品了详情页面
    function  gotoModelDetail(mid){
    	window.location.href="<%=path%>/wxModel/wxmodelDetails.do?mid="+mid;
    }
    

	//去购物车
	function gotoShopping() {
		window.location.href = "/3dcreatia/wxModelShoppingController/wxGetModelCartList.do";
	}
	//去商品了详情页面
	function gotoModelDetail(mid) {
		window.location.href = "/3dcreatia/wxModel/wxmodelDetails.do?mid="
				+ mid;
	}

</script>
</html>
