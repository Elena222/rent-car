package edu.snnu.carrent.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONObject;

import edu.snnu.carrent.model.Driver;
import edu.snnu.carrent.model.User;
import edu.snnu.carrent.service.AddToObject;
import edu.snnu.carrent.service.DriverService;

/*
 * 司机服务实现类
 */

public class DriverServiceImpl implements DriverService {

	private static SessionFactory sessionFactory = new Configuration()//
			.configure()//
			.buildSessionFactory();

	@Override
	public Session getSession() {
		return null;
	}

	@Override
	public void save(Driver t) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();

			User user = new User();
			user.setUserName("123");
			user.setPassWord("214");
			user.setUserTel("23114");
			t.setUser(user);

			session.save(user);
			session.save(t);
			tx.commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(Long id) {

	}

	@Override
	public void update(Driver t) {

	}

	@Override
	public Driver getById(Long id) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			Driver driver = (Driver) session.get(Driver.class,
					(int) id.intValue());
			JSONObject jsonObject;

			try {
				jsonObject = AddToObject.addToJson(driver);
				System.out.println(jsonObject.toJSONString());
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}

			tx.commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Driver> getByIds(Long[] ids) {
		return null;
	}

	@Override
	public List<Driver> getAll() throws HibernateException {
		return null;
	}

}
