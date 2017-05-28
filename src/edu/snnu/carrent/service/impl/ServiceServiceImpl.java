package edu.snnu.carrent.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONObject;

import edu.snnu.carrent.model.Service;
import edu.snnu.carrent.service.AddToObject;
import edu.snnu.carrent.service.ServiceService;

/*
 * 特色服务的服务实现类
 */

public class ServiceServiceImpl implements ServiceService {
	private static SessionFactory sessionFactory = new Configuration()//
			.configure()//
			.buildSessionFactory();

	@Override
	public Session getSession() {
		return null;
	}

	@Override
	public void save(Service service) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(service);
			tx.commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(Long serviceId) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();

			Object service = session.get(Service.class, serviceId.intValue());
			session.delete(service);

			tx.commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Service service) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();

			session.update(service);

			tx.commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public Service getById(Long id) {
		Session session = sessionFactory.openSession();

		try {
			Transaction tx = session.beginTransaction();

			String hql = "from Service s where s.serviceId=" + id.intValue();
			Query query = session.createQuery(hql);
			Service service = (Service) query.uniqueResult();
			JSONObject jsonObject;

			try {
				jsonObject = AddToObject.addToJson(service);
				System.out.println(jsonObject.toJSONString());
			} catch (NoSuchMethodException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				e1.printStackTrace();
			} catch (NoSuchFieldException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			tx.commit();
			return service;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Service> getByIds(Long[] ids) {
		return null;
	}

	@Override
	public List<Service> getAll() throws HibernateException {
		return null;
	}

}
