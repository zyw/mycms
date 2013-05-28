package org.mycms.cms.commons;

import java.io.Serializable;

public class Attributes implements Serializable {

	private static final long serialVersionUID = -4513729356935131391L;
	
	private int fileType;
	

	public Attributes() {
		super();
	}

	public Attributes(int fileType) {
		super();
		this.fileType = fileType;
	}

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}
}
