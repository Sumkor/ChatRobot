package com.dao;

import java.util.List;
import java.util.Map;

import com.bean.Message;

/**
 * @author Sumkor
 * ��Message�����ļ����Ӧ�Ľӿ�
 */
public interface IMessage {
	//��ӦXML�е�SQL���id,��������,��������
	public List<Message> queryMessageList(Map<String,Object> parameter);
	public int count(Message message);
}
