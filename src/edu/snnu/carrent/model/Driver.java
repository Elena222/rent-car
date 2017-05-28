package edu.snnu.carrent.model;

import java.util.Date;
import java.util.Set;

/*
 * 司机实体类
 */
public class Driver {

	private Integer driverId;// 司机ID
	private String driverName;// 司机名
	private Date driverBirthday;// 司机生日
	private String driverTel;// 司机电话
	private User driverUser;// 关联的用户
	private Integer driverCardType;// 驾照类型
	private Set<Order> driverOrder;// 与司机有关的订单

	// 无参构造函数
	public Driver() {
	}

	// 有参构造函数
	public Driver(String driverName, Date driverBirthday, String driverTel) {
		super();
		this.driverName = driverName;
		this.driverBirthday = driverBirthday;
		this.driverTel = driverTel;
	}

	// 司机ID的get方法
	public Integer getDriverId() {
		return driverId;
	}

	// 司机ID的set方法
	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	// 司机名的get方法
	public String getDriverName() {
		return driverName;
	}

	// 司机名的set方法
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	// 司机生日的get方法
	public Date getDriverBirthday() {
		return driverBirthday;
	}

	// 司机生日的set方法
	public void setDriverBirthday(Date driverBirthday) {
		this.driverBirthday = driverBirthday;
	}

	// 司机电话的get方法
	public String getDriverTel() {
		return driverTel;
	}

	// 司机电话的set方法
	public void setDriverTel(String driverTel) {
		this.driverTel = driverTel;
	}

	// 关联的用户的get方法
	public User getUser() {
		return driverUser;
	}

	// 关联的用户的set方法
	public void setUser(User user) {
		this.driverUser = user;
	}

	// 订单的get方法
	public Set<Order> getDriverOrder() {
		return driverOrder;
	}

	// 订单的set方法
	public void setDriverOrder(Set<Order> driverOrder) {
		this.driverOrder = driverOrder;
	}

}
