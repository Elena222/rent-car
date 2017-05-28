package edu.snnu.carrent.model;

import java.util.Set;

/*
 * 车辆类型实体类
 */
public class Type {
	private Integer typeId;// 车辆类型的ID
	private String typeName;// 车辆类型的名称
	private String typeDesc;// 车辆类型的描述

	private Set<Car> typeCars;// 此类型的所有车辆

	public Type() {
	}

	public Type(String typeName, String typeDesc) {
		super();
		this.typeName = typeName;
		this.typeDesc = typeDesc;
	}

	// 车型ID的get方法
	public Integer getTypeId() {
		return typeId;
	}

	// 车型ID的set方法
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	// 车型名称的get方法
	public String getTypeName() {
		return typeName;
	}

	// 车型名称的set方法
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	// 车型描述的get方法
	public String getTypeDesc() {
		return typeDesc;
	}

	// 车型描述的set方法
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	// 此类型的车辆的get方法
	public Set<Car> getTypeCars() {
		return typeCars;
	}

	// 此类型的车辆的set方法
	public void setTypeCars(Set<Car> typeCars) {
		this.typeCars = typeCars;
	}

}
