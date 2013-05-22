package org.mycms.cms.dao;

import java.util.List;

import org.mycms.cms.entity.Module;

public interface ModuleDao {
	int saveModule(Module module);
	List<Module> listModule(int tempId);
}
