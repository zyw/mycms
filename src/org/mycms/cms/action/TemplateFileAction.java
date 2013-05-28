package org.mycms.cms.action;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.mycms.cms.commons.Constant;
import org.mycms.cms.commons.Message;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component("templateFileAction")
public class TemplateFileAction extends BaseAction {

	private static final long serialVersionUID = 7847595614308232868L;
	
	private Message message;
	
	private String templateName;	//所属模板名称
	private String moduleName;		//所属模块名称
	private String fileName;		//要加载的模板文件名称
	private String fileContent;		//上传的文件内容
	
	private File tempFile;
	private String tempFileFileName;
	private String tempFileContentType;
	
	public void setTempFileContentType(String tempFileContentType) {
		this.tempFileContentType = tempFileContentType;
	}
	private Map<String,List<String>> fileInfos; 
	
	public Message getMessage() {
		return message;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	public Map<String, List<String>> getFileInfos() {
		return fileInfos;
	}

	public void setTempFile(File tempFile) {
		this.tempFile = tempFile;
	}

	public void setTempFileFileName(String tempFileFileName) {
		this.tempFileFileName = tempFileFileName;
	}

	@Override
	public String execute() throws Exception {
		String realPath = ServletActionContext.getServletContext().getRealPath(Constant.SKINS+File.separator+templateName+File.separator+moduleName);
		File tempfiles = new File(realPath);
		File[] vmfiles = tempfiles.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".vm");
			}
		});
		List<String> names = null;
		List<String> contents = null;
		if(vmfiles.length > 0){
			fileInfos = new HashMap<String, List<String>>();
			names = new ArrayList<String>();
			contents = new ArrayList<String>();
		}
		
		for(int i=0;i<vmfiles.length;i++){
			String name = vmfiles[i].getName();
			names.add(name);
			if(i == 0){
				BufferedReader content = new BufferedReader(new InputStreamReader(new FileInputStream(vmfiles[i]), "UTF-8"));
				StringBuffer sb = new StringBuffer();
				String temp = null;
				while((temp = content.readLine()) != null){
					sb.append(temp+"\n");
				}
				content.close();
				contents.add(sb.toString());
				fileInfos.put("contents", contents);
			}
			fileInfos.put("names", names);
		}
		return SUCCESS;
	}
	public String readerFile() throws Exception{
		String realPath = ServletActionContext.getServletContext().getRealPath(Constant.SKINS+File.separator+templateName+File.separator+moduleName+File.separator+fileName);
		readFileContent(realPath);
		return null;
	}
	public String readerRes() throws Exception{
		String realPath = ServletActionContext.getServletContext().getRealPath(Constant.SKINS+File.separator+fileName);
		readFileContent(realPath);
		return null;
	}
	public String saveModify() throws Exception{
		String realPath = ServletActionContext.getServletContext().getRealPath(Constant.SKINS+File.separator+templateName+File.separator+moduleName+File.separator+fileName);
		File file = new File(realPath);
		message = new Message();
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
			bw.write(fileContent);
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
			message.setNameContent(Constant.ERROR, "修改失败！");
		}finally{
			bw.close();
		}
		message.setNameContent(Constant.SUCCESS, "修改成功！");
		return FINISH;
	}
	public String uploadTempFile() throws Exception{
		String realPath = ServletActionContext.getServletContext().getRealPath(Constant.SKINS+File.separator+templateName+File.separator+moduleName+File.separator+tempFileFileName);
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(tempFile);
			fos = new FileOutputStream(realPath);
			int len = 0;
			byte[] buff = new byte[1024];
			while((len = fis.read(buff)) != -1){
				fos.write(buff, 0, len);
			}
			fos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			fos.close();
			fis.close();
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter pw = response.getWriter();
		pw.print("{ success: true, fileUrl:'" + realPath + "' }");
		pw.flush();
		return null;
	}
	private void readFileContent(String realPath) throws IOException, FileNotFoundException{
		File file = new File(realPath);
		Map<String,String> fileContentList = new HashMap<String,String>();
		StringBuffer sb = new StringBuffer();
		
		BufferedReader content = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		String temp = null;
		while((temp = content.readLine()) != null){
			sb.append(temp+"\n");
		}
		content.close();
		
		fileContentList.put("content", sb.toString());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Cache-Control","no-cache");
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(fileContentList);
		PrintWriter pw = response.getWriter();
		pw.print(json);
		pw.flush();
	}
}
