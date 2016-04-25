<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<body>

	<!--
        	作者：offline
        	时间：2015-12-02
        	描述：文字链接
        -->
	<footer class="foot">
		<div class="foot_div">
			<div class="foot_top">
				<ul class="foot_ul_one left">
					<li class="lastLi"><a href="#" onclick="gotoLastPage(1)">关于我们</a></li>
					<li><a href="#" onclick="gotoLastPage(1)">公司介绍</a></li>
					<li><a href="#">团队介绍</a></li>
				</ul>
				<ul class="foot_ul_two left">
					<li class="lastLi"><a href="#" onclick="gotoLastPage(2)">加入我们</a></li>
					<li><a href="#">招聘信息</a></li>
				</ul>
				<ul class="foot_ul_three left">
					<li class="lastLi"><a href="#" onclick="gotoLastPage(3)">品牌合作</a></li>
					<li><a href="#" onclick="gotoLastPage(3)">已合作品牌</a></li>
					<li><a href="#">友情链接</a></li>
					<li><a href="#">合作热线</a></li>
				</ul>
				<ul class="foot_ul_four left">
					<li class="lastLi"><a href="#" onclick="gotoLastPage(4)">帮助中心</a></li>
					<li><a href="#" onclick="gotoLastPage(4)">购物流程</a></li>
					<li><a href="#" onclick="gotoLastPage(4)">支付方式</a></li>
					<li><a href="#" onclick="gotoLastPage(4)">产品配送</a></li>
					<li><a href="#" onclick="gotoLastPage(4)">在线客服</a></li>
					<li><a href="#">定制流程</a></li>
				</ul>
				<div class="foot_div_one left">
					<div class="outside_border">
						<div class="inside_border">
							<p class="p1">3D CREATIA</p>
							<p>为创造而生</p>
							<p>订制你的生活</p>
							<p>爱体验网，专属于你的生活方式</p>
							<p>WHAT YOU WANT</p>
							<p>WHAT I CREATE</p>
						</div>
					</div>
					<img class="telephone"
						src="<%=request.getContextPath()%>/images/pc/066.gif" />
				</div>
				<div class="foot_bottom">
					<p>Copyright&copy;北京云帆互联科技有限公司  2015-2016 All Rights Reserved.网站备案:京ICP备16006346号</p>
				</div>
			</div>
		</div>
	</footer>
</body>
<script type="text/javascript">
	//去底部页面
	function gotoLastPage(type) {
		window.location.href = "<%=request.getContextPath()%>/turncenterController/turnBottom.do?markerPage="
				+ type;
	}
</script>
</html>