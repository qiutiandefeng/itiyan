$(function(){
	//alert($)
	$(".denglu_div1_p3_a1").click(function(){//alert(1)
		if($(".denglu_div1_p3_img1").css("display")=="block"){
			$("#remember_pwd").val(1)//记住密码
			//alert(2)
			$(".denglu_div1_p3_img1").css({"display":"none"})
			$(".denglu_div1_p3_img2").css({"display":"block"})
		}else{
			$("#remember_pwd").val(2)//取消记住密码
			//alert(3)
			$(".denglu_div1_p3_img2").css({"display":"none"})
			$(".denglu_div1_p3_img1").css({"display":"block"})
		}
		 
	})
	
//	$(".zhuce_div1_a1").click(function(){
//		
//		if($(".zhuce_div1_img1").css("display")=="block"){
//			
//			$(".zhuce_div1_img1").css({"display":"none"})
//			$(".zhuce_div1_img2").css({"display":"block"})
//		}else{
//			
//			$(".zhuce_div1_img2").css({"display":"none"})
//			$(".zhuce_div1_img1").css({"display":"block"})
//		}
// 	})
	$(".zhuce_div1_img1").click(function(){
		$(".zhuce_div1_img1").css({"display":"none"})
		$(".zhuce_div1_img2").css({"display":"block"})
		$("#agree_message").val(1)
	})
	$(".zhuce_div1_img2").click(function(){
		$(".zhuce_div1_img2").css({"display":"none"})
		$(".zhuce_div1_img1").css({"display":"block"})
		$("#agree_message").val(2)
	})
	
	$(".zhuce_input1").blur(function(){
		checkRegisterName()
		
	})
	$(".zhuce_input2").blur(function(){
		checkRegisterpwd()
	})
	$(".zhuce_input3").blur(function(){
		checkRegisterpwdSame()
	})
	
	$(".denglu_div1_input1").blur(function(){
		var index=$(".denglu_div1_input1").val();
		var index1=/^([a-zA-Z0-9_\.\-]+)@([a-zA-Z0-9_\.\-]+)\.[c]{1}[o]{1}[m]{1}$/;
		var index2=/^[1][3,5,7,8]{1}[0-9]{9}$/;
		if(index.match("@")=="@"){
			//alert("邮箱号")
			if(index1.test(index)){
				$(".denglu_div1_p4_sp1").css({"display":"none"})
				$(".denglu_div1_p4_sp2").css({"display":"none"})
				//alert("真1")
			}else{
				$(".denglu_div1_p4_sp1").css({"display":"none"})
				$(".denglu_div1_p4_sp2").css({"display":"block"})
				//alert("假1")
			}
		}else{
			//alert("手机号")
			if(index2.test(index)){
				$(".denglu_div1_p4_sp1").css({"display":"none"})
				$(".denglu_div1_p4_sp2").css({"display":"none"})
				//alert("真")
			}else{
				$(".denglu_div1_p4_sp1").css({"display":"block"})
				$(".denglu_div1_p4_sp2").css({"display":"none"})
				//alert("假")
			}
		}
	})
	$(".denglu_div1_input2").blur(function(){
		var index=$(".denglu_div1_input2").val()
		var index1=/^[a-zA-Z0-9]{6,20}$/
		if(index1.test(index)){
			$(".denglu_div1_p5 span").css({"display":"none"})
			
			//alert("正确")
		}else{
			$(".denglu_div1_p5 span").css({"display":"block"})
			//alert("错误")
		}
	})

	$(".denglu_div1_p1_zhuanhuan").click(function(){
		$(".denglu").css({"display":"none"})
		$(".zhuce").css({"display":"block"})
	})
	$(".zhuce_p1_zhuanhuan").click(function(){
		$(".denglu").css({"display":"block"})
		$(".zhuce").css({"display":"none"})
	})
	
	
})
