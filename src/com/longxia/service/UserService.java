package com.longxia.service;

import java.util.List;

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

	// �����û� Id ��ȡ�����û���Ϣ
	public User getUserById(int id) {
		return userDAO.findById(id);
	}

	// ��½����
	public Boolean login(String username, String password) {
		return userDAO.login(username,password);
	}
	
	
	public User getUserByUsername(String username){
		return (User) userDAO.findByUsername(username).get(0);
	}

	// ע�᷽��
	public int registry(User user) {
		if(findByUsername(user.getUsername())){
			try{
				userDAO.save(user);
				return 0;
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			return 1;
		}
		return -1;
	}
	
	//��ѯע���û����Ƿ�ռ��
	public Boolean findByUsername(String username) {

		return userDAO.findByUsername(username).size()==0?true:false;
	}

}
