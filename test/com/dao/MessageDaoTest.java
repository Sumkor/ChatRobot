package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.bean.Message;
import com.util.Page;

public class MessageDaoTest {

	@Test
	public void testQueryMessageList() {
		MessageDao messageDao = new MessageDao();
		List<Message> mesList = new ArrayList<Message>();
		
		Map<String,Object> parameter = new HashMap<String,Object>();
		Message message = new Message();
		message.setDescription("精彩");
		parameter.put("message", message);
		
		Page page = new Page();
		page.setTotalNumber(5);
		page.setCurrentPage(1);
		parameter.put("page", page);
		mesList = messageDao.queryMessageList(parameter);
		
		for(Message mes:mesList){
			System.out.println(mes.getId()+" "+mes.getCommand()
					+" "+mes.getDescription());
		}
	}
	
	@Test
	public void testInsertOne(){
		MessageDao messageDao = new MessageDao();
		Message message = new Message();
		message.setCommand("条目1");
		message.setDescription("条目1描述");
		message.setContent("条目1内容内容内容内容内容内容内容内容内容内容内容");
		messageDao.insertOne(message);
	}
	
	@Test
	public void testQueryMesById() {
		MessageDao messageDao = new MessageDao();
		Message message = new Message();
		message = messageDao.queryMesById(5);
		System.out.println(message.getId()+" "+message.getCommand() +" "+message.getDescription());
	}
	
	@Test
	public void testUpdateOne() {
		MessageDao messageDao = new MessageDao();
		Message message = new Message();
		message.setId("12");
		message.setCommand("条目5");
		message.setDescription("条目5修改");
		message.setContent("条目5修改修改修改修改修改修改修改修改修改修改");
		messageDao.updateOne(message);
		System.out.println(message.getId()+" "+message.getCommand() +" "+message.getDescription());
	}
}
