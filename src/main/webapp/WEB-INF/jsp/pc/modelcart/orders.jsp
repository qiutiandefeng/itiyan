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
<link href="<%=request.getContextPath()%>/images/pc/logo2.png"
	type="image/x-icon" rel="shortcut icon" />
<meta charset="utf-8">
<title>爱体验网-确认订单</title>
<link rel="stylesheet" href="<%=path%>/css/pc/Common_style.css" />
<link rel="stylesheet" href="<%=path%>/css/cartcss/orders.css" />
<link href="<%=request.getContextPath()%>/css/motaichuang.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="<%=path%>/js/cart/orders.js"></script>

</head>
<body onload="onProvinces(0)">
	<input type="hidden" id="yfhl_user" value="${yfhl_user.uid}" />
	<div>
		<!--hander -->
		<c:set value="${model.condition}" var="condition"></c:set>
		<%@include file="../partpage/hander.jsp"%>
	</div>
	<div class="nav_bottom"></div>
	<!--
        	作者：offline
        	时间：2015-12-22
        	描述：填写订单
        -->
	<div class="orders">
		<p class="orders_p1">
			<a href="#">首页</a> > <a href="#">产品</a> > <a href="#">填写订单</a>
		</p>
		<div class="orders_div1">
			<p class="orders_div1_p1">填写订单</p>
			<p class="orders_div1_p2">fill orders</p>
			<div class="orders_div1_div1">
				<img src="<%=path%>/images/pc/cart/026.gif" />
			</div>
			<ul class="orders_div1_ul1">
				<li class="orders_div1_ul1_li1">查看购物车</li>
				<li class="orders_div1_ul1_li2">填写订单</li>
				<li class="orders_div1_ul1_li3">付款，完成购买</li>
			</ul>
		</div>
		<p class="orders_p2">【请确认收货地址】</p>
		<div class="orders_div2">
			<input type="hidden" id="useraddressid" value="" />
			<c:forEach items="${userAddressList}" var="address" varStatus="i">
				<c:if test="${address.isDefault == 1}">
					<ul class="orders_div2_ul1">
						<li class="orders_div2_ul1_li1"
							onclick="selectAddress('${address.id}','${address.username}','${address.telephone}','${address.province}${address.city}${address.addressArea}${address.address}')"><img
							class="orders_div2_ul1_li1_img1" src="../images/pc/cart/084.gif" />
							<img class="orders_div2_ul1_li1_img2"
							src="<%=request.getContextPath()%>/images/pc/cart/085.gif" /> <span>${address.username}</span></li>
						<li class="orders_div2_ul1_li2">${address.telephone}</li>
						<li class="orders_div2_ul1_li3">${address.province}${address.city}${address.addressArea}${address.address}</li>
						<li class="orders_div2_ul1_li4"><a
							class="orders_div2_ul1_li4_a1" href="#"
							onclick="onDefAddress(${address.id},${address.uid})">默认地址</a></li>
						<li class="orders_div2_ul1_li5 right"><a
							class="orders_div2_ul1_li5_a1 left" href="#"
							onClick="showuptAddress('${address.id}','${address.username}','${address.telephone}','${address.province}','${address.city}','${address.addressArea}','${address.address}','${address.zipcode}','${address.isDefault}','${address.provinceId}','${address.cityId}')">[修改]</a><a
							class="right" href="#" onClick="onDelAddress(${address.id})">[删除]</a></li>
					</ul>

				</c:if>
			</c:forEach>
			<c:forEach items="${userAddressList}" var="address" varStatus="i">
				<c:if test="${address.isDefault == 0}">
					<ul class="orders_div2_ul1">
						<li class="orders_div2_ul1_li1"
							onclick="selectAddress('${address.id}','${address.username}','${address.telephone}','${address.province}${address.city}${address.addressArea}${address.address}')"><img
							class="orders_div2_ul1_li1_img1" src="../images/pc/cart/084.gif" />
							<img class="orders_div2_ul1_li1_img2"
							src="<%=request.getContextPath()%>/images/pc/cart/085.gif" /> <span>${address.username}</span></li>
						<li class="orders_div2_ul1_li2">${address.telephone}</li>
						<li class="orders_div2_ul1_li3">${address.province}${address.city}${address.addressArea}${address.address}</li>
						<li class="orders_div2_ul1_li4"><a
							class="orders_div2_ul1_li4_a1" href="#"
							onclick="onDefAddress(${address.id},${address.uid})"> 设为默认地址
						</a></li>
						<li class="orders_div2_ul1_li5 right"><a
							class="orders_div2_ul1_li5_a1 left" href="#"
							onClick="showuptAddress('${address.id}','${address.username}','${address.telephone}','${address.province}','${address.city}','${address.addressArea}','${address.address}','${address.zipcode}','${address.isDefault}','${address.provinceId}','${address.cityId}')">[修改]</a><a
							class="right" href="#" onClick="onDelAddress(${address.id})">[删除]</a></li>
					</ul>
					</c:if>
			</c:forEach>
			
		</div>
		<a href="#" class="orders_btn1" onclick="showaddAddress()">添加新地址</a>
		<p class="orders_p3">【请填写订单信息】</p>
		<ul class="orders_ul1">
			<li class="orders_ul1_li1">商品信息</li>
			<li class="orders_ul1_li2">单价(元)</li>
			<li class="orders_ul1_li3">数量</li>
			<li class="orders_ul1_li4">优惠活动</li>
			<li class="orders_ul1_li5">小计(元)</li>
		</ul>
		<div class="orders_div4" id="divBrand">
			<c:forEach var="item" items="${brandMap}" varStatus="i">
				<div id="trade_${i.count}">
					<p class="orders_div4_p1">
						<a href="#" id="brandId">${item.key}</a>
					</p>
					<c:forEach items="${item.value}" var="modelshopping" varStatus="j">
						<div class="orders_div4_div1">
							<div class="orders_div4_div1_div1">
								<div class="orders_div4_div1_div1_div1 left">
									<a href="#"><img class="left"
										src="<%=request.getContextPath()%>/upload/uploadImg/model/${modelshopping.msModelimg}" /></a>
									<div class="left">
										<p class="orders_div4_div1_div1_div1_div1_p1">
											<a href="#">${modelshopping.msModelname}</a>
										</p>
										<p class="content1">材质:${modelshopping.msModtexture}</p>
										<p class="content1">尺寸:${modelshopping.msModsize}</p>
									</div>
								</div>
								<div class="orders_div4_div1_div1_div2 left">
									￥<span>${modelshopping.msModprice}</span>
								</div>
								<div class="orders_div4_div1_div1_div3 left">
									<button class="orders_div4_div1_div1_div3_btn1"
										onclick="onChange(${modelshopping.msId},1,'${modelshopping.msModprice}','count${i.index}${j.index}','pricecount${i.index}${j.index}','brandcount${i.index}')">-</button>
									<span class="orders_div4_div1_div1_div3_sp1"
										id="count${i.index}${j.index}">${modelshopping.msModcount}</span>
									<button class="orders_div4_div1_div1_div3_btn2"
										onclick="onChange(${modelshopping.msId},2,'${modelshopping.msModprice}','count${i.index}${j.index}','pricecount${i.index}${j.index}','brandcount${i.index}')">+</button>
								</div>
								<div class="orders_div4_div1_div1_div4 left">无</div>
								<div class="orders_div4_div1_div1_div5 left">
									￥<span id="pricecount${i.index}${j.index}">${modelshopping.countPrice}</span>
								</div>
							</div>
							<input type="hidden" name="remark${i.index}"
								value="${modelshopping.msId}">
							<c:if test="${j.index+1==item.value.size()}">
								<div class="orders_div4_div1_div2">
									<div class="orders_div4_div1_div2_div1 left">
										备注：<input class="orders_div4_div1_div2_div1_in1" type="text"
											id="remark${i.index}" name="remark" maxlength="50" value="" /><span
											class="orders_div4_div1_div2_div1_sp1">剩余字数<span
											class="orders_div4_div1_div2_div1_sp1_sp1">50</span></span>
									</div>
									<div class="orders_div4_div1_div2_div2 left">
										<p class="orders_div4_div1_div2_div2_p1">
											品牌总价：<span>￥<span id="brandcount${i.index}">${priceList.get(item.key)}</span></span>
										</p>
										<p class="orders_div4_div1_div2_div2_p2">
											运费：+￥<span>${transportPriceList.get(item.key)}</span>
										</p>
									</div>
								</div>
							</c:if>
						</div>
					</c:forEach>

				</div>
			</c:forEach>
		</div>
		<!--
            	作者：offline
            	时间：2016-01-20
            	描述：优惠券
            -->
		<!-- 
		<div class="orders_div7">
			<p class="orders_div7_p1">
				【您有<span>1</span>张代金券可用】
			</p>
			<div class="orders_div7_div1">
				<span class="orders_div7_div1_sp1">使用代金券</span> <a
					class="orders_div7_div1_a1" href="###">请选择></a>
				<div class="orders_div7_div1_div1">
					<div class="orders_div7_div1_div1_div1">
						<img class="left" src="img/110.gif" />
						<div class="orders_div7_div1_div1_div1_div1 left">
							<p>满300减50元</p>
							<p>2015.12.16-2016.12.12</p>
						</div>
						<a class="orders_div7_div1_div1_div1_a1 right" href="###">使用</a>
					</div>
					<div class="orders_div7_div1_div1_div1">
						<img class="left" src="img/110.gif" />
						<div class="orders_div7_div1_div1_div1_div1 left">
							<p>满300减50元</p>
							<p>2015.12.16-2016.12.12</p>
						</div>
						<a class="orders_div7_div1_div1_div1_a1 right" href="###">使用</a>
					</div>
					<div class="orders_div7_div1_div1_div1">
						<img class="left" src="img/110.gif" />
						<div class="orders_div7_div1_div1_div1_div1 left">
							<p>满300减50元</p>
							<p>2015.12.16-2016.12.12</p>
						</div>
						<a class="orders_div7_div1_div1_div1_a1 right" href="###">使用</a>
					</div>
					<div class="orders_div7_div1_div1_div1">
						<img class="left" src="img/110.gif" />
						<div class="orders_div7_div1_div1_div1_div1 left">
							<p>满300减50元</p>
							<p>2015.12.16-2016.12.12</p>
						</div>
						<a class="orders_div7_div1_div1_div1_a1 right" href="###">使用</a>
					</div>
				</div>
			</div>
		</div>
		 -->
		<div class="orders_div5">
			<div class="orders_div5_left left">
				<p class="orders_div5_left_p1">
					运费：<span id="transport">${totaltransportPrice}</span>
				</p>
				<p class="orders_div5_left_p2">
					您需要实际支付金额：<span>￥<span id="totalPrice">${totalPrice}</span></span>元
				</p>
				<p class="orders_div5_left_p3">
					寄送至：<span id="spAddress"></span>
				</p>
				<p class="orders_div5_left_p4">
					收货人：<span id="spName"></span>
				</p>
				<p class="orders_div5_left_p5">
					电话号：<span id="spTelephone"></span>
				</p>

			</div>
			<div class="orders_div5_right left">
				<a href="#" onclick="submitTrade()">提交订单</a>
			</div>
		</div>
		<div class="orders_div6"></div>
		<p class="orders_p4">
			<a href="#" onclick="toback()">返回购物车></a>
		</p>
	</div>
	<!--
        	作者：offline
        	时间：2015-12-29
        	描述：模态窗口——修改地址
        -->
	<div class="shouhuo_motai"></div>
	<div class="shouhuo_motai_waitao">
		<div class="shouhuo_motai_div1">
			<div class="shouhuo_motai_div1_div1">
				<span class="shouhuo_motai_div1_div1_sp1">收货人姓名</span> <input
					class="shouhuo_motai_div1_div1_in1" type="text" id="username"
					value="" /> <span class="shouhuo_motai_div1_div1_sp2">请填写您的真实姓名</span>
			</div>
			<div class="shouhuo_motai_div1_div2">
				<span class="shouhuo_motai_div1_div2_sp1">省份</span> <select
					class="shouhuo_motai_div1_div2_se1" id="frist" name="frist"
					onchange="onProvinces(1,'no','no','no',0,0)">
					<option>请选择省份</option>

				</select> <select class="shouhuo_motai_div1_div2_se2" id="city" name="city"
					onchange="onProvinces(2,'no','no','no',0,0)">
					<option onclick="">请选择城市</option>

				</select> <select class="shouhuo_motai_div1_div2_se3" id="xian" name="xian">
					<option>请选择县/区</option>

				</select> <input class="shouhuo_motai_div1_div2_in1" type="text" id="address"
					value="" /> <span class="shouhuo_motai_div1_div2_sp2">请填写您的详细地址</span>
			</div>
			<div class="shouhuo_motai_div1_div3">
				<span class="shouhuo_motai_div1_div3_sp1">手机号码</span> <input
					class="shouhuo_motai_div1_div3_in1" type="text" id="telephone"
					value="" /> <span class="shouhuo_motai_div1_div3_sp2">填写正确手机号便于接收发货和收货通知</span>
			</div>
			<div class="shouhuo_motai_div1_div4">
				<span class="shouhuo_motai_div1_div4_sp1">邮编</span> <input
					class="shouhuo_motai_div1_div4_in1" type="text" id="zipcode"
					value="" />
			</div>
			<div class="shouhuo_motai_div1_div5">
				<input class="shouhuo_motai_div1_div5_in1" type="checkbox"
					id="isDefault" onclick="setDefaulttext()" /> <input type="hidden"
					id="defaultText" value="" /> <input type="hidden" id="addressid"
					value="" /> <span class="shouhuo_motai_div1_div5_sp1">设为默认地址</span>
			</div>
			<a href="#" class="shouhuo_motai_div1_btn1"
				onclick="userAddressManage()">保存</a> <img
				class="shouhuo_motai_div1_img1"
				src="<%=request.getContextPath()%>/images/pc/039.gif" /> <input
				type="hidden" id="markManage" value="" />
		</div>
	</div>
	<div>
		<!--bottom -->
		<%@include file="../partpage/bottom.jsp"%>
	</div>
	<div class="logincalss">
		<!--login -->
		<%@include file="../partpage/login.jsp"%>
	</div>
</body>
<script type="text/javascript">
    //选择收货地址
    function selectAddress(addressid,username,tel,address){
    	$("#spAddress").text(address);
    	$("#spName").text(username);
    	$("#spTelephone").text(tel);
    	
    	$("#useraddressid").val(addressid);
    }
	//设置默认地址
	function onDefAddress(id,uid){
		$.ajax({
	        type: "POST",
	        url: "<%=path%>/userAddressController/setDefault.do",
	        data: {id:id,uid:uid},
	        dataType: "json",
	        success: function(data){
	        	if (data != 0){
	        		alert("设置默认地址成功");
	        		//在这里刷新当前页面吗？
	                window.location.reload();
	        	}
	        }
		});
	}
	//设置是否是默认地址
	function setDefaulttext(){
		var isDefault=Number($("#defaultText").val());
		if(isDefault==0){
			$("#defaultText").val('1');
		}else if(isDefault==1){
			$("#defaultText").val('0');
		}
	}
	//删除地址
	function onDelAddress(id){
		if(confirm("是否确定删除地址？"))
		{
			$.ajax({
	             type: "POST",
	             url: "<%=path%>/userAddressController/delUserAddress.do",
	             data: {id:id},
	             dataType: "json",
	             success: function(data){
	            	 if (data != 0){
	            		 alert("删除成功！");
	                  	 //在这里刷新当前页面吗？
	                     window.location.reload();
	            	 }
	             }
			});
		}
	}
	//修改、添加收货地址信息
	function userAddressManage(){
		var uid=$("#yfhl_user").val();
		if(uid==""){
			if(window.confirm("用户登录失效，请点击确认重新登录！")){
				window.location.href="<%=path%>/login/gotoIndexPC.do";
			}
		}
	 
		var id=$("#addressid").val();//收货地址ID
		var username=$("#username").val();//收货人姓名
		if(username==null || username==''){
			//alert("收货人姓名不能为空！");
			$(".shouhuo_motai_div1_div1_sp2").css({"color":"#f00"});
			return false;
		}else{
			$(".shouhuo_motai_div1_div1_sp2").css({"color":"#aaa"});
		}
		var province=$("#frist").find("option:selected").text();//省份
		var provinceid=$("#frist").find("option:selected").val();//省份id
		var city=$("#city").find("option:selected").text();//城市
		var cityid=$("#city").find("option:selected").val();//城市id
		var addressArea=$("#xian").find("option:selected").text();//区
		var addressAreaid=$("#xian").find("option:selected").val();//区id
		var address=$("#address").val();//地址
		if(province=='请选择省份' || city=='请选择城市'  || addressArea=='请选择县/区' || address==''){
			//alert("收货人详细地址不能为空！");
			$(".shouhuo_motai_div1_div2_sp2").css({"color":"#f00"});
			return false;
		}else {
			$(".shouhuo_motai_div1_div2_sp2").css({"color":"#aaa"});
		}
		var telephone=$("#telephone").val();//电话
		if(telephone==null || telephone==''){
			//alert("收货人电话不能为空！");
			$(".shouhuo_motai_div1_div3_sp2").css({"color":"#f00"});
			return false;
		}else if (isNaN(telephone)) {
			//alert("对不起，手机号只能为数字！");
			$(".shouhuo_motai_div1_div3_sp2").css({"color":"#f00"});
			return false;
		}else{
			$(".shouhuo_motai_div1_div3_sp2").css({"color":"#aaa"});
		}
		var zipcode=$("#zipcode").val();//邮编
		var isDefault=$("#defaultText").val();//是否为默认地址
		var type=$("#markManage").val();//标记是添加还是修改：1添加，2修改
		 
		 $.ajax({
				type:"post",
				url:"<%=request.getContextPath()%>/userAddressController/updateUserAddress.do",
						data : {
							id : id,
							uid : uid,
							username : username,
							telephone : telephone,
							zipcode : zipcode,
							province : province,
							city : city,
							address : address,
							addressArea : addressArea,
							isDefault : isDefault,
							provinceId : provinceid,
							cityId : cityid,
							addressAreaid : addressAreaid,
							markManage :type
						},
						dataType : 'text',
						success : function(result) {
							if(result==1){
								$(".shouhuo_motai").css({"display":"none"});
								$(".shouhuo_motai_div1").css({"display":"none"});
								location.reload();
							}
	
						},
						error : function() {
							alert("bug");
						}
	
					});
	
		}
	//显示添加收货地址模态框
	function showaddAddress(){
		$("#markManage").val("1");//设置标记操作类型:添加
		//显示模态框
		$(".shouhuo_motai").css({"display":"block"});
		$(".shouhuo_motai_div1").css({"display":"block"});
		//清空数据
		$("#addressid").val("");
		$("#username").val("");
		$("#telephone").val("");
		$("#address").val("");
		$("#zipcode").val("");
		$("#defaultText").val(0);
		document.getElementById("isDefault").checked=false;
		$("#frist").html(" ");
		$("#city").html(" ");
		$("#xian").html(" ");
		$("#frist").append("<option>请选择省份</option>");
		$("#city").append("<option>请选择城市</option>");
		$("#xian").append("<option>请选择县/区</option>");
		onProvinces(0,'no','no','no',0,0);//初始化province信息
		}
	//显示修改收货地址模态框
	function showuptAddress(id,name,tel,province,city,area,address,zipcode,isDefault,provinceid,cityid){
		$("#markManage").val("2");//设置标记操作类型：修改
		$(".shouhuo_motai").css({"display":"block"});
		$(".shouhuo_motai_div1").css({"display":"block"});
		$("#addressid").val(id);
		$("#username").val(name);
		$("#telephone").val(tel);
		$("#address").val(address);
		$("#zipcode").val(zipcode);
		$("#defaultText").val(isDefault);
		if(isDefault==0){
			document.getElementById("isDefault").checked=false;
		}else if(isDefault==1){
			document.getElementById("isDefault").checked=true;
		}
		onProvinces(0,province,city,area,0,0);//初始化province信息
		onProvinces(1,province,city,area,1,provinceid);//初始化city信息
		onProvinces(2,province,city,area,1,cityid);//初始化area信息
	}	
	//设置省份地址联动菜单:type:1:修改信息初始化
	function onProvinces(sid,province,city,area,type,markid){
				var parentId = 0;
				if(type==0){
					if (sid == 1){
						parentId = $("#frist").val();
					}
					if (sid == 2){
						parentId = $("#city").val();
					}
				}else if(type==1){
					parentId=markid;
				}
				$.ajax({
		             type: "POST",
		             url: "<%=path%>/userAddressController/getParAddress.do",
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
	//商品点击+/—
	function onChange(msid,type,price,count,pricecountid,brandcountid){
		var countNum=Number($("#"+count).text());
		if (type == 1){
			countNum=countNum-1;
		}else {
			countNum=countNum+1;
		}
		if(countNum<1){
			countNum=1;
			return false;
		}
		 $.ajax({
		     type: "POST",
		     url: "<%=path%>/modelShopping/cartChange.do",
		     data: {msId:msid,marker_count:type,msModcount:countNum},
		     dataType: "json",
		     success: function(data){
		         if(data.state=="0"){  
		             alert(data.value);  
		         }else if(data.state=="1" && data.body[0]=="1")//  
		         {  
		        	 $("#"+count).text(countNum);//数量
		        	 if(type==1){
		        		 $("#"+pricecountid).text((Number($("#"+pricecountid).text())-Number(price)).toFixed(2));//商品总价格
		        		 $("#"+brandcountid).text((Number($("#"+brandcountid).text())-Number(price)).toFixed(2));//订单价格
		        		 $("#totalPrice").text((Number($("#totalPrice").text())-Number(price)).toFixed(2));//总价格 
		        	 }else if(type==2){
		        		 $("#"+pricecountid).text((Number($("#"+pricecountid).text())+Number(price)).toFixed(2));//商品总价格
		        		 $("#"+brandcountid).text((Number($("#"+brandcountid).text())+Number(price)).toFixed(2));//订单价格
		        		 $("#totalPrice").text((Number($("#totalPrice").text())+Number(price)).toFixed(2));//总价格 
		        	 }
		         } 
		     }
		 });
	
	}
	//返回购物车
	function toback(){
	 
		window.location.href="<%=path%>/modelShopping/cartList.do";
	}
	//提交订单
	function submitTrade(){
		//1.判断是否已经登录
		 var uid=$("#yfhl_user").val();
		  if(uid=="" || uid==null){
			  gotoLogin();//去登陆页面
		    return false;
		    }
		//2、判断是否选择收货地址
		var address=$("#useraddressid").val();//收货地址ID
		if (address == ''){
			alert("请选择收货地址！");
			return false;
		}
		//2、获取订单信息
		var remarkArray=document.getElementsByName("remark");//获取订单备注信息
		var value="";
		var msids="";
		var submit_views="";
		for(var i=0;i<remarkArray.length;i++){
			value=remarkArray[i].value;
			if(value==""){
				value="val_null";
			}
			var shoppingArray=document.getElementsByName(remarkArray[i].id);//获取订单下的购物车ID
			for(var j=0;j<shoppingArray.length;j++){
				msids=shoppingArray[j].value+";"+msids;
			}
			submit_views=value+";"+ msids+";"+ submit_views;
			msids="";
		}
		submit_views=submit_views.substring(0,submit_views.length-2);
		//提交
		document.write('<form action="<%=request.getContextPath()%>/tradeManage/addTrades.do" method="post" name="formx1" style="display:none">');
		document.write('<input type="hidden" name="uid" value="'+uid+'"/>');
		document.write('<input type="hidden" name="submit_views" value="'+submit_views+'"/>');
		document.write('<input type="hidden" name="addressid" value="'+address+'"/>');
		document.write("</form>");
		document.formx1.submit();
	}
	 
	//去登录页面
	function gotoLogin(){
		window.location.href="<%=path%>/login/gotoIndexPC.do";
	}
	 
	
</script>
</html>
