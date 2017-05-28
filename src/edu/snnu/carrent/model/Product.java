package edu.snnu.carrent.model;

import java.util.HashSet;
import java.util.Set;

/*
 * 产品实体类
 */
public class Product {

	private Integer productId;// 产品ID
	private String productName;// 产品名
	private double productPrice;// 产品价格

	private Set<Order> productOrders = new HashSet<Order>();// 产品关联的订单
	private Car productCar;// 产品的车辆
	private Set<Service> productServices = new HashSet<Service>();// 产品关联的服务
	private Package productPackage;// 产品的套餐

	public Product() {
		super();
	}

	public Product(String productName) {
		super();
		this.productName = productName;
	}

	// 产品ID的get方法
	public Integer getProductId() {
		return productId;
	}

	// 产品ID的set方法
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	// 产品名的get方法
	public String getProductName() {
		return productName;
	}

	// 产品名的set方法
	public void setProductName(String productName) {
		this.productName = productName;
	}

	// 产品价格的get方法
	public double getProductPrice() {
		return productPrice;
	}

	// 产品价格的set方法
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	// 服务的get方法
	public Set<Service> getProductServices() {
		return productServices;
	}

	// 服务的set方法
	public void setProductServices(Set<Service> productServices) {
		this.productServices = productServices;
	}

	// 车辆的get方法
	public Car getProductCar() {
		return productCar;
	}

	// 车辆的set方法
	public void setProductCar(Car productCar) {
		this.productCar = productCar;
	}

	// 产品关联的订单的get方法
	public Set<Order> getProductOrders() {
		return productOrders;
	}

	// 套餐的get方法
	public Package getProductPackage() {
		return productPackage;
	}

	// 套餐的set方法
	public void setProductPackage(Package productPackage) {
		this.productPackage = productPackage;
	}

	// 产品关联的订单的set方法
	public void setProductOrders(Set<Order> productOrders) {
		this.productOrders = productOrders;
	}

}
