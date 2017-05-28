package edu.snnu.carrent.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONObject;

import edu.snnu.carrent.model.Package;
import edu.snnu.carrent.service.AddToObject;
import edu.snnu.carrent.service.PackageService;

/*
 * 套餐服务实现类
 */
public class PackageServiceImpl implements PackageService {
	private static SessionFactory sessionFactory = new Configuration()//
			.configure()//
			.buildSessionFactory();

	@Override
	public Session getSession() {
		return null;
	}

	@Override
	public void save(Package pack) {
		Session session = sessionFactory.openSession();

		try {
			Transaction tx = session.beginTransaction();
			session.save(pack);
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
	public void update(Package t) {

	}

	@Override
	public Package getById(Long id) {
		Session session = sessionFactory.openSession();

		try {
			Transaction tx = session.beginTransaction();
			Package pack = (Package) session.get(Package.class, id.intValue());
			JSONObject jsonObject;

			try {
				jsonObject = AddToObject.addToJson(pack);
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
			return pack;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Package> getByIds(Long[] ids) {
		return null;
	}

	@Override
	public List<Package> getAll() throws HibernateException {
		return null;
	}

}
