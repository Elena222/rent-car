package edu.snnu.carrent.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

/*
 * 基础服务类
 */
public interface BaseService<T> {
	Session getSession();

	void save(T t);

	void delete(Long id);

	void update(T t);

	T getById(Long id);

	List<T> getByIds(Long[] ids);

	List<T> getAll() throws HibernateException;
}
