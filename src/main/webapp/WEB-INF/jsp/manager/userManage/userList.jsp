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
<title>用户管理页</title>

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
		var condition = $.trim($("#condition").val());//搜索框去掉前后空格
		$("#condition").val(condition);
	}
	//用户来源设置
	function userFrom(type) {
		$("#markUserfrom").val(type);//设置用户来源
		checkSubmit();//表单验证
		$("#sform").submit();//提交表单

	}
	//添加用户:type:1添加；2编辑；3查看;uid:用户ID;studioStatus:设计师申请状态
	function userManage(type,uid,studioStatus){
	    
		var groupId=$("#groupId").val();//获取操作的是普通用户还是设计师：1普通用户；4设计师
		var pageIndex=$("#pageIndex").val();
		var markUserfrom=$("#markUserfrom").val();
		var condition = $.trim($("#condition").val());//搜索框去掉前后空格
		window.location.href="<%=request.getContextPath()%>/userManage/gotoUserManage.do?pageInfo.pageIndex="
				+ pageIndex + "&markManage=" + type + "&groupId=" + groupId+"&markUserfrom="
				+markUserfrom + "&uid="+uid+"&studioStatus="+studioStatus+"&condition="+condition;
	}
	//删除用户
	function userDel(uid){
		var groupId=$("#groupId").val();//获取操作的是普通用户还是设计师：1普通用户；4设计师
		var pageIndex=$("#pageIndex").val();
		if(window.confirm("确定要删除该用户吗？")){
			window.location.href="<%=request.getContextPath()%>/userManage/userDel.do?pageInfo.pageIndex="
				+ pageIndex + "&groupId=" + groupId + "&uid=" + uid;
         } 
		
	}
	//导出Excel
	function outExcel(){
		var groupId=$("#groupId").val();//获取操作的是普通用户还是设计师：1普通用户；4设计师
		var markUserfrom=$("#markUserfrom").val();//标记查询来源：1:全部;2:平台端；3:微信端
	//	alert("groupId="+groupId);
	//	alert("markUserfrom="+markUserfrom);
		$.ajax({
			async:true,
			error:function(){
				window.location.href="<%=request.getContextPath()%>/outExcelController/outExcelCommonUser.do?groupId=" + groupId + "&markUserfrom=" + markUserfrom;
				//parent.$("#btn_close").click();//执行完后关闭正在加载
			},
			success:function(){
				window.location.href="<%=request.getContextPath()%>/outExcelController/outExcelCommonUser.do?groupId="
								+ groupId + "&markUserfrom=" + markUserfrom;
						//parent.$("#btn_close").click();//执行完后关闭正在加载
					}
				});
		//parent.$("#btn_parent").click();//ajax异步执行正在加载
	}
</script>
</head>
<body>
	<h1 class="narrow" style="margin-top: 0">
		<img src="../images/icon_29.png"
			style="float: left; margin-top: 10px;">&nbsp;用户管理
	</h1>
	<div class="container-fluid" style="margin-left: -14px;">
		<form id="sform" action="queryList.do" method="post"
			class="newWell form-inline" style="margin-top: -5px;">
			<input type="text" placeholder="用户名/设计师/邮箱/手机号" name="condition"
				style="margin-top: 0px;" id="condition" value="${user.condition}"
				class="nav-search-input"> <input type="submit"
				onclick="checkSubmit()" id="selectLick" value="查询"
				class="btn btn-primary btn-sm" style="margin-left: 5px;">&nbsp;
			<input type="button" onclick="userManage(1,0,0);" value="新增"
				class="btn btn-primary btn-sm" style="margin-left: 5px;">
			&nbsp;<input type="button" value="导出" class="btn btn-primary btn-sm"
				style="margin-left: 5px;" onclick="outExcel();" />
			&nbsp;&nbsp;&nbsp;<a href="#" onclick="userFrom(1);">所有（${user.sumCount}）</a>&nbsp;&nbsp;<a
				href="#" onclick="userFrom(2);">平台（${user.pCount}）</a>&nbsp; &nbsp;<a
				href="#" onclick="userFrom(3);">微信（${user.wCount}）</a> <input
				type="hidden" id="pageIndex" name="pageIndex"
				value="${user.pageInfo.pageIndex}" /> <input type="hidden"
				id="groupId" name="groupId" value="${user.groupId}" /> <input
				type="hidden" name="markUserfrom" id="markUserfrom"
				value="${user.markUserfrom}" />
		</form>
		<table class="table table-bordered table-striped table-hover"
			style="margin-top: -4px;">
			<thead>
				<tr class=" alert-info">
					<th>来源</th>
					<th>用户编号</th>
					<c:if test="${user.groupId==4}">
						<th>品牌</th>
					</c:if>
					<th>用户名</th>
					<th>邮箱</th>
					<th>电话</th>
					<!-- 	<th>用户角色</th> -->
					<th>真实姓名</th>
					<c:if test="${user.groupId==4}">
						<th>状态</th>
					</c:if>
					<th>所在地</th>

					<th colspan="3">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="user" varStatus="i">
					<tr>
						<c:choose>
							<c:when test="${user.wxOpenid==null}">
								<td>平台</td>
							</c:when>
							<c:when test="${user.wxOpenid!=null}">
								<td>微信</td>
							</c:when>
						</c:choose>

						<td>${user.uid}</td>
						<c:if test="${user.groupId==4}">

							<td>${user.dBrand}</td>
						</c:if>
						<td>${user.username}</td>
						<td>${user.email}</td>
						<td>${user.phone}</td>
						<!-- 	<c:choose>
							<c:when test="${user.groupId==1}">
								<td>普通用户</td>
							</c:when>
							<c:when test="${user.groupId==2}">
								<td>管理员</td>
							</c:when>
							<c:when test="${user.groupId==3}">
								<td>供应商</td>
							</c:when>
							<c:when test="${user.groupId==4}">
								<td>签约设计师</td>
							</c:when>
							<c:otherwise>
								<td>不明</td>
							</c:otherwise>
						</c:choose> -->
						<td>${user.realname}</td>
						<c:if test="${user.groupId==4}">
							<c:choose>
								<c:when test="${user.studioStatus==1}">
									<td>申请中</td>
								</c:when>
								<c:when test="${user.studioStatus==2}">
									<td>已签约</td>
								</c:when>
								<c:when test="${user.studioStatus==3}">
									<td>未签约</td>
								</c:when>
								<c:when test="${user.studioStatus==4}">
									<td>未通过</td>
								</c:when>
								<c:otherwise>
									<td>无</td>
								</c:otherwise>
							</c:choose>
						</c:if>
						<td>${user.dAddress}</td>
						<td colspan="3"><c:choose>
								<c:when test="${user.groupId!=4 }">
									<a href="javascript:userManage(3,${user.uid},0);"
										style="color: blue;">查看</a>
									<a href="javascript:userManage(2,${user.uid},0);"
										style="color: blue;">编辑</a>
									<a href="javascript:userDel(${user.uid});" style="color: blue;">删除</a>
								</c:when>
								<c:when test="${user.groupId==4}">
									<a
										href="javascript:userManage(3,${user.uid},${user.studioStatus});"
										style="color: blue;">查看</a>
									<c:if test="${user.studioStatus!=1}">
										<a href="javascript:userManage(2,${user.uid},0);"
											style="color: blue;">编辑</a>
										<a href="javascript:userDel(${user.uid});"
											style="color: blue;">删除</a>
									</c:if>
									<c:if test="${user.studioStatus==1}">
										<a href="javascript:checkPass(${user.uid});"
											style="color: blue;">审核</a>
									</c:if>
								</c:when>

							</c:choose></td>

					</tr>
				</c:forEach>
				<c:forEach items="${designerApplyList}" var="designerApply"
					varStatus="i">
					<tr>
						<c:choose>
							<c:when test="${user.wxOpenid==null}">
								<td>平台</td>
							</c:when>
							<c:when test="${user.wxOpenid!=null}">
								<td>微信</td>
							</c:when>
						</c:choose>

						<td>${designerApply.uid}</td>
						<td>${designerApply.applydUsername}</td>
						<td>${designerApply.applydEmail}</td>
						<td>${designerApply.phone}</td>
						<!-- <c:choose>
							<c:when test="${user.groupId==1}">
								<td>普通用户</td>
							</c:when>
							<c:when test="${user.groupId==2}">
								<td>管理员</td>
							</c:when>
							<c:when test="${user.groupId==3}">
								<td>供应商</td>
							</c:when>
							<c:when test="${user.groupId==4}">
								<td>签约设计师</td>
							</c:when>
							<c:otherwise>
								<td>不明</td>
							</c:otherwise>
						</c:choose> -->
						<td>${designerApply.realname}</td>
						<td>申请中</td>
						<td>${designerApply.applydAddress}</td>
						<td></td>
						<td colspan="3"><c:choose>
								<c:when test="${user.groupId!=4 }">
									<a href="javascript:userManage(3,${user.uid},0);"
										style="color: blue;">查看</a>
									<a href="javascript:userManage(2,${user.uid},0);"
										style="color: blue;">编辑</a>
									<a href="javascript:userDel(${user.uid});" style="color: blue;">删除</a>
								</c:when>
								<c:when test="${user.groupId==4}">
									<a
										href="javascript:userManage(3,${user.uid},${user.studioStatus});"
										style="color: blue;">查看</a>
									<c:if test="${user.studioStatus!=1}">
										<a href="javascript:userManage(2,${user.uid},0);"
											style="color: blue;">编辑</a>
										<a href="javascript:userDel(${user.uid});"
											style="color: blue;">删除</a>
									</c:if>
									<c:if test="${user.studioStatus==1}">
										<a href="javascript:checkPass(${user.uid});"
											style="color: blue;">审核</a>
									</c:if>
								</c:when>

							</c:choose></td>

					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="page-paging2 " style="margin-left: 15px;">
		<!-- 分页 -->
		<c:set value="${user.pageInfo}" var="pageInfo"></c:set>
		<%@include file="../template/pageTemplate.jsp"%>
	</div>



</body>
</html>