package edu.snnu.carrent.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONObject;

import edu.snnu.carrent.model.Type;
import edu.snnu.carrent.service.AddToObject;
import edu.snnu.carrent.service.BaseService;
import edu.snnu.carrent.service.TypeService;

/*
 * 车型组服务实现类
 */

public class TypeServiceImpl implements TypeService, BaseService<Type> {

	private static SessionFactory sessionFactory = new Configuration()
			.configure().buildSessionFactory();

	@Override
	public void save(Type t) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.clear();
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
	public void update(Type t) {
	}

	@Override
	public Type getById(Long id) {
		Session session = sessionFactory.openSession();

		try {
			Transaction tx = session.beginTransaction();

			// String hql = "from type t where t.typeId=" + id.intValue();
			// Query query = session.createQuery(hql);
			// Type type = (Type) query.uniqueResult();
			Type type = (Type) session.get(Type.class, id.intValue());

			tx.commit();
			return type;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Type> getByIds(Long[] ids) {
		return null;
	}

	@Override
	public List<Type> getAll() throws HibernateException {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Type";
			Query query = session.createQuery(hql);
			List<Type> list = query.list();

			for (Type type : list) {
				JSONObject jsonObject = AddToObject.addToJson(type);
				System.out.println(jsonObject.toJSONString());
				// type.ToJson();
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Session getSession() {
		return null;
	}
}
