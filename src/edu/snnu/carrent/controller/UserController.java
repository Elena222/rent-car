package edu.snnu.carrent.controller;

import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.snnu.carrent.model.User;
import edu.snnu.carrent.service.UserService;
import edu.snnu.carrent.service.impl.UserServiceImpl;

/*
 * 用户控制类
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	UserService userServiceImpl = new UserServiceImpl();

	public UserController() {
	}

	// 添加用户
	@ResponseBody
	@RequestMapping(value = "/add")
	public String add(User user) {

		System.out.println(user.getUserMail());

		User userSave = new User();

		userSave.setUserMail(user.getUserMail());
		userSave.setUserTel(user.getUserTel());

		userServiceImpl.save(userSave);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", "Ok");

		return jsonObject.toJSONString();
	}

	// 查找用户
	@ResponseBody
	@RequestMapping(value = "/find")
	public String getById(User user) {

		System.out.println(user.getUserTel());
		System.out.println(user.getPassWord());
		JSONObject jsonObject = userServiceImpl.getById(user);

		return jsonObject.toJSONString();
	}

	// 查找所有用户
	@RequestMapping(value = "/findall")
	public String getall(Model model) {

		UserServiceImpl userServiceImpl = new UserServiceImpl();
		userServiceImpl.getAll();

		return "/";
	}
}
