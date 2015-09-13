package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MaintainService;

/**
 * @author Sumkor
 * ������¼����
 */
@SuppressWarnings("serial")
public class InsertOneServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		//�ж��û��Ƿ����ظ��ύ
		boolean repeat = isRepeatSubmit(req);
        if(repeat==true){
            System.out.println("�벻Ҫ�ظ��ύ");
            req.getRequestDispatcher("/List.action").forward(req, resp);
            return;
        }
        //�Ƴ�session�е�token
        req.getSession().removeAttribute("token");
        System.out.println("�����û��ύ���󣡣�");
	
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		String content = req.getParameter("content");
		MaintainService maintainService = new MaintainService();
		maintainService.insertOne(command, description, content);
		// ��ҳ����ת
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}
	
	
	/**
     * �жϿͻ����ύ���������ƺͷ����������ɵ������Ƿ�һ��
     * @param request
     * @return 
     *         true �û��ظ��ύ�˱� 
     *         false �û�û���ظ��ύ��
     */
    private boolean isRepeatSubmit(HttpServletRequest request) {
        String clientToken = request.getParameter("token");
        String serverToken = (String) request.getSession().getAttribute("token");
        //1������û��ύ�ı�������û��token�����û����ظ��ύ�˱�
        if(clientToken==null){
            return true;
        }
        //2�������ǰ�û���Session�в�����Token(����)�����û����ظ��ύ�˱�
        if(serverToken==null){
            return true;
        }
        //3���洢��Session�е�Token(����)����ύ��Token(����)��ͬ�����û����ظ��ύ�˱�
        if(!clientToken.equals(serverToken)){
            return true;
        }
        return false;
    }
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
