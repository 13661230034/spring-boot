package com.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cn.service.JedisService;

import redis.clients.jedis.Jedis;

/**
 * Jedis测试类
 * 
 * @author ynt
 *
 */
@RestController
public class JedisDemoController {

	@Autowired
	private JedisService jedisService;

	@RequestMapping(value = { "/getjedis" }, method = { RequestMethod.GET }, produces="application/json;charset=UTF-8")
	public String jediss(){
		Jedis jed = jedisService.getjedis();
		jed.set("name", "姚通");
		System.out.println(jed);
		return jed.toString();
	}
	
}
