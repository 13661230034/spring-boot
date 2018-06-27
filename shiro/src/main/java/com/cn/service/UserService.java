package com.cn.service;

import java.util.List;
import java.util.Map;

import com.cn.entity.User;

public interface UserService {

	public List<User> getByMap(Map<String, Object> map);

	public User getById(Integer id);

	public User create(User user);

	public User update(User user);

	public int delete(Integer id);

	public User getByUserName(String userName);

}
