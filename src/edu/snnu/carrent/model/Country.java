package edu.snnu.carrent.model;

import java.util.Set;

/*
 * 国家实体类
 */
public class Country {

	private Integer countryId;// 国家ID
	private String countryString;// 国家名称
	private Set<City> countryCit;// 国家拥有的城市
}
