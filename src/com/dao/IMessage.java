package com.dao;

import java.util.List;
import java.util.Map;

import com.bean.Message;

/**
 * @author Sumkor
 * 与Message配置文件相对应的接口
 */
public interface IMessage {
	//对应XML中的SQL语句id,参数类型,返回类型
	public List<Message> queryMessageList(Map<String,Object> parameter);
	public int count(Message message);
}
