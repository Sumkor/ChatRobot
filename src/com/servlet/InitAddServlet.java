package com.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sumkor
 * ����Token���Ʋ���ת������ҳ��(InsertOneServlet.action)
 */
@SuppressWarnings("serial")
public class InitAddServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
				
		Random ran = new Random();
        String token = String.valueOf(ran.nextInt());//��������	
        System.out.println("���ɵ�token��"+token);
        req.getSession().setAttribute("token", token);//�ڷ�����ʹ��session����token(����)
		
		req.getRequestDispatcher("/WEB-INF/jsp/back/insert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
