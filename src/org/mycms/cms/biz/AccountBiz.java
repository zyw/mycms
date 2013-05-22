package org.mycms.cms.biz;

import org.mycms.cms.entity.Account;

public interface AccountBiz {
	Account accountlogin(Account account);
	/**
	 * 修改最后的登录时间
	 * */
	boolean updateLoginDate(Account account);
}
