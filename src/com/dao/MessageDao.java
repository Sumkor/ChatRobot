package com.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bean.Message;
import com.db.DBAccess;

/**
 * 数据库Message表操作
 * @author Sumkor
 */
public class MessageDao {
	/**
	 * 根据查询条件查询消息列表
	 * @param command
	 * @param description
	 * @return
	 */
	public List<Message> queryMessageList(Map<String, Object> parameter) {
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();// 加载配置信息，Mybatis中相关的类Configuration

			// Message message = new Message();
			// message.setCommand(command);
			// message.setDescription(description);//将需要传递的两个参数封装为对象
			// messageList = sqlSession.selectList("Message.queryMessageList",message);

			// 动态代理,接口没有实现类.Mybatis为接口提供实现类,即用Proxy.newProxyInstance()创建代理实例,返回类型为Object,利用泛型强制转换
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			// 代理实例调用接口方法时,并不会执行,而是触发MapperProxy.invoke(),其中包含sqlSession.selectList(namespace.id,parameter)
			// 至于为什么会包含,因为接口方法与(加载Mybatis的)配置信息对应得上,即 接口名.方法=namespace.id
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
	 * 查询条数
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
	 * 单条删除
	 * @param id
	 */
	public void deleteOne(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			sqlSession.delete("Message.deleteOne", id);
			// mybatis有事务控制能力，不会自动提交，所以对于增删改 需要手动提交
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
	 * 批量删除
	 * @param id
	 */
	public void deleteBatch(List<Integer> ids) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
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
