package edu.snnu.carrent.model;

import java.util.Set;

/*
 * 城市实体类
 */
public class City {

	private Integer cityId;// 城市ID
	private String cityName;// 城市名称
	private Integer cityIsTake;// 取车城市为0，还车城市为1
	private Set<Place> cityPlace;// 城市所有的位置
	private Country cityFromCountry;// 城市所属的国家
}
