$(function(){
	$(".shejishi_div_div1_div3_div1").hover(function(){
		$(this).children("div.shejishi_div_div1_div3_div1_div1").fadeIn()
	},function(){
		$(this).children("div.shejishi_div_div1_div3_div1_div1").fadeOut()
	})
})
