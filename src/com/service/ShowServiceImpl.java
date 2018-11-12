package com.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.EmployeeDao;
import com.dao.ShowDao;
import com.entity.Show;
import com.util.MyBatisUtils;

public class ShowServiceImpl implements ShowService {
	@Override
	public List<Show> queryEmployees() {
		try {
			ShowDao showDao=(ShowDao) MyBatisUtils.getMapper(ShowDao.class);
			List<Show> lists=showDao.queryAll();
			return lists;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void delete(Integer id) {
		try{
			ShowDao showDao=(ShowDao) MyBatisUtils.getMapper(ShowDao.class);
			showDao.deleteById(id);
			MyBatisUtils.commit();
		}catch(Exception e){
			MyBatisUtils.rollback();
		}
		
	}

	@Override
	public void insert(Show show) {
		try{
			ShowDao showDao=(ShowDao) MyBatisUtils.getMapper(ShowDao.class);
			showDao.insert(show);
			MyBatisUtils.commit();
		}catch(Exception e){
			e.printStackTrace();
			MyBatisUtils.rollback();
		}
		
	}

	@Override
	public void update(Show show) {
		try{
			ShowDao showDao=(ShowDao) MyBatisUtils.getMapper(ShowDao.class);
			showDao.update(show);
			MyBatisUtils.commit();
		}catch(Exception e){
			e.printStackTrace();
			MyBatisUtils.rollback();
		}
		
	}

}
