package org.mycms.cms.dao;

import java.util.List;

import org.mycms.cms.entity.Column;

public interface ColumnDao {
	boolean addColumn(Column column);
	List<Column> listByParentId(Integer parentId);
}
