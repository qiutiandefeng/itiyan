$(function(){
	var swiper1=new Swiper('.swiper-container1',{
		autoplay:3000,
		loop:true,
		autoplayDisableOnInteraction : false,
		pagination:'.swiper-pagination',
	})
	var swiper2 = new Swiper('.swiper-container2', {
        
        slidesPerView: 2.1,
        slidesPerColumn: 2,
        paginationClickable: true,
        spaceBetween: 30,
        freeMode: true
    });
    var swiper3 = new Swiper('.swiper-container3', {
        
        slidesPerView: 1.3,
        paginationClickable: true,
        spaceBetween: 30,
        freeMode: true
    });
    var swiper4 = new Swiper('.swiper-container4', {
    	
        slidesPerView: 2.1,
        slidesPerColumn: 2,
        paginationClickable: true,
        spaceBetween: 30,
        freeMode: true
    });
    $(".swiper-container2 .swiper-wrapper .swiper-slide").css({"marginTop":"4px","marginRight":"10px"})
    $(".swiper-container3 .swiper-wrapper .swiper-slide").css({"marginTop":"4px","marginRight":"10px"})
    $(".swiper-container4 .swiper-wrapper .swiper-slide").css({"marginTop":"4px","marginRight":"10px"})
    
    $(".imgTop").click(function(){
		$("html,body").animate({scrollTop: 0},500);
	})
})
