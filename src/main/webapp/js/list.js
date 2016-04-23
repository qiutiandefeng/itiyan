$(function(){
	$li1=$(".showright_nav_price");
	$ul1=$(".showright_nav_ulprice");
	$li1.hover(function(){
		$ul1.fadeIn(300)
		
	},function(){ 
		$ul1.fadeOut(300)
		
	})
	
	$ul1.hover(function(){
		$ul1.stop().fadeIn(300)
		
	},function(){
		$ul1.fadeOut(300)
		
	})
	
	
	//二级菜单写在一级菜单内然后 $(一级菜单).children(二级菜单).show
	$(".dianji").click(function(){
		if($(this).children("img.img1").css("display")=="block"){
			$(this).children("img.img1").css({"display":"none"})
			$(this).children("img.img2").css({"display":"block"})
			$(this).parent().children("li.leftNav_ul1_lis").stop().animate({"height":"26px"},200)
		}else{
			$(this).children("img.img1").css({"display":"block"})
			$(this).children("img.img2").css({"display":"none"})
			$(this).parent().children("li.leftNav_ul1_lis").stop().animate({"height":"0px"},200)
		}
	})
})
