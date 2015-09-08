package com.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bean.Command;
import com.db.DBAccess;

/**
 * 与指令表对应的数据库操作类
 */
public class CommandDao {
	/**
	 * 根据查询条件查询指令列表
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
			// 通过sqlSession执行SQL语句
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
