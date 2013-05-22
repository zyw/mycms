package org.mycms.cms.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDao extends HibernateDaoSupport {
	
	@Resource(name="sessionFactory")
	public void setSf(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
}
