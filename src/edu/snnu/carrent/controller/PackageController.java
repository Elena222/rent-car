package edu.snnu.carrent.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.snnu.carrent.model.Package;
import edu.snnu.carrent.service.PackageService;
import edu.snnu.carrent.service.impl.PackageServiceImpl;

/*
 * 套餐控制类
 */
@Controller
@RequestMapping(value = "/package")
public class PackageController {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	PackageService packageServiceImpl = new PackageServiceImpl();

	// 查找套餐
	@RequestMapping(value = "/find")
	public String add(Model model) {

		long id = 1;

		Package package1 = packageServiceImpl.getById(id);

		return "/";
	}
}
