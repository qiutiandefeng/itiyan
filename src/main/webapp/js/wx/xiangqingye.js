$(function(){
	//alert(1)
	//banner的自动轮播方式方向速度循环模式
	var mySwiper=new Swiper('.swiper-container',{
		autoplay:2000,
		loop:true,
		autoplayDisableOnInteraction : false,
		pagination:'.swiper-pagination',
	})
	//banner的下标计算实际宽度居中位置
	var $index=$(".banner_divs span").length;
	$(".banner_divs").css({"width":""+$index*20+"px"}) 
	
	$(".show_div5_div1_div1").click(function(){
		
	})
	//tab切换
	
	$(".show_div5_div1_div2").click(function(){
		$(".show_div5_div1_div2").css({"color":"#00DEBD"})
		
		$(".show_div5_div1_div3").css({"color":"#111"})
		$(".show_div5_div2").css({"display":"none"})
		$(".show_div5_div3").css({"display":"block"})
		$(".show_div5_div4").css({"display":"none"})
		$(".show_div5_p1").css({"display":"none"})
		$(".twoPx").removeClass("twoPxRight").addClass("twoPxLeft")
		
	})
	$(".show_div5_div1_div3").click(function(){
		$(".show_div5_div1_div3").css({"color":"#00DEBD"})
		$(".show_div5_div1_div2").css({"color":"#111"})
		$(".show_div5_div2").css({"display":"none"})
		$(".show_div5_div3").css({"display":"none"})
		$(".show_div5_div4").css({"display":"block"})
		$(".show_div5_p1").css({"display":"none"})
		$(".twoPx").removeClass("twoPxLeft").addClass("twoPxRight")
		
	})
	$(".show_div2_a1").click(function(){
		$("div").addClass("bodys")
		$(".motai_div1").css({"display":"block"})
		$(".motai_div1").removeClass("bodys")
		$(".mohu").css({"display":"block"})
		$(".mohu").removeClass("bodys")
		$(".imgTop").css({"display":"none"})
	})
	$(".show_div5_div3_p5_a1").click(function(){
		$("div").addClass("bodys")
		$(".motai_div2").css({"display":"block"})
		$(".motai_div2").removeClass("bodys")
		$(".mohu").css({"display":"block"})
		$(".mohu").removeClass("bodys")
		$(".imgTop").css({"display":"none"})
	})
	$(".motai_div1_img1").click(function(){
		$(".motai_div1").css({"display":"none"})
		$(".mohu").css({"display":"none"})
		$("div").removeClass("bodys")
		$(".imgTop").css({"display":"block"})
	})
	$(".motai_div2_img1").click(function(){
		$(".motai_div2").css({"display":"none"})
		$(".mohu").css({"display":"none"})
		$("div").removeClass("bodys")
		$(".imgTop").css({"display":"block"})
	})
	$(".show_div7_a2").click(function(){
		$("#mark_type").val(2);
		$(".options").fadeIn(500)
		$(".imgTop").css({"display":"none"})
		$(".options_div1").removeClass("options_div3").addClass("options_div2")
		$(".cars_div1").removeClass("cars_div2").css({"display":"none"})
	})
	$(".show_div7_a1").click(function(){
		$("#mark_type").val(1);
		$(".options").fadeIn(500)
		$(".imgTop").css({"display":"none"})
		$(".options_div1").removeClass("options_div3").addClass("options_div2")
		$(".cars_div1").removeClass("cars_div2").css({"display":"none"})
	})
	$(".options_div1_div2_div2_sp").click(function(){
		$(".options_div1_div2_div2_sp").css({"background":"#F3F3F3","color":"#000"})
		$(this).css({"background":"#000","color":"#fff"})
		$(".options_div1_div2_div2_img").css({"border":"1px solid #fff"})
	})
	$(".options_div1_div2_div2_img").click(function(){
		$(".options_div1_div2_div2_img").css({"border":"1px solid #fff"})
		$(".options_div1_div2_div2_sp").css({"background":"#F3F3F3","color":"#000"})
		$(this).css({"border":"1px solid #000"})
	})
	$(".options_div1_div3_div2_sp").click(function(){
		$(".options_div1_div3_div2_sp").css({"color":"#000","background":"#f4f4f4"})
		$(this).css({"color":"#fff","background":"#000"})
	})
	$(".options_div1_div4_div2_im1").click(function(){
		var $index=$(".options_div1_div4_div2_sp").text();
		$index--;
		if($index<1){
			$index=1;
		}
		$(".options_div1_div4_div2_sp").text($index);
	})
	$(".options_div1_div4_div2_im2").click(function(){
		var $index=$(".options_div1_div4_div2_sp").text();
		$index++;
		$(".options_div1_div4_div2_sp").text($index);
	})
	//阻止上层dom追捕
	$(".options_div1").click(function(e){
		e=window.event||e;
		if(e.stopPropagation){
			e.stopPropagation();
		}else{
			e.cancelBubble=true;
		}
	})
	$(".options").click(function(){
		$(".options").fadeOut(100)
		$(".imgTop").css({"display":"block"})
		$(".options_div1").removeClass("options_div2").addClass("options_div3")
	})
	//回到顶部
	$(".imgTop").click(function(){
		$("html,body").animate({scrollTop: 0},500);
	})
	//
	$(".options_div1_div5").click(function(){
		
//		$(".options_div1").removeClass("options_div2").addClass("options_div3")
//		$(".imgTop").css({"display":"block"})
//		$(".options").fadeOut(100)
//		$(".cars_div1").fadeIn(100)
//		$(".cars_div1").addClass("cars_div2")
	})
	
	//
	$(".cars_div1").click(function(){
		$(".cars_div1").removeClass("cars_div2")
		$(".cars_div1").addClass("cars_div2")
	})
	
	
})