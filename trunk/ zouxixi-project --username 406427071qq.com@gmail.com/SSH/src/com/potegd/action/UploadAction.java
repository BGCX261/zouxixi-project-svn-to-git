package com.potegd.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@Component("uploadAction")
@Scope("prototype")
public class UploadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// 上传文件存放路径
	private final static String UPLOADDIR = "/Upload";
	// 上传文件集合
	private List<File> file;
	// 上传文件名集合
	private List<String> fileFileName;
	// 上传文件内容类型集合
	private List<String> fileContentType;

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String execute() throws Exception {
		try {
			for (int i = 0; i < file.size(); i++) {
				uploadFile(i);
			}
			return "success";
		} catch (Exception e) {
			//e.printStackTrace();
			//addFieldError("file", "至少要选择一个上传的文件！");
			addFieldError("file", getText("SelectOneFileAtLeast"));
			return "input";
		}
	}

	private void uploadFile(int i) throws FileNotFoundException, IOException {
		try {
			InputStream in = new FileInputStream(file.get(i));
			String dir = ServletActionContext.getServletContext().getRealPath(
					UPLOADDIR);
			System.out.println("上传文件的路径:" + dir);
			File uploadFile = new File(dir, this.getFileFileName().get(i));
			OutputStream out = new FileOutputStream(uploadFile);
			byte[] buffer = new byte[1024 * 1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			in.close();
			out.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
