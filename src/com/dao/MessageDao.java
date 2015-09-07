package com.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	public List<Message> queryMessageList(String command,String description){
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);//将需要传递的两个参数封装为对象
			
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
	 * 单条删除
	 * @param id
	 */
	public void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句			
			sqlSession.delete("Message.deleteOne",id);
			//mybatis有事务控制能力，不会自动提交，所以对于增删改 需要手动提交，查询不需要的	
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
	 * 批量删除
	 * @param id
	 */
	public void deleteBatch(List<Integer> ids){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句			
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
