package com.cn.config.jedis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

@Component
@Setter
@Getter
public class JedisConfiguration {
	@Autowired
	private JedisConfiguration jedisConfigurations;

	@Value("${jedis.port}")
	private int port;
	@Value("${jedis.host}")
	private String host;
	@Value("${jedis.max.total}")
	private Integer maxTotal;
	@Value("${jedis.max.idle}")
	private Integer maxIdle;
	@Value("${jedis.max.waitmillis}")
	private Long maxWaitMillis;

	public JedisConfiguration() {
	}

	@Bean
	public ShardedJedisPool shardedJedisPool() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(jedisConfigurations.getMaxTotal());
		jedisPoolConfig.setMaxIdle(jedisConfigurations.getMaxIdle());
		jedisPoolConfig.setMaxWaitMillis(jedisConfigurations.getMaxWaitMillis());
		List<JedisShardInfo> jedisShardInfos = new ArrayList<>();
		jedisShardInfos.add(new JedisShardInfo(jedisConfigurations.getHost()));
		return new ShardedJedisPool(jedisPoolConfig, jedisShardInfos);
	}
}