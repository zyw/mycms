package org.mycms.cms.entity;

import java.io.Serializable;

public class Template implements Serializable {

	private static final long serialVersionUID = -625904684134399111L;
	
	private int id;
	private String t_name;			//主题模板的英文名称 并保证其唯一性，生成的在skins目录中的目录名就是该名称
	private String t_title;			//主题模板的中文名称
	private String t_cover;			//封面图片
	private int t_isapply;			//是否使用
	private String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_title() {
		return t_title;
	}
	public void setT_title(String t_title) {
		this.t_title = t_title;
	}
	public String getT_cover() {
		return t_cover;
	}
	public void setT_cover(String t_cover) {
		this.t_cover = t_cover;
	}
	public int getT_isapply() {
		return t_isapply;
	}
	public void setT_isapply(int t_isapply) {
		this.t_isapply = t_isapply;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
