<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"%>
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
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>爱体验—购物车</title>
<link rel="stylesheet" type="text/css"
	href="/3dcreatia/css/wx/gouwuche.css" />
<link rel="stylesheet" href="/3dcreatia/css/cartcss/Common_style.css" />
<script type="text/javascript" src="/3dcreatia/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/3dcreatia/js/wx/gouwuche.js"></script>
<!-- 微信 -->
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	
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

</head>
<body>
	<c:if test="${modelCartList.size()==0}">
		<div class="kong">
			<p>购物袋快饿扁了~</p>
			<p>快帮他挑点宝贝吧~</p>
			<p>
				<a href="<%=path%>/wxModel/wxgotoModelIndex.do">去逛逛！</a>
			</p>
		</div>
	</c:if>
	<c:if test="${modelCartList.size()!=0}">
		<input type="hidden" id="yfhl_user" value="${yfhl_user.uid}" />
		<div class="cars">
			<c:forEach items="${modelCartList}" var="modelshopping" varStatus="i">
				<c:if test="${modelshopping.marker_state==1}">
					<div class="carst">
						<div class="cars_div1">
							<div class="cars_div1_div1">
								<img class="cars_div1_div1_img1"
									src="../images/wx/030.gif" /> <img
									class="cars_div1_div1_img2" src="../images/wx/027.gif"
									id="${modelshopping.msId}" name="selected" />
							</div>
							<div class="cars_div1_div2">
								<img
									src="/upload/uploadImg/model/${modelshopping.msModelimg}" />
							</div>
							<div class="cars_div1_div3">
								<p class="cars_div1_div3_p1">${modelshopping.msModelname}</p>
								<p class="cars_div1_div3_p2">
									<span>${modelshopping.msModtexture}</span>/<span
										class="cars_div1_div3_p2_sp2">${modelshopping.msModsize}</span>
								</p>
							</div>
							<div class="cars_div1_div4">
								<p>
									￥<span id="countmodelPrice${modelshopping.msId}">${modelshopping.countPrice}</span>
								</p>
								<div class="cars_div1_div4_div1">
									<img class="cars_div1_div4_div1_img1"
										src="<%=path %>/images/wx/019.gif"
										onclick="onChange('${modelshopping.msId}',1,'${modelshopping.msModprice}','msModcount${modelshopping.msId}','countmodelPrice${modelshopping.msId}')" />
									<span class="cars_div1_div4_div1_sp1"
										id="msModcount${modelshopping.msId}">${modelshopping.msModcount}</span>
									<img class="cars_div1_div4_div1_img2"
										onclick="onChange('${modelshopping.msId}',2,'${modelshopping.msModprice}','msModcount${modelshopping.msId}','countmodelPrice${modelshopping.msId}')"
										src="<%=path %>/images/wx/020.gif" />
								</div>
							</div>
						</div>
						<div class="carst_shanchu">
							<button onclick="onDel('${modelshopping.msId}')">删除</button>
						</div>
					</div>
				</c:if>
				<c:if test="${modelshopping.marker_state==2}">
					<div class="carst carstShi">
						<div class="cars_div1">
							<div class="cars_div1_div1"></div>
							<div class="cars_div1_div2">
								<div class="cars_div1_div2_div1">
									<span>失效</span>
								</div>
								<img
									src="/upload/uploadImg/model/${modelshopping.msModelimg}" />
							</div>
							<div class="cars_div1_div3">
								<p class="cars_div1_div3_p1">${modelshopping.msModelname}</p>
								<p class="cars_div1_div3_p2">
									<span>${modelshopping.msModtexture}</span>/<span
										class="cars_div1_div3_p2_sp2">${modelshopping.msModsize}</span>
								</p>
							</div>
							<div class="cars_div1_div4">
								<p>
									￥<span id="countmodelPrice${modelshopping.msId}">${modelshopping.msModprice*modelshopping.msModcount}</span>
								</p>
								<div class="cars_div1_div4_div1">
									<img class="cars_div1_div4_div1_img1s"
										src="<%=path %>/images/wx/62.png" /> <span
										class="cars_div1_div4_div1_sp1"
										id="msModcount${modelshopping.msId}">${modelshopping.msModcount}</span>
									<img class="cars_div1_div4_div1_img2s"
										src="<%=path %>/images/wx/61.png" />
								</div>
							</div>
						</div>
						<div class="carst_shanchu">
							<button onclick="onDel('${modelshopping.msId}')">删除</button>
						</div>
					</div>
				</c:if>
			</c:forEach>

		</div>
		<!--
        	作者：offline
        	时间：2016-03-04
        	描述：全部金额结算
        -->
		<div class="money">
			<div class="money_div1">
				<img class="money_div1_img1" src="<%=path %>/images/wx/4.png" /><img
					class="money_div1_img2" src="<%=path %>/images/wx/027.gif" />全部
			</div>
			<div class="money_div2">
				<p class="money_div2_p1">
					合计：<span>￥<span id="countPrice">0.00</span></span>
				</p>
				<p class="money_div2_p2">
					总额：￥<span class="money_div2_p2_sp1" id="totalPrice">0.00</span>减：￥<span
						id="favorablePrice">0.00</span>
				</p>
			</div>
		</div>
		<div class="money_end" onclick="onSettlement()">
			去结算<span>(<span id="countNumber">0</span>)
			</span>
		</div>
	</c:if>
</body>
<script type="text/javascript">
	//点击+/-
	function onChange(msid,type,price,count,countmodelprice){
		var countNum=Number($("#"+count).text());
		
		//alert(countNum);
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
		     url: "/3dcreatia/wxModelShoppingController/wxCartChange.do",
		     data: {msId:msid,marker_count:type,msModcount:countNum},
		     dataType: "json",
		     success: function(data){
		         if(data.state=="0"){  
		             alert(data.value);  
		         }else if(data.state=="1" && data.body[0]=="1")//  
		         {  
		        	 $("#"+count).text(countNum);//数量
		        	 if(type==1){
		        		 $("#"+countmodelprice).text((Number(price)*Number(countNum)).toFixed(2));//商品总价
		        	 }else if(type==2){
		        		 $("#"+countmodelprice).text((Number(price)*Number(countNum)).toFixed(2));//商品总价
		        	 }
		        	$("#countPrice").text(getTotalPrice());//合计
		        	$("#totalPrice").text(getTotalPrice());//总金额
		        		
		         } 
		     }
		 });
		
	}
	//计算已选中商品的总计金额
	function getTotalPrice(){
		var selected = document.getElementsByName("selected");  
		var count=0;
		var totalPrice=0;
		 for(var i=0;i<selected.length;i++){ 
	            if(selected[i].style.display=="block"){ 
	               count=count+1;
	               totalPrice=totalPrice+Number($("#countmodelPrice"+selected[i].id).text());
	            } 
	        } 
		return totalPrice.toFixed(2);
	}
	//统计选中商品的数量
	function getCountNumber(){
		var countNumber=0;
		var selected = document.getElementsByName("selected");  
		var count=0;
		 for(var i=0;i<selected.length;i++){ 
	            if(selected[i].style.display=="block"){ 
	            	countNumber=countNumber+1;
	            } 
	        } 
		return countNumber;
	}
	//删除
	function onDel(msId){
			$.ajax({
	             type: "POST",
	             url: "/3dcreatia/wxModelShoppingController/wxcartDel.do",
	             data: {msId:msId},
	             dataType: "json",
	             success: function(data){
	                  	//在这里刷新当前页面吗？
	                    window.location.reload();
	             }
	         });
			selectModel();
	}
	//选中复选框操作
	function selectModel(){
		
		 $("#countPrice").text(getTotalPrice());//合计
		 $("#totalPrice").text(getTotalPrice());//总金额
		 $("#countNumber").text(getCountNumber());//选中商品数量
	}
	//判断选中的商品数量
	function getCheckBox(){  
		var selected = document.getElementsByName("selected");               
        var flag = false ;    
        var str = "";
        for(var i=0;i<selected.length;i++){ 
            if(selected[i].style.display=="block" ){ 
                flag = true ; 
                if (str != ""){
                	str = str + ";" + selected[i].id;
                }else {
                	str = selected[i].id;
                }
            } 
        } 
        if(!flag){ 
            alert("请最少选择一项！"); 
            return str; 
        } 
        return str;
	}
	//结算
	function onSettlement(){
		var check = getCheckBox();
		var uid = $("#yfhl_user").val();
		if(uid=="" || uid==null){
			alert("没有用户ID");
		}
		if (check != ""){
			document.write('<form action="<%=path %>/wxModelShoppingController/wxSettleCountByShopping.do" method="post" name="formx1" style="display:none">');
			document.write('<input type="hidden" name="check" value="'+check+'"/>');
			document.write('<input type="hidden" name="uid" value="'+uid+'"/>');
			document.write("</form>");
			document.formx1.submit();
		}

	}
	//模糊查询
	function selByCondition() {
		//1.搜索框去掉前后空格
		var condition = $.trim($("#condition").val());
		$("#condition").val(condition);
		document.form_condition.submit();
	}
	//去购物车
	function gotoShopping(){
		//判断是否已经登录
		 var uid=$("#yfhl_user").val();
		  if(uid=="" || uid==null){
			alert("用户没有授权登录");
		    return false;
		    }
		window.location.href="/3dcreatia/modelShopping/cartList.do";
	}
	//跳转到商品详情页面
	function to_modeldetail(mid) {
		window.location.href = "<%=path%>/modelController/gotoModelDetailPC.do?mid="
				+ mid;
	}
</script>
</html>
