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
		message.setDescription("����");
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
		message.setCommand("��Ŀ1");
		message.setDescription("��Ŀ1����");
		message.setContent("��Ŀ1��������������������������������������������");
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
		message.setCommand("��Ŀ5");
		message.setDescription("��Ŀ5�޸�");
		message.setContent("��Ŀ5�޸��޸��޸��޸��޸��޸��޸��޸��޸��޸�");
		messageDao.updateOne(message);
		System.out.println(message.getId()+" "+message.getCommand() +" "+message.getDescription());
	}
}
