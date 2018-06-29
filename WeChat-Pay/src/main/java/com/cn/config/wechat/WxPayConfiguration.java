package com.cn.config.wechat;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 微信支付相关配置
 * <p>
 * yao
 */
@PropertySource("classpath:config/wxPay.properties")
@Configuration
public class WxPayConfiguration {
	@Value("${appId}")
	private String appId;

	@Value("${mchId}")
	private String mchId;

	@Value("${mchKey}")
	private String mchKey;

	// @Value("${Wxpay.subAppId}")
	// private String subAppId;

	// @Value("${Wxpay.subMchId}")
	// private String subMchId;

	@Value("${keyPath}")
	private String keyPath;

	// 测试环境
	@Value("${useSandboxEnv}")
	private boolean useSandboxEnv;

	@Bean
	public WxPayConfig payConfig() {

		WxPayConfig payConfig = new WxPayConfig();
		payConfig.setAppId(this.appId);
		payConfig.setMchId(this.mchId);
		payConfig.setMchKey(this.mchKey);
		// 子账户 配置
		// payConfig.setSubAppId(this.subAppId);
		// payConfig.setSubMchId(this.subMchId);
		payConfig.setKeyPath(this.keyPath);
		// 测试环境 生产环境下删除
		payConfig.setUseSandboxEnv(useSandboxEnv);
		return payConfig;
	}

	@Bean
	public WxPayService payService() {
		WxPayService payService = new WxPayServiceImpl();
		payService.setConfig(payConfig());
		return payService;
	}
}