package org.mycms.cms.dao.impl;

import java.util.List;

import org.mycms.cms.dao.BaseDao;
import org.mycms.cms.dao.TemplateDao;
import org.mycms.cms.entity.Template;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Component("templateDao")
public class TemplateDaoImpl extends BaseDao implements TemplateDao {

	public int saveTemplate(Template template) {
		Integer result = 0;
		try {
			result = (Integer)getHibernateTemplate().save(template);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Template> listTemplate() {
		String hql = "From Template as t order by t.id desc";
		List<Template> result = null;
		try {
			result = getHibernateTemplate().find(hql);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Template selectById(int temp_id) {
		String hql = "From Template as t where t.id = ?";
		Template result = null;
		List<Template> templates = null;
		try {
			templates = getHibernateTemplate().find(hql,temp_id);
			if(templates != null && !templates.isEmpty())
				result = templates.get(0);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

}
