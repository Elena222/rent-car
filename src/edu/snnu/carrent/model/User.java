package edu.snnu.carrent.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

/*
 * 用户实体类
 */
public class User {
	private Integer userId; // 用户ID
	private String userName;// 用户名
	private String passWord;// 用户密码
	private String userTel;// 用户电话
	private Integer userSex;// 用户性别

	@Autowired
	private String userMail; // 用户邮箱

	private Set<Order> userOrders = new HashSet<Order>();// 用户的所有订单
	private Set<Driver> userDrivers = new HashSet<Driver>();// 用户的所有司机

	public User() {
		super();
	}

	public User(String userName) {
		super();
		this.userName = userName;
	}

	// 用户Id的get方法
	public Integer getUserId() {
		return userId;
	}

	// 用户Id的set方法
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	// 用户名的get方法
	public String getUserName() {
		return userName;
	}

	// 用户名的set方法
	public void setUserName(String userName) {
		this.userName = userName;
	}

	// 用户密码的get方法
	public String getPassWord() {
		return passWord;
	}

	// 用户密码的set方法
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	// 用户电话的get方法
	public String getUserTel() {
		return userTel;
	}

	// 用户电话的set方法
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	// 用户的所有订单的get方法
	public Set<Order> getUserOrders() {
		return userOrders;
	}

	// 用户所有订单的set方法
	public void setUserOrders(Set<Order> userOrders) {
		this.userOrders = userOrders;
	}

	// 用户所有司机的get方法
	public Set<Driver> getUserDrivers() {
		return userDrivers;
	}

	// 用户所有司机的set方法
	public void setUserDrivers(Set<Driver> userDrivers) {
		this.userDrivers = userDrivers;
	}

	public Integer getUserSex() {
		return userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

}
