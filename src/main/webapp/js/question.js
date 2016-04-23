
		/**
		 * 单选题题干非空验证 
		 */
		function onblurST(obj) {
			var val = $("#" + obj).val();
			if (val == ""&&Filenum==0 ) {
				$("#" + obj).attr("placeholder","请输入 或上传照片 ");
			} else {
				$("#" + obj).attr("placeholder","");
				//$("#" + obj).val("");
			}
		}
		/**
		 * 单选题选项A 验证
		 * @param obj
		 */
		function onblurSA(obj) {
			var val = $("#" + obj).val();
			if (val == ""&&Anum==0 ) {
				$("#" + obj).attr("placeholder","请输入 或上传照片 ");
			} else {
				$("#" + obj).attr("placeholder","");
				//$("#" + obj).val("");
			}
		}
		/**
		 * 单选题选项B 验证
		 * @param obj
		 */
		function onblurSB(obj) {
			var val = $("#" + obj).val();
			if (val == ""&&Bnum==0) {
				$("#" + obj).attr("placeholder","请输入 或上传照片 ");
			} else {
				$("#" + obj).attr("placeholder","");
				//$("#" + obj).val("");
			}
		}
		/**
		 * 单选题选项C 验证
		 * @param obj
		 */
		function onblurSC(obj) {
			var val = $("#" + obj).val();
			if (val == ""&&Cnum==0) {
				$("#" + obj).attr("placeholder","请输入 或上传照片 ");
			} else {
				$("#" + obj).attr("placeholder","");
				//$("#" + obj).val("");
			}
		}
		/**
		 * 单选题选项D 验证
		 * @param obj
		 */
		function onblurSD(obj) {
			var val = $("#" + obj).val();
			if (val == ""&&Dnum==0) {
				$("#" + obj).attr("placeholder","请输入 或上传照片 ");
			} else {
				$("#" + obj).attr("placeholder","");
				//$("#" + obj).val("");
			}
		}
		/**
		 * 验证多选题题干 
		 * @param obj
		 */
		function onblurMT(obj) {
			var val = $("#" + obj).val();
			if (val == ""&&Hnum==0) {
				$("#" + obj).attr("placeholder","请输入 或上传照片 ");
			} else {
				$("#" + obj).attr("placeholder","");
			}
		}
		/***
		 * 验证多选题A
		 * @param obj
		 */
		function onblurMA(obj) {
			var val = $("#" + obj).val();
			if (val == "") {
				$("#" + obj).attr("placeholder","请输入 或上传照片 ");
			} else {
				$("#" + obj).attr("placeholder","");
			}
		}
		/***
		 * 验证多选题B
		 * @param obj
		 */
		function onblurMB(obj) {
			var val = $("#" + obj).val();
			if (val == "") {
				$("#" + obj).attr("placeholder","请输入 或上传照片 ");
			} else {
				$("#" + obj).attr("placeholder","");
			}
		}
		/***
		 * 验证多选题C
		 * @param obj
		 */
		function onblurMC(obj) {
			var val = $("#" + obj).val();
			if (val == "") {
				$("#" + obj).attr("placeholder","请输入 或上传照片 ");
			} else {
				$("#" + obj).attr("placeholder","");
			}
		}
		/***
		 * 验证多选题D
		 * @param obj
		 */
		function onblurMD(obj) {
			var val = $("#" + obj).val();
			if (val == "") {
				$("#" + obj).attr("placeholder","请输入 或上传照片 ");
			} else {
				$("#" + obj).attr("placeholder","");
			}
		}
		/***
		 * 验证多选题E
		 * @param obj
		 */
		function onblurME(obj) {
			var val = $("#" + obj).val();
			if (val == "") {
				$("#" + obj).attr("placeholder","请输入 或上传照片 ");
			} else {
				$("#" + obj).attr("placeholder","");
			}
		}
		



/**
 * 提交单选题
 * @returns {Boolean}
 */


function subSingle(){
	
	var stitleContents = $("#stitleContents").val();
	var stitleOptionA = $("#stitleOptionA").val();
	var stitleOptionB = $("#stitleOptionB").val();
	var stitleOptionC = $("#stitleOptionC").val();
	var stitleOptionD = $("#stitleOptionD").val();
		if(stitleContents==""&&Filenum==0 ){
			$("#stitleContents").focus();
			$("#stitleContents").attr("placeholder","请输入 或上传照片 ");
			return false;
		}else{
			$("#stitleContents").attr("placeholder","");
			$("#stitleOptionA").focus();
			$("#stitleOptionA").attr("placeholder","请输入 或上传照片 ");
		}
		if(stitleOptionA==""&&Anum==0){
			$("#stitleOptionA").focus();
			$("#stitleOptionA").attr("placeholder","请输入 或上传照片 ");
			return false;
			}else{
			$("#stitleOptionA").attr("placeholder","");
			$("#stitleOptionB").focus();
			$("#stitleOptionB").attr("placeholder","请输入 或上传照片 ");
			}
		if(stitleOptionB==""&&Bnum==0){
			$("#stitleOptionB").focus();
			$("#stitleOptionB").attr("placeholder","请输入 或上传照片 ");
			return false;
			}else{
			$("#stitleOptionC").focus();
			$("#stitleOptionC").attr("placeholder","请输入 或上传照片 ");
			}
		if(stitleOptionC==""&&Cnum==0){
			$("#stitleOptionC").focus();
			$("#stitleOptionC").attr("placeholder","请输入 或上传照片 ");
			return false;
			}else{
			$("#stitleOptionD").focus();
			$("#stitleOptionD").attr("placeholder","请输入 或上传照片 ");
			}
		if(stitleOptionD==""&&Dnum==0){
			$("#stitleOptionD").focus();
			$("#stitleOptionD").attr("placeholder","请输入 或上传照片 ");
			return false;
			}else{
			//$("#sanswerAnalysis").focus();
			}
	
	$("#Single").submit();
	//$("#SingleSub").attr("data-dismiss","modal");
	//alert("单选题提交");
	setTimeout(function(){
		//refreshPage1();
	}, 3000);
	
}

/**
 * 提交多选题
 */
function subMultiple(){
	var stitleContents = $("#mtitleContents").val();
	var stitleOptionA = $("#mtitleOptionA").val();
	var stitleOptionB = $("#mtitleOptionB").val();
	var stitleOptionC = $("#mtitleOptionC").val();
	var stitleOptionD= $("#mtitleOptionD").val();
	var stitleOptionE= $("#mtitleOptionE").val();
	var sanswerAnalysis = $("#manswerAnalysis").val();
	
	var a = document.getElementsByName("answer");
	var n=0;
	for (var i = 0; i < a.length; i++) {
		if (a[i].checked) {
			n=n+1;
		}
	}
	if(stitleContents==""&&Hnum==0 ){
		$("#mtitleContents").focus();
		$("#mtitleContents").attr("placeholder","请输入 或上传照片 ");
		return false;
	}else{
		$("#mtitleOptionA").focus();
		$("#mtitleOptionA").attr("placeholder","请输入 或上传照片 ");
	}
	
	
	if(stitleOptionA==""&&Inum==0){
		$("#mtitleOptionA").focus();
		$("#mtitleOptionA").attr("placeholder","请输入 或上传照片 ");
		return false;
		}else{
		$("#mtitleOptionB").focus();
		$("#mtitleOptionB").attr("placeholder","请输入 或上传照片 ");
		}
	if(stitleOptionB==""&&Jnum==0){
		$("#mtitleOptionB").focus();
		$("#mtitleOptionB").attr("placeholder","请输入 或上传照片 ");
		return false;
		}else{
		$("#mtitleOptionC").focus();
		$("#mtitleOptionC").attr("placeholder","请输入 或上传照片 ");
		}
	if(stitleOptionC==""&&Knum==0){
		$("#mtitleOptionC").focus();
		$("#mtitleOptionC").attr("placeholder","请输入 或上传照片 ");
		return false;
		}else{
		$("#mtitleOptionD").focus();
		$("#mtitleOptionD").attr("placeholder","请输入 或上传照片 ");
		}
	if(stitleOptionD==""&&Lnum==0){
		$("#mtitleOptionD").focus();
		$("#mtitleOptionD").attr("placeholder","请输入 或上传照片 ");
		return false;
		}else{
		$("#mtitleOptionE").focus();
		$("#mtitleOptionE").attr("placeholder","请输入 或上传照片 ");
		}
	if(stitleOptionE==""&&Mnum==0){
		$("#mtitleOptionE").focus();
		$("#mtitleOptionE").attr("placeholder","请输入 或上传照片 ");
		return false;
		}else{
			 $("#mtitleOptionE").blur();
			if(n<2){
				$("#answerWarm").focus();
				$(".modal-body").scrollTop(590);
				$("#answerWarm").html("<font size='2px;'>至少选择两个答案</font>");
				return false;
			}
		}
	//提交数据
	$("#Multiple").submit();
	//窗口消失 
	//$("#btn-Multiple").attr("data-dismiss","modal");
	//refreshPage1();

}
/**
 * 查看单个题目
 * @param id
 */

function ShowOneTitle(id){
	$.ajax( {    
	    url:"<%=path%>/titleStore/ShowOneTitle.do",
		type : 'post',
		dataType : 'json',
		data:{id:id},
		success : function(data) {
			
			var da="标准答案：  ";
			if(data.optionList[0]["answer"]==1){
				da=da+"A"+"  ";
			}
			if(data.optionList[1]["answer"]==1){
				da=da+"B"+"  ";
			}
			if(data.optionList[2]["answer"]==1){
				da=da+"C"+"  ";
			}
			if(data.optionList[3]["answer"]==1){
				da=da+"D"+"  ";
			}
			if(data.optionList.length>4){
				if(data.optionList[4]["answer"]==1){
					da=da+" E";
				}
			}
			$("#da").html(da);
			
			
			//题干照片
			var photo1="";
			//选项aA
			var photo2="";
			//选项
			var photo3="";
			//选项c
			var photo4="";
			//选项d
			var photo5="";
			//选项e
			var photo6="";
			//选项答案解析 
			var photo7="";
			//将照片拼接html 
			for(var i=0;i<data.phtotInfo.length;i++){
				if(data.phtotInfo[i]["type"]==1){
					photo1=photo1+'<img style="width: 40px;height: 40px;" src="'+data.phtotInfo[i]["photoPath"]+'">'
				}
				if(data.phtotInfo[i]["titleID"]==data.optionList[0]["optionID"]){
					photo2=photo2+'<img style="width: 40px;height: 40px;" src="'+data.phtotInfo[i]["photoPath"]+'">'
				}
				if(data.phtotInfo[i]["titleID"]==data.optionList[1]["optionID"]){
					photo3=photo3+'<img style="width: 40px;height: 40px;" src="'+data.phtotInfo[i]["photoPath"]+'">'
				}
				if(data.phtotInfo[i]["titleID"]==data.optionList[2]["optionID"]){
					photo4=photo4+'<img style="width: 40px;height: 40px;" src="'+data.phtotInfo[i]["photoPath"]+'">'
				}
				if(data.phtotInfo[i]["titleID"]==data.optionList[3]["optionID"]){
					photo5=photo5+'<img style="width: 40px;height: 40px;" src="'+data.phtotInfo[i]["photoPath"]+'">'
				}
				if(data.optionList.length>4){
					if(data.phtotInfo[i]["titleID"]==data.optionList[4]["optionID"]){
						photo6=photo6+'<img style="width: 40px;height: 40px;" src="'+data.phtotInfo[i]["photoPath"]+'">'
					}
				}
				if(data.phtotInfo[i]["type"]==3){
					photo7=photo7+'<img style="width: 40px;height: 40px;" src="'+data.phtotInfo[i]["photoPath"]+'">'
				}
			}
			//开始写入照片  
			var type=data.store["type"];
			$("#leixing").html(type==1?"单选 ":"多选");
			var tigan=data.store["titleContents"];
			var daan="  答案解析： "+data.store["answerAnalysis"]
			$("#tigan").html(tigan+photo1);
			$("#daan").html(daan+photo7);
			var h1="A : "+data.optionList[0]["titleOptionContent"];
			$("#A").html(h1+photo2);
			var h2="B : "+data.optionList[1]["titleOptionContent"];
			$("#B").html(h2+photo3);
			var h3="C : "+data.optionList[2]["titleOptionContent"];
			$("#C").html(h3+photo4);
			var h4="D : "+data.optionList[3]["titleOptionContent"];
			$("#D").html(h4+photo5);
			var h5="";
			if(data.optionList.length==5){
				h5="E : "+data.optionList[4]["titleOptionContent"];
				$("#E").html(h5);
			}
		}

	});
}
function ShowOneTitle(id){
	$.ajax( {    
	    url:"<%=path%>/titleStore/ShowOneTitle.do",
		type : 'post',
		dataType : 'json',
		data:{id:id},
		success : function(data) {
			
			var da="标准答案：  ";
			if(data.optionList[0]["answer"]==1){
				da=da+"A"+"  ";
			}
			if(data.optionList[1]["answer"]==1){
				da=da+"B"+"  ";
			}
			if(data.optionList[2]["answer"]==1){
				da=da+"C"+"  ";
			}
			if(data.optionList[3]["answer"]==1){
				da=da+"D"+"  ";
			}
			if(data.optionList.length>4){
				if(data.optionList[4]["answer"]==1){
					da=da+" E";
				}
			}
			$("#da").html(da);
			
			
			//题干照片
			var photo1="";
			//选项aA
			var photo2="";
			//选项
			var photo3="";
			//选项c
			var photo4="";
			//选项d
			var photo5="";
			//选项e
			var photo6="";
			//选项答案解析 
			var photo7="";
			//将照片拼接html 
			for(var i=0;i<data.phtotInfo.length;i++){
				if(data.phtotInfo[i]["type"]==1){
					photo1=photo1+'<img style="width: 40px;height: 40px;" src="'+data.phtotInfo[i]["photoPath"]+'">'
				}
				if(data.phtotInfo[i]["titleID"]==data.optionList[0]["optionID"]){
					photo2=photo2+'<img style="width: 40px;height: 40px;" src="'+data.phtotInfo[i]["photoPath"]+'">'
				}
				if(data.phtotInfo[i]["titleID"]==data.optionList[1]["optionID"]){
					photo3=photo3+'<img style="width: 40px;height: 40px;" src="'+data.phtotInfo[i]["photoPath"]+'">'
				}
				if(data.phtotInfo[i]["titleID"]==data.optionList[2]["optionID"]){
					photo4=photo4+'<img style="width: 40px;height: 40px;" src="'+data.phtotInfo[i]["photoPath"]+'">'
				}
				if(data.phtotInfo[i]["titleID"]==data.optionList[3]["optionID"]){
					photo5=photo5+'<img style="width: 40px;height: 40px;" src="'+data.phtotInfo[i]["photoPath"]+'">'
				}
				if(data.optionList.length>4){
					if(data.phtotInfo[i]["titleID"]==data.optionList[4]["optionID"]){
						photo6=photo6+'<img style="width: 40px;height: 40px;" src="'+data.phtotInfo[i]["photoPath"]+'">'
					}
				}
				if(data.phtotInfo[i]["type"]==3){
					photo7=photo7+'<img style="width: 40px;height: 40px;" src="'+data.phtotInfo[i]["photoPath"]+'">'
				}
			}
			//开始写入照片  
			var type=data.store["type"];
			$("#leixing").html(type==1?"单选 ":"多选");
			var tigan=data.store["titleContents"];
			var daan="  答案解析： "+data.store["answerAnalysis"]
			$("#tigan").html(tigan+photo1);
			$("#daan").html(daan+photo7);
			var h1="A : "+data.optionList[0]["titleOptionContent"];
			$("#A").html(h1+photo2);
			var h2="B : "+data.optionList[1]["titleOptionContent"];
			$("#B").html(h2+photo3);
			var h3="C : "+data.optionList[2]["titleOptionContent"];
			$("#C").html(h3+photo4);
			var h4="D : "+data.optionList[3]["titleOptionContent"];
			$("#D").html(h4+photo5);
			var h5="";
			if(data.optionList.length==5){
				h5="E : "+data.optionList[4]["titleOptionContent"];
				$("#E").html(h5);
			}
		}

	});
}


/**
 * 分页跳转
 * @param pageIndex
 */
function to_page1(pageIndex) {
	//判断传入的下一页值，若小于1，则设置为1
	if (pageIndex < 1) {
		pageIndex = 1;
	}
	var form = $('#sform');//获取form表单，页面form表单都为sform
	var hidden = '<input type="hidden" id="pageIndex" name="pageInfo.pageIndex" value="'
			+ pageIndex+ '"/>';
	form.append(hidden);//添加记录下一页页数的隐藏域
	form.submit();//提交表单
	$('#pageIndex').remove();//移除页数隐藏域

}

/**
 * 信息删除后，刷新页面
 */
function refreshPage1() {
	// 当前页面记录数
	var currentPageRec = $('#currentPageRec').val();
	// 取得当前页数
	var currentPageNum = $('#currentPageNum').val();
	// 如果当前页就一条数据，则删除后跳往上一页
	if (currentPageRec == 1) {
		currentPageNum = currentPageNum - 1;
	}
	// 刷新页面，跳转到指定页
	to_page1(currentPageNum);
}

