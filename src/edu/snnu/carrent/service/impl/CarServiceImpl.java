package edu.snnu.carrent.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONObject;

import edu.snnu.carrent.model.Car;
import edu.snnu.carrent.model.Company;
import edu.snnu.carrent.model.Type;
import edu.snnu.carrent.service.AddToObject;
import edu.snnu.carrent.service.CarService;

/*
 * 车辆服务实现类
 */
public class CarServiceImpl implements CarService {

	private static SessionFactory sessionFactory = new Configuration()
			.configure().buildSessionFactory();

	@Override
	public Session getSession() {
		return null;
	}

	//
	@Override
	public void save1(Car car, Company company, Type type) {
		Session session = sessionFactory.openSession();

		try {
			Transaction tx = session.beginTransaction();

			car.setCarCompany(company);
			company.getCompanyCar().add(car);
			car.setCarType(type);

			session.save(type);
			session.save(company);
			session.save(car);

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
	public void update(Car t) {

	}

	@Override
	public Car getById(Long carId) {
		Session session = sessionFactory.openSession();

		try {
			Transaction tx = session.beginTransaction(); // 开始事务
			Car car = (Car) session.get(Car.class, carId.intValue());
			JSONObject jsonObject;

			try {
				jsonObject = AddToObject.addToJson(car);
				System.out.println(jsonObject.toJSONString());
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			tx.commit(); // 提交事务
			return car;
		} catch (RuntimeException e) {
			session.getTransaction().rollback(); // 回滚事务
			throw e;
		} finally {
			session.close(); // 关闭Session
		}
	}

	@Override
	public List<Car> getByIds(Long[] ids) {
		return null;
	}

	@Override
	public List<Car> getAll() throws HibernateException {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();

			List<Car> list = session.createQuery("FROM Car").list();
			AddToObject addToObject = new AddToObject();
			JSONObject jsonObject;
			for (Car car : list) {

				try {
					jsonObject = AddToObject.addToJson(car);
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
			}
			tx.commit();
			return list;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void save(Car t) {
		// TODO Auto-generated method stub

	}

	public Integer getcarTotal(Date takeCarDateEnd, Date backCarDateEnd,
			Integer carPrice) {
		Integer carToalPrice = 0;
		int days = 0;

		days = takeCarDateEnd.getDay() - backCarDateEnd.getDay();
		carToalPrice = days * carPrice;

		JSONObject js = new JSONObject();

		js.put("status", 200);
		js.put("message", "OK");
		js.put("contents", carToalPrice);

		System.out.println(js.toJSONString());

		return carToalPrice;
	}
}
