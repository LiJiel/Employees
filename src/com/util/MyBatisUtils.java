package com.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	private static SqlSessionFactory factory = null;
	
	//Map<Thread,Object>
	static ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();
	
	static {
		try {
			InputStream inputStream = Resources
					.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSession openSession() {
		SqlSession sqlSession = factory.openSession();
		return sqlSession;
	}
	
	//多用在实战中
	//先获得ThreadLocal中的对象,如果对象为null,表示不存在,需要创建,保存到ThreadLocal中
	//如果不为null,直接返回
	public static SqlSession getCurentSession(){
		SqlSession sqlSession = local.get();
		if(sqlSession == null){
			sqlSession = openSession();
			local.set(sqlSession);
		}
		return sqlSession;
	}
	
	//获得接口的实现类
	public static Object getMapper(Class clazz){
		SqlSession sqlSession = getCurentSession();
		return sqlSession.getMapper(clazz);
	}
	
	//处理事务
	public static void commit(){
		SqlSession sqlSession = getCurentSession();
		sqlSession.commit();
		close();
	}
	public static void rollback(){
		SqlSession sqlSession = getCurentSession();
		sqlSession.rollback();
		close();
	}

	//封装close
	public static void close(){
		SqlSession sqlSession = getCurentSession();
		sqlSession.close();
		local.remove();
	}
}
