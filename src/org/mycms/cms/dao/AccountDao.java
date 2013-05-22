package org.mycms.cms.dao;

import org.mycms.cms.entity.Account;

public interface AccountDao {
	/**
	 * 登录接口
	 * */
	Account accountlogin(Account account);
	/**
	 * 修改最后的登录时间
	 * */
	boolean updateLoginDate(Account account);
}
