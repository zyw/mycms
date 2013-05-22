package org.mycms.cms.dao.impl;

import java.util.List;

import org.mycms.cms.dao.BaseDao;
import org.mycms.cms.dao.ModuleDao;
import org.mycms.cms.entity.Module;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Component("moduleDao")
public class ModuleDaoImpl extends BaseDao implements ModuleDao {

	public int saveModule(Module module) {
		Integer result = 0;
		try {
			result = (Integer)getHibernateTemplate().save(module);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Module> listModule(int tempId) {
		String queryString = "From Module as m where m.temp_id=?";
		List<Module> result = null;
		try {
			result = getHibernateTemplate().find(queryString,tempId);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

}
