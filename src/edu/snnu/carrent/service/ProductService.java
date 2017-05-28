package edu.snnu.carrent.service;

import edu.snnu.carrent.model.Car;
import edu.snnu.carrent.model.Package;
import edu.snnu.carrent.model.Product;
import edu.snnu.carrent.model.Service;

/*
 * 产品服务类
 */

public interface ProductService extends BaseService<Product> {

	void save(Product productadd, Car car, Service service, Package pack);

}
