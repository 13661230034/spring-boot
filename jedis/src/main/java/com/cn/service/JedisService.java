package com.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.config.jedis.JedisConfiguration;

import redis.clients.jedis.Jedis;

@Service
public class JedisService {

	@Autowired
	private JedisConfiguration jedisconfiguration;

	public Jedis getjedis() {
		Jedis jedis = new Jedis(jedisconfiguration.getHost(), jedisconfiguration.getPort());
		System.out.println("jedis参数#####" + jedis);
		return jedis;
	}
}