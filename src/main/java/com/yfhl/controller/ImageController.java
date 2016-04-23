package com.yfhl.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import sun.misc.BASE64Decoder;

import com.yfhl.common.FileBaseController;

/**
 * 上传图片Controller
 * 
 * @author luans
 * @date 2015年11月20日
 */
@Controller
@Scope(value="prototype")
@SuppressWarnings("restriction")
@RequestMapping("imageController")
public class ImageController extends FileBaseController {

	/**
	 * 上传图片:单张图片上传（jquery）
	 * 
	 * @param HttpServletRequest
	 * @param String
	 * @return String:图片保存路径
	 * @date 2015年11月20日
	 * @auther luans
	 */
	@RequestMapping("updateImg")
	@ResponseBody
	public String updateImg(HttpServletRequest request, String image,String oldImg,String path) {
		System.out.println("进入图片上传");
		// String image = request.getParameter("image");
		String marker = image.substring(image.indexOf("/") + 1,
				image.indexOf(";"));
		System.out.println("marker=" + marker);
		String header = "data:image/" + marker + ";base64,";
		String image1 = image.substring(header.length());
		BASE64Decoder decoder = new BASE64Decoder();
		String rootpath = request.getSession().getServletContext()
				.getRealPath(System.getProperty("file.separator"));
		rootpath=rootpath.substring(0,rootpath.length()-10);//去掉"3dcreatia\",直接保存才服务器的webapp目录下，和项目同级目录
		System.out.println("存储路径：" + rootpath);
		String uploadpath = rootpath + path;
		File uploadPath = new File(uploadpath);
		String fileName =super.getFileNameNew() + "." + marker;// 图片名字
		System.out.println("fileName=" + fileName);	
		if (!uploadPath.exists()) {
			uploadPath.mkdirs();
		}
		String imgFilePath = uploadpath + System.getProperty("file.separator")
				+ fileName;
		System.out.println("数据库路径：" + imgFilePath);
		String name = imgFilePath.substring(imgFilePath.lastIndexOf("\\") + 1,
				imgFilePath.length());//
		System.out.println("name=" + name);
		try {
			byte[] decodedBytes = decoder.decodeBuffer(image1);
			FileOutputStream out = new FileOutputStream(imgFilePath);
			out.write(decodedBytes);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//删除之前的图片
		File f = new File(rootpath + path+oldImg);
		f.delete();
		return fileName;
	}

	/**
	 * 上传图片:多张图片上传（ swfupload插件）
	 * 
	 * @param HttpServletRequest
	 * @return String:图片保存路径
	 * @date 2016年1月26日
	 * @auther luans
	 */
	@RequestMapping("updateImgs")
	@ResponseBody
	public void uploadImgs(HttpServletRequest request) {
		System.out.println("进入后台添加图片");
		System.out.println("name====>" + request.getParameter("name"));
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置内存缓冲区，超过后写入临时文件
		factory.setSizeThreshold(10240000);
		// 设置临时文件存储位置
		String base = "d:/uploadFiles";

		File file = new File(base);
		if (!file.exists())
			file.mkdirs();
		factory.setRepository(file);
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置单个文件的最大上传值
		upload.setFileSizeMax(10002400000l);
		// 设置整个request的最大值
		upload.setSizeMax(10002400000l);
		upload.setHeaderEncoding("UTF-8");

		try {
			List<?> items = upload.parseRequest(request);
			FileItem item = null;
			String fileName = null;
			for (int i = 0; i < items.size(); i++) {
				item = (FileItem) items.get(i);
				fileName = base + File.separator + item.getName();
				// 保存文件
				if (!item.isFormField() && item.getName().length() > 0) {
					item.write(new File(fileName));
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 上传图片:多张图片上传（ webuploader插件）
	 * 
	 * @param MultipartFile
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @return String:图片保存路径
	 * @date 2016年2月2日
	 * @auther luans
	 */
	@RequestMapping("/uploadHeadPic")
	public String uploadHeadPic(@RequestParam("file") MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("uid:"+request.getParameter("uid"));
		try {
			super.upload(file, "/upload/uploadImg/model/", request);
		 
			response.getWriter().print(super.getFileName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
