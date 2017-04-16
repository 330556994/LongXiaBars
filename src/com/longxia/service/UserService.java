package com.longxia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longxia.entities.User;
import com.longxia.hibernate.dao.impl.UserDAO;

/**
 * 
 * @author LongXia
 * @date 2017-4-15 ����5:25:49
 * @description �û�ҵ����
 *
 */

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	
	//�����û� Id ��ȡ�����û���Ϣ
	public User getUserById(int id){
		return userDAO.findById(id);
	}
	
}
