$(function(){
	$(".sheji_dl_dt").hover(function(){
		$(this).children("div.sheji_dl_dt_div1").fadeIn()
	},function(){
		$(this).children("div.sheji_dl_dt_div1").fadeOut()
	})
})
