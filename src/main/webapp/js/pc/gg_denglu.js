function logincalssfadein(){
	$(".logincalss").css({"display":"block"})
}
$(function(){
	$(".logincalss").click(function(){
		$(".logincalss").css({"display":"none"})
	})
	$(".denglu").click(function(ev){
		ev.stopPropagation();
	})
	$(".zhuce").click(function(ev){
		ev.stopPropagation();
	})
})	

