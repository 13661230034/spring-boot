package com.cn.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Permission {

	private Integer id;

	private String name;

	private String permissionUrl;

	private String method;

	private String description;

}
