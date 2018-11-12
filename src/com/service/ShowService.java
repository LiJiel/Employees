package com.service;

import java.util.List;

import com.entity.Show;

public interface ShowService {
	public List<Show> queryEmployees();
	public void delete(Integer id);
	public void insert(Show show);
	public void update(Show show);
}
