<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"%>
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
<meta charset="utf-8" />
<title>爱体验网-购物车</title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/cartcss/cart.css" />
<link rel="stylesheet" href="<%=path %>/css/pc/Common_style.css" />
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="<%=path%>/js/cart/car.js"></script>


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
        	时间：2016-01-08
        	描述：购物车
        -->
	<div class="carttop">
		<div class="cart_top">
			<div class="cart_top1" style="">
				<a href="###">首页</a> > <a href="###">产品</a> > <a href="###">我的购物车</a>
			</div>
			<div class="cart_top2">
				<h2>购物车</h2>
				<p>my shopping cart</p>
				<img src="<%=path%>/images/pc/cart/cart1.gif" />
				<div class="cartd">
					<div class="cartd1">查看购物车</div>
					<div class="cartd2">填写订单</div>
					<div class="cartd3">付款，完成购买</div>
				</div>
			</div>
		</div>
	</div>

	<div class="cartcen">
		<div class="cart_center">
			<div class="cartcon">
				<div class="cartcon1">
					<img class="cartcon1_img1" src="<%=path%>/images/pc/cart/077.png" />
					<img class="cartcon1_img2" src="<%=path%>/images/pc/cart/078.png" />
					<span class="cartcon1_sp1">全选</span>
				</div>
				<div class="cartcon2">商品信息</div>
				<div class="cartcon3">单价(元)</div>
				<div class="cartcon4">数量</div>
				<div class="cartcon5">小计(元)</div>
				<div class="cartcon6">操作</div>
			</div>



			<c:forEach items="${brandMap}" var="item" varStatus="i">
				<div class="cart_center_div1">
					<div class="cart_center_div1_div1">
						<img class="cart_center_div1_div1_img1 left"
							src="<%=path%>/images/pc/cart/079.png" /> <img
							class="cart_center_div1_div1_img2 left"
							src="<%=path%>/images/pc/cart/080.png" /> <a class="left"
							href="###">${item.value}</a>
					</div>
					<div class="cart_center_div1_div2">
						<c:forEach items="${modelList}" var="model" varStatus="j">
							<c:if
								test="${item.value == model.brand && modelCartList.get(j.index).marker_state==1}">
								<ul class="cart_center_div1_div2_ul1">
									<li class="cart_center_div1_div2_ul1_li1"><img
										class="cart_center_div1_div2_ul1_li1_img1"
										src="<%=path%>/images/pc/cart/079.png" /> <img
										id="${modelCartList.get(j.index).msId}" name="selected"
										class="cart_center_div1_div2_ul1_li1_img2"
										src="<%=path%>/images/pc/cart/080.png" /></li>
									<li class="cart_center_div1_div2_ul1_li2"><a href="###"><img
											class="cart_center_div1_div2_ul1_li2_img1 left"
											src="<%=request.getContextPath()%>/upload/uploadImg/model/${model.img}"
											onclick="to_modeldetail('${model.mid}')" /></a>
										<div class="cart_center_div1_div2_ul1_li2_div1 left">
											<p class="cart_center_div1_div2_ul1_li2_div1_p1">
												<a href="###" onclick="to_modeldetail('${model.mid}')">${model.title}</a>
											</p>

											<p class="cart_center_div1_div2_ul1_li2_div1_p2">
												<span>材质：</span><span>${modelCartList.get(j.index).msModtexture}</span>
											</p>
											<p class="cart_center_div1_div2_ul1_li2_div1_p3">
												<span>尺寸：</span><span>${modelCartList.get(j.index).msModsize}</span>
											</p>
										</div></li>
									<li class="cart_center_div1_div2_ul1_li3"
										id="modelPrice_${j.index }">￥<span>${modelCartList.get(j.index).msModprice}</span>
										<input type="hidden" id="modelId_${j.index}" name="modelId"
										value="${model.mid}" /> <input type="hidden"
										id="countId_${j.index}" name="countId" value="${j.index}" />
										<input type="hidden" id="uid" name="uid"
										value="${modelCartList.get(j.index).msUid}" /> <input
										type="hidden" id="msId" name="msId"
										value="${modelCartList.get(j.index).msId}" />
									</li>
									<li class="cart_center_div1_div2_ul1_li4">
										<button
											onclick="onChange(${modelCartList.get(j.index).msId},1,'${modelCartList.get(j.index).msModprice}','count${i.index}${j.index}','pricecount${i.index}${j.index}')">-</button>
										<input type="text" id="count${i.index}${j.index}" name="count"
										value="${modelCartList.get(j.index).msModcount}"
										disabled="disabled" />
										<button
											onclick="onChange(${modelCartList.get(j.index).msId},2,'${modelCartList.get(j.index).msModprice}','count${i.index}${j.index}','pricecount${i.index}${j.index}')">+</button>
									</li>
									<li class="cart_center_div1_div2_ul1_li5">￥<span
										id="pricecount${i.index}${j.index}" class="luans">${priceList.get(j.index)}</span>
									</li>
									<li class="cart_center_div1_div2_ul1_li6"><a href="###"
										onclick="onDel(${modelCartList.get(j.index).msId})">删除</a></li>
								</ul>
							</c:if>
							<c:if
								test="${item.value == model.brand && modelCartList.get(j.index).marker_state==2}">
								<ul
									class="cart_center_div1_div2_ul1 cart_center_div1_div2_ul1Shixiao">
									<li class="cart_center_div1_div2_ul1_li1"><div>失效</div> <img
										id="${modelCartList.get(j.index).msId}" name="selected"
										src="<%=path%>/images/pc/cart/080.png" style="display: none" /></li>
									<li class="cart_center_div1_div2_ul1_li2"><a href="###"><img
											class="cart_center_div1_div2_ul1_li2_img1 left"
											src="..//upload//uploadImg//model/${model.img}"
											onclick="to_modeldetail('${model.mid}')" /></a>
										<div class="cart_center_div1_div2_ul1_li2_div1 left">
											<p class="cart_center_div1_div2_ul1_li2_div1_p1">
												<a href="###" onclick="to_modeldetail('${model.mid}')">${model.title}</a>
											</p>

											<p class="cart_center_div1_div2_ul1_li2_div1_p2">
												<span>材质：</span><span>${modelCartList.get(j.index).msModtexture}</span>
											</p>
											<p class="cart_center_div1_div2_ul1_li2_div1_p3">
												<span>尺寸：</span><span>${modelCartList.get(j.index).msModsize}</span>
											</p>
										</div></li>
									<li class="cart_center_div1_div2_ul1_li3"
										id="modelPrice_${j.index }">￥<span>${modelCartList.get(j.index).msModprice}</span>
										<input type="hidden" id="modelId_${j.index}" name="modelId"
										value="${model.mid}" /> <input type="hidden"
										id="countId_${j.index}" name="countId" value="${j.index}" />
										<input type="hidden" id="uid" name="uid"
										value="${modelCartList.get(j.index).msUid}" /> <input
										type="hidden" id="msId" name="msId"
										value="${modelCartList.get(j.index).msId}" />
									</li>
									<li class="cart_center_div1_div2_ul1_li4">
										<button>-</button> <input type="text"
										id="count${i.index}${j.index}" name="count"
										value="${modelCartList.get(j.index).msModcount}"
										disabled="disabled" />
										<button>+</button>
									</li>
									<li class="cart_center_div1_div2_ul1_li5">￥<span
										id="pricecount${i.index}${j.index}" class="luans">${priceList.get(j.index)}</span>
									</li>
									<li class="cart_center_div1_div2_ul1_li6"><a href="###"
										onclick="onDel(${modelCartList.get(j.index).msId})">删除</a></li>
								</ul>


							</c:if>
						</c:forEach>
					</div>
				</div>
			</c:forEach>

			<div class="cartb">
				<div class="cartb1">
					<img class="cartb1_conte_img1"
						src="<%=path%>/images/pc/cart/079.png" /> <img
						class="cartb1_conte_img2" src="<%=path%>/images/pc/cart/080.png" />
					<span class="cartb1_sp1">全选</span> <a href="###" class="cartb1_sp2"
						onclick="onDel('all')">删除</a>
				</div>
				<div class="cartb2">
					<p class="p1">
						已选择<span id="selected_model">0</span>件商品
					</p>
					<p class="p2">
						商品总计:<span id="totalPrice">0.00</span>元
					</p>
				</div>
				<a href="###" class="cartb3" onclick="onSettlement()">结算</a>
			</div>
		</div>

		<!--
        	作者：offline
        	时间：2016-01-08
        	描述：最近浏览
        -->
		<div class="cartbot">
			<div class="cartbot1">
				<div class="cart">
					<p>最近浏览 RECENT REVIEW</p>
				</div>
				<img src="<%=path%>/images/pc/cart/cart2.gif" />
				<div class="cart1">
					<c:forEach items="${recentList}" var="recent">
						<a href="###" onclick="to_modeldetail('${recent.rMid}')"><img
							src="<%=request.getContextPath()%>/upload/uploadImg/model/${recent.modelImg}" /></a>
					</c:forEach>

				</div>
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
<script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
<script type="text/javascript">
	//点击+/-
	function onChange(msid,type,price,count,pricecountid){
		var countNum=Number($("#"+count).val());
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
		        	 $("#"+count).val(countNum);//数量
		        	 if(type==1){
		        		 $("#"+pricecountid).text((Number($("#"+pricecountid).text())-Number(price)).toFixed(2));//商品总价格
		        		 $("#totalPrice").text(getTotalPrice());//总价格
		        	 }else if(type==2){
		        		 $("#"+pricecountid).text((Number($("#"+pricecountid).text())+Number(price)).toFixed(2));//商品总价格
		        		 $("#totalPrice").text(getTotalPrice());//总价格 
		        	 }
		         } 
		     }
		 });
		
	}
	//计算已选中商品的总计金额
	function getTotalPrice(){
		var selected = document.getElementsByName("selected");  
		var pricecount=$(".luans");
		var count=0;
		var totalPrice=0;
		 for(var i=0;i<selected.length;i++){ 
	            if(selected[i].style.display=="block"){ 
	               count=count+1;
	               totalPrice=totalPrice+Number($("#"+pricecount[i].id).text());
	            } 
	        } 
		return totalPrice.toFixed(2);
	}
	//删除
	function onDel(msId){
		if(msId=="all"){//全选删除
			var selted = document.getElementsByName("selected");   
		    if(selted.length==0){
		    	alert("请选择要删除的购物车商品！");
		    	return false;
		    }
	        for(var i=0;i<selted.length;i++){ 
	            if(selted[i].style.display=="block" && msId=="all"){ 
	            	msId=selted[i].id;
	            }else {
	            	msId=msId+";"+selted[i].id;
	            } 
	        } 
		}
		if(confirm("删除后，商品将不在购物车，是否确定？"))
		{
			$.ajax({
	             type: "POST",
	             url: "<%=path%>/modelShopping/cartDel.do",
	             data: {msId:msId},
	             dataType: "json",
	             success: function(data){
	            	 
	                 if(data.state=="0")  
	                 {  
	                     alert(data.value);  
	                 }  
	                 else if(data.state=="1")//未绑定微博  
	                 {  
	                    //alert("删除成功！");
	                  	//在这里刷新当前页面吗？
	                    window.location.reload();
	                 }  
	             }
	         });
		}
	}
	//判断选中的商品数量
	function getCheckBox()
	{  
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
		var uid = $("#uid").val();
		if (check != ""){
			document.write('<form action="<%=request.getContextPath()%>/modelShopping/settleCountByShopping.do" method="post" name="formx1" style="display:none">');
			document.write('<input type="hidden" name="check" value="'+check+'"/>');
			document.write('<input type="hidden" name="uid" value="'+uid+'"/>');
			document.write("</form>");
			document.formx1.submit();
		}

	}
	//跳转到商品详情页面
	function to_modeldetail(mid){
		window.open("<%=request.getContextPath()%>/modelController/gotoModelDetailPC.do?mid="+mid);
		}
</script>
</html>
