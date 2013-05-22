package org.mycms.cms.biz;

import java.util.List;

import org.mycms.cms.entity.Column;

public interface ColumnBiz {
	boolean addColumn(Column column);
	List<Column> listByParentId(Integer parentId);
}
