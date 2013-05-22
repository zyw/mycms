package org.mycms.cms.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.mycms.cms.biz.ModuleBiz;
import org.mycms.cms.commons.Constant;
import org.mycms.cms.entity.Module;
import org.springframework.stereotype.Component;

@Component("moduleAction")
public class ModuleAction extends BaseAction {

	private static final long serialVersionUID = 5348192562775503900L;
	
	@Resource(name="moduleBiz")
	private ModuleBiz moduleBiz;
	
	private Module module;
	private List<Module> modules;
	private int total;
	
	
	private File tempfile;
	private String tempfileFileName;
	private String tempfileContentType;
	private String templateName;
	
	@JSON(serialize=false)
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	@JSON(name="rows")
	public List<Module> getModules() {
		return modules;
	}

	public int getTotal() {
		return total;
	}

	public void setTempfile(File tempfile) {
		this.tempfile = tempfile;
	}

	public void setTempfileFileName(String tempfileFileName) {
		this.tempfileFileName = tempfileFileName;
	}

	public void setTempfileContentType(String tempfileContentType) {
		this.tempfileContentType = tempfileContentType;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
//
//	public String getTemplateName() {
//		return templateName;
//	}

	public String addModule() throws Exception{
		String realPath = ServletActionContext.getServletContext().getRealPath(Constant.SKINS+File.separator+templateName);
		File file = new File(realPath+File.separator+module.getM_name());
		if(!file.exists()){
			file.mkdirs();
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(tempfile);
			fos = new FileOutputStream(file+File.separator+tempfileFileName);
			byte[] buff = new byte[1024];
			int len = 0;
			while((len=fis.read(buff))!= -1){
				fos.write(buff, 0, len);
				fos.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}finally{
			fos.close();
			fis.close();
		}
		module.setDef_template(tempfileFileName);
		int result = moduleBiz.saveModule(module);
		if(result > 0){
			return SUCCESS;
		}
		return ERROR;
	}
	public String listModule() throws Exception{
		modules = moduleBiz.listModule(module.getTemp_id());
		if(modules == null) return ERROR;
		total = modules.size();
		return FINISH;
	}
}
