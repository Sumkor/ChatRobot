package com.service;

import java.util.ArrayList;
import java.util.List;

import com.bean.Message;
import com.dao.MessageDao;

/**
 * @author Sumkor
 * 维护相关的业务功能
 */
public class MaintainService {
	public void deleteOne(String id){
		if(id!=null && !"".equals(id.trim())){
			MessageDao messageDao = new MessageDao();
			messageDao.deleteOne(Integer.valueOf(id));
		}
	}
	public void deleteBatch(String[] ids){
		MessageDao messageDao = new MessageDao();
		List<Integer> idList = new ArrayList<Integer>();
		for(String id:ids){
			idList.add(Integer.valueOf(id));
		}
		messageDao.deleteBatch(idList);
	}
	/**
	 * 插入单条
	 * @param command
	 * @param description
	 * @param content
	 */
	public void insertOne(String command,String description,String content){
		MessageDao messageDao = new MessageDao();
		Message message = new Message();
//		if(command!=null && !"".equals(command.trim())
//				&& description!=null && !"".equals(description.trim()) 
//				&& content!=null && !"".equals(content.trim())){
//			message.setCommand(command);
//			message.setDescription(description);
//			message.setContent(content);
//			messageDao.insertOne(message);
//		}
		message.setCommand(command);
		message.setDescription(description);
		message.setContent(content);
		messageDao.insertOne(message);
	}
}
