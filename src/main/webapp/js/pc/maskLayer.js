$(function(){
	
	var $numIndex=$(".morNav li").length
	$(".morNav").css({"width":$numIndex*140+"px"});
	
	
	var $dtts=$(".dtt");
	var $layers=$(".layer");
	$dtts.hover(function(){
		$(this).children("div.layer").fadeIn()
	},function(){
		$(this).children("div.layer").fadeOut()
	})
	
	
	
	

	var $mornav_lis=$(".morNav li");
	$mornav_lis.mouseover(function(){
		$(this).find("a").addClass("initialize");
		$(this).siblings("li").find("a").removeClass("initialize")
	})
	var $li1s=$(".li1");
	$mornav_lis.click(function(){
		
		var index=$(this).index();
		
		$li1s.css({"display":"none"});
		$li1s.eq(index).css({"display":"block"})
	})
	
	
	
	
	
	
	var $divs=$(".designer_ul li");
	
	$divs.hover(function(){
		$(this).children("div.designer_ul_li_div").fadeIn(300)
	},function(){
		$(this).children("div.designer_ul_li_div").fadeOut(300)
	}) 
	
	 
	recommended_a();
	//本周推荐
	function recommended_a(){
		var $ours=$(".recommended_div_");
		$ours.hover(function(){
			$(this).children("div.oursss").fadeIn();
			
			},function(){
			$(this).children("div.oursss").fadeOut();
			
		})
	}
	
	//滑动显示
	$(".nav_right_li2").hover(function(){
		$(".showright_nav_ulprice").fadeIn(300)
	},function(){
		$(".showright_nav_ulprice").fadeOut(300)
	})
})


