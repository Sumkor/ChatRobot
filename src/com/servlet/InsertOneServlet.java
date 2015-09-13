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

		//判断用户是否是重复提交
		boolean repeat = isRepeatSubmit(req);
        if(repeat==true){
            System.out.println("请不要重复提交");
            req.getRequestDispatcher("/List.action").forward(req, resp);
            return;
        }
        //移除session中的token
        req.getSession().removeAttribute("token");
        System.out.println("处理用户提交请求！！");
	
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		String content = req.getParameter("content");
		MaintainService maintainService = new MaintainService();
		maintainService.insertOne(command, description, content);
		// 向页面跳转
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}
	
	
	/**
     * 判断客户端提交上来的令牌和服务器端生成的令牌是否一致
     * @param request
     * @return 
     *         true 用户重复提交了表单 
     *         false 用户没有重复提交表单
     */
    private boolean isRepeatSubmit(HttpServletRequest request) {
        String clientToken = request.getParameter("token");
        String serverToken = (String) request.getSession().getAttribute("token");
        //1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
        if(clientToken==null){
            return true;
        }
        //2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
        if(serverToken==null){
            return true;
        }
        //3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
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
