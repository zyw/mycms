package org.mycms.cms.entity;

import java.io.Serializable;

public class Module implements Serializable {

	private static final long serialVersionUID = -202925812715656765L;
	
	private int id;
	private String m_name;				//模版中模块的英文名称，保证其唯一性，生成主题模版中的模块目录名称
	private String m_title;				//模版中模块的中文名称
	private int temp_id;				//所属模版ID
	private String def_template;		//使用的模板名称
	private String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_title() {
		return m_title;
	}
	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	public int getTemp_id() {
		return temp_id;
	}
	public void setTemp_id(int temp_id) {
		this.temp_id = temp_id;
	}
	public String getDef_template() {
		return def_template;
	}
	public void setDef_template(String def_template) {
		this.def_template = def_template;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
