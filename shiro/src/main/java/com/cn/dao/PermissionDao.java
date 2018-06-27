package com.cn.dao;

import java.util.List;
import java.util.Map;

import com.cn.entity.Permission;

public interface PermissionDao {

	public List<Permission> queryAll();

	public List<Permission> getByMap(Map<String, Object> map);

	public List<Permission> getList();

	public List<Permission> getByUserId(Integer userId);

	public Permission getById(Integer id);

	public Permission create(Permission permission);

	public int update(Permission permission);

	public int delete(Integer id);

}