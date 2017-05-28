package edu.snnu.carrent.model;

import java.util.HashSet;
import java.util.Set;

/*
 * 套餐实体类
 */
public class Package {

	private Integer packageId;// 套餐ID
	private String packageName;// 套餐名
	private double packagePrice;// 套餐价格
	private String packageDes;// 套餐描述

	private Set<Order> packageOrders = new HashSet<Order>();// 套餐关联的订单
	private Set<Product> packageProducts = new HashSet<Product>();// 套餐关联的产品

	// 无参构造函数
	public Package() {
		super();
	}

	public Package(String packageName) {
		super();
		this.packageName = packageName;
	}

	// 套餐编号的get方法
	public Integer getPackageId() {
		return packageId;
	}

	// 套餐ID的set方法
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	// 套餐名的get方法
	public String getPackageName() {
		return packageName;
	}

	// 套餐名的set方法
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	// 套餐价格的get方法
	public double getPackagePrice() {
		return packagePrice;
	}

	// 套餐价格的set方法
	public void setPackagePrice(double packagePrice) {
		this.packagePrice = packagePrice;
	}

	// 套餐描述的get方法
	public String getPackageDes() {
		return packageDes;
	}

	// 套餐描述的set方法
	public void setPackageDes(String packageDes) {
		this.packageDes = packageDes;
	}

	// 套餐关联订单的get方法
	public Set<Order> getPackageOrders() {
		return packageOrders;
	}

	// 套餐关联订单的set方法
	public void setPackageOrders(Set<Order> packageOrders) {
		this.packageOrders = packageOrders;
	}

	// 套餐关联的产品的get方法
	public Set<Product> getPackageProducts() {
		return packageProducts;
	}

	// 套餐关联的产品的set方法
	public void setPackageProducts(Set<Product> packageProducts) {
		this.packageProducts = packageProducts;
	}

}
