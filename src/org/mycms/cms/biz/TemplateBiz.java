package org.mycms.cms.biz;

import java.util.List;

import org.mycms.cms.entity.Template;

public interface TemplateBiz {
	int saveTemplate(Template template);
	List<Template> listTemplate();
	Template selectById(int temp_id);
}
