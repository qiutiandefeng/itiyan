$(function(){
	
	
	
	
	$(".motai_div1_div2_ul1_li_p").click(function(){
		if($(this).parent().children("ul.motai_div1_div2_ul1_li_ul").css("display")=="none"){
			$(this).parent().children(".motai_div1_div2_ul1_li_ul").animate({height:"show"});
		}else{
			$(this).parent().children(".motai_div1_div2_ul1_li_ul").animate({height:"hide"});
		}
	})
	$(".img1").click(function(){
		$(".motai").fadeIn("fast",callback1);
		
	})
	function callback1(){
		$(".motai_div1").animate({left:"0%"})
	}
	$(".motai").click(function(){
		$(".motai_div1").animate({left:"-70%"})
		$(".motai").fadeOut();
		
	})
	
	$(".motai_div1").click(function(e){
		e=window.event||e;
		if(e.stopPropagation){
			e.stopPropagation();
		}else{
			e.cancelBubble=true;
		}
	})
})
