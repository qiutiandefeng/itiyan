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
<title>评论管理页</title>

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
		var status = $.trim($("#status").val());//订单的状态
		$("#tradeNo").val(tradeNo);
		$("#status").val(status);
	}
	//用户来源设置
	function tradeFrom(type) {
	 
		$("#markTradeFrom").val(type);//设置用户来源
		$("#status").text(0);
// 		checkSubmit();//表单验证
		$("#sform").submit();//提交表单
	}
	
	
</script>
</head>
<body>
	<h1 class="narrow" style="margin-top: 0">
		<img src="../images/icon_29.png"
			style="float: left; margin-top: 10px;">&nbsp;评论管理
	</h1>
	<div class="container-fluid" style="margin-left: -14px;">
		<form id="sform" action="queryList.do" method="post"
			class="newWell form-inline" style="margin-top: -5px;">
			<input type="text" placeholder="商品名称或买家名称" name="condition"
				style="margin-top: 0px;" id="condition" value="${comments.condition}"
				class="nav-search-input"> 
			
			<input
				type="hidden" id="pageIndex" name="pageIndex" value="${comments.pageInfo.pageIndex }" /> 
			<input type="submit"
				onclick="checkSubmit()" id="selectLick" value="查询"
				class="btn btn-primary btn-sm" style="margin-left: 5px;">&nbsp;
		</form>
		<table class="table table-bordered table-striped table-hover"
			style="margin-top: -4px;">
			<thead>
				<tr class=" alert-info">
					<th width="300px">评论内容</th>
					<th>商品</th>	
					<th>买家名称</th>
					<th>设计师</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${commentList}" var="comment" varStatus="i">
					<tr>
						<td>${comment.content}</td>
						<td>${comment.title}</td>
						<td>${comment.username}</td>
						<td>${comment.modelAuther}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="page-paging2 " style="margin-left: 15px;">
		<!-- 分页 -->
		<c:set value="${comments.pageInfo}" var="pageInfo"></c:set>
		<%@include file="../template/pageTemplate.jsp"%>
	</div>



</body>
</html>