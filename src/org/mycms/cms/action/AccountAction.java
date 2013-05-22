package org.mycms.cms.action;

import javax.annotation.Resource;

import org.mycms.cms.biz.AccountBiz;
import org.mycms.cms.commons.Constant;
import org.mycms.cms.commons.Toolkit;
import org.mycms.cms.entity.Account;
import org.springframework.stereotype.Component;

@Component("accountAction")
public class AccountAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	@Resource(name="accountBiz")
	private AccountBiz accountBiz;

	private Account account;

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}

	@Override
	public String execute() throws Exception {
		account.setAccount_password(Toolkit.MD5(account.getAccount_password()));
		Account a = accountBiz.accountlogin(account);
		if(a != null){
			session.put(Constant.LOGIN_KEY, a);
			accountBiz.updateLoginDate(a);
			System.out.println(a.getAccount_loginname());
			return SUCCESS;
		}
		return INPUT;
	}
}
