package com.yfhl.util.mail;

import java.util.Date;

public class mailTest {

	public void testSendEmail() {
		//设置邮件内容
		MimeMessageDTO mimeDTO = new MimeMessageDTO();
		String url="欢迎您注册爱体验网账号，快快点击链接，完成最后的注册验证吧！"
				+ "http://localhost:8080/3dcreatia/modelController/gotoModelPC.do";
		mimeDTO.setSentDate(new Date());
		mimeDTO.setSubject("邮件的标题");
		mimeDTO.setText(url);
		
		//设置相关参数
		String userName = "18519176409@163.com";
		String password = "Luans1234";
		String targetAddress = "1056429144@qq.com";
		
		//发送邮件
		if(MailUtil.sendEmail(userName, password, targetAddress, mimeDTO)){
			System.out.println("邮件发送成功！");
		}else{
			System.out.println("邮件发送失败!!!");
		}
		
	}

}
