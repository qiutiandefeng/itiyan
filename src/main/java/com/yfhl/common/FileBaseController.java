package com.yfhl.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 功能：上传文件公共Action
 * 
 * @date 2016年2月2日
 * @author luans
 *
 */
public class FileBaseController {
	private String allowSuffix = "jpg,png,gif,jpeg";// 允许文件格式
	private long allowSize = 2L;// 允许文件大小
	private String fileName;
	private String[] fileNames;

	public String getAllowSuffix() {
		return allowSuffix;
	}

	public void setAllowSuffix(String allowSuffix) {
		this.allowSuffix = allowSuffix;
	}

	public long getAllowSize() {
		return allowSize * 1024 * 1024;
	}

	public void setAllowSize(long allowSize) {
		this.allowSize = allowSize;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String[] getFileNames() {
		return fileNames;
	}

	public void setFileNames(String[] fileNames) {
		this.fileNames = fileNames;
	}

	/**
	 * 
	 * 功能：重新命名文件
	 * 
	 * @return String
	 * @date 2014年9月25日
	 * @author luans
	 */
	protected String getFileNameNew() {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		String pwdcode = RandomStringUtils.randomAlphanumeric(8);// 生成8位随机字符串：防止命名重复
		return pwdcode+fmt.format(new Date());
	}

	/**
	 * 
	 * 功能：文件上传
	 * 
	 * @param files
	 * @param destDir
	 * @throws Exception
	 * @date 2016年2月2日
	 * @author luans
	 */
	public void uploads(MultipartFile[] files, String destDir,
			HttpServletRequest request) throws Exception {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path;
		try {
			fileNames = new String[files.length];
			int index = 0;
			for (MultipartFile file : files) {
				String suffix = file.getOriginalFilename().substring(
						file.getOriginalFilename().lastIndexOf(".") + 1);
				int length = getAllowSuffix().indexOf(suffix);
				if (length == -1) {
					throw new Exception("请上传允许格式的文件");
				}
				if (file.getSize() > getAllowSize()) {
					throw new Exception("您上传的文件大小已经超出范围");
				}
				String realPath = request.getSession().getServletContext()
						.getRealPath("/");
				File destFile = new File(realPath + destDir);
				if (!destFile.exists()) {
					destFile.mkdirs();
				}
				String fileNameNew = getFileNameNew() + "." + suffix;//
				File f = new File(destFile.getAbsoluteFile() + "\\"
						+ fileNameNew);
				file.transferTo(f);
				f.createNewFile();
				fileNames[index++] = basePath + destDir + fileNameNew;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * 功能：文件上传
	 * 
	 * @param files
	 * @param destDir
	 * @throws Exception
	 * @date 2016年2月2日
	 * @author luans
	 */
	public String upload(MultipartFile file, String destDir,
			HttpServletRequest request) throws Exception {
		String path = request.getContextPath();
		
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path;
		String fileNameNew;
		System.out.println("basePath:"+basePath);
		try {
			String suffix = file.getOriginalFilename().substring(
					file.getOriginalFilename().lastIndexOf(".") + 1);
			int length = getAllowSuffix().indexOf(suffix);
			if (length == -1) {
				throw new Exception("请上传允许格式的文件");
			}
			if (file.getSize() > getAllowSize()) {
				throw new Exception("您上传的文件大小已经超出范围");
			}

			String realPath = request.getSession().getServletContext()
					.getRealPath("/");
			realPath=realPath.substring(0,realPath.length()-10);//去掉"3dcreatia\",直接保存才服务器的webapp目录下，和项目同级目录
			System.out.println("realPath:"+realPath);
			File destFile = new File(realPath + destDir);
			if (!destFile.exists()) {
				destFile.mkdirs();
			}
			fileNameNew = getFileNameNew() + "." + suffix;
			System.out.println("fileNameNew:"+fileNameNew);
			File f = new File(destFile.getAbsoluteFile() + "/" + fileNameNew);
			file.transferTo(f);
			f.createNewFile();
			fileName = basePath + destDir + fileNameNew;
		} catch (Exception e) {
			throw e;
		}
		return fileNameNew;
	}
}
