package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MaintainService;
import com.util.TokenCheck;

/**
 * @author Sumkor
 * 单条记录插入
 */
@SuppressWarnings("serial")
public class UpdateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		//判断用户是否是重复提交
		boolean repeat = TokenCheck.isRepeatSubmit(req);
        if(repeat==true){
            System.out.println("请不要重复提交");
            req.getRequestDispatcher("/List.action").forward(req, resp);
            return;
        }
        //移除session中的token
        req.getSession().removeAttribute("token");
        System.out.println("处理用户提交请求");
	
        String id = req.getParameter("id");
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		String content = req.getParameter("content");
		MaintainService maintainService = new MaintainService();
		maintainService.updateOne(id,command, description, content);
		// 向页面跳转
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
