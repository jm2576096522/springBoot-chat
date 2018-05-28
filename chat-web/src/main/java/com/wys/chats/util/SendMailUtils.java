package com.wys.chats.util;

import java.io.File;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

@Configuration
public class SendMailUtils {

	@Value(value = "${spring.mail.host}")
	private String host;

	@Value(value = "${spring.mail.username}")
	private String username;

	@Value(value = "${spring.mail.password}")
	private String password;

	@Value(value = "${spring.mail.port}")
	private String port;

	@Value(value = "${spring.mail.protocol}")
	private String protocol;

	@Value(value = "${spring.mail.properties.mail.debug}")
	private String propertiesMmailDebug;

	@Value(value = "${spring.mail.properties.mail.smtp.socketFactory.class}")
	private String propertiesMailSmtpSocketFactoryClass;

	@Value(value = "${spring.mail.properties.mail.smtp.auth}")
	private String propertiesMailSmtpAuth;

	@Value(value = "${spring.mail.properties.mail.smtp.timeout}")
	private String propertiesMailSmtpTimeout;

	private JavaMailSenderImpl mailSender;

	private String random;

	public void getRandom() {
		random = (int) (Math.random() * 1000000) + "";
	}

	public final String DEFALUT_ENCODING = "UTF-8";

	public String sendTextWithMail(String[] tos, String subject, String text) throws Exception {
		mailSender = initJavaMailSender();
		MimeMessage mailMessage = mailSender.createMimeMessage();
		getRandom();
		initMimeMessageHelper(mailMessage, tos, mailSender.getUsername(), subject, text + random);
		// 发送邮件
		mailSender.send(mailMessage);
		System.out.println("邮件发送成功..");
		return random;
	}

	public void sendTextWithHtml(JavaMailSenderImpl sender, String[] tos, String subject, String text)
			throws Exception {
		MimeMessage mailMessage = sender.createMimeMessage();
		initMimeMessageHelper(mailMessage, tos, sender.getUsername(), subject, text);
		// 发送邮件
		sender.send(mailMessage);

		System.out.println("邮件发送成功..");
	}

	public void sendTextWithImg(JavaMailSenderImpl sender, String[] tos, String subject, String text, String imgId,
			String imgPath) throws MessagingException {
		MimeMessage mailMessage = sender.createMimeMessage();
		MimeMessageHelper messageHelper = initMimeMessageHelper(mailMessage, tos, sender.getUsername(), subject, text,
				true, true, "GBK");
		// 发送图片
		FileSystemResource img = new FileSystemResource(new File(imgPath));
		messageHelper.addInline(imgId, img);
		// 发送邮件
		sender.send(mailMessage);

		System.out.println("邮件发送成功..");
	}

	public void sendWithAttament(JavaMailSenderImpl sender, String[] tos, String subject, String text,
			String AttachName, String filePath) throws MessagingException {
		MimeMessage mailMessage = sender.createMimeMessage();
		MimeMessageHelper messageHelper = initMimeMessageHelper(mailMessage, tos, sender.getUsername(), subject, text,
				true, true, DEFALUT_ENCODING);

		FileSystemResource file = new FileSystemResource(new File(filePath));
		// 发送邮件
		messageHelper.addAttachment(AttachName, file);
		sender.send(mailMessage);

		System.out.println("邮件发送成功..");

	}

	public void sendWithAll(JavaMailSenderImpl sender, String[] tos, String from, String subject, String text,
			String imgId, String imgPath, String AttachName, String filePath) throws MessagingException {
		MimeMessage mailMessage = sender.createMimeMessage();
		MimeMessageHelper messageHelper = initMimeMessageHelper(mailMessage, tos, sender.getUsername(), subject, text,
				true, true, DEFALUT_ENCODING);
		// 插入图片
		FileSystemResource img = new FileSystemResource(new File(imgPath));
		messageHelper.addInline(imgId, img);
		// 插入附件
		FileSystemResource file = new FileSystemResource(new File(filePath));
		messageHelper.addAttachment(AttachName, file);
		// 发送邮件
		sender.send(mailMessage);
		System.out.println("邮件发送成功..");

	}

	private MimeMessageHelper initMimeMessageHelper(MimeMessage mailMessage, String[] tos, String from, String subject,
			String text) throws MessagingException {
		return initMimeMessageHelper(mailMessage, tos, from, subject, text, true, false, DEFALUT_ENCODING);
	}

	private MimeMessageHelper initMimeMessageHelper(MimeMessage mailMessage, String[] tos, String from, String subject,
			String text, boolean isHTML, boolean multipart, String encoding) throws MessagingException {
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, multipart, encoding);
		//接收方
		messageHelper.setTo(tos);
		//发送方
		messageHelper.setFrom(from);
		messageHelper.setSubject(subject);
		// true 表示启动HTML格式的邮件
		messageHelper.setText(text, isHTML);
		return messageHelper;
	}

	public JavaMailSenderImpl initJavaMailSender() {
		Properties properties = new Properties();
		properties.setProperty("mail.debug", propertiesMmailDebug.trim());// 是否显示调试信息(可选)
		properties.setProperty("mail.smtp.starttls.enable", "false");
		properties.setProperty("mail.smtp.socketFactory.class", propertiesMailSmtpSocketFactoryClass.trim());
		properties.setProperty("mail.smtp.auth", propertiesMailSmtpAuth.trim());
		properties.put(" mail.smtp.timeout ", propertiesMailSmtpTimeout.trim());
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setJavaMailProperties(properties);
		javaMailSender.setHost(host.trim());
		javaMailSender.setUsername(username.trim()); // 根据自己的情况,设置username
		javaMailSender.setPassword(password.trim()); // 根据自己的情况, 设置password
		javaMailSender.setPort(Integer.valueOf(port.trim()));
		javaMailSender.setDefaultEncoding("UTF-8");
		return javaMailSender;
	}

}