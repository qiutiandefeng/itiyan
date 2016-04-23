<%@ page language="java" import="java.util.*,com.yfhl.entity.*"
	contentType="text/html; charset=UTF-8"%>
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
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>爱体验—支付</title>
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="<%=path%>/js/pay/qrcode.js"></script>
<script type="text/javascript" src="<%=path%>/js/wx/dizhixinxi.js"></script>
<script type="text/javascript" src="<%=path%>/js/wx/dizhixuanze.js"></script>
<script type="text/javascript" src="<%=path%>/js/wx/gongGong.js"></script>
<link href="<%=path%>/css/wx/dingdan.css" type="text/css"
	rel="stylesheet">
<link href="<%=path%>/css/wx/dizhixinxi.css" type="text/css"
	rel="stylesheet">
<link href="<%=path%>/css/wx/dizhixuanze.css" type="text/css"
	rel="stylesheet">

<!-- 微信 -->
<script type="text/javascript"
	src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>

<%
	String appid = (String) request.getAttribute("appId");
	String timestamp = (String) request.getAttribute("timestamp");
	String nonceStr = (String) request.getAttribute("nonceStr");
	String signature = (String) request.getAttribute("signature");
%>
<!-- 微信分享接口 -->
<script type="text/javascript">

//https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx66f9db2c0482ac07&redirect_uri=http://aishaimi.cn/campusambassador/users/share?uid=dbe22b1a-77e6-4f45-9872-f6e5248fdc17&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect
//      	var uurl = location.href.split('#')[0];
     	var appId = '<%=appid%>';
     	var url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appId+"&redirect_uri="+uurl+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
     	var timestamp = '<%=timestamp%>';
     	var nonceStr = '<%=nonceStr%>';
     	var signature = '<%=signature%>';
     	var imgUrl = '<%=path%>/images/pc/051.gif';
     	
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
<body onload="onProvinces(0)">
	<div class="divsss">
		<div class="div1s" id="div1s"></div>
		<div class="div2s">长按识别屏幕上的二维码，即可完成支付</div>
	</div>

	<input type="hidden" id="yfhl_user" value="${yfhl_user.uid}" />
	<input type="hidden" id="check" value="${check}"/>
	<input type="hidden" id="marker_pay" value="0"/>	
	<div class="dingDan">
		<!--
            	作者：offline
            	时间：2016-03-21
            	描述：第一页个人订单
            -->
		<!--
        	作者：offline
        	时间：2016-03-02
        	描述：第一块，地址
        -->
		<div class="top">
			<input type="hidden" id="userAddressId" value="${userAddress.id}" />
			<c:if test="${userAddress.id=='' || userAddress.id==null }">
				<div class="top_div1" onclick="showaddAddress()">
					<span>添加收获地址</span> <img src="<%=path%>/images/wx/022.gif" />
					<div class="clearBoth"></div>
				</div>
			</c:if>
			<c:if test="${userAddress.id!='' && userAddress.id!=null}">
				<div class="top_div2">
					<p class="top_div2_p1">收获地址</p>
					<div class="top_div2_div1">
						<div class="top_div2_div1_div1">
							<p class="top_div2_div1_div1_p1">
								<span class="top_div2_div1_div1_p1_sp1" id="addUsername">${userAddress.username}</span>
								<span class="top_div2_div1_div1_p1_sp2" id="addTel">${userAddress.telephone}</span>
							</p>
							<p class="top_div2_div1_div1_p2">
								<span>${userAddress.province}</span>-<span>${userAddress.city}</span>
								<span>${userAddress.address}</span>
							</p>
						</div>
					</div>
				</div>
			</c:if>
		</div>
		<div class="tenPx"></div>
		<!--
        	作者：offline
        	时间：2016-03-02
        	描述：第二块，商品信息
        -->
		<c:forEach var="item" items="${brandMap}" varStatus="i">
			<div class="content">
				<p class="content_p1">${item.key}</p>
				<c:forEach items="${item.value}" var="modelshopping" varStatus="j">
					<div class="content_div1">
						<img class="content_div1_img1"
							src="/upload/uploadImg/model/${modelshopping.msModelimg}" />
						<div class="content_div1_div1">
							<p class="content_div1_div1_p1">${modelshopping.msModelname}</p>
							<p class="content_div1_div1_p2">
								<span>${modelshopping.msModtexture}</span>/<span>${modelshopping.msModsize}</span>
							</p>
							<p class="content_div1_div1_p3">
								×<span>${modelshopping.msModcount}</span>
							</p>
						</div>
						<div class="content_div1_div2">
							￥<span>${modelshopping.countPrice}</span>
						</div>
						<div class="clearBoth"></div>
					</div>
					<input type="hidden" name="remark${i.index}"
						value="${modelshopping.msId}">
				</c:forEach>
				<input class="content_in1" type="text" placeholder="对设计师说："
					id="remark${i.index}" name="remark" />
			</div>
		</c:forEach>
		<div class="tenPx"></div>
		<!--
        	作者：offline
        	时间：2016-03-02
        	描述：第三块，信息，支付
        -->
		<div class="bottom">
			<p class="bottom_p1">
				<span class="bottom_p1_sp1">商品金额</span> <span class="bottom_p1_sp2">￥<span>${totalModelPrice}</span></span>
			</p>
			<p class="bottom_p2">
				<span class="bottom_p2_sp1">运费</span> <span class="bottom_p2_sp2">￥<span>${totaltransportPrice}</span></span>
			</p>
			<p class="bottom_p3">
				<span class="bottom_p3_sp1">您暂无可使用的优惠</span> <span
					class="bottom_p3_sp2"><img src="<%=path%>/images/wx/025.gif" /></span>

			</p>
			<p class="bottom_p4">
				<span class="bottom_p4_sp1">使用优惠</span> <img
					src="<%=path%>/images/wx/025.gif" /> <span class="bottom_p4_sp2"><span>0</span>张可使用</span>

			</p>
		</div>
		<div class="bottom_div1">
			<p class="bottom_div1_p1">实际支付金额</p>
			<p class="bottom_div1_p2">
				￥<span>${totalPrice}</span>
			</p>
		</div>
		<div class="bottom_div2">
			<button onclick="submitTrade()">微信支付</button>
		</div>
	</div>
	<!--
        	作者：offline
        	时间：2016-03-21
        	描述：第二页地址信息
        -->
	<div class="dizhiXinxi">

		<div class="div1">
			<input type="text" placeholder="收货人姓名" value="" id="username" />
		</div>
		<div class="div2">
			<input type="text" placeholder="收货人手机" value="" id="telephone" />
		</div>
		<div class="div3">
			<select id="frist" name="frist"
				onchange="onProvinces(1,'no','no','no',0,0)">
				<option>请选择省份</option>
			</select><select id="city" name="city"
				onchange="onProvinces(2,'no','no','no',0,0)">
				<option onclick="">请选择城市</option>
			</select> <select id="xian" name="xian">
				<option>请选择县/区</option>
			</select>
		</div>
		<div class="div4">
			<input type="text" placeholder="详细街道地址" value="" id="address" />
		</div>
		<div class="div5">
			<div class="div5_div1">
				<input type="hidden" id="addressid" value="" /> <img
					class="div5_img1" src="<%=path%>/images/wx/026.gif" id="nodefault" />
				<img class="div5_img2" src="<%=path%>/images/wx/027.gif"
					id="isdefault" /> 设为默认地址
			</div>
		</div>
		<button class="but1" onclick="userAddressManage()">保存并使用</button>
	</div>

	<!--
        	作者：offline
        	时间：2016-03-21
        	描述：地址选择第三页
        -->
	<div class="dizhiXuanze">
		<c:forEach items="${userAddressList}" var="address">
			<div class="xuanze xuanze1">
				<div class="xuanze_div1">
					<div class="xuanze_div1_div1">
						<span class="xuanze_div1_div1_sp1">${address.username}</span> <span
							class="xuanze_div1_div1_sp2">${address.telephone}</span>
					</div>
					<div class="xuanze_div1_div2">
						<span class="xuanze_div1_div2_sp1"> <c:if
								test="${address.isDefault==1}">
						【默认】</c:if></span> <span>${address.address} </span>
					</div>
				</div>
				<div class="xuanze_div2">
					<img class="xuanze_div2_img1" src="<%=path %>/images/wx/051.gif"
						onclick="setDefault('${address.id}')" />
				</div>
				<div class="xuanze_div3">
					<img class="xuanze_div3_img1" src="<%=path%>/images/wx/045.gif" />
					<img src="<%=path %>/images/wx/028.gif"
						onclick="showuptAddress('${address.id}','${address.username}','${address.telephone}','${address.province}','${address.city}','${address.addressArea}','${address.address}','${address.zipcode}','${address.isDefault}','${address.provinceId}','${address.cityId}')" />
				</div>
				<div class="shanchu" onclick="delAddress('${address.id}')">删除</div>
			</div>
		</c:forEach>

		<div class="xuanze_bottom" onclick="showaddAddress()">添加新地址</div>
		<input type="hidden" id="markManage" value="" />
	</div>



</body>
<script type="text/javascript">
	//删除地址
	function delAddress(id){
		if(confirm("是否确定删除地址？"))
		{
			$.ajax({
	             type: "POST",
	             url: "<%=path%>/wxuserAddressController/wxdelUserAddress.do",
	             data: {id:id},
	             dataType: "json",
	             success: function(data){
	            	 if (data != 0){
	                  	 //在这里刷新当前页面吗？
	                     //window.location.reload();
	                  	 //重新加载页面
	                  	 
	            	 }
	             }
			});
		}
	}
	//返回购物车
	function toback(){
		window.location.href="<%=path%>/modelShopping/cartList.do";
	}
	//提交订单
	function submitTrade() {
		var marker_pay=$("#marker_pay").val();
		if(marker_pay!="0"){
			//alert("您的订单已经生成成功！");
			window.location.href="/3dcreatia/wxtrade/wxtradeList.do";
			return false;
		}
		//1.判断是否已经登录
		var uid = $("#yfhl_user").val();
		 
		//2、判断是否选择收货地址
		var address = $("#userAddressId").val();//收货地址ID
		if (address == '') {
			alert("请选择收货地址！");
			return false;
		}
		//3、获取订单信息
		var remarkArray = document.getElementsByName("remark");//获取订单备注信息
		var value = "";
		var msids = "";
		var submit_views = "";
		for (var i = 0; i < remarkArray.length; i++) {
			value = remarkArray[i].value;
			if (value == "") {
				value = "val_null";
			}
			var shoppingArray = document.getElementsByName(remarkArray[i].id);//获取订单下的购物车ID
			for (var j = 0; j < shoppingArray.length; j++) {
				msids = shoppingArray[j].value + ";" + msids;
			}
			submit_views = value + ";" + msids + ";" + submit_views;
			msids = "";
		}
		submit_views = submit_views.substring(0, submit_views.length - 2);
		//提交
		$.ajax({
	             type: "POST",
	             url: "<%=path%>/wxtrade/wxAddTrades.do",
	             data: {
	            	 uid : uid,
	            	 submit_views : submit_views,
	            	 addressid : address
	             },
	             dataType: "json",
	             success: function(data){
	            	 //alert(data+"---");
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
 			    		$("#marker_pay").val("1");

	             }
	         });
		 
	}
	function tanchus(){
		$(".divsss").css({"display":"block"});
	}

	//设置添加收货地址页面信息
	function showaddAddress(){
		$("#markManage").val("1");//设置标记操作类型:添加
		//设置显示添加页面
		$(".dingDan").css({"display":"none"});
		$(".dizhiXinxi").css({"display":"block"});
		$(".dizhiXuanze").css({"display":"none"});
		//清空数据
		$("#addressid").val("");
		$("#username").val("");
		$("#telephone").val("");
		$("#address").val("");
		$(".div5_img1").css({"display":"display"});
		$(".div5_img2").css({"display":"none"});
		$("#frist").html(" ");
		$("#city").html(" ");
		$("#xian").html(" ");
		$("#frist").append("<option>请选择省份</option>");
		$("#city").append("<option>请选择城市</option>");
		$("#xian").append("<option>请选择县/区</option>");
		onProvinces(0,'no','no','no',0,0);//初始化province信息
		}
	//设置修改收货地址页面信息
	function showuptAddress(id,name,tel,province,city,area,address,zipcode,isDefault,provinceid,cityid){
		$("#markManage").val("2");//设置标记操作类型：修改
		$(".shouhuo_motai").css({"display":"block"});
		//设置显示修改页面
		$(".dingDan").css({"display":"none"});
		$(".dizhiXinxi").css({"display":"block"});
		$(".dizhiXuanze").css({"display":"none"});
		$("#addressid").val(id);
		$("#username").val(name);
		$("#telephone").val(tel);
		$("#address").val(address);	
		$("#zipcode").val(zipcode);
		$("#defaultText").val(isDefault);
		if(isDefault==0){
			$(".div5_img1").css({"display":"dispaly"});
			$(".div5_img2").css({"display":"none"});
		}else if(isDefault==1){
			$(".div5_img1").css({"display":"none"});
			$(".div5_img2").css({"display":"dispaly"});
		}
		onProvinces(0,province,city,area,0,0);//初始化province信息
		onProvinces(1,province,city,area,1,provinceid);//初始化city信息
		onProvinces(2,province,city,area,1,cityid);//初始化area信息
	}
	//修改、添加收货地址信息
	function userAddressManage(){
		var uid=$("#yfhl_user").val();
		var id = $("#addressid").val();//收货地址ID
		var username = $("#username").val();//收货人姓名
		if (username == null || username == '') {
			//alert("收货人姓名不能为空！");
			$(".shouhuo_motai_div1_div1_sp2").css({
				"color" : "#f00"
			});
			return false;
		} else {
			$(".shouhuo_motai_div1_div1_sp2").css({
				"color" : "#aaa"
			});
		}
		var province = $("#frist").find("option:selected").text();//省份
		var provinceid = $("#frist").find("option:selected").val();//省份id
		var city = $("#city").find("option:selected").text();//城市
		var cityid = $("#city").find("option:selected").val();//城市id
		var addressArea = $("#xian").find("option:selected").text();//区
		var addressAreaid = $("#xian").find("option:selected").val();//区id
		var address = $("#address").val();//地址
		if (province == '请选择省份' || city == '请选择城市' || addressArea == '请选择县/区'
				|| address == '') {
			//alert("收货人详细地址不能为空！");
			$(".shouhuo_motai_div1_div2_sp2").css({
				"color" : "#f00"
			});
			return false;
		} else {
			$(".shouhuo_motai_div1_div2_sp2").css({
				"color" : "#aaa"
			});
		}
		var telephone = $("#telephone").val();//电话
		if (telephone == null || telephone == '') {
			//alert("收货人电话不能为空！");
			$(".shouhuo_motai_div1_div3_sp2").css({
				"color" : "#f00"
			});
			return false;
		} else if (isNaN(telephone)) {
			//alert("对不起，手机号只能为数字！");
			$(".shouhuo_motai_div1_div3_sp2").css({
				"color" : "#f00"
			});
			return false;
		} else {
			$(".shouhuo_motai_div1_div3_sp2").css({
				"color" : "#aaa"
			});
		}
		var isDefault = 1;//设置为默认地址
		//if($("#isdefault").css('display')=='block'){
		//	isDefault=1;
		//}
		var type = $("#markManage").val();//标记是添加还是修改：1添加，2修改

		$.ajax({
			type : "post",
			url : "/3dcreatia/wxuserAddressController/wxupdateUserAddress.do",
			data : {
				id : id,
				uid : uid,
				username : username,
				telephone : telephone,
				province : province,
				city : city,
				address : address,
				addressArea : addressArea,
				isDefault : isDefault,
				provinceId : provinceid,
				cityId : cityid,
				addressAreaid : addressAreaid,
				markManage : type
			},
			dataType : 'text',
			success : function(result) {
				if (result == 1) {
					//重新加载订单信息
					onloadpage();
				}

			},
			error : function() {
				alert("bug");
			}

		});

	}
	//设置为默认地址
	function setDefault(id) {
		var uid = $("#yfhl_user").val();
		$.ajax({
			type : "post",
			url : "/3dcreatia/wxuserAddressController/wxsetDefault.do",
			data : {
				id : id,
				uid : uid
			},
			dataType : 'text',
			success : function(result) {
				if (result == 1) {
					
					//重新加载订单信息
					onloadpage();
				}
			},
			error : function() {
				alert("bug");
			}

		});
	}

	//设置省份地址联动菜单:type:1:修改信息初始化
	function onProvinces(sid, province, city, area, type, markid) {
		var parentId = 0;
		if (type == 0) {
			if (sid == 1) {
				parentId = $("#frist").val();
			}
			if (sid == 2) {
				parentId = $("#city").val();
			}
		} else if (type == 1) {
			parentId = markid;
		}
		$.ajax({
			type : "POST",
			url : "/3dcreatia/userAddressController/getParAddress.do",
			data : {
				parentId : parentId
			},
			dataType : "json",
			success : function(data) {

				if (data.state == "0") {

				} else if (data.state == "1")//  
				{
					if (sid == 1) {
						parentId = $("#frist").val();
						$("#city").html(" ");
						$("#xian").html(" ");
						$("#city").append("<option>请选择城市</option>");
						$("#xian").append("<option>请选择县/区</option>");
					}
					if (sid == 2) {
						parentId = $("#city").val();
						$("#xian").html(" ");
						$("#xian").append("<option>请选择县/区</option>");
					}
					for (var i = 0; i < data.body.length; i++) {
						if (sid == 0 && province == data.body[i].areaname) {
							$("#frist").append(
									'<option value="'+data.body[i].id+' " selected="selected">'
											+ data.body[i].areaname
											+ '</option>');
						} else if (sid == 0
								&& province != data.body[i].areaname) {
							$("#frist").append(
									"<option value='"+data.body[i].id+"'>"
											+ data.body[i].areaname
											+ "</option>");
						} else if (sid == 1 && city == data.body[i].areaname) {//二级城市变量
							$("#city").append(
									"<option value='"+data.body[i].id+"' selected='selected'>"
											+ data.body[i].areaname
											+ "</option>");
						} else if (sid == 1 && city != data.body[i].areaname) {//二级城市变量
							$("#city").append(
									"<option value='"+data.body[i].id+"'>"
											+ data.body[i].areaname
											+ "</option>");
						} else if (sid == 2 && area == data.body[i].areaname) {
							$("#xian").append(
									"<option value='"+data.body[i].id+"' selected='selected'>"
											+ data.body[i].areaname
											+ "</option>");
						} else if (sid == 2 && area != data.body[i].areaname) {
							$("#xian").append(
									"<option value='"+data.body[i].id+"'>"
											+ data.body[i].areaname
											+ "</option>");
						}
					}

				}
			}
		});
	}
   //重新加载页面
   function onloadpage(){
	   var check =$("#check").val();
		var uid = $("#yfhl_user").val();
	    document.write('<form action="<%=path%>/wxModelShoppingController/wxSettleCountByShopping.do" method="post" name="formx1" style="display:none">');
		document.write('<input type="hidden" name="check" value="'+check+'"/>');
		document.write('<input type="hidden" name="uid" value="'+uid+'"/>');
		document.write("</form>");
		document.formx1.submit();
	}
</script>
</html>
