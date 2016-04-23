// 设置模态框的显示位置 并且 点击空白不消失的效果
function bootstrapStaticAndPosition(ID){
	$(ID).modal({backdrop: 'static', keyboard: false});
	/*$(ID).modal().css({
		    'margin-left': function () {
		       return -($(this).width() / 7);
		   }
	});*/
}

// bootstrap 模态框的显示 点击空白不消失的效果
function bootstrapModalShow(ID){
	$(ID).modal({backdrop: 'static', keyboard: false});
	$(ID).modal('show');
}

// 判断数组是否包含某个元素 包含：true 不包含：false  在线考试页面使用
Array.prototype.S=String.fromCharCode(2);
Array.prototype.in_array=function(e){
    var r=new RegExp(this.S+e+this.S);
    return (r.test(this.S+this.join(this.S)+this.S));
};