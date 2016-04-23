/**
 * dialog弹出窗口工具 add by mengLei
 */

// 动态加载js文件
// document.write('<script src="<%=basePath%>/js/dialog/dialog.min.js"></script>');

// 设置默认值
$.dialog.setting.extendDrag = true;
$.dialog.setting.lock = true;// 锁屏，遮罩
$.dialog.setting.drag = true;// 不许拖拽:true可以拖拽；false不可以拖拽
$.dialog.setting.resize = false;// 不许改变大小
$.dialog.setting.max = false;// 屏蔽最大按钮
$.dialog.setting.min = false;// 屏蔽最小按钮

/**
 * 显示弹出窗口
 * 
 * @param title
 *            窗口标题
 * @param url
 *            页面地址或action
 * @param width
 *            窗口宽度（默认700px）
 * @param height
 *            窗口高度（默认400px）
 */
function showDialog(title, url, width, height) {
	if (!width) {
		width = 700;// 默认宽度
	}

	if (!height) {
		height = 400;// 默认高度
	}

	$.dialog({
		title : title,// 标题
		content : 'url:' + url,// 页面地址或action
		width : width,// 宽度
		height : height,
		lock:true
	});
}

/**
 * 信息提示框
 * 
 * @param info
 *            提示信息
 * @param icon
 *            默认：info； 选项：success:成功 error:错误 info:确认 warning:警告
 * @param frameApi
 *            打开该alert窗口的父窗口对象
 */
function showAlert(info, icon, frameApi) {
	if (!icon) {
		icon = 'info';
	}
	// 在dialog窗口中打开子窗口
	if (frameApi) {
		frameApi.opener.$.dialog({
			title : '提示',
			icon : icon + '.png',
			content : info,
			width : 220,// 宽度
			height : 80,// 高度
			parent : frameApi,
			ok : true
		});
	} else {
		$.dialog({
			title : '提示',
			icon : icon + '.png',
			content : info,
			width : 220,// 宽度
			height : 80,// 高度
			ok : true
		});
	}
}
/**
 * confirm 信息确认框
 * 
 * @param info
 *            提示信息
 * @param callBack
 *            确认按钮回调函数
 * @param icon
 *            默认：warning； 选项：success:成功 error:错误 info:确认 warning:警告
 */
function showConfirm(info, callBack, icon) {
	if (!icon) {
		icon = 'warning';
	}

	$.dialog({
		title : '提示',
		content : info,
		icon : icon + '.png',
		width : 220,// 宽度
		height : 80,// 高度
		ok : callBack,// 确认按钮，回调函数
		cancel : true
	});
}

/**
 * 信息确认框(无取消按钮)
 * 
 * @param info
 *            提示信息
 * @param callBack
 *            确认按钮回调函数
 * @param icon
 *            默认：warning； 选项：success:成功 error:错误 info:确认 warning:警告
 */
function showAlertConfirm(info, callBack, icon) {
	if (!icon) {
		icon = 'warning';
	}

	$.dialog({
		title : '提示',
		content : info,
		icon : icon + '.png',
		width : 220,// 宽度
		height : 80,// 高度
		ok : callBack
	// 确认按钮，回调函数
	});
}

/**
 * 上浮信息提示框，3秒后自动关闭
 * 
 * @param info
 *            提示信息
 * @param icon
 *            默认：success； 选项：success:成功 error:错误 info:确认 warning:警告
 */
function showMsg(info, icon, width) {
	if (!icon) {
		icon = 'success';
	}

	if (!width) {
		width = 120;// 默认宽度
	}

	$.dialog({
		title : false,
		content : info,
		icon : icon + '1.png',
		width : width,
		left : '50%',
		top : 0,
		time : 3,
		lock : false,
		close : function() {
			var duration = 300, /* 动画时长 */
			api = this, opt = api.config, wrap = api.DOM.wrap, top = $(window)
					.scrollTop()
					- wrap[0].offsetHeight;

			wrap.animate({
				top : top + 'px',
				opacity : 0
			}, duration, function() {
				opt.close = function() {
				};
				api.close();
			});

			return false;
		}
	});

}

/**
 * 
 * @param info
 *            提示信息
 * @param icon
 *            默认：success； 选项：success:成功 error:错误 info:确认 warning:警告
 */
function showTip(info, icon, width) {
	window.top.showtips(info, icon, width);
}

function showImg(src) {
	$.dialog({
		title : '',
		content : '<img src="' + src + '" />',
		padding : 0
	});
}
