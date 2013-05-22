package org.mycms.cms.biz.impl;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.mycms.cms.biz.AccountBiz;
import org.mycms.cms.dao.AccountDao;
import org.mycms.cms.entity.Account;
import org.springframework.stereotype.Service;

@Service("accountBiz")
public class AccountBizImpl implements AccountBiz {
	
	@Resource(name="accountDao")
	private AccountDao accountDao;
	
	public Account accountlogin(Account account) {
		return accountDao.accountlogin(account);
	}

	public boolean updateLoginDate(Account account) {
		account.setLastLoginTime(new Timestamp(new Date().getTime()));
		return accountDao.updateLoginDate(account);
	}
}
