package com.cn.config.mybatis;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

/**
 * Mybatis分页插件 <br/>
 * 注册MyBatis分页插件PageHelper
 * 
 * @author 姚通
 * @version 1.0
 */
@Configuration
public class MybatisConfig {

	/**
	 * 第一个参数是第几页；第二个参数是每页显示条数。 <br/>
	 * PageHelper.startPage(1,2);
	 * 
	 * @return
	 */
	@Bean
	public PageHelper pageHelper() {
		// System.out.println("MyBatisConfiguration.pageHelper()");
		PageHelper pageHelper = new PageHelper();
		Properties p = new Properties();
		p.setProperty("offsetAsPageNum", "true");
		p.setProperty("rowBoundsWithCount", "true");
		p.setProperty("reasonable", "true");
		pageHelper.setProperties(p);
		return pageHelper;
	}

}