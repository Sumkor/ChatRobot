package com.service;

import java.util.List;
import java.util.Random;

import com.bean.Command;
import com.bean.CommandContent;
import com.dao.CommandDao;

public class QueryService {

	/**
	 * 根据指令名称查询
	 * @param commandName
	 * @return
	 */
	public String queryByCommand(String commandName) {
		CommandDao commandDao = new CommandDao();
		List<Command> commandList = null;
		//回复主菜单
		if("help".equals(commandName)){
			commandList = commandDao.queryCommandList(null, null);//查询全部
			StringBuilder result = new StringBuilder();
			for (Command comm : commandList) {
				result.append("回复"+comm.getCommandName()+"可查看"+comm.getDescription()+"<br />");
			}
			return result.toString();
		}
		//回复指令名称对应信息
		commandList = commandDao.queryCommandList(commandName, null);
		if(commandList.size() > 0){
			List<CommandContent> contentList = commandList.get(0).getContentList();
			int i = new Random().nextInt(contentList.size());
			System.out.println(i);
			return contentList.get(i).getContent()+"<br />";
		}
		return "Unknown";
	}

}
