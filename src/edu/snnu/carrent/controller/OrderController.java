package edu.snnu.carrent.controller;

import java.util.Date;

import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.snnu.carrent.model.Car;
import edu.snnu.carrent.model.Company;
import edu.snnu.carrent.model.Driver;
import edu.snnu.carrent.model.Order;
import edu.snnu.carrent.model.Package;
import edu.snnu.carrent.model.Product;
import edu.snnu.carrent.model.Service;
import edu.snnu.carrent.model.User;
import edu.snnu.carrent.service.OrderService;
import edu.snnu.carrent.service.impl.OrderServiceImpl;

/*
 * 订单控制类
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	OrderService orderServiceImpl = new OrderServiceImpl();

	public OrderController() {
	}

	// 添加订单
	@ResponseBody
	@RequestMapping(value = "/add")
	public String add() {
		// Order order, Car car, Company company, Driver driver,
		// Package pack, Product product, Service service, User user
		Order order = new Order(22);
		Car car = new Car("宝马X3", 200);
		Company company = new Company("11", "222", "333", "444");

		Date driverBirthday = new Date();
		Driver driver = new Driver("张三", driverBirthday, "2222");
		Package pack = new Package("2222");
		Product product = new Product("111");
		Service service = new Service("1", "222");
		User user = new User("1222");

		orderServiceImpl.save(order, car, company, driver, pack, product,
				service, user);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 200);
		jsonObject.put("msg", "ok");
		return jsonObject.toJSONString();
	}

	// 查找订单
	@RequestMapping(value = "/find")
	public String getById(Model model) {

		long id = 1;

		Order order = orderServiceImpl.getById(id);

		return "/";
	}

	// 查找所有订单
	@RequestMapping(value = "/findall")
	public String getall(User user) {

		JSONObject jsonObject = orderServiceImpl.getAll(user.getUserId());

		return jsonObject.toJSONString();
	}
}
