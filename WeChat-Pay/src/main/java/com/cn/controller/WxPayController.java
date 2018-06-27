package com.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.cn.dto.WxPayRequest;
import com.cn.util.WxPayUtil;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;

/**
 * 微信支付
 * 
 * @author ynt
 *
 */
@RequestMapping(value = "/pay")
@RestController
public class WxPayController extends WxPayUtil{

	/**
	 * 微信支付
	 */
	@Autowired
	private WxPayService payService;

	/**
	 * 微信公众号
	 */
	@Autowired
	private WxMpService mpService;

	/**
	 * 微信配置
	 */
	@Autowired
	private WxPayConfig config;

	/**
	 * Code获取Openid<br/>
	 * 用code换取oauth2的access token<br/>
	 * 
	 * @param code
	 * @return
	 * @throws WxErrorException
	 */
	public String oauth2getAccessToken(String code, String userid) throws Exception {

		try {
			// 校验参数是否为空-->userid在此就不写了
			if (!code.equals("") && !code.equals(null)) {
				WxMpOAuth2AccessToken mpOpenid = mpService.oauth2getAccessToken(code);
				// 获取到openid
				System.out.println(mpOpenid.getOpenId());
				// Openid获取成功-->SUCCESS
				return null;
			} else {
				// 如果入参不存在-->哪来的回哪去
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 根据自己逻辑返回
			return null;
		}
	}

	/**
	 * 统一下单(详见https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1)
	 * 在发起微信支付前，需要调用统一下单接口，获取"预支付交易会话标识"
	 * 接口地址：https://api.mch.weixin.qq.com/pay/unifiedorder
	 *
	 * @param WxPay
	 *            请求对象，注意一些参数如appid、mchid等不用设置，方法内会自动从配置对象中获取到（前提是对应配置中已经设置）
	 */
	public String unifiedOrder() throws Exception {
		WxPayRequest strs = new WxPayRequest();
		try {

			WxPayUnifiedOrderRequest request = WxPayUnifiedOrderRequest.newBuilder().version("1.0")
					// 设备号
					.deviceInfo("WEB")
					// 商品描述
					.body("有钱花不完")
					// 商户订单号
					.outTradeNo("12345678")
					// 钱-->以分为单位
					.totalFee(1)
					// 用户请ip地址
					.spbillCreateIp("127.0.0.1")
					// 回调地址
					.notifyUrl("127.0.0.1")
					// 交易类型 现在为公众号支付
					.tradeType("JSAPI")
					// 用户openid-->上一个方法获取的Openid
					.openid("")
					// 不允许使用信用卡
					.limitPay("no_credit")
					// 交易起始时间-->看微信官方文档的时间规则
					.timeStart("123123")
					// 交易结束时间-->看微信官方文档的时间规则
					.timeExpire("123123").build();
			request.checkAndSign(config);
			//获取预支付绘画标识
			WxPayUnifiedOrderResult payun = payService.unifiedOrder(request);
			if (!payun.equals("") && !payun.equals(null)) {
				//微信支付签名算法
				strs = createSign(null, config.getMchKey(), false, payun.getPrepayId());
				return JSON.toJSONString(strs);
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		// return null;

	}

	

}
