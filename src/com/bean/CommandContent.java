package com.bean;

/**
 * 与指令内容表对应的实体类
 */
public class CommandContent {
	private String id;//主键
	private String content;//自动回复的内容
	private String commandId;//关联的指令表主键

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCommandId() {
		return commandId;
	}

	public void setCommandId(String commandId) {
		this.commandId = commandId;
	}
}
