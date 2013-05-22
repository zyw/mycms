package org.mycms.cms.dao.impl;

import java.util.List;

import org.mycms.cms.dao.BaseDao;
import org.mycms.cms.dao.ColumnDao;
import org.mycms.cms.entity.Column;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Component("columnDao")
public class ColumnDaoImpl extends BaseDao implements ColumnDao {

	public boolean addColumn(Column column) {
		try {
			Integer id = (Integer)getHibernateTemplate().save(column);
			if(id != null && id.intValue() > 0)
				return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Column> listByParentId(Integer parentId) {
		String hql = "From Column as c where c.parentId = ?";
		List<Column> result = null;
		try {
			result = getHibernateTemplate().find(hql, parentId);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		
		return result;
	}

}
