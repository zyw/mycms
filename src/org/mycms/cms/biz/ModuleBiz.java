package org.mycms.cms.biz;

import java.util.List;

import org.mycms.cms.entity.Module;

public interface ModuleBiz {
	int saveModule(Module module);
	List<Module> listModule(int tempId);
}
