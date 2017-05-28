package edu.snnu.carrent.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.snnu.carrent.model.Car;
import edu.snnu.carrent.model.Product;
import edu.snnu.carrent.model.Service;
import edu.snnu.carrent.service.ProductService;
import edu.snnu.carrent.service.impl.ProductServiceImpl;

/*
 * 产品控制类
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	ProductService productServiceImpl = new ProductServiceImpl();
	private Product product = (Product) context.getBean("product");

	public ProductController() {
	}

	// 添加产品
	@RequestMapping(value = "/add")
	public String add(Product productadd, Model model) {

		String productName = "产品1";
		double productPrice = 123;

		productadd.setProductName(productName);
		productadd.setProductPrice(productPrice);

		String carName = "奥迪";
		double carPrice = 390.11;

		Car car = new Car(carName, carPrice);

		String serviceName = "serviceName";
		String serviceDes = "serviceDes";

		Service service = new Service(serviceName, serviceDes);

		edu.snnu.carrent.model.Package package1 = new edu.snnu.carrent.model.Package();
		package1.setPackageName("套餐1");

		productServiceImpl.save(productadd, car, service, package1);

		return "/";
	}

}
