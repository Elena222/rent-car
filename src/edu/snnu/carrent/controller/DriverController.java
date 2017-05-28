package edu.snnu.carrent.controller;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.snnu.carrent.model.Driver;
import edu.snnu.carrent.service.DriverService;
import edu.snnu.carrent.service.impl.DriverServiceImpl;

/*
 * 司机控制类
 */
@Controller
@RequestMapping(value = "/driver")
public class DriverController {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	DriverService driverServiceImpl = new DriverServiceImpl();

	public DriverController() {
	}

	// 添加司机信息
	@RequestMapping(value = "/add")
	public String add(Model model) {

		Date now = new Date();
		Date driverBirthday = new Date();
		String driverName = "zhangsan";
		String driverTel = "87239487";
		int driverYear = now.getYear() - driverBirthday.getYear();

		Driver driver = new Driver(driverName, driverBirthday, driverTel);

		driverServiceImpl.save(driver);

		return "/";
	}

	// 查找司机
	@RequestMapping(value = "/find")
	public String getById(Model model) {

		long id = 1;

		driverServiceImpl.getById(id);

		return "/";
	}

}
