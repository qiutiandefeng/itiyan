$(function(){
	//alert($)
	//(".orders_div2_ul1_li4")
	$(".orders_div2_ul1").children("li.orders_div2_ul1_li4").children("a.orders_div2_ul1_li4_a1").css({"fontSize":"0px"})
	$(".orders_div2_ul1").each(function(){//alert(1);
	//alert($(this).children("li.orders_div2_ul1_li4").children("a.orders_div2_ul1_li4_a1").html());
		if($(this).children("li.orders_div2_ul1_li4").children("a.orders_div2_ul1_li4_a1").html()=="  默认地址"){
			//alert(2);
			$(this).css({"background":"#f0f0f0","border":"1px dashed #ccc","borderLeft":"0"})
			$(this).children("li.orders_div2_ul1_li4").children("a.orders_div2_ul1_li4_a1").css({"fontSize":"0px"})
			$(this).children("li.orders_div2_ul1_li4").children("a.orders_div2_ul1_li4_a1").css({"fontSize":"12px"})
			$(this).children("li.orders_div2_ul1_li1").children("img.orders_div2_ul1_li1_img1").css({"display":"none"})
			$(this).children("li.orders_div2_ul1_li1").children("img.orders_div2_ul1_li1_img2").css({"display":"block"})
		}else{
			//alert(3);
			}
	})
	
//	$(".orders_div2_ul1").eq(0).css({"background":"#f0f0f0","border":"1px dashed #ccc","borderLeft":"0"})
//	$(".orders_div2_ul1").children("li.orders_div2_ul1_li4").children("a.orders_div2_ul1_li4_a1").css({"fontSize":"0px"})
//	$(".orders_div2_ul1").eq(0).children("li.orders_div2_ul1_li4").children("a.orders_div2_ul1_li4_a1").css({"fontSize":"12px"})
//	$(".orders_div2_ul1").eq(0).children("li.orders_div2_ul1_li4").children("a.orders_div2_ul1_li4_a1").html("默认地址")
//	$(".orders_div2_ul1").eq(0).children("li.orders_div2_ul1_li1").children("img.orders_div2_ul1_li1_img1").css({"display":"none"})
//	$(".orders_div2_ul1").eq(0).children("li.orders_div2_ul1_li1").children("img.orders_div2_ul1_li1_img2").css({"display":"block"})
//	
	$(".orders_div2_ul1").hover(function(){
		$(this).css({"background":"#f0f0f0"})
		$(this).children("li.orders_div2_ul1_li4").children("a.orders_div2_ul1_li4_a1").css({"fontSize":"12px"})
	},function(){
		if($(this).children("li.orders_div2_ul1_li1").children("img.orders_div2_ul1_li1_img1").css("display")=="block"){
			$(this).css({"background":"#fff"})
			$(this).children("li.orders_div2_ul1_li4").children("a.orders_div2_ul1_li4_a1").css({"fontSize":"0px"})
			
		}
		
	})
	$(".orders_div2_ul1").click(function(){
		$(".orders_div2_ul1").css({"background":"#fff","border":"0"})
		$(".orders_div2_ul1").children("li.orders_div2_ul1_li4").children("a.orders_div2_ul1_li4_a1").css({"fontSize":"0px"})
		$(this).css({"background":"#f0f0f0","border":"1px dashed #ccc","borderLeft":"0"})
		$(this).children("li.orders_div2_ul1_li4").children("a.orders_div2_ul1_li4_a1").css({"fontSize":"12px"})
		$(".orders_div2_ul1").children("li.orders_div2_ul1_li1").children("img.orders_div2_ul1_li1_img2").css({"display":"none"})
		$(".orders_div2_ul1").children("li.orders_div2_ul1_li1").children("img.orders_div2_ul1_li1_img1").css({"display":"block"})
		$(this).children("li.orders_div2_ul1_li1").children("img.orders_div2_ul1_li1_img1").css({"display":"none"})
		$(this).children("li.orders_div2_ul1_li1").children("img.orders_div2_ul1_li1_img2").css({"display":"block"})
	})
//	 
//	var $index
//	$(".orders_div4_div1_div1_div3_btn1").click(function(){
//		$index=$(this).parent().children("span.orders_div4_div1_div1_div3_sp1").html()
//		$index--;
//		if($index<1){
//			$index=1;
//			
//		}
//		$(this).parent().children("span.orders_div4_div1_div1_div3_sp1").html($index)
//	})
//	$(".orders_div4_div1_div1_div3_btn2").click(function(){
//		$index=$(this).parent().children("span.orders_div4_div1_div1_div3_sp1").html()
//		$index++;
//		$(this).parent().children("span.orders_div4_div1_div1_div3_sp1").html($index)
//		
//		
//	})
//	
	$(".orders_div4_div1_div2_div1_in1").keyup(function(){
		//alert(1)
		var $num1=[]
		$num1=$(this).val()
		//alert($num1.length)
		var i;
		i=50-parseInt($num1.length)
		$(this).parent().children("span.orders_div4_div1_div2_div1_sp1").children("span.orders_div4_div1_div2_div1_sp1_sp1").html(i)
	})
	
	 
	$(".orders_div2_ul1_li5_a1").click(function(e){
						e=window.event||e;
						if(e.stopPropagation){
							e.stopPropagation();
						}else{
							e.cancelBubble=true;
						}
					})
	 
	$(".shouhuo_motai_div1_img1").click(function(){
		$(".shouhuo_motai").css({"display":"none"})
		$(".shouhuo_motai_div1").css({"display":"none"})
	})
	
	$(".orders_div7_div1_a1").click(function(){
		if($(".orders_div7_div1_div1").css("display")=="block"){
			$(".orders_div7_div1_div1").css({"display":"none"});
		}else{
			$(".orders_div7_div1_div1").css({"display":"block"});
		}
		
	})
	
})
