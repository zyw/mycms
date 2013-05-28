package org.mycms.cms.commons;

import java.io.Serializable;

public class TreeVO implements Serializable {

	private static final long serialVersionUID = 6592015478612055669L;
	
	private String id;  
    private String text;
    private String state;
    private String iconCls;
    private Attributes attributes;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
}
