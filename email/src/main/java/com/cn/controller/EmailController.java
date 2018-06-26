package com.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cn.service.impl.EmailServiceImp;
@Component
//@RestController
public class EmailController {

	@Autowired
	private EmailServiceImp emailService;
	// 收件人邮箱
	private String to = "13661230034@163.com";

	/**
	 * 邮件发送方法<br/>
	 * @param to 收件人邮箱地址<br/>
	 * @param title 头部<br/>
	 * @param content 内容<br/>
	 * @return<br/>
	 */
	@Scheduled(cron = "0/10 * * * * ?")
//	@RequestMapping("/")
	public String EmailTest() {
		emailService.sendSimple(to, "下班打卡", "重要事情说三遍、下班打卡、下班打卡、下班打卡");
		return "SUCCESS";
	}

}
