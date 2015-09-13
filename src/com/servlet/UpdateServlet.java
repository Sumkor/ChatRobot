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
 * ������¼����
 */
@SuppressWarnings("serial")
public class UpdateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		//�ж��û��Ƿ����ظ��ύ
		boolean repeat = TokenCheck.isRepeatSubmit(req);
        if(repeat==true){
            System.out.println("�벻Ҫ�ظ��ύ");
            req.getRequestDispatcher("/List.action").forward(req, resp);
            return;
        }
        //�Ƴ�session�е�token
        req.getSession().removeAttribute("token");
        System.out.println("�����û��ύ����");
	
        String id = req.getParameter("id");
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		String content = req.getParameter("content");
		MaintainService maintainService = new MaintainService();
		maintainService.updateOne(id,command, description, content);
		// ��ҳ����ת
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
