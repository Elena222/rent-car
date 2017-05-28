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

import edu.snnu.carrent.model.User;
import edu.snnu.carrent.service.AddToObject;
import edu.snnu.carrent.service.UserService;

/*
 * 用户服务实现类
 */

public class UserServiceImpl implements UserService {
	private static SessionFactory sessionFactory = new Configuration()//
			.configure()//
			.buildSessionFactory();

	public void save(User user) {
		Session session = sessionFactory.openSession();

		try {
			Transaction tx = session.beginTransaction();

			session.save(user);
			tx.commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public Session getSession() {
		return null;
	}

	@Override
	public void delete(Long userId) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();

			String hql = "delete User u where u.userId=" + userId.intValue();
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
	public void update(User user) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();

			session.update(user);
			tx.commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}

	}

	@Override
	public User getById(Long id) {
		Session session = sessionFactory.openSession();
		User user;
		try {
			Transaction tx = session.beginTransaction();
			user = (User) session.get(User.class, id.intValue());
			AddToObject addToObject = new AddToObject();
			JSONObject jsonObject;

			try {
				jsonObject = addToObject.addToJson(user);
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
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public List<User> getByIds(Long[] ids) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();

			List<User> list = session.createQuery("FROM User").list();
			List<User> listret = null;
			for (int i = 0; i < ids.length; i++) {
				User user = (User) session.get(User.class, ids[i].intValue());

				if (list.contains(user)) {
					listret.add(user);
				}
				return listret;
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
	public List<User> getAll() throws HibernateException {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			AddToObject addToObject = new AddToObject();
			List<User> list = session.createQuery("FROM User").list();
			JSONObject jsonObject;

			for (User userone : list) {
				try {
					jsonObject = AddToObject.addToJson(userone);
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
	public JSONObject getById(User user) {
		Session session = sessionFactory.openSession();
		JSONObject jsonObject = new JSONObject();

		try {
			Transaction tx = session.beginTransaction();
			String hql = "from User";
			List<User> userlist = session.createQuery(hql).list();
			String msg = "error";
			for (User user2 : userlist) {
				if (user2.getUserTel().equals(user.getUserTel())) {
					if ((user2.getPassWord().equals(user.getPassWord()))) {
						msg = "ok";
						break;
					} else {
						continue;
					}
				}
			}
			System.out.println(msg);
			jsonObject.put("message", msg);
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
		return jsonObject;
	}
}
