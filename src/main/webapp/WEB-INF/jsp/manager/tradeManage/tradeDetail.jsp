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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.js"></script>
<title>订单详情</title>
<script type="text/javascript">
//屏蔽点击键盘Backspace键，页面向后跳转
window.onload=function(){  
   
        //获取事件对象  
        var elem = event.relatedTarget || event.srcElement || event.target ||event.currentTarget;   
          
        if(event.keyCode==8){//判断按键为backSpace键  
          
                //获取按键按下时光标做指向的element  
                var elem = event.srcElement || event.currentTarget;   
                  
                //判断是否需要阻止按下键盘的事件默认传递  
                var name = elem.nodeName;  
                  
                if(name!='INPUT' && name!='TEXTAREA'){  
                    return _stopIt(event);  
                }  
                var type_e = elem.type.toUpperCase();  
                if(name=='INPUT' && (type_e!='TEXT' && type_e!='TEXTAREA' && type_e!='PASSWORD' && type_e!='FILE')){  
                        return _stopIt(event);  
                }  
                if(name=='INPUT' && (elem.readOnly==true || elem.disabled ==true)){  
                        return _stopIt(event);  
                }  
            }  
         
    }  
	function _stopIt(e){  
	    if(e.returnValue){  
	        e.returnValue = false ;  
	    }  
	    if(e.preventDefault ){  
	        e.preventDefault();  
	    }                 

     return false;  
	}  
    
	//订单来源设置
	function tradeFrom(type) {
	 
		$("#markTradeFrom").val(type);//设置订单户来源
// 		$("#status").text(0);
// 		checkSubmit();//表单验证
		$("#sform").submit();//提交表单
	}
	
	
</script>



</head>
<body>
<form id="sform" action="queryList.do" method="post"
			class="newWell form-inline">
	<table>
		<tr>
			<h3>订单详情</h3>
		</tr>
		<tr>
			<td id="id">订单号：</td>
			<td >${tradeOne.tradeNo }</td>
			<td id="id">买家名称：</td>
			<td>${user.username }</td>
			
		</tr>
		<tr>
			<td id="id">下单日期：</td>
			<td>
			<fmt:formatDate value="${tradeOne.addTime }" pattern="yyyy年MM月dd日HH点mm分ss秒" /></td>
			<td id="id">订单来源：</td>
			<c:choose>
				<c:when test="${tradeOne.wxpayNo == null || tradeOne.wxpayNo==''}">
					<td>平台</td>
				</c:when>
				<c:otherwise>
					<c:out value="微信" />
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<!-- 1：等待付款 2：已付款，等待发货 3：已发货，等待收货 4：交易完成 5：交易取消 -->
			<td id="id">订单状态：</td>
			<c:choose>
				<c:when test="${tradeOne.status == 1}">
					<td>等待付款</td>
				</c:when>
				<c:when test="${tradeOne.status == 2}">
					<td>已付款，等待发货</td>
				</c:when>
				<c:when test="${tradeOne.status == 3}">
					<td>已发货，等待收货</td>
				</c:when>
				<c:when test="${tradeOne.status == 4}">
					<td>交易完成</td>
				</c:when>
				<c:otherwise>
					<c:out value="交易取消" />
				</c:otherwise>
			</c:choose>
			<td id="id">支付方式：</td>
			<c:choose>
				<c:when	test="${tradeOne.alipayNo != null || tradeOne.alipayNo != ''}">
					<td>支付宝支付</td>
				</c:when>
				<c:otherwise>
					<c:out value="微信支付" />
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<td>支付日期：</td>
			<td><fmt:formatDate value="${tradeOne.paymentTime }" pattern="yyyy年MM月dd日HH点mm分ss秒" /></td>
			<td>支付金额：</td>
			<fmt:formatNumber value="${tradeOne.cashFee }" pattern="0.00"/> 
<%-- 			<td>${tradeOne.cashFee }</td> --%>
		</tr>
		<br />
		<br />
		<tr>
			<h3>购买的商品</h3>
		</tr>
		<tr>
			<td>货品名称</td>
			<td>设计师</td>
			<td>品牌</td>
			<td>材质</td>
			<td>数量</td>
		</tr>
		<c:forEach items="${modelList }" var="ml" varStatus="i">
			<tr>
				<td>${ml.title }</td>
				<td>${authorList.get(i.index).username }</td>
				<td>${ml.brand }</td>
				<td>
				<c:forEach items="${modelTypeList }" var="list" varStatus="j">
					${list.modtTexture }&nbsp;&nbsp;${list.modtColorDesc }&nbsp;&nbsp;${list.modtSize }
				</c:forEach>
				</td>
				<td>${tradeDetailList.get(i.index).qty }</td>
			</tr>
		</c:forEach>
		<br />
		<br />
		<tr>
			<h3>配送信息</h3>
		</tr>
		<tr>
			<td>收 件 人：</td>
			<td>${tradeOne.realname }</td>
			<td>电 &nbsp;话：</td>
			<td>${tradeOne.phone }</td>
			<td>收货地址：</td>
			<td>${tradeOne.address }</td>
			<td>邮 &nbsp;编：</td>
			<td>${tradeOne.zipcode }</td>
		</tr>
		<br />
		<br />
		<br />
		<tr>
			<h3>发货信息</h3>
		</tr>
		<tr>
			<td>运单号：</td>
			<td>${tradeOne.logistics }</td>
		</tr>
		<tr></tr>
		<tr></tr>
		
	</table>
	<div>
		<input type="hidden" id="tradeOneNo" name="tradeOneNo" value="${tradeOne.tradeOneNo }" />
		<input type="hidden" id="pageIndex" name="pageInfo.pageIndex" value="${trade.pageInfo.pageIndex }" />
		<input type="hidden" id="state" name="state" value="${tradeOne.state}"/>
		<input type="hidden" id="status" name="status" value="${tradeOne.status}"/>
		<input type="hidden" id="markTradeFrom" name="markTradeFrom" value="${tradeOne.markTradeFrom}"/>
	</div>
	<div align="center"><a href="#" onclick="tradeFrom(${tradeOne.markTradeFrom});">返回列表</a></div>
<%-- 	<%=path%>/tradeManage/queryList.do?pageInfo.pageIndex=${trade.pageInfo.pageIndex } --%>
</form>
</body>
</html>