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
	src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/global.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/layer/layer.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/dialog/dialog.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/dialog.js"></script>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/style.css" type="text/css"
	rel="stylesheet">
<link href="<%=path%>/css/newWell.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单管理页</title>

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
    //提交验证
	function checkSubmit() {
    	
		var tradeNo = $.trim($("#tradeNo").val());//搜索框去掉前后空格
		var state = $.trim($("#status").val());//订单的状态
// 		var markTradeFrom = $.trim($("#markTradeFrom").val());
		$("#tradeOneNo").val(tradeNo);
		$("#state").val(state);
// 		$("#markTradeFrom").val(markTradeFrom);//设置订单户来源
	}
	//订单来源设置
	function tradeFrom(type) {
	 
		$("#markTradeFrom").val(type);//设置订单户来源
// 		$("#status").text(0);
		checkSubmit();//表单验证
		$("#sform").submit();//提交表单
	}
	
	//查看订单
	function tradeManage(id){
		var tradeOneNo = $.trim($("#tradeNo").val());
		var status=$("#status").val();//获取操作订单的状态
		var pageIndex=$("#pageIndex").val();
		var markTradeFrom=$("#markTradeFrom").val();
		window.location.href="<%=request.getContextPath()%>/tradeManage/gotoTradeManage.do?pageInfo.pageIndex="+ pageIndex + "&status=" + status+"&markTradeFrom="+markTradeFrom + "&tradeOneNo="+tradeOneNo+"&id="+id;
	}
	
	function tradeDel(tId)
	{
		if(confirm("取消订单后不再恢复，是否确认？"))
		{
			window.location.href="<%=request.getContextPath()%>/tradeManage/cancelTrade.do?tId="+tId;
		}
	}
// 	$("input[name='status'][value='${trade.status }']").attr("checked",true);
	
</script>
</head>
<body>
	<h1 class="narrow" style="margin-top: 0">
		<img src="../images/icon_29.png"
			style="float: left; margin-top: 10px;">&nbsp;订单管理
	</h1>
	<div class="container-fluid" style="margin-left: -14px;">
		<form id="sform" action="queryList.do" method="post"
			class="newWell form-inline" style="margin-top: -5px;">
			<input type="text" placeholder="订单号" name="tradeNo"
				style="margin-top: 0px;" id="tradeNo" value="${trade.tradeOneNo}"
				class="nav-search-input"> 
			<SELECT style="height: 28 " width="15%" name="status" id="status" >&nbsp;&nbsp;
		         <option value="0" selected="selected">请选择：</option>
		         <option value="1" <c:if test="${'1' eq trade.state}">selected</c:if>>等待付款</option>
		         <option value="2" <c:if test="${'2' eq trade.state}">selected</c:if>>已付款，等待发货</option>
		         <option value="3" <c:if test="${'3' eq trade.state}">selected</c:if>>已发货，等待收货</option>
		         <option value="4" <c:if test="${'4' eq trade.state}">selected</c:if>>交易完成</option>
		         <option value="5" <c:if test="${'5' eq trade.state}">selected</c:if>>交易取消</option>
		         <option value="6" <c:if test="${'6' eq trade.state}">selected</c:if>>供应商打印中</option>
		   </SELECT>
			<input type="submit"
				onclick="checkSubmit()" id="selectLick" value="查询"
				class="btn btn-primary btn-sm" style="margin-left: 5px;">&nbsp;
			<a
				href="#" onclick="tradeFrom(1);">所有（${trade.sumCount}）</a>&nbsp;&nbsp;<a
				href="#" onclick="tradeFrom(2);">平台（${trade.pCount}）</a>&nbsp; &nbsp;<a
				href="#" onclick="tradeFrom(3);">微信（${trade.wCount}）</a> <input
				type="hidden" id="pageIndex" name="pageIndex" value="${trade.pageInfo.pageIndex }" /> 
			<input type="hidden" name="markTradeFrom" id="markTradeFrom"
				value="${trade.markTradeFrom}" />
				<input type="hidden" id="state" name="state" value="${trade.state}"/> 
				<input type="hidden" id="tradeOneNo" name="tradeOneNo"/> 
		</form>
		<table class="table table-bordered table-striped table-hover"
			style="margin-top: -4px;">
			<thead>
				<tr class=" alert-info">
					<th>订单号</th>
					<th>来源</th>
					<th>买家</th>
					<th>订单状态</th>
					<th>订单金额</th>
					<th>支付方式</th>
					<th>下单时间</th>
					<th colspan="3">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tradelist}" var="trade" varStatus="i">
					<tr>
						<td>${trade.tradeNo}</td>
<%-- 						<td>${trade.phone}</td> --%>
						<c:choose>
							<c:when test="${trade.wxOpenid==null}">
								<td>平台</td>
							</c:when>
							<c:when test="${trade.wxOpenid!=null}">
								<td>微信</td>
							</c:when>
						</c:choose>
						<td>${trade.uid}</td>
						<c:choose>
							<c:when test="${trade.status==1}">
								<td>等待付款</td>
							</c:when>
							<c:when test="${trade.status==2}">
								<td>已付款，等待发货</td>
							</c:when>
							<c:when test="${trade.status==3}">
								<td>已发货，等待收货</td>
							</c:when>
							<c:when test="${trade.status==4}">
								<td>交易完成</td>
							</c:when>
							<c:when test="${trade.status==5}">
								<td>交易取消</td>
							</c:when>
							<c:when test="${trade.status==6}">
								<td>供应商打印中</td>
							</c:when>
							<c:otherwise>
								<td>不明</td>
							</c:otherwise>
						</c:choose>
						<td>${trade.totalPrice}</td>
						<c:choose>
							<c:when test="${trade.wxpayNo == null || trade.wxpayNo == ''}">
								<td>支付宝</td>
							</c:when>
							<c:otherwise>
								<td>微信</td>
							</c:otherwise>
						</c:choose>
						<td><fmt:formatDate value="${trade.addTime}"
								pattern="yyyy-MM-dd:HH:mm" /></td>
						<td colspan="3"><a
							href="javascript:tradeManage(${trade.id});" style="color: blue;">查看</a>
							<a href="javascript:tradeDel(${trade.id});" style="color: blue;">取消订单</a>
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="page-paging2 " style="margin-left: 15px;">
		<!-- 分页 -->
		
		<c:set value="${trade.pageInfo}" var="pageInfo"></c:set>
		<%@include file="../template/pageTemplate.jsp"%>
	</div>



</body>
</html>