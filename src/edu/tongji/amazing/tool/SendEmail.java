package edu.tongji.amazing.tool;

import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.SSLSocketFactory;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.inject.Factory;

@Component("sendemail")
public class SendEmail {

	private JavaMailSenderImpl email;
	
	private MimeMessage message;
	
	public SendEmail() {
		// TODO Auto-generated constructor stub
		email = new JavaMailSenderImpl();
		email.setHost("smtp.qq.com");
		email.setUsername("772773671@qq.com");
		email.setPassword("celufkikdtfebedd");
		email.setPort(465);
		email.setDefaultEncoding("UTF-8");
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.ssl.enable", true);
		properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.timeout", 25000);
		email.setJavaMailProperties(properties);
//		System.out.println("构造函数的调用");
	}
	
	//发送邮件
	public void send(String emailaddress,String phone) throws MessagingException{
		message = email.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setFrom("772773671@qq.com");
		helper.setTo(emailaddress);
		helper.setSubject("欢迎您注册世界之窗 ");
		helper.setText(
				"<font color='red'>"
				+ "请点击一下的连接激活账户：http://10.60.42.70:8080/AmazingAd/web/advertiser/active?phone="+phone
				+ "</font>",true);
		email.send(message);
	}
}
