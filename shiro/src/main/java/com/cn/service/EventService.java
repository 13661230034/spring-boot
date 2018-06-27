package com.cn.service;

import java.util.List;
import java.util.Map;

import com.cn.entity.Event;

public interface EventService {

	public List<Event> getByMap(Map<String, Object> map);

	public Event getById(Integer id);

	public Event create(Event event);

	public int update(Event event);

	public int delete(Integer id);

}
