package org.mycms.cms.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mycms.cms.biz.TemplateBiz;
import org.mycms.cms.dao.TemplateDao;
import org.mycms.cms.entity.Template;
import org.springframework.stereotype.Service;

@Service("templateBiz")
public class TemplateBizImpl implements TemplateBiz {
	
	@Resource(name="templateDao")
	private TemplateDao templateDao;
	
	public int saveTemplate(Template template) {
		return templateDao.saveTemplate(template);
	}

	public List<Template> listTemplate() {
		return templateDao.listTemplate();
	}

	public Template selectById(int temp_id) {
		return templateDao.selectById(temp_id);
	}
}
