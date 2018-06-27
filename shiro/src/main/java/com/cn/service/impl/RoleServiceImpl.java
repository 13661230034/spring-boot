package com.cn.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.dao.RoleDao;
import com.cn.entity.Role;
import com.cn.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	public List<Role> getByMap(Map<String, Object> map) {
		return this.roleDao.getByMap(map);
	}

	public Role getById(Integer id) {
		return this.roleDao.getById(id);
	}

	public Role create(Role role) {
		return this.roleDao.create(role);
	}

	public int update(Role role) {
		return this.roleDao.update(role);
	}

	public int delete(Integer id) {
		return this.roleDao.delete(id);
	}

}
