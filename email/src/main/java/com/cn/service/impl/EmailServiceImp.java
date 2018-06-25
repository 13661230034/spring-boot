package com.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cn.service.EmailService;

@Service
public class EmailServiceImp implements EmailService {

	@Value("${spring.mail.username}")
	private String from;

	@Autowired
	private JavaMailSender sender;

	/**
	 * 邮件发送
	 * 
	 * @param to
	 * @param title
	 * @param content
	 */
	public void sendSimple(String to, String title, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from); // 发送者
		message.setTo(to); // 接受者
		message.setSubject(title); // 发送标题
		message.setText(content); // 发送内容
		sender.send(message);

		System.out.println("邮件发送成功");
	}

}