/**
 * ���ú�̨����ɾ������
 */
function deleteBatch(basePath) {
	$("#mainForm").attr("action",basePath + "DeleteBatchServlet.action");
	$("#mainForm").submit();
}

/**
 * �޸ĵ�ǰҳ�룬���ú�̨���²�ѯ��ʵ��ҳ����ת
 */
function changeCurrentPage(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}

/**
 * ��ת��������¼ҳ��
 */
function redirect(basePath) {
	window.location.href = basePath+"InitAddServlet.action";
}