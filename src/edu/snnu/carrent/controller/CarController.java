package edu.snnu.carrent.controller;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.snnu.carrent.model.Car;
import edu.snnu.carrent.model.Company;
import edu.snnu.carrent.model.Type;
import edu.snnu.carrent.service.CarService;
import edu.snnu.carrent.service.impl.CarServiceImpl;

/**
 * 车辆控制类
 */
@Controller
@RequestMapping(value = "car")
public class CarController {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	CarService carServiceImpl = new CarServiceImpl();

	public CarController() {
	}

	// 添加车辆
	@RequestMapping(value = "/add")
	public String add(Model model) {

		String carNameStr = "奥蒂";
		double carPriceInt = 1;
		double doorNum = 4;
		double seatNum = 5;
		String gear = "自动挡";
		String carDes = "非常棒的自驾游车辆";
		String carPhoto = "sdsd.png";
		String typeName = "宝马";
		String typeDesc = "高档的轿车";

		Car car = new Car(carNameStr, carPriceInt, doorNum, seatNum, gear,
				carDes, carPhoto);
		Company company = new Company();
		Type type = new Type(typeName, typeDesc);

		company.setCompanyName("herzt");
		carServiceImpl.save1(car, company, type);
		// carServiceImpl.save1(car);
		return "/";
	}

	// 查找车辆
	@RequestMapping(value = "/find")
	public String getById(Model model) {

		long carId = 1;

		carServiceImpl.getById(carId);

		return "/";
	}

	// 查找所有车辆
	@RequestMapping(value = "/findall")
	public String getall(Model model) {

		carServiceImpl.getAll();

		return "/";
	}

	// 计算车的总价
	@RequestMapping(value = "/carTotal")
	public String carTotal(Model model) {

		Date takeCarDateEnd = null;
		Date backCarDateEnd = null;
		Integer carPrice = null;

		carServiceImpl.getcarTotal(takeCarDateEnd, backCarDateEnd, carPrice);

		return "/";

	}
}
