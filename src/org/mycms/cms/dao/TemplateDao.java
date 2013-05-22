package org.mycms.cms.dao;

import java.util.List;

import org.mycms.cms.entity.Template;

public interface TemplateDao {
	int saveTemplate(Template template);
	List<Template> listTemplate();
	Template selectById(int temp_id);
}
