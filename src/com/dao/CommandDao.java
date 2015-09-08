package com.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bean.Command;
import com.db.DBAccess;

/**
 * ��ָ����Ӧ�����ݿ������
 */
public class CommandDao {
	/**
	 * ���ݲ�ѯ������ѯָ���б�
	 */
	public List<Command> queryCommandList(String commandName,String description) {
		DBAccess dbAccess = new DBAccess();
		List<Command> commandList = new ArrayList<Command>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Command command = new Command();
			command.setCommandName(commandName);
			command.setDescription(description);
			// ͨ��sqlSessionִ��SQL���
			commandList = sqlSession.selectList("Command.queryCommandList", command);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return commandList;
	}
}
