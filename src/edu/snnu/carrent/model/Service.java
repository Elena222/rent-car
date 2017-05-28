package edu.snnu.carrent.model;

import java.util.HashSet;
import java.util.Set;

/*
 * 服务实体类
 */
public class Service {

	private Integer serviceId;// 服务ID
	private String serviceName;// 服务名
	private double servicePrice;// 服务价格
	private String serviceDes;// 服务描述

	private Set<Order> serviceOrders = new HashSet<Order>();// 服务订单
	private Set<Product> serviceProducts = new HashSet<Product>();// 关联的产品

	// 无参构造函数
	public Service() {
		super();
	}

	// 有参构造函数
	public Service(String serviceName, String serviceDes) {
		super();
		this.serviceName = serviceName;
		this.serviceDes = serviceDes;
	}

	// 获得服务ID
	public Integer getServiceId() {
		return serviceId;
	}

	// 服务ID的set方法
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	// 服务名称的get方法
	public String getServiceName() {
		return serviceName;
	}

	// 服务名称的set方法
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	// 服务价格的get方法
	public double getServicePrice() {
		return servicePrice;
	}

	// 服务价格的set方法
	public void setServicePrice(double servicePrice) {
		this.servicePrice = servicePrice;
	}

	// 服务描述的get方法
	public String getServiceDes() {
		return serviceDes;
	}

	// 服务描述的set方法
	public void setServiceDes(String serviceDes) {
		this.serviceDes = serviceDes;
	}

	// 服务的订单的get方法
	public Set<Order> getServiceOrders() {
		return serviceOrders;
	}

	// 服务的订单的set方法

	public void setServiceOrders(Set<Order> serviceOrders) {
		this.serviceOrders = serviceOrders;
	}

	// 服务产品的get方法
	public Set<Product> getServiceProducts() {
		return serviceProducts;
	}

	// 服务产品的set方法
	public void setServiceProducts(Set<Product> serviceProducts) {
		this.serviceProducts = serviceProducts;
	}

}
