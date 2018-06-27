package com.cn.dao;

import java.util.List;
import java.util.Map;

import com.cn.entity.User;

public interface UserDao {

	public List<User> getByMap(Map<String, Object> map);

	public User getById(Integer id);

	public Integer create(User user);

	public int update(User user);

	public int delete(Integer id);

	public User getByUserName(String userName);

}