package com.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sumkor
 * 生成Token令牌并跳转至新增页面(InsertOneServlet.action)
 */
@SuppressWarnings("serial")
public class InitAddServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
				
		Random ran = new Random();
        String token = String.valueOf(ran.nextInt());//创建令牌	
        System.out.println("生成的token："+token);
        req.getSession().setAttribute("token", token);//在服务器使用session保存token(令牌)
		
		req.getRequestDispatcher("/WEB-INF/jsp/back/insert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
