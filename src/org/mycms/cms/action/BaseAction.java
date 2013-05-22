package org.mycms.cms.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 3099729747828372058L;
	
	//用户查询完成没有错误后
	protected static final String FINISH = "finish";
	
	protected Map<String,Object> session;
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}
