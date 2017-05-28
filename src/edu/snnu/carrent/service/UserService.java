package edu.snnu.carrent.service;

import org.json.simple.JSONObject;

import edu.snnu.carrent.model.User;

/*
 * 用户服务类
 */

public interface UserService extends BaseService<User> {

	JSONObject getById(User user);

}
