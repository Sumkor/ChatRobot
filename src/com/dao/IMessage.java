package com.dao;

import java.util.List;
import java.util.Map;

import com.bean.Message;

/**
 * @author Sumkor
 * ��Message�����ļ����Ӧ�Ľӿ�
 */
public interface IMessage {
	//��ӦXML��id(queryMessageList),����Ĳ���,��������
	public List<Message> queryMessageList(Map<String,Object> parameter);
	public int count(Message message);
	public void insertOne(Message message);
}
