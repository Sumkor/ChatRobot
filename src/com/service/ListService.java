package com.service;

import java.util.List;

import com.bean.Message;
import com.dao.MessageDao;

/**
 * 列表相关的业务功能
 * servlet不与dao层直接交互
 * @author Sumkor
 */
public class ListService {
	public List<Message> queryMessageList(String command,String description){
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessageList(command, description);
	}
}
