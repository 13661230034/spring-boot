package com.cn.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.dao.EventDao;
import com.cn.entity.Event;
import com.cn.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventDao;

	public List<Event> getByMap(Map<String, Object> map) {
		return this.eventDao.getByMap(map);
	}

	public Event getById(Integer id) {
		return this.eventDao.getById(id);
	}

	public Event create(Event event) {
		return this.eventDao.create(event);
	}

	public int update(Event event) {
		return this.eventDao.update(event);
	}

	public int delete(Integer id) {
		return this.eventDao.delete(id);
	}

}
