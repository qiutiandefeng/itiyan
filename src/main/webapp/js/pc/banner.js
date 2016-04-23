var $index=0;//当前INDEX值

// 定时器自动变换2.5秒每次
var $imgs=$(".imgLest li");
var autoChange=setInterval(function(){
	if($index<$imgs.length-1){
		$index++;
	}else{
		$index=0
	}
	//调用轮播函数
	changeTo($index);
},2500)
	$(".textLest").find("li").each(function(item) {
				$(this).hover(function() {
					clearInterval(autoChange);
					changeTo(item);
					curIndex = item;
				}, function() {
					autoChange = setInterval(function() {
						if (curIndex < $(".imgLest li").length - 1) {
							curIndex++;
						} else {
							curIndex = 0;
						}
						//调用变换处理函数       
						changeTo(curIndex);
					}, 2500);
				});
			});
			//处理动画函数
function changeTo(num){
	$(".imgLest").find("li").removeClass("imgOn").stop().fadeOut().eq(num).fadeIn().addClass("imgOn");
	$(".textLest").find("li").removeClass("textOn").eq(num).addClass("textOn");
	$(".square").find("li").removeClass("squareOn").eq(num).addClass("squareOn");
}
