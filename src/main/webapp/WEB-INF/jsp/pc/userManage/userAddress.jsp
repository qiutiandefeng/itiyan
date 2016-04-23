<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/zhanghu_shouhuo.js"></script>
<link href="<%=request.getContextPath()%>/css/pc/Common_style.css"
	type="text/css" rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/css/gonggong_gerenzhongxin.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/zhanghu_shouhuo.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/motaichuang.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/images/pc/logo2.png" type="image/x-icon"
	rel="shortcut icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的爱体验-收货地址</title>

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
        	时间：2015-12-28
        	描述：交易——收藏
        -->
	<p class="shoucang_p">
		<a href="#">首页</a> > <a href="#">个人中心</a> > <a href="#">账户中心</a> > <a
			href="<%=path%>/userAddressController/queryUserAddress.do">收货地址</a>
	</p>
	<div class="shoucang">
		<div class="shoucang_left left">
			<div class="shoucang_left_div1">
				<div class="shoucang_left_div1_div1 left">
					<c:if test="${yfhl_user.avatar=='' || yfhl_user.avatar=='null'}">
						<img src="<%=request.getContextPath()%>/images/pc/defalut_useravator.png" />
					</c:if>
					<c:if test="${yfhl_user.avatar!='' && yfhl_user.avatar!='null'}">
						<img src="<%=request.getContextPath()%>/upload/uploadImg/user/${yfhl_user.avatar}" />
					</c:if>
				</div>
				<div class="shoucang_left_div1_div2 left">
					<p class="shoucang_left_div1_div2_p1">${yfhl_user.username}</p>
					<p class="shoucang_left_div1_div2_p2">
						<a href="<%=path%>/userManage/gotoUserManagePC.do">编辑个人信息</a>
					</p>
				</div>
			</div>
			<div class="shoucang_left_div2">
				<p class="shoucang_left_div2_p1">交易中心</p>
				<ul class="shoucang_left_div2_ul1">
					<li><a href="<%=path%>/tradeManage/queryListPC.do">我的订单</a></li>
					<li><a href="<%=path%>/modelCollectionController/queryList.do">我的收藏</a></li>
					<li><a href="<%=path%>/userManage/gotoGoodsBackPagePC.do">退换货</a></li>
				</ul>
				<p class="shoucang_left_div2_p1">账户中心</p>
				<ul class="shoucang_left_div2_ul1">
					<li><a href="<%=path%>/userManage/gotoUserManagePC.do">编辑个人信息</a></li>
					<li><a href="<%=request.getContextPath()%>/userManage/gotochangePwdPC.do">修改密码</a></li>
					<li><a class="a1"
						href="<%=path%>/userAddressController/queryUserAddress.do">收货地址</a></li>
				</ul>
			</div>
			<div class="dongde"></div>
		</div>
		<div class="shouhuo_right left">
			<p class="shouhuo_right_p1">【发货地址】</p>
			<p class="shouhuo_right_p2">已保存的地址</p>
			<c:forEach items="${list}" var="address" varStatus="i">
				<div class="shouhuo_right_div1 left">
					<img class="shouhuo_right_div1_img1" src="<%=request.getContextPath()%>/images/pc/036.gif" />
					<img class="shouhuo_right_div1_img2" src="<%=request.getContextPath()%>/images/pc/037.gif" />
					<img class="shouhuo_right_div1_img3" src="<%=request.getContextPath()%>/images/pc/038.gif" />
					<div class="shouhuo_right_div1_div1">
						<span class="left">${address.username}</span> <span class="right">${address.telephone}</span>
					</div>
					<div class="shouhuo_right_div1_div2">
						<span class="shouhuo_right_div1_div2_sp1">${address.province}</span>
						<span class="shouhuo_right_div1_div2_sp2">${address.city}</span> <span
							class="shouhuo_right_div1_div2_sp3">${address.addressArea}</span>
						<span class="shouhuo_right_div1_div2_sp4">${address.address}</span>
					</div>
					<div class="shouhuo_right_div1_div3">
						<a href="#" class="shouhuo_right_div1_div3_sp1" id="${address.id}"
							onclick="setDefault('${address.id}')">设为默认地址</a> <a href="#"
							class="shouhuo_right_div1_div3_sp2"
							onclick="showuptAddress('${address.id}','${address.username}','${address.telephone}','${address.province}','${address.city}','${address.addressArea}','${address.address}','${address.zipcode}','${address.isDefault}','${address.provinceId}','${address.cityId}')">[修改]</a>
						<a href="#" class="shouhuo_right_div1_div3_sp3"
							onclick="delAddress('${address.id}',this)">[删除]</a>
					</div>
				</div>
			</c:forEach>
			<button class="tianjia_dizhi" onclick="showaddAddress()">添加新地址</button>
		</div>

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
				class="shouhuo_motai_div1_img1" src="<%=request.getContextPath()%>/images/pc/039.gif" /> <input
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
//确认删除
function delAddress(id,obj){
	
	if(window.confirm("确认要删除该收获地址吗？")){
		
		 $.ajax({
				type:"post",
				url:"<%=request.getContextPath()%>/userAddressController/delUserAddress.do",
					data : {
						id : id
					},
					dataType : 'text',
					success : function(result) {
						if(result=="1"){
							$(obj).parent().parent().css({"display":"none"});
						}

					},
					error : function() {
						alert("bug");
					}

				});
     } 
}
//设置为默认地址
function setDefault(id){
	if($("#"+id).html()=="默认地址"){
		return;
		}
	
	var uid=$("#yfhl_user").val();
	//if(window.confirm("确认要设置该收获地址为默认地址吗？")){
		 $.ajax({
				type:"post",
				url:"<%=request.getContextPath()%>/userAddressController/setDefault.do",
					data : {
						id : id,
						uid : uid
					},
					dataType : 'text',
					success : function(result) {
						 

					},
					error : function() {
						alert("bug");
					}

				});
   // } 
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

//修改、添加收货地址信息
function userAddressManage(){
	var uid=$("#yfhl_user").val();
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
</script>
</html>