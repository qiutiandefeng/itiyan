<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/global.js"></script>

<input type="hidden" id="currentPageNum" name="currentPageNum" value="${pageInfo.pageIndex}">
<input type="hidden" id="currentPageRec" name="currentPageRec" value="${pageInfo.currentPageRec}">
<input type="hidden" id="totalPage" value="${pageInfo.totalPage}"/>
<div id="pager" class="page-paging">
	<ul>
		<li><a href="javascript:to_page('1')">首页</a></li>
    	
		<c:choose>
			<c:when test="${pageInfo.pageIndex==1}">
				<li><a
					onmouseout="this.style.backgroundColor='white';this.style.color='black'"><img
						src="<%=request.getContextPath()%>/images/pre_13.jpg" /> </a></li>
			</c:when>
			<c:otherwise>
			<li>
				<a href="javascript:to_page('${pageInfo.prePage}')"><img
					src="<%=request.getContextPath()%>/images/pre_13.jpg" /> </a></li>
			</c:otherwise>
		</c:choose>

		<c:if test="${(pageInfo.pageIndex - pageInfo.signSize)>1}">
			<li class="page-paging_ul_li1"><a href="javascript:to_page('1')">1</a></li>
			<li><span><a title="更多">...</a> </span></li>
		</c:if>

		<c:forEach items="${pageInfo.pageNumbers}" var="num">
			<c:choose>
				<c:when test="${num != pageInfo.pageIndex}">
					<li><span><a href="javascript:to_page('${num}')">${num}</a>
					</span></li>
				</c:when>
				<c:otherwise>
					<li><strong><span class="current">${num}</span></strong></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:if
			test="${(pageInfo.pageIndex + pageInfo.signSize) < pageInfo.totalPage}">
			<li><span><a title="更多">...</a> </span></li>
			<li><span><a
					href="javascript:to_page('${pageInfo.totalPage}')">${pageInfo.totalPage}</a>
			</span></li>
		</c:if>

		<c:choose>
			<c:when test="${pageInfo.pageIndex == pageInfo.totalPage}">
				<li><a
					onmouseout="this.style.backgroundColor='white';this.style.color='black'"><img
						src="<%=request.getContextPath()%>/images/next_16.jpg" /> </a></li>
			</c:when>
			<c:otherwise>
				<li><a href="javascript:to_page('${pageInfo.nextPage}')"><img
						src="<%=request.getContextPath()%>/images/next_16.jpg" /> </a></li>
			</c:otherwise>
		</c:choose>
		<li><a href="javascript:to_page('${pageInfo.totalPage}')">末页</a></li>
		<li class="page_list_input"><input class="page_list_input_1" type="text" id="page_go" /></li>
		<li class="page_list_btn"><button onclick="return page_go()">go</button></li>
	</ul>
</div>

