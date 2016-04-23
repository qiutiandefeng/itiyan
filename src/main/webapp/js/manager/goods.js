$(function(){
	//设置商品规格选择块隐藏
	$(".inp1").click(function(){
		if($(this).is(":checked")){
			$(this).parent().children("input.inp2").attr("disabled",false)
			
		}else{
			$(this).parent().children("input.inp2").attr("disabled",true)
			
		}
	})
})

	//统计商品规格信息
	function getmodeltype(){
//		//图片字符串获取
//		var pinjie="";	
		var pinjie1="";
//		$(".pinjie1").each(function(){
//			pinjie+=$(this).children("td.td1").html();
//			pinjie+=";;"
//			var pinjieNum1=$(this).children("td.td2").children("input.td2_in1").val();
//			if(pinjieNum1==""){
//				pinjieNum1="url/null";
//				pinjie+=pinjieNum1;
//			}else{
//				pinjie+=pinjieNum1;
//			}
//			pinjie+=";;;"
//			
//		})
//		pinjie=pinjie.substring(0,pinjie.length-3)
		//价格库存字符串获取
			
		$(".gong1 tr").each(function(){
			$textture=$(this).children("td").eq(0).html();
			$size=$(this).children("td").eq(1).html();
			pinjie1+=$(this).children("td").eq(0).html();
			pinjie1+=";;"
			pinjie1+=$(this).children("td").eq(1).html();
			pinjie1+=";;"
			pinjie1+=$(this).children("td").eq(2).children("input").val();
			pinjie1+=";;"
			pinjie1+=$(this).children("td").eq(3).children("input.kucunliang").val();
			pinjie1+=";;"
			//var pinjieSrc=$(".ta1 tr");
			//材质图片
			$(".ta1 tr").each(function(){
				if($(this).children("td.td1").text()==$textture){
					var srcIndex=$(this).children("td.td2").children("img")[0].name;
					if(srcIndex==""){
						pinjie1+="url_null";
					}else{
						pinjie1+=srcIndex;
					}
				}
			})
			
			 
			$(".inp2").each(function(){
				//尺寸标记
				if(this.value==$size){
					pinjie1+=";;";
					//alert("尺寸:"+$(this).parent()[0].id);
					pinjie1+=$(this).parent()[0].id;
				}
				//材质标记
				if(this.value==$textture){
					pinjie1+=";;";
					//alert("材质:"+$(this).parent()[0].id);
					pinjie1+=$(this).parent()[0].id;
				}
			});
			
			pinjie1+=";;;";
			
		})
		pinjie1=pinjie1.substring(0,pinjie1.length-3);
		$("#modelType").val(pinjie1);
		//alert($("#modelType").val());
		
	}



















