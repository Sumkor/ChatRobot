package com.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public List<Message> queryMessageList(Map<String, Object> parameter) {
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();// ����������Ϣ��Mybatis����ص���Configuration

			// Message message = new Message();
			// message.setCommand(command);
			// message.setDescription(description);//����Ҫ���ݵ�����������װΪ����
			// messageList = sqlSession.selectList("Message.queryMessageList",message);

			// ��̬����,�ӿ�û��ʵ����.MybatisΪ�ӿ��ṩʵ����,����Proxy.newProxyInstance()��������ʵ��,��������ΪObject,���÷���ǿ��ת��
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			// ����ʵ�����ýӿڷ���ʱ,������ִ��,���Ǵ���MapperProxy.invoke(),���а���sqlSession.selectList(namespace.id,parameter)
			// ����Ϊʲô�����,��Ϊ�ӿڷ�����(����Mybatis��)������Ϣ��Ӧ����,�� �ӿ���.����=namespace.id
			messageList = imessage.queryMessageList(parameter);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}

	/**
	 * ��ѯ����
	 * @param message
	 * @return
	 */
	public int count(Message message) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = dbAccess.getSqlSession();
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			result = imessage.count(message);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return result;
	}

	/**
	 * ����ɾ��
	 * @param id
	 */
	public void deleteOne(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// ͨ��sqlSessionִ��SQL���
			sqlSession.delete("Message.deleteOne", id);
			// mybatis��������������������Զ��ύ�����Զ�����ɾ�� ��Ҫ�ֶ��ύ
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	/**
	 * ����ɾ��
	 * @param id
	 */
	public void deleteBatch(List<Integer> ids) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// ͨ��sqlSessionִ��SQL���
			sqlSession.delete("Message.deleteBatch", ids);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}
