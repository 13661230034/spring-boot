package com.cn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxPayRequest {

	private Integer userid;
	private String authCode;
	private String timestamp;
	private String nonceStr;
	private String packages;
	private String appid;
	private String signType;
	private String paySign;
	private String outTradeNo;
	private String codeUrl;
}
