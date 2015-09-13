package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MaintainService;

/**
 * @author Sumkor
 * 单条记录插入
 */
@SuppressWarnings("serial")
public class InsertOneServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		String content = req.getParameter("content");
		MaintainService maintainService = new MaintainService();
		maintainService.insertOne(command, description, content);
		// 向页面跳转
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
