package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.bean.Message;

public class MessageDaoTest {

	@Test
	public void testQueryMessageList() {
		MessageDao messageDao = new MessageDao();
		List<Message> mesList = new ArrayList<Message>();
		mesList = messageDao.queryMessageList("", "¾«²Ê");
		
		for(Message mes:mesList){
			System.out.println(mes.getId()+" "+mes.getCommand()
					+" "+mes.getDescription());
		}
	}

}
