package com.longxia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longxia.entities.User;
import com.longxia.hibernate.dao.impl.UserDAO;

/**
 * 
 * @author LongXia
 * @date 2017-4-15 下午5:25:49
 * @description 用户业务类
 * 
 */

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	// 根据用户 Id 获取单个用户信息
	public User getUserById(int id) {
		return userDAO.findById(id);
	}

	// 登陆功能
	public Boolean login(String username, String password) {
		return userDAO.login(username,password);
	}
	
	
	public User getUserByUsername(String username){
		return (User) userDAO.findByUsername(username).get(0);
	}

	// 注册方法
	public List<User> getList() {
		return userDAO.getList();
	}


}
