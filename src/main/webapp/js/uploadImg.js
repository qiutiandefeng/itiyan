
function checkPic()
{
	var picPath = document.getElementById("picPath").value;
	var type = picPath.substring(picPath.lastIndexOf("."),picPath.length).toLowerCase();
	if((type!=".jpg")&&(type!=".bmp")&&(type!=".gif")&&(type!=".png"))
		{
			//alert("请上传正确的图片格式");
			document.getElementById("onstellationError").innerHTML="请上传jpg,bmp,gif,png格式的图像！";
			return false;
		}
	return true;
}
//图片预览
function PreviewImage(divImage,upload,width,height)
{
	if(checkPic())
		{
			try{
				//图片路径
				
			//	var imgPath; 
				var Browser_Agent = navigator.userAgent;
				//判断浏览器
				if(Browser_Agent.indexOf("Firefox")!=-1){
					//imgPath = upload.files[0].getAsDataURL();
					imgPath = window.URL.createObjectURL(upload.files[0]);
					document.getElementById(divImage).innerHTML = "<img id='imgPreview' src='"+imgPath+"'width='"+width+"'height='"+height+"'/>";
				}else{
					//IE浏览器ie9必须在兼容模式下才能显示预览图片
					var Preview = document.getElementById(divImage).value;
					Preview.fileters.item("DXImageTransform.Microsoft.AlphaImageLoader").src=upload.value;
					Preview.style.width = width;
					Preview.style.height=height;
				}
				
			}catch(e)
			{
				document.getElementById("onstellationError").innerHTML="请上传正确的图片格式!!";
				//alert("请上传正确格式的图片");
			}
		}
}

//页面加载时动作：包括获取产品值，对不同浏览器做不同的处理
$(function () {
    
    if (window.navigator.userAgent.indexOf("MSIE 8.0") >= 1) {
        //alert("IE8")
        //document.getElementById("browserSbumit").innerHTML="<input type=\"submit\"  onclick=\"up(this)\" style=\"background-image:url(\'images/jxsc.png\');width:136px;height:46px; cursor:pointer;\" value=\"\" />"
    }
});




var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
function fileChange(target){
    var fileSize = 0;
    if (isIE && !target.files) {    // IE浏览器
        var filePath = target.value; // 获得上传文件的绝对路径
        /**
         * ActiveXObject 对象为IE和Opera所兼容的JS对象
         * 用法：
         *         var newObj = new ActiveXObject( servername.typename[, location])
         *         其中newObj是必选项。返回 ActiveXObject对象 的变量名。
         *        servername是必选项。提供该对象的应用程序的名称。
         *        typename是必选项。要创建的对象的类型或类。
         *        location是可选项。创建该对象的网络服务器的名称。
         *\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
         *     Scripting.FileSystemObject 为 IIS 内置组件，用于操作磁盘、文件夹或文本文件，
         *    其中返回的 newObj 方法和属性非常的多
         *    如：var file = newObj.CreateTextFile("C:\test.txt", true) 第二个参表示目标文件存在时是否覆盖
         *    file.Write("写入内容");    file.Close();
         */
        var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
        // GetFile(path) 方法从磁盘获取一个文件并返回。
        var file = fileSystem.GetFile(filePath);
        fileSize = file.Size;    // 文件大小，单位：b
    }
    else {    // 非IE浏览器
        fileSize = target.files[0].size;
    }
    var size = fileSize / 1024;
    if (size > 200) {
        return false;
    }
    return true;
}



    //预览图像和增加新的上传框
function add(obj) {
	//alert(obj.file[1].name);
    obj.select();
    obj.blur();
    var nfile;
    var position;
    if (obj.files) {
        nfile = obj.files[0].name;
        position=obj.lang       
    }
    else{
        nfile = document.selection.createRange().text;
    }
  
  
    var Extention = nfile.substring(nfile.lastIndexOf(".")).toLocaleLowerCase();
    var allowExtention = ".jpg,.bmp,.gif,.png";
    if (allowExtention.indexOf(Extention) < 0) {
    	 alert("请上传jpg,bmp,gif,png格式的图像！");
        //document.getElementById("onstellationError").innerHTML = "请上传jpg,bmp,gif,png格式的图像！";
        return;
    }
    //在此做文件格式验证
    //验证文件大小是否超出限制
    if(fileChange(obj)==false){
    	alert("请上传小于200k的图片");
    	return;
    };
   
    if(position=='scjx'){
    	 Fipd++;
    	 //alert(Fipd)
    	 Filenum++;   
    	 //alert(Filenum);
    	 //该上传框隐藏
         obj.style.display = "none";
         var myid="filescjx"+Fipd;
    	 //增加新的上传框filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;
         $('<input id='+myid +' name="file" type="file" onchange="add(this)" lang="scjx" style="cursor:pointer;width: 56px; height: 30px; filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0; writing-mode: tb-rl"/>').appendTo($("#inputList"));
         //alert($("#inputList").html())
    	 
         if (Filenum > 4) {
             //document.getElementById("inputList").style = "float: left; border: 1px solid blue; width: 136px; height: 46px;";       	
             //$("#inputList").css("background-image", "url('images/jxtj.png')");//继续添加按钮
        	 //alert("#filescjx" +(Fipd-1));
       		 $("#filescjx" +(Fipd-1)).remove();
        	 alert("最大可以上传4张");
        	 Filenum--; 
         	return;
         }
         //本地预览该上传框的图像
         preview(obj,position,Fipd);
    }
    
   
    if(position=='scjx1'){
    	Apd++;
    	Anum++;  
    	//alert(Anum);
    	
    	 obj.style.display = "none";
    	 var myid="filescjx1"+Apd;
         //增加新的上传框filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;
         $('<input  id='+myid+' name="file1" type="file" onchange="add(this)" lang="scjx1"  style="cursor:pointer;width: 56px; height: 30px; filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;  writing-mode: tb-rl"/>').appendTo($("#inputList1"));
   
    	
        if (Anum > 4) {
            //document.getElementById("inputList").style = "float: left; border: 1px solid blue; width: 136px; height: 46px;";       	
            //$("#inputList").css("background-image", "url('images/jxtj.png')");//继续添加按钮        	
        	$("#filescjx1" +(Apd-1)).remove();        	
        	Anum--;
        	alert("最大可以上传4张");
        	return;
        }
       
        //本地预览该上传框的图像
        preview(obj,position,Apd)
         //该上传框隐藏
       
    }
   
    if(position=='scjx2'){
    	Bpd++;
    	Bnum++;  
    	//alert(Bnum); 
    	obj.style.display = "none";
    	var myid="filescjx2"+Bpd; 
          //增加新的上传框filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;
        $('<input id='+myid +' name="file2" type="file" onchange="add(this)" lang="scjx2"  style="cursor:pointer;width:56px; height: 30px; filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;  writing-mode: tb-rl"/>').appendTo($("#inputList2"));
      
        if (Bnum > 4) {
            //document.getElementById("inputList").style = "float: left; border: 1px solid blue; width: 136px; height: 46px;";       	
            //$("#inputList").css("background-image", "url('images/jxtj.png')");//继续添加按钮
        	$("#filescjx2" +(Bpd-1)).remove(); 
        	Bnum--;
        	alert("最大可以上传4张");
        	return;
        }
       
        //本地预览该上传框的图像
        preview(obj,position,Bpd)
         //该上传框隐藏
      
    }
    
    if(position=='scjx3'){
    	Cpd++;
    	Cnum++;  
    	//alert(Cnum);  
    	obj.style.display = "none";
    	var myid="filescjx3"+Cpd; 
        //增加新的上传框filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;
        $('<input id='+myid +' name="file3" type="file" onchange="add(this)" lang="scjx3"  style="cursor:pointer;width: 56px; height: 30px; filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;  writing-mode: tb-rl"/>').appendTo($("#inputList3"));
        //alert($("#inputList3").html())
        if (Cnum > 4) {
            //document.getElementById("inputList").style = "float: left; border: 1px solid blue; width: 136px; height: 46px;";       	
            //$("#inputList").css("background-image", "url('images/jxtj.png')");//继续添加按钮
        	$("#filescjx3" +(Cpd-1)).remove(); 
        	Cnum--;
        	alert("最大可以上传4张");
        	return;
        }
       
        //本地预览该上传框的图像
        preview(obj,position,Cpd)
         //该上传框隐藏
        
    }    
   
    if(position=='scjx4'){
    	Dpd++;
    	Dnum++;  
    	//alert(Dnum); 
    	 obj.style.display = "none";
    	 var myid="filescjx4"+Dpd;
         //增加新的上传框filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;
         $('<input id='+myid +' name="file4" type="file" onchange="add(this)" lang="scjx4"  style="cursor:pointer;width: 56px; height: 30px; filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;  writing-mode: tb-rl"/>').appendTo($("#inputList4"));
    
        if (Dnum > 4) {
            //document.getElementById("inputList").style = "float: left; border: 1px solid blue; width: 136px; height: 46px;";       	
            //$("#inputList").css("background-image", "url('images/jxtj.png')");//继续添加按钮
        	$("#filescjx4" +(Dpd-1)).remove(); 
        	Dnum--;
        	alert("最大可以上传4张");
        	return;
        }
       
        //本地预览该上传框的图像
        preview(obj,position,Dpd)
         //该上传框隐藏
       
    }    
   
    
    
    if(position=='scjx5'){
    	
    	Fpd++;
    	Fnum++;
    	//alert(Fnum);
    	 //该上传框隐藏
        obj.style.display = "none";
        var myid="filescjx5"+Fpd;
        //增加新的上传框filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;
        $('<input id='+myid +' name="file5" type="file" onchange="add(this)" lang="scjx5"  style="cursor:pointer;width: 56px; height: 30px; filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;  writing-mode: tb-rl"/>').appendTo($("#inputList5"));
   
        if (Fnum > 4) {
            //document.getElementById("inputList").style = "float: left; border: 1px solid blue; width: 136px; height: 46px;";       	
            //$("#inputList").css("background-image", "url('images/jxtj.png')");//继续添加按钮
        	$("#filescjx5" +(Fpd-1)).remove(); 
        	Fnum--;
        	alert("最大可以上传4张");
        	return;
        }
       
        //本地预览该上传框的图像
        preview(obj,position,Fpd)
        
    }    
    
 
 if(position=='scjx6'){
	 Hpd++;
 	 Hnum++;  
 	//alert(Hnum); 
 	 obj.style.display = "none";
 	var myid="filescjx6"+Hpd;
     //增加新的上传框filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;
     $('<input id='+myid +' name="file6" type="file" onchange="add(this)" lang="scjx6"  style="cursor:pointer;width: 56px; height: 30px; filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;  writing-mode: tb-rl"/>').appendTo($("#inputList6"));
 
     if (Hnum > 4) {
         //document.getElementById("inputList").style = "float: left; border: 1px solid blue; width: 136px; height: 46px;";       	
         //$("#inputList").css("background-image", "url('images/jxtj.png')");//继续添加按钮
    	 $("#filescjx6" +(Hpd-1)).remove();
    	 Hnum--;
    	 alert("最大可以上传4张");
     	return;
     }
    
     //本地预览该上传框的图像
     preview(obj,position,Hpd)
      //该上传框隐藏
    
 }    
 
 
 
 if(position=='scjx7'){
 	Ipd++;
 	Inum++;  
 	//alert(Inum);
 	  //该上传框隐藏
    obj.style.display = "none";
    var myid="filescjx7"+Ipd;
    //增加新的上传框filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;
    $('<input id='+myid +' name="file7" type="file" onchange="add(this)" lang="scjx7"  style="cursor:pointer;width: 56px; height: 30px; filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;writing-mode: tb-rl"/>').appendTo($("#inputList7"));

     if (Inum > 4) {
         //document.getElementById("inputList").style = "float: left; border: 1px solid blue; width: 136px; height: 46px;";       	
         //$("#inputList").css("background-image", "url('images/jxtj.png')");//继续添加按钮
    	 $("#filescjx7" +(Ipd-1)).remove();
    	 Inum--;
    	 alert("最大可以上传4张");
     	return;
     }
    
     //本地预览该上传框的图像
     preview(obj,position,Ipd)
    
 }    
 
 
 if(position=='scjx8'){
 	Jpd++;
 	Jnum++;  
 	//alert(Jnum); 
 	  //该上传框隐藏
    obj.style.display = "none";
    var myid="filescjx8"+Jpd;
    //增加新的上传框filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;
    $('<input id='+myid+' name="file8" type="file" onchange="add(this)" lang="scjx8"  style="cursor:pointer;width: 56px; height: 30px; filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0; writing-mode: tb-rl"/>').appendTo($("#inputList8"));
     if (Jnum > 4) {
         //document.getElementById("inputList").style = "float: left; border: 1px solid blue; width: 136px; height: 46px;";       	
         //$("#inputList").css("background-image", "url('images/jxtj.png')");//继续添加按钮
    	 $("#filescjx8" +(Jpd-1)).remove();
    	 Jnum--;
    	 alert("最大可以上传4张");
     	return;
     }
    
     //本地预览该上传框的图像
     preview(obj,position,Jpd)
    
 }    
 
 
 if(position=='scjx9'){
 	Kpd++;
 	Knum++;  
 	//alert(Knum); 
 	  //该上传框隐藏
    obj.style.display = "none";
    var myid="filescjx9"+Kpd;
    //增加新的上传框filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;
    $('<input id='+myid+' name="file9" type="file" onchange="add(this)" lang="scjx9"  style="cursor:pointer;width: 56px; height: 30px; filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;  writing-mode: tb-rl"/>').appendTo($("#inputList9"));

     if (Knum > 4) {
         //document.getElementById("inputList").style = "float: left; border: 1px solid blue; width: 136px; height: 46px;";       	
         //$("#inputList").css("background-image", "url('images/jxtj.png')");//继续添加按钮
    	 $("#filescjx9" +(Kpd-1)).remove();
    	 Knum--; 
    	 alert("最大可以上传4张");
     	return;
     }
    
     //本地预览该上传框的图像
     preview(obj,position,Kpd)
    
 }    
 
 
 if(position=='scjxv'){
 	Lpd++;
 	Lnum++;  
 	//alert(Lnum); 
 	 //该上传框隐藏
    obj.style.display = "none";
    var myid="filescjxv"+Lpd;
    //增加新的上传框filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;
    $('<input id='+myid+' name="filev" type="file" onchange="add(this)" lang="scjxv"  style="cursor:pointer;width: 56px; height: 30px; filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;  writing-mode: tb-rl"/>').appendTo($("#inputListv"));

     if (Lnum > 4) {
         //document.getElementById("inputList").style = "float: left; border: 1px solid blue; width: 136px; height: 46px;";       	
         //$("#inputList").css("background-image", "url('images/jxtj.png')");//继续添加按钮
    	 $("#filescjxv" +(Lpd-1)).remove();
    	 Lnum--; 
    	 alert("最大可以上传4张");
     	return;
     }
    
     //本地预览该上传框的图像
     preview(obj,position,Lpd)
     
 }    
    
 
 
 if(position=='scjxw'){
	 	Mpd++;
	 	Mnum++;  
	 	//alert(Mnum);  
	 	 //该上传框隐藏
	     obj.style.display = "none";
	     var myid="filescjxw"+Mpd;
	     //增加新的上传框filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;
	     $('<input id='+myid+' name="filew" type="file" onchange="add(this)" lang="scjxw"  style="cursor:pointer;width: 56px; height: 30px; filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0; writing-mode: tb-rl"/>').appendTo($("#inputListw"));
	 
	     if (Mnum > 4) {
	         //document.getElementById("inputList").style = "float: left; border: 1px solid blue; width: 136px; height: 46px;";       	
	         //$("#inputList").css("background-image", "url('images/jxtj.png')");//继续添加按钮
	    	 $("#filescjxw" +(Mpd-1)).remove();	
	    	 Mnum--; 
	    	 alert("最大可以上传4张");
	     	return;
	     }
	    
	     //本地预览该上传框的图像
	     preview(obj,position,Mpd)
	     
 }    
 
 
 
 if(position=='scjxz'){
	 	Npd++;
	 	Nnum++;  
	 	//alert(Nnum); 
	 	  //该上传框隐藏
	     obj.style.display = "none";
	     var myid="filescjxz"+Npd;
	     //增加新的上传框filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;
	     $('<input id='+myid+' name="filez" type="file" onchange="add(this)" lang="scjxz"  style="cursor:pointer;width: 56px; height: 30px; filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0;  writing-mode: tb-rl"/>').appendTo($("#inputListz"));
	 
	     if (Nnum > 4) {
	         //document.getElementById("inputList").style = "float: left; border: 1px solid blue; width: 136px; height: 46px;";       	
	         //$("#inputList").css("background-image", "url('images/jxtj.png')");//继续添加按钮
	    	 $("#filescjxz" +(Npd-1)).remove();	
	    	 Nnum--; 
	    		alert("最大可以上传4张");
	     	return;
	     }
	    
	     //本地预览该上传框的图像
	     preview(obj,position,Npd)
	    
 }    
 

}

    //隐藏上传文件div，显示本地预览div
    function sczpdown() {
        document.getElementById('sczpdown1').style.display = 'none';
        document.getElementById('sczpdown2').style.display = '';
    }

    
//检测上传限制
function limit() {
    var num = 0;
    $.ajax({
        url: "./Service/CommonService.ashx",
        async: false,
        cache:false,
        data: {
            "action": "querynum",
            "userID": "16877",
            "code": document.getElementById('constellationCode').value
        },
        success: function (data) {
            num = data;
        }
    });
    if (parseInt(num) + (Filenum - Delnum) > 10)
        return true;
    else
        return false;
}
//检测有没选择产品
function checkConstellation() {
    document.getElementById("onstellationError").innerHTML = "";
    if (document.getElementById('constellationCode').value == "") {
        document.getElementById("onstellationError").innerHTML = "请选择一个产品";
        return false;
    }
    else {
        return true;
    }
}