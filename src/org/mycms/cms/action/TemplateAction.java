package org.mycms.cms.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.mycms.cms.biz.TemplateBiz;
import org.mycms.cms.commons.Constant;
import org.mycms.cms.entity.Template;
import org.springframework.stereotype.Component;

@Component("templateAction")
public class TemplateAction extends BaseAction {

	private static final long serialVersionUID = 3656953570566467098L;
	
	@Resource(name="templateBiz")
	private TemplateBiz templateBiz;
	
	private Template template;
	private List<Template> templates;
	private int total;
	
	private File cover;
	private String coverFileName;
	private String coverContentType;
	
	@JSON(serialize=false)
	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}
	@JSON(name="rows")
	public List<Template> getTemplates() {
		return templates;
	}
	
	public int getTotal() {
		return total;
	}

	@JSON(serialize=false)
	public File getCover() {
		return cover;
	}

	public void setCover(File cover) {
		this.cover = cover;
	}
	@JSON(serialize=false)
	public String getCoverFileName() {
		return coverFileName;
	}

	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}
	@JSON(serialize=false)
	public String getCoverContentType() {
		return coverContentType;
	}

	public void setCoverContentType(String coverContentType) {
		this.coverContentType = coverContentType;
	}
	public String addTemplate() throws Exception{
		String realPath = ServletActionContext.getServletContext().getRealPath(Constant.SKINS);
		File cover_file = new File(realPath+File.separator+template.getT_name());
		
		if(cover_file.exists()) return INPUT;
		
		if(!cover_file.mkdir()) return INPUT;
		
		String pathName = "cover" + coverFileName.substring(coverFileName.lastIndexOf("."));
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(cover);
			fos = new FileOutputStream(cover_file+File.separator+pathName);
			byte[] buffer = new byte[1024];
			int len = 0;
			
			while((len=fis.read(buffer))!=-1){
				fos.write(buffer, 0, len);
				fos.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			fos.close();
			fis.close();
		}
		template.setT_cover(pathName);
		int result = templateBiz.saveTemplate(template);
		if(result > 0)
			return SUCCESS;
		return ERROR;
	}
	public String listTemplate() throws Exception{
		templates = templateBiz.listTemplate();
		if(templates == null) return ERROR;
		String basePath = ServletActionContext.getRequest().getScheme()+"://"+ServletActionContext.getRequest().getServerName()
			+":"+ServletActionContext.getRequest().getServerPort()+ServletActionContext.getRequest().getContextPath()+"/skins";
		for(Template t : templates)
			t.setT_cover(basePath+"/"+t.getT_name()+"/"+t.getT_cover());
		total = templates.size();
		return FINISH;
	}
}
