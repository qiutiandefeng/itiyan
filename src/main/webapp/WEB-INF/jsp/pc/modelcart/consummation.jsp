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
	href="<%=path%>/css/cartcss/consummation.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/cartcss/orders.css" />
<link rel="stylesheet" href="<%=path %>/css/pc/Common_style.css" />
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.js"></script>


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
        	时间：2015-12-25
        	描述：完成
        -->
	<div class="consummation">
		<div class="orders">
			<p class="orders_p1">
				<a href="#">首页</a> > <a href="#">产品</a> > <a href="#">完成购买</a>
			</p>
			<div class="orders_div1">
				<p class="orders_div1_p1">完成</p>
				<p class="orders_div1_p2">consummation</p>
				<div class="orders_div1_div1">
					<img src="<%=request.getContextPath()%>/images/pc/030.gif" />
				</div>
				<ul class="orders_div1_ul1">
					<li class="orders_div1_ul1_li1">查看购物车</li>
					<li class="orders_div1_ul1_li2">填写订单</li>
					<li class="orders_div1_ul1_li3">付款，完成购买</li>
				</ul>
			</div>
			<p class="orders_p2">【完成支付】</p>
		</div>
		<div class="consummation_div1">
			<p class="consummation_div1_p1">您已经付款成功，完成购买！</p>
			<p class="consummation_div1_p2">为保障您的权益，收货时请开箱检查，发现货物异常请不要签收</p>
			<p class="consummation_div1_p3">
				订单金额：<span>${totalPrice}</span>元<a>(在线支付)</a>
			</p>
			<p class="consummation_div1_p4">
				实际支付金额：<span>${totalPrice}</span>元
			</p>
			<c:forEach items="${tradeList}" var="trade">
				<div class="consummation_div1_div1">
					<p class="consummation_div1_div1_p1">
						<span class="consummation_div1_div1_p1_sp1">订单号：</span> <span
							class="consummation_div1_div1_p1_sp2">${trade.tradeNo}</span>
					</p>
					<p class="consummation_div1_div1_p2">
						寄送至：<span>${trade.realname}</span><span>${trade.address  }</span><span>${trade.phone}</span>
					</p>
					<p class="consummation_div1_div1_p3">
						配送信息：<span>1</span>个包裹 <span class="consummation_div1_div1_p3_sp1">(共<span>${trade.modelCount}</span>件商品)
						</span> <a href="###" onclick="toDetail(2,'${trade.id}')">查看订单</a>
					</p>
				</div>
			</c:forEach>
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
	                    alert("删除成功！");
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
	//查看订单:1：等待付款 2：已付款，等待发货 3：已发货，等待收货 4：交易完成 5：交易取消
	function toDetail(type, tid) {
		var userid = $("#yfhl_user").val();
		document
				.write('<form action="<%=request.getContextPath()%>/tradeManage/queryTradeDetailPC.do" method="post" name="formx1" style="display:none">');
		document.write('<input type="hidden" name="state" value="'+type+'"/>');
		document
				.write('<input type="hidden" name="markUserid" value="'+userid+'"/>');
		document.write('<input type="hidden" name="id" value="'+tid+'"/>');
		document.write("</form>");
		document.formx1.submit();

	}
</script>
</html>
