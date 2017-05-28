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

import edu.snnu.carrent.model.Company;
import edu.snnu.carrent.service.AddToObject;
import edu.snnu.carrent.service.CompanyService;

/*
 * 公司服务实现类
 */

public class CompanyServiceImpl implements CompanyService {
	private static SessionFactory sessionFactory = new Configuration()//
			.configure()//
			.buildSessionFactory();

	@Override
	public Session getSession() {
		return null;
	}

	@Override
	public void save(Company company) {
		Session session = sessionFactory.openSession();

		try {
			Transaction tx = session.beginTransaction(); // 开始事务

			session.save(company);
			tx.commit(); // 提交事务
		} catch (RuntimeException e) {
			session.getTransaction().rollback(); // 回滚事务
			throw e;
		} finally {
			session.close(); // 关闭Session
		}
	}

	@Override
	public void delete(Long companyid) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			String hql = "delete Company c where c.companyId="
					+ companyid.intValue();
			Query query = session.createQuery(hql);
			query.executeUpdate();
			tx.commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Company t) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();

			session.update(t); // 操作

			tx.commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public Company getById(Long id) {
		Session session = sessionFactory.openSession();

		try {
			Transaction tx = session.beginTransaction(); // 开始事务
			Company company = (Company) session.get(Company.class,
					id.intValue());

			JSONObject jsonObject;

			try {
				jsonObject = AddToObject.addToJson(company);
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

			tx.commit(); // 提交事务
			return company;
		} catch (RuntimeException e) {
			session.getTransaction().rollback(); // 回滚事务
			throw e;
		} finally {
			session.close(); // 关闭Session
		}
	}

	@Override
	public List<Company> getByIds(Long[] ids) {
		return null;
	}

	@Override
	public List<Company> getAll() throws HibernateException {
		return null;
	}

}
