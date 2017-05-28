package edu.snnu.carrent.service;

import java.util.Date;

import edu.snnu.carrent.model.Car;
import edu.snnu.carrent.model.Company;
import edu.snnu.carrent.model.Type;

/*
 *车辆服务类 
 */
public interface CarService extends BaseService<Car> {

	void save1(Car car, Company company, Type type);

	Integer getcarTotal(Date takeCarDateEnd, Date backCarDateEnd,
			Integer carPrice);
}
