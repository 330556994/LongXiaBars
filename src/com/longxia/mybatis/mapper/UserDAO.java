package com.longxia.mybatis.mapper;

import java.util.List;

import com.longxia.entities.User;

public interface UserDAO {

	// 根据用户 Id 获取单个用户信息
	User findById(int id);
	
	// 登陆功能
	Boolean login(String username, String password);
	
	// 通过用户名获取 User 对象
	List<User> findByUsername(String username);
	
	
	
	
	
}
