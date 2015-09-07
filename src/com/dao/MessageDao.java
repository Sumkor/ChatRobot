package com.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bean.Message;
import com.db.DBAccess;

/**
 * ���ݿ�Message�����
 * @author Sumkor
 */
public class MessageDao {
	/**
	 * ���ݲ�ѯ������ѯ��Ϣ�б�
	 * @param command
	 * @param description
	 * @return
	 */
	public List<Message> queryMessageList(String command,String description){
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);//����Ҫ���ݵ�����������װΪ����
			
			messageList = sqlSession.selectList("Message.queryMessageList",message);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		return messageList;
	}	
	
	/**
	 * ����ɾ��
	 * @param id
	 */
	public void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��SQL���			
			sqlSession.delete("Message.deleteOne",id);
			//mybatis��������������������Զ��ύ�����Զ�����ɾ�� ��Ҫ�ֶ��ύ����ѯ����Ҫ��	
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	/**
	 * ����ɾ��
	 * @param id
	 */
	public void deleteBatch(List<Integer> ids){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��SQL���			
			sqlSession.delete("Message.deleteBatch",ids);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
}
