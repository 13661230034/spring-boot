package com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 * 
 * @author ynt
 *
 */
@EnableAutoConfiguration // 启用自动配置，允许加载第三方 Jar 包的配置
@ComponentScan // 默认扫描 @SpringBootApplication 所在类的同级目录以及它的子目录
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
