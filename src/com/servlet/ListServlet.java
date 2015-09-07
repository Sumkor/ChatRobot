package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ListService;

/**
 * �б�ҳ���ʼ������
 * @author Sumkor
 *
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//����ҳ���ֵ ��������
		String command=req.getParameter("command");
		String description=req.getParameter("description");
		//��ʾ��������
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		//��ѯ��Ϣ�б�����ҳ��
		ListService listService = new ListService();
		req.setAttribute("messageList", listService.queryMessageList(command, description));
		
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
