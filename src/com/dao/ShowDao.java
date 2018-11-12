package com.dao;

import java.util.List;

import com.entity.Show;

public interface ShowDao {
	public List<Show> queryAll();
	public void deleteById(Integer id);
	public void insert(Show show);
	public void update(Show show);
}
