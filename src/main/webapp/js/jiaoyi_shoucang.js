$(function(){
	$(".shoucang_right_div1_sp5").click(function(){
		
		if($(".shoucang_right_div1_sp4").css("display")=="none"){
			$(".shoucang_right_div1_sp3").css({"display":"inline-block"})
			$(".shoucang_right_div1_sp3tong").removeClass().addClass("shoucang_right_div1_sp3")
			$(".shoucang_right_div1_sp4").css({"display":"inline-block"})
			$(".shoucang_right_div1_sp5").css({"marginRight":"10px"})
			$(".shoucang_right_div1_sp5").html("取消处理")
			$(".shoucang_right_div2_dl_img2").css({"display":"block"})
			$(".shoucang_right_div2_dl_div2").css({"display":"none"})
		}else{
			
			$(".shoucang_right_div1_sp3tong").removeClass().addClass("shoucang_right_div1_sp3")
			$(".shoucang_right_div1_sp3").css({"display":"none"})
			$(".shoucang_right_div1_sp4").css({"display":"none"})
			$(".shoucang_right_div1_sp5").css({"marginRight":"580px"})
			$(".shoucang_right_div1_sp5").html("批量处理")
			$(".shoucang_right_div2_dl_img2").css({"display":"none"})
			$(".shoucang_right_div2_dl_img1").css({"display":"none"})
			
		}
		//shoucang_right_div2_dl_img1
	})
	$(".shoucang_right_div2_dl_img2").click(function(){
		$(this).parent().children("img.shoucang_right_div2_dl_img1").css({"display":"block"})
		$(this).css({"display":"none"})
		var index=0;
		var $shoucang_right_div2_dl_img2Length=$(".shoucang_right_div2_dl_img2").length
		$(".shoucang_right_div2_dl_img2").each(function(){
			if($(this).css("display")=="none"){
				index++;
				if(index==$shoucang_right_div2_dl_img2Length){
					$(".shoucang_right_div1_sp3").removeClass().addClass("shoucang_right_div1_sp3tong")
				}
				
			}
			
		})
	})
	$(".shoucang_right_div2_dl_img1").click(function(){
		$(this).parent().children("img.shoucang_right_div2_dl_img2").css({"display":"block"})
		$(this).css({"display":"none"})
		$(".shoucang_right_div2_dl_img1").each(function(){
			if($(this).css("display")=="none"){
				$(".shoucang_right_div1_sp3tong").removeClass().addClass("shoucang_right_div1_sp3")
			}
		})
	})
	$(".shoucang_right_div1_sp3").click(function(){
		if($(".shoucang_right_div2_dl_img1").css("display")=="block"){
			$(".shoucang_right_div2_dl_img1").css({"display":"none"})
			$(".shoucang_right_div2_dl_img2").css({"display":"block"})
			$(".shoucang_right_div1_sp3tong").removeClass().addClass("shoucang_right_div1_sp3")
			
		}else{
			$(".shoucang_right_div2_dl_img2").css({"display":"none"})
			$(".shoucang_right_div2_dl_img1").css({"display":"block"})
			$(".shoucang_right_div1_sp3").removeClass().addClass("shoucang_right_div1_sp3tong")
		}
	})

	
	$(".shoucang_right_div2_dl_dd").hover(function(){
		if($(this).children("div.shoucang_right_div2_dl_div2").css("display")=="none"){
			if($(this).children("img.shoucang_right_div2_dl_img2").css("display")=="none"){
				if($(this).children("img.shoucang_right_div2_dl_img1").css("display")=="none"){
					$(this).children("div.shoucang_right_div2_dl_div1").css({"display":"block"})
				}
			}
			
		}
		
	},function(){
		$(this).children("div.shoucang_right_div2_dl_div1").css({"display":"none"})
	})
	$(".shoucang_right_div2_dl_div1_img1").click(function(){
		$(this).parent().parent().children("div.shoucang_right_div2_dl_div2").css({"display":"block"})
		$(this).parent().css({"display":"none"})
	})
	$(".shoucang_right_div2_dl_div2_p2_sp2").click(function(){
		$(this).parent().parent().css({"display":"none"})
		
	})
	
	
	$(".shoucang_right_div2_dl_div2_p2_sp1").click(function(){
		$(this).parent().parent().parent().parent().css({"display":"none"})
	})
	//删除功能，隐藏选中删除信息
//	$(".shoucang_right_div1_sp4").click(function(){
//		
//		$(".shoucang_right_div2_dl_img1").each(function(){
//			if($(this).css("display")=="block"){
//				$(this).parent().parent().css({"display":"none"})
//			}
//		})
////		if($(".shoucang_right_div2_dl_img1").css("display")=="block"){
////			
////		}
//	})
	
//	$(".shoucang_right_div1_sp3").hover(function(){
//		//if()
//		$(".shoucang_right_div1_sp3").css({"color":"#00debd","background":"url(img/075.gif) no-repeat"})
//	},function(){
//		$(".shoucang_right_div1_sp3").css({"color":"#000","background":"url(img/046.gif) no-repeat"})
//	})
//	$(".shoucang_right_div1_sp4").hover(function(){
//		$(".shoucang_right_div1_sp4").css({"color":"#00debd","background":"url(img/076.gif) no-repeat"})
//	},function(){
//		$(".shoucang_right_div1_sp4").css({"color":"#000","background":"url(img/047.gif) no-repeat"})
//	})
	
	//shoucang_right_div1_sp3tong
//	$(".shoucang_right_div2_dl_div2_p2_sp2").hover(function(){
//		$(this).css({"color":"#00f"})
//	},function(){
//		$(this).css({"color":"#fff"})
//	})
//	$(".shoucang_right_div2_dl_div2_p2_sp1").hover(function(){
//		$(this).css({"color":"#00f"})
//	},function(){
//		$(this).css({"color":"#fff"})
//	})
})







