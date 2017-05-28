package edu.snnu.carrent.service;

import org.json.simple.JSONObject;

import edu.snnu.carrent.model.Car;
import edu.snnu.carrent.model.Company;
import edu.snnu.carrent.model.Driver;
import edu.snnu.carrent.model.Order;
import edu.snnu.carrent.model.Package;
import edu.snnu.carrent.model.Product;
import edu.snnu.carrent.model.Service;
import edu.snnu.carrent.model.User;

/*
 * 订单服务类
 */

public interface OrderService extends BaseService<Order> {

	void save(Order order, Car car, Company company, Driver driver,
			Package pack, Product product, Service service, User user);

	JSONObject getAll(Integer userId);

}
