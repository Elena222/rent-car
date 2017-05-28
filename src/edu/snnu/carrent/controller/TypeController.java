package edu.snnu.carrent.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.snnu.carrent.model.Type;
import edu.snnu.carrent.service.TypeService;
import edu.snnu.carrent.service.impl.TypeServiceImpl;

/*
 * 车型控制类
 */
@Controller
@RequestMapping(value = "/type")
public class TypeController {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	TypeService typeServiceImpl = new TypeServiceImpl();

	public TypeController() {
	}

	// 查找所有车型
	@RequestMapping(value = "/findall")
	public String find(Type type1, Model model) {

		typeServiceImpl.getAll();

		return "/";
	}

}
