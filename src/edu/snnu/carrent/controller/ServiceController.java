package edu.snnu.carrent.controller;

import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.snnu.carrent.model.Service;
import edu.snnu.carrent.service.AddToObject;
import edu.snnu.carrent.service.ServiceService;
import edu.snnu.carrent.service.impl.ServiceServiceImpl;

/*
 * 特色服务控制类
 */
@Controller
@RequestMapping(value = "/service")
public class ServiceController {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	ServiceService serviceImpl = new ServiceServiceImpl();

	public ServiceController() {
	}

	// 添加特色服务
	@RequestMapping(value = "/add")
	public String add(Model model) {

		String serviceName = "司导";
		String serviceDes = "司机导游";
		double servicePrice = 29;

		Service service = new Service(serviceName, serviceDes);
		service.setServicePrice(servicePrice);

		serviceImpl.save(service);
		return "/";
	}

	// 删除特色服务
	@RequestMapping(value = "/delete")
	public String delete(Model model) {

		ServiceServiceImpl serviceImpl = new ServiceServiceImpl();
		long serviceId = 2938;

		serviceImpl.delete(serviceId);

		return "/";
	}

	// 更新特色服务
	@RequestMapping(value = "/update")
	public String update(Model model) {

		ServiceServiceImpl serviceImpl = new ServiceServiceImpl();
		long id = 3;
		String serviceName = "服务名称";

		Service service = serviceImpl.getById(id);
		service.setServiceName(serviceName);
		serviceImpl.update(service);

		return "/";
	}

	// 查找特色服务
	@RequestMapping(value = "/find")
	public String find(Model model) throws Exception {

		ServiceServiceImpl serviceImpl = new ServiceServiceImpl();
		long id = 2;

		Service service = serviceImpl.getById(id);
		JSONObject jsonObject = AddToObject.addToJson(service);

		System.out.println(jsonObject.toJSONString());

		return "/";
	}
}
