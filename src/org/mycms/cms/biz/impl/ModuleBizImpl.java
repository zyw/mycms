package org.mycms.cms.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mycms.cms.biz.ModuleBiz;
import org.mycms.cms.dao.ModuleDao;
import org.mycms.cms.entity.Module;
import org.springframework.stereotype.Service;

@Service("moduleBiz")
public class ModuleBizImpl implements ModuleBiz {
	
	@Resource(name="moduleDao")
	private ModuleDao moduleDao;
	
	public int saveModule(Module module) {
		return moduleDao.saveModule(module);
	}

	public List<Module> listModule(int tempId) {
		return moduleDao.listModule(tempId);
	}
}
