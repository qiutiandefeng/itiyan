window.onload=function(){
	
	 
//	var num1=[];
//	var num2=[];//2个数组；分别储存尺寸和材料；
	var tab1=document.getElementById("tab1")
	var index=tab1.getElementsByClassName("inp1");//材料点击按钮
	var changes1=tab1.getElementsByClassName("inp2");
	var num=document.getElementById("ta1");
	var tab2=document.getElementById("tab2");
	var objs=tab2.getElementsByClassName("inp1");//尺寸点击按钮
	var changes2=tab2.getElementsByClassName("inp2");
	var cbg=document.getElementById("div3_div4_div2_div2_div3");
	//内容更改
	for(var i=0;i<changes1.length;i++){
		changes1[i].onkeyup=function(){
			document.getElementById(this.id+"_2").innerHTML=(this.value);
			var fix=document.getElementsByClassName(this.id+"_1_1_1");
			for(var j=0;j<fix.length;j++){
				fix[j].innerHTML=(this.value);
			}
		}
	}
	for(var i=0;i<changes2.length;i++){
		changes2[i].onkeyup=function(){
			var fix1=document.getElementsByClassName(this.id+"_2");
			for(var j=0;j<fix1.length;j++){
				fix1[j].innerHTML=(this.value);
			}
		}
	}
	
	//添加删除
	for(var i=0;i<index.length;i++){//材料判定
		index[i].onclick=function(){
			
			if(this.checked==true){
				var table1=document.createElement("table");
				table1.setAttribute("class","gong1");
				//图片上传部分
				var index1=document.createElement("tr");
				var index2=document.createElement("td");
				var index3=document.createElement("td");
				var index4=this.parentNode.getElementsByClassName("inp2")[0].value;
				index2.innerHTML=(index4)
				index3.innerHTML=("<a href='#' class='in1'>图片上传<input type='file' id='' name='"+this.id+"_1_1' onchange='selectImagez(this)' /></a><img id='"+this.id+"_1_1' src='..//upload//uploadImg//textture/${user.avatar}'  />")
				index1.setAttribute("id","_1"+this.id)
				index2.setAttribute("class","td1")
				index2.setAttribute("id",this.id+"_2")
				index3.setAttribute("class","td2");
				index1.appendChild(index2);
				index1.appendChild(index3);
				num.appendChild(index1);
				for(var j=0;j<objs.length;j++){
					if(objs[j].checked==true){
						var table2=document.createElement("tr");
						var table5=document.createElement("td");
						var table6=document.createElement("td");
						var table7=document.createElement("td");
						var table8=objs[j].parentNode.getElementsByClassName("inp2")[0].value;
						var table3=document.createElement("td");
						var table4=this.parentNode.getElementsByClassName("inp2")[0].value;
						var table9=document.getElementById("price").value;
						table1.setAttribute("id",this.id+"_1");
						table2.setAttribute("id",objs[j].id+"_1");
						table3.setAttribute("class",this.id+"_1_1_1");
						table5.setAttribute("class",objs[j].id+"_2");
						table3.innerHTML=(table4);
						table5.innerHTML=(table8);
						table6.innerHTML=('<input type="text" value="'+table9+'"/>');
						table7.innerHTML=('<input type="number" class="kucunliang" onblur="qqq(this)"/> <input class="td2_in1" type="hidden" value=""/>');
						table2.appendChild(table3);
						table2.appendChild(table5);
						table2.appendChild(table6);
						table2.appendChild(table7);
						table1.appendChild(table2);
						cbg.appendChild(table1);
					}
				}
			}else{
				var abc=document.getElementById("_1"+this.id);
				num.removeChild(abc)
				cbg.removeChild(document.getElementById(this.id+"_1"))
			}
		}
	}
	for(var i=0;i<objs.length;i++){//尺寸判定
		objs[i].onclick=function(){
			if(this.checked==true){
				for(var j=0;j<index.length;j++){
					if(index[j].checked==true){
						var table2=document.createElement("tr");
						table2.setAttribute("id",this.id+"_1");
						var table5=document.createElement("td");
						var table6=document.createElement("td");
						var table7=document.createElement("td");
						var table8=this.parentNode.getElementsByClassName("inp2")[0].value;
						var table9=document.getElementById("price").value;
						table5.setAttribute("id",this.id+"_1_1_1");
						table5.innerHTML=(table8);
						table6.innerHTML=('<input type="text" value="'+table9+'"/>');
						table7.innerHTML=('<input type="number" class="kucunliang" onblur="qqq(this)"/>');
						//numbers=j;
						var table9=document.createElement("td");
						var table10=index[j].parentNode.getElementsByClassName("inp2")[0].value;
						table9.innerHTML=(table10);
						table9.setAttribute("class",index[j].id+"_2");
						table2.appendChild(table9);
						table2.appendChild(table5);
						table2.appendChild(table6);
						table2.appendChild(table7);
						document.getElementById(index[j].id+"_1").appendChild(table2);
							
					}
				}
				
			}else{
				var bbq=document.getElementsByClassName("gong1");
				for(var n=0;n<bbq.length;n++){
					bbq[n].removeChild(document.getElementById(this.id+"_1"))
				}
				
				
				
			}
		}
	}
	//修改时，初始化商品信息
	updateMdel();

}
function qqq(){
	var kucunliang=document.getElementsByClassName("kucunliang");
	var kucunNum=0;
	for(var i=0;i<kucunliang.length;i++){
		if(kucunliang[i].value==""){
			kucunliang[i].value=0;
		}
		kucunNum+=parseInt(kucunliang[i].value);
		if(kucunliang[i].value==0){
			kucunliang[i].value="";
		}
	}
	document.getElementById("modRepertory").value=kucunNum;
	
}








