package com.longxia.mybatis.mapper;

import java.util.List;

import com.longxia.entities.User;

public interface UserDAO {

	// �����û� Id ��ȡ�����û���Ϣ
	User findById(int id);
	
	// ��½����
	Boolean login(String username, String password);
	
	// ͨ���û�����ȡ User ����
	List<User> findByUsername(String username);
	
	
	
	
	
}
