Filenum = 0;//单选题题干
Fipd=0;
Anum=0;//单选A
Apd=0;
Bnum=0;//单选B
Bpd=0;
Cnum=0;//单选C
Cpd=0;
Dnum=0;//单选D
Dpd=0;
Fnum=0;//单选解析
Fpd=0;
Hnum=0;//多选题干
Hpd=0;
Inum=0;//多选A
Ipd=0;
Jnum=0;//多选B
Jpd=0;
Knum=0;//多选C
Kpd=0;
Lnum=0;//多选D
Lpd=0;
Mnum=0;//多选E
Mpd=0;
Nnum=0;///多选解析
Npd=0;
Delnum = 0;
////垃圾桶上下移动效果
//function imgHover() {
//    $('.ljt').css('opacity', 0.6);
//    $('.img').hover(function () {
//        var el = $(this);
//        el.find('.ljt').stop(true, true).animate({ top: 160 }, 'fast');
//    }, function () {
//        var el = $(this);
//        el.find('.ljt').stop(true, true).animate({ top: 210 }, 'fast');
//    });
//}

//本地预览
function preview(obj,position,Filenum) {
	 
    var browserVersion = window.navigator.userAgent.toUpperCase();
    
   // var extention = obj.value.substring(obj.value.lastIndexOf(".") + 1).toLowerCase();
    if (obj.files) {//兼容chrome、火狐7+、360浏览器5.5+等，应该也兼容ie10，HTML5实现预览
        if (window.FileReader) {
            var reader = new FileReader();
            reader.onload = function (e) {
                HTML5(e.target.result,position,Filenum);
            }
            reader.readAsDataURL(obj.files[0]);
        }
    }//IE9及以下本地图像预览
    else if (browserVersion.indexOf("MSIE") > -1) {
        return (IE(obj));
    }
    return false;
}

//IE9及以下本地图像预览
function IE(obj) {
    obj.select();
    obj.blur();
    var nfile = document.selection.createRange().text;
    /*
    var nfile = document.selection.createRange().text;
    var allowExtention = ".jpg,.bmp,.gif,.png";//允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;
    var Extention = nfile.substring(nfile.lastIndexOf("."));
    if (allowExtention.indexOf(Extention) < 0) { return false; }*/
    document.selection.empty();
    document.getElementById("scjx").innerHTML += "<div class='yczp'  id='yczp" + (Filenum - 1) + "' >"
                                                + "<div class='img' onmouseover='imgHoverOver(this)' onmouseout='imgHoverOut(this)'>"
                                                + "<a href='#'><img class='photo' height='193' width='138'/></a>"
                                                + "<div class='ljt'>"
                                                + "<a href='javascript:destroy(" + ((Filenum - 1)) + ")'><img src='images/ljt.png' /></a>"
                                                + "</div>"
                                                + "</div>"
                                                + "</div>"
    var Img = "#yczp" + (Filenum - 1);
    //$(Img).css("filter", "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='" + nfile + "')");
    $(Img).find(".img").find("a").find(".photo").css("filter", "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='" + nfile + "')");
    //imgHover();
   // return true;
}

function imgHoverOver(obj) {
    $(obj).find('.ljt').css('opacity', 0.6);
    $(obj).find('.ljt').stop().animate({ top: 160 }, 'fast');
}
function imgHoverOut(obj) {

    $(obj).find('.ljt').stop().animate({ top: 210 }, 'fast');
}
//垃圾桶上下移动效果
function imgHover() {
    $('.ljt').css('opacity', 0.6);
    $('.img').hover(function () {
        var el = $(this);
        el.find('.ljt').stop().animate({ top: 160 }, 'fast');
    }, function () {
        var el = $(this);
        el.find('.ljt').stop().animate({ top: 210 }, 'fast');
    });
}

//IE10+,及谷歌，火狐本地预览
function HTML5(src,position,Filenum) {
    /*
    var allowExtention = ".jpg,.bmp,.gif,.png";//允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;
    var Extention = src.substring(src.lastIndexOf("."));
    alert(Extention)
    if (allowExtention.indexOf(Extention) < 0) { return false; }*/
    img = new Image();
    img.src = src;
    
    img.width = 138;
    img.height = 193;
    //document.getElementById("scjx").innerHTML += "<div class='yczp'  id='yczp" + ((Filenum - 1)) + "' ><div class='img'><a href='#'><img  height='" + img.height + "' width='" + img.width + "' src='" + img.src + "'/></a><div class='ljt'><a href='javascript:destroy(" + ((Filenum - 1)) + ")'><img src='images/ljt.png' /></a></div></div></div>"
    //imgHover();
    document.getElementById(position).innerHTML += "<span class='yczp'  id='yczp" + position+(Filenum - 1) + "' >"
                                                + "<span class='img' onmouseover='imgHoverOver(this)' onmouseout='imgHoverOut(this)'>"
                                                + "<a href='#'><img class='photo' height='70' width='70' src='" + img.src + "'/></a>"
                                                + "<span class='ljt'>"
                                                + "<a href='#' id='"+(Filenum-1)+"' name='"+position+"' onclick='return destroy(this)' title='点击删除'> x </a>"
                                                + "</span>"
                                                + "</span>"
                                                + "</span>"
    //return true;
}

//删除上传框和对应的图像预览
function destroy(obj) {
	var id= parseInt(obj.id)+1;
	//alert(obj.name+obj.id)
	 
    $("#yczp" + obj.name+obj.id).remove();
    $("#file" + obj.name+obj.id).remove();
    PositionSelect(obj.name);
    return false;
}



//点击关闭按钮时计数的归零
function NumClear(){
	//alert("删除里")
	Filenum = 0;//单选题题干
	Fipd=0;
	Anum=0;//单选A
	Apd=0;
	Bnum=0;//单选B
	Bpd=0;
	Cnum=0;//单选C
	Cpd=0;
	Dnum=0;//单选D
	Dpd=0;
	Fnum=0;//单选解析
	Fpd=0;
	Hnum=0;//多选题干
	Hpd=0;
	Inum=0;//多选A
	Ipd=0;
	Jnum=0;//多选B
	Jpd=0;
	Knum=0;//多选C
	Kpd=0;
	Lnum=0;//多选D
	Lpd=0;
	Mnum=0;//多选E
	Mpd=0;
	Nnum=0;///多选解析
	Npd=0;
}









function PositionSelect(position){
	  if(position=='scjx'){
	    	if(Filenum==5){
	    		Filenum--;
	    	}
	    	Filenum--;
	    	//alert(Filenum);	
	    }
	 // alert(position);  
	if(position=='scjx1'){
		//alert(Anum);
    	if(Anum==5){
    		Anum--;
    	}
    	Anum--;
    	//alert(Anum);
    }
    
    if(position=='scjx2'){
    	if(Bnum==5){
    		Bnum--;
    	}
    	Bnum--;
    	//alert(Bnum);
    }
    
    if(position=='scjx3'){
    	if(Cnum==5){
    		Cnum--;
    	}
    	Cnum--;
    	//alert(Cnum);
    }
    
    if(position=='scjx4'){
    	if(Dnum==5){
    		Dnum--;
    	}
    	Dnum--;
    	//alert(Cnum);
    }
    
    if(position=='scjx5'){
    	if(Fnum==5){
    		Fnum--;
    	}
    	Fnum--;
    	//alert(Cnum);
    }
    
    if(position=='scjx6'){
    	if(Hnum==5){
    		Hnum--;
    	}
    	Hnum--;
    	//alert(Cnum);
    }
    
   
    
    
    if(position=='scjx7'){
    	if(Inum==5){
    		Inum--;
    	}
    	Inum--;
    	//alert(Cnum);
    }
    if(position=='scjx8'){
    	if(Jnum==5){
    		Jnum--;
    	}
    	Jnum--;
    	//alert(Cnum);
    }
    if(position=='scjx9'){
    	if(Knum==5){
    		Knum--;
    	}
    	Knum--;
    	//alert(Cnum);
    }
    if(position=='scjxv'){
    	if(Lnum==5){
    		Lnum--;
    	}
    	Lnum--;
    	//alert(Cnum);
    }
    if(position=='scjxw'){
    	if(Mnum==5){
    		Mnum--;
    	}
    	Mnum--;
    	//alert(Cnum);
    }
    if(position=='scjxz'){
    	if(Nnum==5){
    		Nnum--;
    	}
    	Nnum--;
    	//alert(Cnum);
    }
   
	
	
}
