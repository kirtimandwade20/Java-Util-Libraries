package com.xml.converter.pojo;

public class Detail {

	@Override
	public String toString() {
		return "Detail [messageId=" + messageId + ", text=" + text + "]";
	}
	private String messageId;
	private String text;
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
