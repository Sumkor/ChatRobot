package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bean.Message;
import com.dao.MessageDao;
import com.util.Page;

/**
 * 列表相关的业务功能
 * servlet不与dao层直接交互
 * @author Sumkor
 */
public class ListService {
	public List<Message> queryMessageList(String command,String description,Page page){
		Message message=new Message();
		message.setCommand(command);
		message.setDescription(description);
		
		//设置查询条数
		MessageDao messageDao = new MessageDao();
		int totalNumber=messageDao.count(message);
		page.setTotalNumber(totalNumber);
		
		Map<String,Object> parameter=new HashMap<String,Object>();
		parameter.put("message", message);
		parameter.put("page", page);
		return messageDao.queryMessageList(parameter);
	}
}
