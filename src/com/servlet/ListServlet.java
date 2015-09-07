package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ListService;

/**
 * 列表页面初始化控制
 * @author Sumkor
 *
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//接收页面的值 检索条件
		String command=req.getParameter("command");
		String description=req.getParameter("description");
		//显示检索条件
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		//查询消息列表并传给页面
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
