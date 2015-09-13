package com.dao;

import java.util.List;
import java.util.Map;

import com.bean.Message;

/**
 * @author Sumkor
 * 与Message配置文件相对应的接口
 */
public interface IMessage {
	//对应XML中id(queryMessageList),传入的参数,返回类型
	public List<Message> queryMessageList(Map<String,Object> parameter);
	public int count(Message message);
	public void insertOne(Message message);
}
