$(function(){
	$(".shouhuo_right_div1").eq(0).css({"border":"3px solid #000"})
	$(".shouhuo_right_div1").eq(0).children("img.shouhuo_right_div1_img1").css({"display":"block"})
	$(".shouhuo_right_div1").eq(0).children("img.shouhuo_right_div1_img2").css({"display":"none"})
	$(".shouhuo_right_div1").eq(0).children("img.shouhuo_right_div1_img3").css({"display":"block"})
	$(".shouhuo_right_div1").eq(0).children("div.shouhuo_right_div1_div3").css({"color":"#000"})
	$(".shouhuo_right_div1").eq(0).children("div.shouhuo_right_div1_div3").children("a.shouhuo_right_div1_div3_sp1").html("默认地址")


	$(".shouhuo_right_div1").click(function(){
		$(".shouhuo_right_div1").css({"border":"3px solid #ccc"})
		$(".shouhuo_right_div1").children("img.shouhuo_right_div1_img1").css({"display":"none"})
		$(".shouhuo_right_div1").children("img.shouhuo_right_div1_img2").css({"display":"block"})
		$(".shouhuo_right_div1").children("img.shouhuo_right_div1_img3").css({"display":"none"})
		$(".shouhuo_right_div1").children("div.shouhuo_right_div1_div3").children().css({"color":"#aaa"})
		//$(".shouhuo_right_div1").children("div.shouhuo_right_div1_div3").children("a.shouhuo_right_div1_div3_sp1").html("设为默认地址")
		$(this).css({"border":"3px solid #000"})
		$(this).children("img.shouhuo_right_div1_img1").css({"display":"block"})
		$(this).children("img.shouhuo_right_div1_img2").css({"display":"none"})
		$(this).children("img.shouhuo_right_div1_img3").css({"display":"block"})
		$(this).children("div.shouhuo_right_div1_div3").children().css({"color":"#000"})
		//$(this).children("div.shouhuo_right_div1_div3").children("a.shouhuo_right_div1_div3_sp1").html("默认地址")
		
	})
	$(".shouhuo_right_div1_div3_sp1").click(function(){
		$(".shouhuo_right_div1_div3_sp1").html("设为默认地址")
		$(this).html("默认地址")
	})
//阻止冒泡	
//	$(".shouhuo_right_div1_div3_sp1").click(function(e){
//		e=window.event||e;
//		if(e.stopPropagation){
//			e.stopPropagation();
//		}else{
//				e.cancelBubble=true;
//			}
//	})
	$(".shouhuo_right_div1").hover(function(){
		if($(this).children("img.shouhuo_right_div1_img3").css("display")=="block"){
			
		}else{
			$(this).children("img.shouhuo_right_div1_img1").css({"display":"block"})
		$(this).children("img.shouhuo_right_div1_img2").css({"display":"none"})
		$(this).css({"border":"3px solid #000"})
		$(this).children("div.shouhuo_right_div1_div3").children().css({"color":"#277DD4"})
		}
		
	},function(){
		if($(this).children("img.shouhuo_right_div1_img3").css("display")=="block"){
			
		}else{
			$(this).children("img.shouhuo_right_div1_img1").css({"display":"none"})
		$(this).children("img.shouhuo_right_div1_img2").css({"display":"block"})
		$(this).css({"border":"3px solid #ccc"})
		$(this).children("div.shouhuo_right_div1_div3").children().css({"color":"#aaa"})
		}
		
	})

	$(".shouhuo_right_div1_div3_sp3").click(function(e){
		e=window.event||e;
		if(e.stopPropagation){
			e.stopPropagation();
		}else{
				e.cancelBubble=true;
			}
	})
	$(".shouhuo_right_div1_div3_sp2").click(function(e){
		e=window.event||e;
		if(e.stopPropagation){
			e.stopPropagation();
		}else{
				e.cancelBubble=true;
			}
	})
	//显示修改收货地址模态框
//	$(".shouhuo_right_div1_div3_sp2").click(function(){
//		alert("234");
//		$(".shouhuo_motai").css({"display":"block"})
//		$(".shouhuo_motai_div1").css({"display":"block"})
//		alert("123");
//	})
	$(".shouhuo_motai_div1_img1").click(function(){
		$(".shouhuo_motai").css({"display":"none"})
		$(".shouhuo_motai_div1").css({"display":"none"})
	})
	
	
	
})
