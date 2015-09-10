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
		message.setDescription("¾«²Ê");
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

}
