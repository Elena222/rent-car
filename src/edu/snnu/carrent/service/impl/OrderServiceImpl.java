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

import edu.snnu.carrent.model.Car;
import edu.snnu.carrent.model.Company;
import edu.snnu.carrent.model.Driver;
import edu.snnu.carrent.model.Order;
import edu.snnu.carrent.model.Package;
import edu.snnu.carrent.model.Product;
import edu.snnu.carrent.model.Service;
import edu.snnu.carrent.model.User;
import edu.snnu.carrent.service.AddToObject;
import edu.snnu.carrent.service.OrderService;

/*
 * 订单服务实现类
 */

public class OrderServiceImpl implements OrderService {
	private static SessionFactory sessionFactory = new Configuration()//
			.configure()//
			.buildSessionFactory();

	@Override
	public Session getSession() {
		return null;
	}

	@Override
	public void save(Order order, Car car, Company company, Driver driver,
			Package pack, Product product, Service service, User user) {
		Session session = sessionFactory.openSession();

		try {
			Transaction tx = session.beginTransaction();

			order.setOrderCar(car);
			car.getCarOrders().add(order);

			order.setOrderCompany(company);
			company.getCompanyOrder().add(order);

			order.setOrderDriver(driver);

			order.setOrderPackage(pack);
			pack.getPackageOrders().add(order);

			order.setOrderProduct(product);
			product.getProductOrders().add(order);

			order.getOrderServices().add(service);
			// service.getServiceOrders().add(order);

			order.setOrderUser(user);
			user.getUserOrders().add(order);

			System.out.println(order.getOrderPrice());

			session.save(order);
			session.save(car);
			session.save(company);
			session.save(driver);
			session.save(pack);
			session.save(product);
			session.save(service);
			session.save(user);

			tx.commit();
			System.out.println("22");
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}

	}

	@Override
	public void delete(Long orderId) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();

			String hql = "delete Order o where o.orderId=" + orderId.intValue();
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
	public void update(Order orderId) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();

			session.update(orderId);

			tx.commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public Order getById(Long id) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			Order order = (Order) session.get(Order.class, id.intValue());
			JSONObject jsonObject;

			try {
				jsonObject = AddToObject.addToJson(order);
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

			tx.commit();
			return order;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Order> getByIds(Long[] ids) {
		Session session = sessionFactory.openSession();

		try {
			Transaction tx = session.beginTransaction();
			List<User> list = session.createQuery("FROM Order").list();
			List<Order> listret = null;
			for (int i = 0; i < ids.length; i++) {
				Order order = (Order) session.get(Order.class,
						ids[i].intValue());
				if (list.contains(order)) {
					listret.add(order);
				}
				return listret;
			}
			tx.commit();
			return listret;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Order> getAll() throws HibernateException {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();

			List<Order> list = session.createQuery("FROM Order").list();
			JSONObject jsonObject;

			for (Order order : list) {
				try {
					jsonObject = AddToObject.addToJson(order);
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
	public void save(Order t) {

	}

	@Override
	public JSONObject getAll(Integer userId) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();

			List<Order> list = session.createQuery("FROM Order ").list();
			JSONObject jsonObject = new JSONObject();
			JSONObject jsonObjectList = new JSONObject();

			for (Order order : list) {
				if (order.getOrderUser().getUserId() == userId) {
					jsonObject.put("orderNum", order.getOrderNum());
					jsonObject.put("orderTakeCity", order.getOrderTakeCity());
					jsonObject.put("orderBackCity", order.getOrderBackCity());
					jsonObject.put("orderTakePlace", order.getOrderTakePlace());
					jsonObject.put("orderBackPlace", order.getOrderBackPlace());
					jsonObject.put("orderPrice", order.getOrderPrice());
					jsonObject.put("IsPay", order.getIsPay());
					jsonObject
							.put("IsPay", order.getOrderServices().toString());
					jsonObjectList.put("order", jsonObject);
				} else {
					continue;
				}
			}
			tx.commit();
			return jsonObjectList;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}

	}
}
