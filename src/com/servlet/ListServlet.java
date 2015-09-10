package com.servlet;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ListService;
import com.util.Page;

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
		String currentPage=req.getParameter("currentPage");
		
		//获取当前页
		Page page=new Page();
		Pattern pattern=Pattern.compile("[0-9]{1,9}");//[0-9]表示0-到9的数字，{1,9}表示1到9个
		if(currentPage==null || !pattern.matcher(currentPage).matches()){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		
		//显示检索条件
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		req.setAttribute("page", page);
		//查询消息列表并传给页面
		ListService listService = new ListService();
		req.setAttribute("messageList", listService.queryMessageList(command,description,page));
		
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
