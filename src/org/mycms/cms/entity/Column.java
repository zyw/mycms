package org.mycms.cms.entity;

import java.io.Serializable;

public class Column implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer column_id;
	private String column_name;
	private String column_title;
	private String template;
	private String column_icon;
	private String openway;
	private Integer column_order;
	private Integer parentId;
	private String description;
	
	public Integer getColumn_id() {
		return column_id;
	}
	public void setColumn_id(Integer column_id) {
		this.column_id = column_id;
	}
	public String getColumn_name() {
		return column_name;
	}
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	public String getColumn_title() {
		return column_title;
	}
	public void setColumn_title(String column_title) {
		this.column_title = column_title;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getColumn_icon() {
		return column_icon;
	}
	public void setColumn_icon(String column_icon) {
		this.column_icon = column_icon;
	}
	public String getOpenway() {
		return openway;
	}
	public void setOpenway(String openway) {
		this.openway = openway;
	}
	public Integer getColumn_order() {
		return column_order;
	}
	public void setColumn_order(Integer column_order) {
		this.column_order = column_order;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
