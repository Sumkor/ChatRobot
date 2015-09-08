package com.service;

import java.util.List;
import java.util.Random;

import com.bean.Command;
import com.bean.CommandContent;
import com.dao.CommandDao;

public class QueryService {

	/**
	 * ����ָ�����Ʋ�ѯ
	 * @param commandName
	 * @return
	 */
	public String queryByCommand(String commandName) {
		CommandDao commandDao = new CommandDao();
		List<Command> commandList = null;
		//�ظ����˵�
		if("help".equals(commandName)){
			commandList = commandDao.queryCommandList(null, null);//��ѯȫ��
			StringBuilder result = new StringBuilder();
			for (Command comm : commandList) {
				result.append("�ظ�"+comm.getCommandName()+"�ɲ鿴"+comm.getDescription()+"<br />");
			}
			return result.toString();
		}
		//�ظ�ָ�����ƶ�Ӧ��Ϣ
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
