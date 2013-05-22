package org.mycms.cms.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer account_id;
	private String account_loginname;
	private String account_password;
	private String account_name;
	private String account_email;
	private Integer account_role;
	private String account_ip;
	private Integer login_count;
	private String mobilephone;
	private Timestamp lastLoginTime;
	private String originalPic;
	
	public Integer getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}
	public String getAccount_loginname() {
		return account_loginname;
	}
	public void setAccount_loginname(String account_loginname) {
		this.account_loginname = account_loginname;
	}
	public String getAccount_password() {
		return account_password;
	}
	public void setAccount_password(String account_password) {
		this.account_password = account_password;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getAccount_email() {
		return account_email;
	}
	public void setAccount_email(String account_email) {
		this.account_email = account_email;
	}
	public Integer getAccount_role() {
		return account_role;
	}
	public void setAccount_role(Integer account_role) {
		this.account_role = account_role;
	}
	public String getAccount_ip() {
		return account_ip;
	}
	public void setAccount_ip(String account_ip) {
		this.account_ip = account_ip;
	}
	public Integer getLogin_count() {
		return login_count;
	}
	public void setLogin_count(Integer login_count) {
		this.login_count = login_count;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getOriginalPic() {
		return originalPic;
	}
	public void setOriginalPic(String originalPic) {
		this.originalPic = originalPic;
	}
}
