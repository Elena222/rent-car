package edu.snnu.carrent.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.snnu.carrent.model.Company;
import edu.snnu.carrent.service.CompanyService;
import edu.snnu.carrent.service.impl.CompanyServiceImpl;

/*
 * 租车公司控制类
 */
@Controller
@RequestMapping(value = "/company")
public class CompanyController {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	CompanyService companyServiceImpl = new CompanyServiceImpl();

	public CompanyController() {
	}

	// 添加租车公司
	@RequestMapping(value = "/add")
	public String add(Model model) {

		String companyName = "heryz";
		String companyPhoto = "herz.jpg";
		String companyDes = "hello welcome hertz";
		String companyTel = "38729478";

		Company company = new Company(companyName, companyPhoto, companyDes,
				companyTel);

		companyServiceImpl.save(company);

		return "/";
	}

	// 删除租车公司
	@RequestMapping(value = "/delete")
	public String companyDelete(Model model) {

		Long companyid = (long) 1;

		companyServiceImpl.delete(companyid);

		return "/";
	}

	// 更新租车公司的信息
	@RequestMapping(value = "/update")
	public String companyUpdate(Model model) {

		long id = 1;
		String companyName = "租租车";

		Company company = companyServiceImpl.getById(id);

		company.setCompanyName(companyName);

		companyServiceImpl.update(company);

		return "/";
	}

	// 查找租车公司
	@RequestMapping(value = "/find")
	public String getall(Model model) {

		long id = 3;

		companyServiceImpl.getById(id);

		return "/";
	}
}
