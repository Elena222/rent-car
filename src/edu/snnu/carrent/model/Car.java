package edu.snnu.carrent.model;

import java.util.HashSet;
import java.util.Set;

/*
 * 车辆实体类
 */

public class Car {
	private Integer carId;// 汽车ID
	private String carName;// 汽车名
	private double carPrice;// 车价
	private double doorNum;// 门数
	private double seatNum;// 座位数
	private String gear;// 档位
	private String carDes;// 车辆描述
	private String carPhoto;// 车辆图片

	private String carSpace;// **车辆空间描述

	private Company carCompany;// 车辆所属公司
	private Type carType;// 车型组
	private Set<Order> carOrders = new HashSet<Order>();// 关联的订单
	private Set<Product> carProducts = new HashSet<Product>();// 产品

	// 无参构造函数
	public Car() {
		super();
	}

	// 有参构造函数
	public Car(String carName, double carPrice) {
		super();
		this.carName = carName;
		this.carPrice = carPrice;

	}

	public Car(String carName, double carPrice, double doorNum, double seatNum,
			String gear, String carDes, String carPhoto) {
		super();
		this.carName = carName;
		this.carPrice = carPrice;
		this.doorNum = doorNum;
		this.seatNum = seatNum;
		this.gear = gear;
		this.carDes = carDes;
		this.carPhoto = carPhoto;
	}

	// 车型组的get方法
	public Type getCarType() {
		return carType;
	}

	// 车型组的set方法
	public void setCarType(Type carType) {
		this.carType = carType;
	}

	// 车辆图片的get方法
	public String getCarPhoto() {
		return carPhoto;
	}

	// 车辆图片的set方法
	public void setCarPhoto(String carPhoto) {
		this.carPhoto = carPhoto;
	}

	// 车辆ID的get方法
	public Integer getCarId() {
		return carId;
	}

	// 车辆ID的set方法
	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	// 车名的get方法
	public String getCarName() {
		return carName;
	}

	// 车名的set方法
	public void setCarName(String carName) {
		this.carName = carName;
	}

	// 车价的get方法
	public double getCarPrice() {
		return carPrice;
	}

	// 车价的set方法
	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}

	// 门数的get方法
	public double getDoorNum() {
		return doorNum;
	}

	// 门数的set方法
	public void setDoorNum(double doorNum) {
		this.doorNum = doorNum;
	}

	// 座位数的get方法
	public double getSeatNum() {
		return seatNum;
	}

	// 座位数的set方法
	public void setSeatNum(double seatNum) {
		this.seatNum = seatNum;
	}

	// 档位的get方法
	public String getGear() {
		return gear;
	}

	// 档位的set方法
	public void setGear(String gear) {
		this.gear = gear;
	}

	// 车辆描述的get方法
	public String getCarDes() {
		return carDes;
	}

	// 车辆描述的set方法
	public void setCarDes(String carDes) {
		this.carDes = carDes;
	}

	// 车辆所属公司的get方法
	public Company getCarCompany() {
		return carCompany;
	}

	// 车辆所属公司的set方法
	public void setCarCompany(Company carCompany) {
		this.carCompany = carCompany;
	}

	// 产品的get方法
	public Set<Product> getCarProducts() {
		return carProducts;
	}

	// 产品的set方法
	public void setCarProducts(Set<Product> carProducts) {
		this.carProducts = carProducts;
	}

	// 订单的get方法
	public Set<Order> getCarOrders() {
		return carOrders;
	}

	// 订单的set方法
	public void setCarOrders(Set<Order> carOrders) {
		this.carOrders = carOrders;
	}

}
