package org.mycms.cms.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mycms.cms.biz.ColumnBiz;
import org.mycms.cms.dao.ColumnDao;
import org.mycms.cms.entity.Column;
import org.springframework.stereotype.Service;

@Service("columnBiz")
public class ColumnBizImpl implements ColumnBiz {
	
	@Resource(name="columnDao")
	private ColumnDao columnDao;
	
	public boolean addColumn(Column column) {
		return columnDao.addColumn(column);
	}

	public List<Column> listByParentId(Integer parentId) {
		return columnDao.listByParentId(parentId);
	}

}
