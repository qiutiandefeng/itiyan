$(function(){
	//点击一个选中一个
	$(".cart_center_div1_div2_ul1_li1_img1").click(function(){
		$(this).css({"display":"none"})
		var index=0;
		var index1=0;
		$(this).parent().children("img.cart_center_div1_div2_ul1_li1_img2").css({"display":"block"})
		$(this).parent().parent().parent().children("ul.cart_center_div1_div2_ul1").children("li.cart_center_div1_div2_ul1_li1").children("img.cart_center_div1_div2_ul1_li1_img1").each(function(){
			
			if($(this).css("display")=="none"){
				index++;
				if(index==$(this).parent().parent().parent().children("ul.cart_center_div1_div2_ul1").children("li.cart_center_div1_div2_ul1_li1").children("img.cart_center_div1_div2_ul1_li1_img1").length){
					$(this).parent().parent().parent().parent().children("div.cart_center_div1_div1").children("img.cart_center_div1_div1_img1").css({"display":"none"})
					$(this).parent().parent().parent().parent().children("div.cart_center_div1_div1").children("img.cart_center_div1_div1_img2").css({"display":"block"})
				}
			}
		})
		$(".cart_center_div1_div2_ul1_li1_img1").each(function(){
			if($(this).css("display")=="none"){
				index1++;
				
				if(index1==$(".cart_center_div1_div2_ul1_li1_img1").length){
					$(".cartcon1_img1").css({"display":"none"})
					$(".cartcon1_img2").css({"display":"block"})
					$(".cartb1_conte_img1").css({"display":"none"})
					$(".cartb1_conte_img2").css({"display":"block"})
				}
				
			}
		})
		//设置已经选中的商品数量
		$("#selected_model").text(getCount());
		//设置商品总计金额
		$("#totalPrice").text(getTotalPrice());
	})
	$(".cart_center_div1_div2_ul1_li1_img2").click(function(){
		$(this).css({"display":"none"})
		$(this).parent().children("img.cart_center_div1_div2_ul1_li1_img1").css({"display":"block"})
		$(".cart_center_div1_div2_ul1_li1_img1").each(function(){
			if($(this).css("display")=="block"){
				$(".cartb1_conte_img1").css({"display":"block"})
				$(".cartb1_conte_img2").css({"display":"none"})
				$(".cartcon1_img1").css({"display":"block"})
				$(".cartcon1_img2").css({"display":"none"})
				$(this).parent().parent().parent().parent().children("div.cart_center_div1_div1").children("img.cart_center_div1_div1_img1").css({"display":"block"})
				$(this).parent().parent().parent().parent().children("div.cart_center_div1_div1").children("img.cart_center_div1_div1_img2").css({"display":"none"})
			}
		})
		//设置已经选中的商品数量
		$("#selected_model").text(getCount());
		//设置商品总计金额
		$("#totalPrice").text(getTotalPrice());
	})
	//点击一个选中当前所有子元素
	$(".cart_center_div1_div1_img1").click(function(){
		$(this).css({"display":"none"})
		$(this).parent().children("img.cart_center_div1_div1_img2").css({"display":"block"})
		$(this).parent().parent().children("div.cart_center_div1_div2").children("ul.cart_center_div1_div2_ul1").children("li.cart_center_div1_div2_ul1_li1").children("img.cart_center_div1_div2_ul1_li1_img1").css({"display":"none"})
		$(this).parent().parent().children("div.cart_center_div1_div2").children("ul.cart_center_div1_div2_ul1").children("li.cart_center_div1_div2_ul1_li1").children("img.cart_center_div1_div2_ul1_li1_img2").css({"display":"block"})
		var index2=0;
		$(".cart_center_div1_div1_img1").each(function(){
			if($(this).css("display")=="none"){
				index2++;
				if(index2==$(".cart_center_div1_div1_img1").length){
					$(".cartcon1_img1").css({"display":"none"})
					$(".cartcon1_img2").css({"display":"block"})
					$(".cartb1_conte_img1").css({"display":"none"})
					$(".cartb1_conte_img2").css({"display":"block"})
				}
			}
		})
		//设置已经选中的商品数量
		$("#selected_model").text(getCount());
		//设置商品总计金额
		$("#totalPrice").text(getTotalPrice());
	})
	$(".cart_center_div1_div1_img2").click(function(){
		$(this).css({"display":"none"})
		$(this).parent().children("img.cart_center_div1_div1_img1").css({"display":"block"})
		$(this).parent().parent().children("div.cart_center_div1_div2").children("ul.cart_center_div1_div2_ul1").children("li.cart_center_div1_div2_ul1_li1").children("img.cart_center_div1_div2_ul1_li1_img2").css({"display":"none"})
		$(this).parent().parent().children("div.cart_center_div1_div2").children("ul.cart_center_div1_div2_ul1").children("li.cart_center_div1_div2_ul1_li1").children("img.cart_center_div1_div2_ul1_li1_img1").css({"display":"block"})
		$(".cartcon1_img2").css({"display":"none"})
		$(".cartcon1_img1").css({"display":"block"})
		$(".cartb1_conte_img2").css({"display":"none"})
		$(".cartb1_conte_img1").css({"display":"block"})
		//设置已经选中的商品数量
		$("#selected_model").text(getCount());
		//设置商品总计金额
		$("#totalPrice").text(getTotalPrice());
	})
	//点击一个所有子元素选中
	$(".cartcon1_img1").click(function(){
		$(this).css({"display":"none"})
		$(this).parent().children("img.cartcon1_img2").css({"display":"block"})
		$(".cart_center_div1_div1_img2").css({"display":"block"})
		$(".cart_center_div1_div1_img1").css({"display":"none"})
		$(".cart_center_div1_div2_ul1_li1_img2").css({"display":"block"})
		$(".cart_center_div1_div2_ul1_li1_img1").css({"display":"none"})
		$(".cartb1_conte_img1").css({"display":"none"})
		$(".cartb1_conte_img2").css({"display":"block"})
		//设置已经选中的商品数量
		$("#selected_model").text(getCount());
		//设置商品总计金额
		$("#totalPrice").text(getTotalPrice());
	})
	$(".cartcon1_img2").click(function(){
		$(this).css({"display":"none"})
		$(this).parent().children("img.cartcon1_img1").css({"display":"block"})
		$(".cart_center_div1_div1_img1").css({"display":"block"})
		$(".cart_center_div1_div1_img2").css({"display":"none"})
		$(".cart_center_div1_div2_ul1_li1_img1").css({"display":"block"})
		$(".cart_center_div1_div2_ul1_li1_img2").css({"display":"none"})
		$(".cartb1_conte_img2").css({"display":"none"})
		$(".cartb1_conte_img1").css({"display":"block"})
		//设置已经选中的商品数量
		$("#selected_model").text(getCount());
		//设置商品总计金额
		$("#totalPrice").text(getTotalPrice());
	})
	$(".cartb1_conte_img1").click(function(){
		$(this).css({"display":"none"})
		$(this).parent().children("img.cartb1_conte_img2").css({"display":"block"})
		$(".cart_center_div1_div1_img2").css({"display":"block"})
		$(".cart_center_div1_div1_img1").css({"display":"none"})
		$(".cart_center_div1_div2_ul1_li1_img2").css({"display":"block"})
		$(".cart_center_div1_div2_ul1_li1_img1").css({"display":"none"})
		$(".cartcon1_img1").css({"display":"none"})
		$(".cartcon1_img2").css({"display":"block"})
		//设置已经选中的商品数量
		$("#selected_model").text(getCount());
		//设置商品总计金额
		$("#totalPrice").text(getTotalPrice());
	})
	$(".cartb1_conte_img2").click(function(){
		$(this).css({"display":"none"})
		$(this).parent().children("img.cartb1_conte_img1").css({"display":"block"})
		$(".cart_center_div1_div1_img1").css({"display":"block"})
		$(".cart_center_div1_div1_img2").css({"display":"none"})
		$(".cart_center_div1_div2_ul1_li1_img1").css({"display":"block"})
		$(".cart_center_div1_div2_ul1_li1_img2").css({"display":"none"})
		$(".cartcon1_img2").css({"display":"none"})
		$(".cartcon1_img1").css({"display":"block"})
		//设置已经选中的商品数量
		$("#selected_model").text(getCount());
		//设置商品总计金额
		$("#totalPrice").text(getTotalPrice());
	})
	//统计已经选中的商品数
	function getCount(){
		var selected = document.getElementsByName("selected");      
		var count=0;
		 for(var i=0;i<selected.length;i++){ 
	            if(selected[i].style.display=="block"){ 
	               count=count+1;
	            } 
	        } 
		return count;
	}
	
	
	
	
	
	
	
	
	
	
})
