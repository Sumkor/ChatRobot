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
	public List<Message> queryMessageList(Map<String,Object> parameter);//����������ѯ���贫��Page��Ϣ
	public Message queryMesById(int id);//����id��ѯ
	public int count(Message message);
	public void deleteOne(int id);
	public void deleteBatch(List<Integer> id);
	public void insertOne(Message message);
	public void updateOne(Message message);
}
