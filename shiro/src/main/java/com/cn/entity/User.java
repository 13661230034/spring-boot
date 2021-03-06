package com.cn.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

	private Integer id;

	private String cnname;

	private String username;

	@JsonIgnore
	private String password;

	private String email;

	private String telephone;

	private String mobilePhone;

	private String wechatId;

	private String skill;

	private Integer departmentId;

	private Integer loginCount;

	private List<Role> roles;

}
