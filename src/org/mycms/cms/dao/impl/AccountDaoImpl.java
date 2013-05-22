package org.mycms.cms.dao.impl;

import java.util.List;

import org.mycms.cms.dao.AccountDao;
import org.mycms.cms.dao.BaseDao;
import org.mycms.cms.entity.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Component("accountDao")
public class AccountDaoImpl extends BaseDao implements AccountDao {
	
	@SuppressWarnings("unchecked")
	public Account accountlogin(Account account) {
		String hql = "From Account as a where a.account_loginname=? and a.account_password=?";
		Account result = null;
		try {
			List<Account> accounts = getHibernateTemplate().find(hql, account.getAccount_loginname(),account.getAccount_password());
			if(accounts != null && !accounts.isEmpty()){
				result = accounts.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean updateLoginDate(Account account) {
		boolean result = false;
		try {
			getHibernateTemplate().update(account);
			result = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return result;
	}

}
