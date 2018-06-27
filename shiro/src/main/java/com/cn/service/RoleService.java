package com.cn.service;

import java.util.List;
import java.util.Map;

import com.cn.entity.Role;

public interface RoleService {

	public List<Role> getByMap(Map<String, Object> map);

	public Role getById(Integer id);

	public Role create(Role role);

	public int update(Role role);

	public int delete(Integer id);

}
