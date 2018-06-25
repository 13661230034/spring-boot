package com.cn.service;

public interface EmailService {

	/**
	 * 邮件发送
	 * 
	 * @param to
	 * @param title
	 * @param content
	 */
	public void sendSimple(String to, String title, String content);
	
	
	
	
}
