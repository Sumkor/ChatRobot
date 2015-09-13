package com.util;

import javax.servlet.http.HttpServletRequest;

public class TokenCheck {
	/**
     * �жϿͻ����ύ���������ƺͷ����������ɵ������Ƿ�һ��
     * @param request
     * @return 
     *         true �û��ظ��ύ�˱� 
     *         false �û�û���ظ��ύ��
     */
    public static boolean isRepeatSubmit(HttpServletRequest request) {
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
}
