package com.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.service.impl.EmailServiceImp;

@RestController
public class EmailController {

	@Autowired
	private EmailServiceImp emailService;
	// 收件人邮箱
	private String to = "13661230034@163.com";

	/**
	 * 邮件发送方法
	 * @param to 收件人邮箱地址
	 * @param title 头部
	 * @param content 内容
	 * @return
	 */
	@RequestMapping("/")
	public String EmailTest(String to, String title, String content) {
		emailService.sendSimple(to, title, content);
		return "SUCCESS";
	}

}
