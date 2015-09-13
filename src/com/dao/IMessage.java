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
	public List<Message> queryMessageList(Map<String,Object> parameter);//根据条件查询，需传入Page信息
	public Message queryMesById(int id);//根据id查询
	public int count(Message message);
	public void deleteOne(int id);
	public void deleteBatch(List<Integer> id);
	public void insertOne(Message message);
	public void updateOne(Message message);
}
