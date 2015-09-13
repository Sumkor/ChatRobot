package com.util;

import javax.servlet.http.HttpServletRequest;

public class TokenCheck {
	/**
     * 判断客户端提交上来的令牌和服务器端生成的令牌是否一致
     * @param request
     * @return 
     *         true 用户重复提交了表单 
     *         false 用户没有重复提交表单
     */
    public static boolean isRepeatSubmit(HttpServletRequest request) {
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
}
