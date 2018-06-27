package com.cn.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.dao.PermissionDao;
import com.cn.entity.Permission;
import com.cn.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionDao permissionDao;

	public List<Permission> queryAll() {
		return this.permissionDao.queryAll();
	}

	public List<Permission> getByMap(Map<String, Object> map) {
		return this.permissionDao.getByMap(map);
	}

	public List<Permission> getList() {
		return this.permissionDao.getList();
	}

	public List<Permission> getByUserId(Integer userId) {
		return this.permissionDao.getByUserId(userId);
	}

	public Permission getById(Integer id) {
		return this.permissionDao.getById(id);
	}

	public Permission create(Permission permission) {
		return this.permissionDao.create(permission);
	}

	public int update(Permission permission) {
		return this.permissionDao.update(permission);
	}

	public int delete(Integer id) {
		return this.permissionDao.delete(id);
	}
}
