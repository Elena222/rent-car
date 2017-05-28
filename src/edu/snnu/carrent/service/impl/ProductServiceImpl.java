package edu.snnu.carrent.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.snnu.carrent.model.Car;
import edu.snnu.carrent.model.Package;
import edu.snnu.carrent.model.Product;
import edu.snnu.carrent.model.Service;
import edu.snnu.carrent.service.ProductService;

/*
 * 产品服务实现类
 */

public class ProductServiceImpl implements ProductService {
	private static SessionFactory sessionFactory = new Configuration()//
			.configure()//
			.buildSessionFactory();

	@Override
	public Session getSession() {
		return null;
	}

	public void save(Product t, Car car, Service service, Package pack) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();

			t.setProductCar(car);
			car.getCarProducts().add(t);

			t.getProductServices().add(service);
			service.getServiceProducts().add(t);

			t.setProductPackage(pack);
			pack.getPackageProducts().add(t);

			session.save(pack);
			session.save(service);
			session.save(car);
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
	public void update(Product t) {

	}

	@Override
	public Product getById(Long id) {
		return null;
	}

	@Override
	public List<Product> getByIds(Long[] ids) {
		return null;
	}

	@Override
	public List<Product> getAll() throws HibernateException {
		return null;
	}

	@Override
	public void save(Product t) {

	}

}
