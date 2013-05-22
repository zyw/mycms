package org.mycms.cms.action;

import javax.annotation.Resource;

import org.mycms.cms.biz.ColumnBiz;
import org.mycms.cms.entity.Column;
import org.springframework.stereotype.Component;

@Component("columnAction")
public class ColumnAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	@Resource(name="columnBiz")
	private ColumnBiz columnBiz;
	
	private Column column;
	
	public Column getColumn() {
		return column;
	}
	public void setColumn(Column column) {
		this.column = column;
	}
	
	public String addColumn()throws Exception{
		boolean result = columnBiz.addColumn(column);
		if(!result)
			return ERROR;
		return SUCCESS;
	}
	public String listByParentId()throws Exception{
		return SUCCESS;
	}
}
