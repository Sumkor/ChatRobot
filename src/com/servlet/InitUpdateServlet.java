package com.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MaintainService;

/**
 * @author Sumkor
 * ����Token���Ʋ���ת������ҳ��(UpdateServlet.action)
 */
@SuppressWarnings("serial")
public class InitUpdateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
				
		Random ran = new Random();
        String token = String.valueOf(ran.nextInt());//��������	
        System.out.println("���ɵ�token��"+token);
        req.getSession().setAttribute("token", token);//�ڷ�����ʹ��session����token(����)
        
        String id = req.getParameter("id");
        MaintainService maintainService = new MaintainService();
        req.setAttribute("message", maintainService.queryMesById(id));//����id��ѯ��������¼
		
		req.getRequestDispatcher("/WEB-INF/jsp/back/update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}

