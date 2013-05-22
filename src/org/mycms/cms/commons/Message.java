package org.mycms.cms.commons;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = 7141332086740894684L;
	
	private Integer messageId;
	private String messageName;
	private String messageContent;
	
	public Message() {
		super();
	}
	public Message(String messageName, String messageContent) {
		super();
		this.messageName = messageName;
		this.messageContent = messageContent;
	}
	public Message(Integer messageId, String messageName, String messageContent) {
		super();
		this.messageId = messageId;
		this.messageName = messageName;
		this.messageContent = messageContent;
	}
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public String getMessageName() {
		return messageName;
	}
	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public void setNameContent(String name,String content){
		this.messageName = name;
		this.messageContent = content;
	}
}
