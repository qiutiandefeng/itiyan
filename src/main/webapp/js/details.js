$(function() {
	var $top1 = $(".details_textimg_top_p1")
	var $top2 = $(".details_textimg_top_p2")
	var $shang = $(".shangpinxingqing")
	var $ping = $(".pinglun")
	$top1.click(function() {
		$shang.css({
			"display" : "block"
		})
		$ping.css({
			"display" : "none"
		})
		$(".details_textimg_top_p1 a").css({
			"border-bottom" : "2px solid #000"
		})
		$(".details_textimg_top_p2 a").css({
			"border" : "0"
		})
		$(".details_textimg_servic").css({
			"display" : "block"
		})
	})
	$top2.click(function() {
		$ping.css({
			"display" : "block"
		})
		$shang.css({
			"display" : "none"
		})
		$(".details_textimg_top_p2 a").css({
			"border-bottom" : "2px solid #000"
		})
		$(".details_textimg_top_p1 a").css({
			"border" : "0"
		})
		$(".details_textimg_servic").css({
			"display" : "none"
		})
	})
	$(".details_details_left_ul1 li").last().addClass(
			"details_details_left_ul1_li1")
	$(".details_details_left_ul1 li a").click(
			function() {
				$(".details_details_left_ul1 li a").removeClass().addClass(
						"borderbai")
				$(this).removeClass().addClass("borderhei")

				var abcd = $(this).html()
				$(".details_details_left_div1").html(abcd)
				$(".details_details_left_div1 img").addClass(
						"details_details_left_img1")
			})

	$(".details_details_left_ul1 li a").first()

	$(".details_details_right_div3_div1 a").click(function() {
		$(".details_details_right_div3 a").removeClass().addClass("borderbai")
		$(this).removeClass().addClass("borderhei")
		setModeltype(1, this.name);

	})
	$(".details_details_right_div4_div1 a")
			.click(
					function() {
						if ($(this).children("span.xukuang").css("display") == "inline") {
							alert(1)
						} else {
							$(".details_details_right_div4 a").removeClass()
									.addClass("borderbai")
							$(this).removeClass().addClass("borderhei")
							setModeltype(2, $(this).children("span").text());
						}

					})

	$(".details_details_right_div7_div3_a1").click(function() {
		$(".details_details_right_div7_div3_a1").css({
			"display" : "none"
		})
		$(".details_details_right_div7_div3_a2").css({
			"display" : "block"
		})
		index111 = 0;
	})
	$(".details_details_right_div7_div3_a2").click(function() {
//		$(".details_details_right_div7_div3_a2").css({
//			"display" : "none"
//		})
//		$(".details_details_right_div7_div3_a1").css({
//			"display" : "block"
//		})
	})
	// var index222=0;
	var index111 = 0;
	$(".details_details_right_div7_div3_a2").hover(function() {

//		index111++
//		if (index111 > 1) {
//			$(".details_details_right_div7_div3_a2").html("取消收藏")
//		}

	}, function() {
		$(".details_details_right_div7_div3_a2").html("已收藏")
	})

	$(".details_details_right_div6_a1").click(function() {
		var index = parseInt($(".details_details_right_div6_sp2").html())
		index--;
		if (index < 1) {
			index = 1;
		}
		$(".details_details_right_div6_sp2").html(index);
	})
	$(".details_details_right_div6_a2").click(function() {
		var index = parseInt($(".details_details_right_div6_sp2").html())
		index++;
		if (index > Number($("#modtRepertory").text())) {
			alert("已达到库存上线");
		} else {
			$(".details_details_right_div6_sp2").html(index);
		}
	})
	$(".details_details_right_div1_div2_a2").hover(function() {
		$(".details_details_right_div1_div2_img1").css({
			"display" : "block"
		})
	}, function() {
		$(".details_details_right_div1_div2_img1").css({
			"display" : "none"
		})
	})
	$(".details_details_right_div7_div2 a").click(function() {
		var index1 = 0;
		var index2 = 0;

	})
	$(".motai_jiaru_div1_img1").click(function() {
		$(".motai_jiaru").css({
			"display" : "none"
		})
	})

})
