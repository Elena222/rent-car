package edu.snnu.carrent.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/*
 * 订单实体类
 */
public class Order {
	private Integer orderId;// 订单ID
	private String orderNum; // 订单号
	private Date takeCarDateStart; // 取车时间段起始时间
	private Date takeCarDateEnd;// 取车时间段终止时间
	private Date backCarDateStart;// 还车时间段起始时间
	private Date backCarDateEnd;// 换车时间段终止时间
	private String orderTakeCity;// 取车城市
	private String orderBackCity;// 还车城市
	private String orderTakePlace;// 取车位置
	private String orderBackPlace;// 还车位置
	private Integer payway;// 支付方式
	private double orderPrice;// 订单价格
	private Integer isPay;// 是否支付
	private Integer orderStatus;// 订单状态

	private Car orderCar;// 订单上的车辆
	private Company orderCompany;// 订单上的公司
	private Driver orderDriver;// 订单的司机
	private Package orderPackage;// 订单的套餐
	private Product orderProduct;// 订单的产品
	private Set<Service> orderServices = new HashSet<Service>();// 订单的服务
	private User orderUser;// 订单的用户

	// 无参构造函数
	public Order() {
		super();
	}

	public Order(double orderPrice) {
		super();
		this.orderPrice = orderPrice;
	}

	// 有参构造函数
	public Order(Date takeCarDateStart, Date takeCarDateEnd,
			Date backCarDateStart, Date backCarDateEnd, String orderTakeCity,
			String orderBackCity, String orderTakePlace, String orderBackPlace,
			Integer payway, double orderPrice, Integer isPay,
			Integer orderStatus, Company orderCompany, Car orderCar,
			Set<Service> orderServices, User orderUser) {
		super();
		this.takeCarDateStart = takeCarDateStart;
		this.takeCarDateEnd = takeCarDateEnd;
		this.backCarDateStart = backCarDateStart;
		this.backCarDateEnd = backCarDateEnd;
		this.orderTakeCity = orderTakeCity;
		this.orderBackCity = orderBackCity;
		this.orderTakePlace = orderTakePlace;
		this.orderBackPlace = orderBackPlace;
		this.payway = payway;
		this.orderPrice = orderPrice;
		this.isPay = isPay;
		this.orderStatus = orderStatus;
		this.orderCompany = orderCompany;
		this.orderCar = orderCar;
		this.orderServices = orderServices;
		this.orderUser = orderUser;
	}

	// 订单号的get方法
	public String getOrderNum() {
		return orderNum;
	}

	// 订单号的set方法
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	// 订单ID的get方法
	public Integer getOrderId() {
		return orderId;
	}

	// 订单ID的set方法
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	// 取车时间段起始时间的get方法
	public Date getTakeCarDateStart() {
		return takeCarDateStart;
	}

	// 取车时间段起始时间的set方法
	public void setTakeCarDateStart(Date takeCarDateStart) {
		this.takeCarDateStart = takeCarDateStart;
	}

	// 取车时间段终止时间的get方法
	public Date getTakeCarDateEnd() {
		return takeCarDateEnd;
	}

	// 取车时间段终止时间的set方法
	public void setTakeCarDateEnd(Date takeCarDateEnd) {
		this.takeCarDateEnd = takeCarDateEnd;
	}

	// 还车时间段起始时间的get方法
	public Date getBackCarDateStart() {
		return backCarDateStart;
	}

	// 还车时间段起始时间的set方法
	public void setBackCarDateStart(Date backCarDateStart) {
		this.backCarDateStart = backCarDateStart;
	}

	// 还车时间段终止时间的get方法
	public Date getBackCarDateEnd() {
		return backCarDateEnd;
	}

	// 还车时间段终止时间的set方法
	public void setBackCarDateEnd(Date backCarDateEnd) {
		this.backCarDateEnd = backCarDateEnd;
	}

	// 取车城市的get方法
	public String getOrderTakeCity() {
		return orderTakeCity;
	}

	// 取车城市的set方法
	public void setOrderTakeCity(String orderTakeCity) {
		this.orderTakeCity = orderTakeCity;
	}

	// 还车城市的get方法
	public String getOrderBackCity() {
		return orderBackCity;
	}

	// 还车城市的set方法
	public void setOrderBackCity(String orderBackCity) {
		this.orderBackCity = orderBackCity;
	}

	// 取车位置的get方法
	public String getOrderTakePlace() {
		return orderTakePlace;
	}

	// 取车位置的set方法
	public void setOrderTakePlace(String orderTakePlace) {
		this.orderTakePlace = orderTakePlace;
	}

	// 还车位置的get方法
	public String getOrderBackPlace() {
		return orderBackPlace;
	}

	// 还车位置的set方法
	public void setOrderBackPlace(String orderBackPlace) {
		this.orderBackPlace = orderBackPlace;
	}

	// 支付方式的get方法
	public Integer getPayway() {
		return payway;
	}

	// 支付方式的set方法
	public void setPayway(Integer payway) {
		this.payway = payway;
	}

	// 订单价格的get方法
	public double getOrderPrice() {
		return orderPrice;
	}

	// 订单价格的set方法
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	// 是否支付的get方法
	public Integer getIsPay() {
		return isPay;
	}

	// 是否支付的set方法
	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}

	// 公司的get方法
	public Company getOrderCompany() {
		return orderCompany;
	}

	// 公司的set方法
	public void setOrderCompany(Company orderCompany) {
		this.orderCompany = orderCompany;
	}

	// 车辆的get方法
	public Car getOrderCar() {
		return orderCar;
	}

	// 车辆的set方法
	public void setOrderCar(Car orderCar) {
		this.orderCar = orderCar;
	}

	// 服务的get方法
	public Set<Service> getOrderServices() {
		return orderServices;
	}

	// 服务的set方法
	public void setOrderServices(Set<Service> orderServices) {
		this.orderServices = orderServices;
	}

	// 用户的get方法
	public User getOrderUser() {
		return orderUser;
	}

	// 用户的set方法
	public void setOrderUser(User orderUser) {
		this.orderUser = orderUser;
	}

	// 司机的get方法
	public Driver getOrderDriver() {
		return orderDriver;
	}

	// 司机的set方法
	public void setOrderDriver(Driver orderDriver) {
		this.orderDriver = orderDriver;
	}

	// 订单状态的get方法
	public Integer getOrderStatus() {
		return orderStatus;
	}

	// 订单状态的set方法
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	// 订单套餐的get方法
	public Package getOrderPackage() {
		return orderPackage;
	}

	// 订单套餐的set方法
	public void setOrderPackage(Package orderPackage) {
		this.orderPackage = orderPackage;
	}

	// 订单产品的get方法
	public Product getOrderProduct() {
		return orderProduct;
	}

	// 订单产品的set方法
	public void setOrderProduct(Product orderProduct) {
		this.orderProduct = orderProduct;
	}

}
