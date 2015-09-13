/**
 * 调用后台批量删除方法
 */
function deleteBatch(basePath) {
	$("#mainForm").attr("action",basePath + "DeleteBatchServlet.action");
	$("#mainForm").submit();
}

/**
 * 修改当前页码，调用后台重新查询，实现页面跳转
 */
function changeCurrentPage(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}

/**
 * 跳转至新增记录页面
 */
function redirect(basePath) {
	window.location.href = basePath+"InitAddServlet.action";
}