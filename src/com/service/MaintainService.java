package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.MessageDao;

/**
 * @author Sumkor
 * 维护相关的业务功能
 */
public class MaintainService {
	public void deleteOne(String id){
		if(id!=null && !"".equals(id.trim())){
			MessageDao message = new MessageDao();
			message.deleteOne(Integer.valueOf(id));
		}
	}
	public void deleteBatch(String[] ids){
		MessageDao message = new MessageDao();
		List<Integer> idList = new ArrayList<Integer>();
		for(String id:ids){
			idList.add(Integer.valueOf(id));
		}
		message.deleteBatch(idList);
	}
}
