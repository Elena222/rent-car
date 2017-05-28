package edu.snnu.carrent.model;

import java.util.HashSet;
import java.util.Set;

/*
 * 公司实体类
 */
public class Company {

	private Integer companyId;// 公司ID
	private String companyName;// 公司名
	private Integer companyScore;// 星级
	private String companyPhoto;// 公司图片
	private String companyDes;// 公司描述
	private String companyTel;// 公司电话
	private Set<Car> companyCar = new HashSet<Car>();// 公司所有的车辆
	private Set<Order> companyOrder = new HashSet<Order>();// 关联的订单

	// 无参构造函数
	public Company() {
	}

	// 有参构造函数
	public Company(String companyName, String companyPhoto, String companyDes,
			String companyTel) {
		super();
		this.companyName = companyName;
		this.companyPhoto = companyPhoto;
		this.companyDes = companyDes;
		this.companyTel = companyTel;
	}

	// 公司ID的get方法
	public Integer getCompanyId() {
		return companyId;
	}

	// 公司ID的set方法
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	// 公司名的get方法
	public String getCompanyName() {
		return companyName;
	}

	// 公司名的set方法
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	// 公司星级的get方法
	public Integer getCompanyScore() {
		return companyScore;
	}

	// 公司星级的set方法
	public void setCompanyScore(Integer companyScore) {
		this.companyScore = companyScore;
	}

	// 公司图片的get方法
	public String getCompanyPhoto() {
		return companyPhoto;
	}

	// 公司图片的set方法
	public void setCompanyPhoto(String companyPhoto) {
		this.companyPhoto = companyPhoto;
	}

	// 公司描述的get方法
	public String getCompanyDes() {
		return companyDes;
	}

	// 公司描述的set方法
	public void setCompanyDes(String companyDes) {
		this.companyDes = companyDes;
	}

	// 公司电话的get方法
	public String getCompanyTel() {
		return companyTel;
	}

	// 公司电话的set方法
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}

	// 公司所有车辆的get方法
	public Set<Car> getCompanyCar() {
		return companyCar;
	}

	// 公司所有车辆的set方法
	public void setCompanyCar(Set<Car> companyCar) {
		this.companyCar = companyCar;
	}

	// 公司关联的订单的get方法
	public Set<Order> getCompanyOrder() {
		return companyOrder;
	}

	// 公司关联的订单的set方法
	public void setCompanyOrder(Set<Order> companyOrder) {
		this.companyOrder = companyOrder;
	}

}
