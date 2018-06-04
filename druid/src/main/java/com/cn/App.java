package com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 启动类
 * @author ynt
 *
 */
/**
 * 扫描Servlet组件时，Servlet、过滤器和监听器可以是通过@WebServlet、@WebFilter和@WebListener自动注册
 * 
 * @author ynt
 */
@ServletComponentScan
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}