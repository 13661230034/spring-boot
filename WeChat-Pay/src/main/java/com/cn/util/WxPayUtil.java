package com.cn.util;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.cn.dto.WxPayRequest;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.util.SignUtils;

public class WxPayUtil {

	
	/**
	 * 微信配置
	 */
	@Autowired
	private WxPayConfig config;
	
	/**
	 * 统一下单 获取签名<br/>
	 * 微信统一下单调用
   * @param params         参数信息
   * @param signType       签名类型，如果为空，则默认为MD5
   * @param signKey        签名Key
   * @param ignoreSignType 签名时，是否忽略signType
   * @return 签名字符串
	 */
	public WxPayRequest createSign(String signType, String signKey, boolean ignoreSignType, String PrepayId) {

		Map<String, String> params = new HashMap<>();
		// 时间戳
		params.put("timeStamp", Long.toString(System.currentTimeMillis() / 1000));
		// 支付签名随机串，不长于 32 位
		params.put("nonceStr", UUID.randomUUID().toString());
		// 统一支付接口返回的prepay_id参数值
		params.put("package", "prepay_id=" + PrepayId);
		// appid
		params.put("appId", config.getAppId());
		// 签名方式 默认MD5
		params.put("signType", "MD5");
		String signkey = SignUtils.createSign(params, signType, signKey, ignoreSignType);

		WxPayRequest wxs = new WxPayRequest();
		wxs.setTimestamp(params.get("timeStamp"));
		wxs.setNonceStr(params.get("nonceStr"));
		wxs.setPackages(params.get("package"));
		wxs.setSignType(params.get("signType"));
		wxs.setAppid(params.get("appId"));
		wxs.setPaySign(signkey);
		return wxs;
	}
	
	
	
	
}
