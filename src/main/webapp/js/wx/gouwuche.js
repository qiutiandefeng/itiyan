$(function(){
	$(".cars_div1_div1_img1").click(function(){
		$(this).css({"display":"none"})
		$(this).parent().children("img.cars_div1_div1_img2").css({"display":"block"})
		selectModel()
	})
	$(".cars_div1_div1_img2").click(function(){
		$(this).css({"display":"none"})
		$(this).parent().children("img.cars_div1_div1_img1").css({"display":"block"})
		$(".money_div1_img1").css({"display":"inline-block"})
		$(".money_div1_img2").css({"display":"none"})
		selectModel()
	})
	
	$(".cars_div1_div4_div1_img2").click(function(){
		var index=$(this).parent().children("span.cars_div1_div4_div1_sp1").html();
		index++;
		//alert(index)
		$(this).parent().children("span.cars_div1_div4_div1_sp1").html(index);
		selectModel();
	})
	$(".cars_div1_div4_div1_img1").click(function(){
		var index=$(this).parent().children("span.cars_div1_div4_div1_sp1").html();
		index--;
		//alert(index)
		if(index<=1){
			index=1;
		}
		$(this).parent().children("span.cars_div1_div4_div1_sp1").html(index);
		selectModel();
	})
	
	$(".money_div1_img1").click(function(){
		$(this).css({"display":"none"})
		$(".money_div1_img2").css({"display":"inline-block"})
		$(".cars_div1_div1_img1").css({"display":"none"})
		$(".cars_div1_div1_img2").css({"display":"block"})
		selectModel();
	})
	$(".money_div1_img2").click(function(){
		$(this).css({"display":"none"})
		$(".money_div1_img1").css({"display":"inline-block"})
		$(".cars_div1_div1_img2").css({"display":"none"})
		$(".cars_div1_div1_img1").css({"display":"block"})
		selectModel();
	})
})

$(document).ready(function(e){
	//设计每一行的宽度=屏幕宽度+按钮宽度
	$(".carst").width($(".cars").width()+$(".carst_shanchu").width());
	// 设定常规信息区域宽度=屏幕宽度
	$(".cars_div1").width($(".cars").width());
	
	//对每一行进行监听
	 var lines=$(".cars_div1");
	 var len=lines.length;
	 var lastX,lastXForMobile;
	
	//记录被按下的对象
	var pressedObj;  // 当前左滑的对象
	var lastLeftObj; // 上一个左滑的对象
	
	// 记录按下的点(坐标)
	var start;
	
	//移动端运行的监听
	for(var i=0;i<len;i++){
		lines[i].addEventListener('touchstart',function(e){
			lastXForMobile = e.changedTouches[0].pageX;
			
			//记录被按下的对象
			pressedObj = this;
			
			// 记录开始按下时的点
			var touches = event.touches[0];
			
			//x横坐标，y纵坐标
			start={x:touches.pageX,y:touches.pageY};
		});
		
		lines[i].addEventListener('touchmove',function(e){
			//计算滑动过程中X，Y的变化量；
			var touches = event.touches[0];
			delta={x:touches.pageX-start.x,y:touches.pageY-start.y};
			
			//如果横向移动大于纵向移动 则禁止纵向移动
			if(Math.abs(delta.x)>Math.abs(delta.y)){
				event.preventDefault();
			}
		});
		
		lines[i].addEventListener('touchend',function(e){
			var diffX = e.changedTouches[0].pageX - lastXForMobile;
			if(diffX < -85){
				//左滑
				$(pressedObj).animate({marginLeft:"-110px"}, 500);
				//已经左滑过的对象
				lastLeftObj && lastLeftObj != pressedObj &&$(lastLeftObj).animate({marginLeft:"0"}, 500);
				//上一个左滑对象
				lastLeftObj = pressedObj;
			}else if(diffX > 85){
				//右滑
				$(pressedObj).animate({marginLeft:"0"}, 500);
				//清空上一个左滑对象
				lastLeftObj = null;
			}
		});
	}
	
	//网页上测试  网页版的监听
	
	
	
	
	
	
	
	
	
	
	
	
	
})















