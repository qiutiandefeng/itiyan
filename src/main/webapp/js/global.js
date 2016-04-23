/**
 * 分页跳转
 * 
 * @param pageIndex
 */
function to_page(pageIndex) {
	// 判断传入的下一页值，若小于1，则设置为1
	if (pageIndex < 1) {
		pageIndex = 1;
	}
	var form = $('#sform');// 获取form表单，页面form表单都为sform
	var hidden = '<input type="hidden" id="pageIndex" name="pageInfo.pageIndex" value="'
			+ pageIndex + '"/>';
	form.append(hidden);// 添加记录下一页页数的隐藏域
	form.submit();// 提交表单
	$('#pageIndex').remove();// 移除页数隐藏域

}
/**
 * 点击查询时触发
 */
function queryData() {
	$("#sform").submit();
}

/**
 * 信息删除后，刷新页面
 */
function refreshPage() {
	// alert(1);
	// 当前页面记录数
	var currentPageRec = $('#currentPageRec').val();
	// 取得当前页数
	var currentPageNum = $('#currentPageNum').val();
	// 如果当前页就一条数据，则删除后跳往上一页
	if (currentPageRec == 1) {
		currentPageNum = currentPageNum - 1;
	}
	// alert(currentPageNum);
	// 刷新页面，跳转到指定页
	to_page(currentPageNum);
}

// 跳页方法
function page_go() {
	var page_go = $('#page_go').val(); // 要跳转到的页
	var totalPage = $("#totalPage").val(); // 总页数
	if(page_go==''){
		return false;
	}
	if (isNaN(page_go)) {
		alert("不是数值型数据！");
		return false;
	} else {
		page_go = parseInt(page_go);// 转换成Int类型
		totalPage = parseInt(totalPage);
	}
	if (page_go < 1) {// 跳转页小于1
		// alert("页数不能小于1");
		// return false;
		page_go = 1;
	}
	if (page_go > totalPage) {// 跳转页大于总页数
		// alert("超过最大页数");
		// return false;
		page_go = totalPage;
	}
	to_page(page_go);

}