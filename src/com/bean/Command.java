package com.bean;

import java.util.List;

/**
 * ��ָ����Ӧ��ʵ����
 */
public class Command {
	private String id;//����
	private String commandName;//ָ������
	private String description;//����
	private List<CommandContent> contentList;//һ��ָ���Ӧ���Զ��ظ������б�
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<CommandContent> getContentList() {
		return contentList;
	}
	public void setContentList(List<CommandContent> contentList) {
		this.contentList = contentList;
	}
	
}
