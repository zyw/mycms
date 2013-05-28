package org.mycms.cms.action;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.mycms.cms.commons.Attributes;
import org.mycms.cms.commons.Constant;
import org.mycms.cms.commons.TreeVO;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component("resourceAction")
public class ResourceAction extends BaseAction {

	private static final long serialVersionUID = 1593533224923227632L;
	
	private String id;
	private String filePath;
	private List<Map<String,String>> filesInfo;
	private String currentPath;
	
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	@JSON(name="rows")
	public List<Map<String, String>> getFilesInfo() {
		return filesInfo;
	}

	public String getCurrentPath() {
		return currentPath;
	}

	@Override
	public String execute() throws Exception {
		StringBuffer sb = new StringBuffer();
		if(id==null){
			String realPath = ServletActionContext.getServletContext().getRealPath(Constant.SKINS);
			File resfile = new File(realPath);
			File[] files = resfile.listFiles();
			sb.append("[{\"id\":1,");
			sb.append("\"text\":\"资源树\",");
			sb.append("\"state\": \"open\",");
			sb.append("\"children\":");
			List<TreeVO> temp = new ArrayList<TreeVO>();
			TreeVO tv = null;
			for(int i=0;i<files.length;i++){
				tv = new TreeVO();
				tv.setId(files[i].getName() + Constant.RES);
				tv.setText(files[i].getName());
				tv.setState("closed");
				tv.setAttributes(new Attributes(1));
				temp.add(tv);
			}
			Gson gson = new Gson();
			sb.append(gson.toJson(temp));
			sb.append("}]");
		}else{
			String realPath = ServletActionContext.getServletContext().getRealPath(Constant.SKINS + File.separator + id);
			File resFile = new File(realPath);
			File[] resFiles = resFile.listFiles();
			List<TreeVO> tempList = new ArrayList<TreeVO>();
			TreeVO tv = null;
			for(int i = 0; i < resFiles.length; i++){
				tv = new TreeVO();
				tv.setText(resFiles[i].getName());
				if(resFiles[i].isFile()){
					tv.setId(id + File.separator + resFiles[i].getName());
					tv.setState("open");
					tv.setAttributes(new Attributes(0));
				}else{
					tv.setId(id + File.separator + resFiles[i].getName());
					tv.setState("closed");
					tv.setAttributes(new Attributes(1));
				}
				tempList.add(tv);
			}
			Gson gson = new Gson();
			sb.append(gson.toJson(tempList));
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Cache-Control","no-cache");
		
		PrintWriter pw = response.getWriter();
		pw.print(sb.toString());
		pw.flush();
		//清除缓存
		setId(null);
		return null;
	}
	public String fileInfo() throws Exception{
		
		if(filePath==null){
			currentPath = Constant.SKINS;
			
		}else{
			currentPath = Constant.SKINS + File.separator + filePath;
		}
		String realPath =  ServletActionContext.getServletContext().getRealPath(currentPath);;
		File resfile = new File(realPath);
		if(resfile.isFile()) return SUCCESS;
		File[] files = resfile.listFiles();
		filesInfo = new ArrayList<Map<String,String>>();
		Map<String,String> tempMap = null;
		for(int i = 0; i < files.length; i++){
			tempMap = new HashMap<String,String>();
			tempMap.put("fileName", files[i].getName());
			tempMap.put("fileSize", (files[i].length()/8)+"");
			Calendar datetime = Calendar.getInstance();
			Date date = new Date(files[i].lastModified());
			datetime.setTime(date);
			tempMap.put("lastModified", date.toString()+" "+datetime.get(Calendar.HOUR_OF_DAY)+":"+datetime.get(Calendar.MINUTE)+":"+datetime.get(Calendar.SECOND));
			filesInfo.add(tempMap);
		}
		return SUCCESS;
	}
}
