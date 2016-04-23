$(function(){
	
	$(".xuanze_div2_img1").click(function(){
		//alert(1)
		$(".xuanze_div2_img1").css({"display":"block"})
		$(".xuanze_div2_img2").css({"display":"none"})
		
		$(this).css({"display":"none"})
		$(this).parent().children("img.xuanze_div2_img2").css({"display":"block"})
		
	})
	$(".xuanze_div2_img2").click(function(){
		//alert(2)
		$(this).css({"display":"none"})
		$(this).parent().children("img.xuanze_div2_img1").css({"display":"block"})
		
	})
	$(".xuanze_div3_img1").click(function(){
		$(this).parent().parent().css({"display":"none"})
	})
	
	
})
