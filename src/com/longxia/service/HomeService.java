package com.longxia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longxia.entities.Bar;
import com.longxia.entities.BarCategoryTwo;
import com.longxia.entities.BarCategory;
//import com.longxia.hibernate.dao.impl.BarCategoryTwoDAO;
//import com.longxia.hibernate.dao.impl.BarCategoryDAO;
//import com.longxia.hibernate.dao.impl.BarDAO;
import com.longxia.mybatis.mapper.BarCategoryDAO;
import com.longxia.mybatis.mapper.BarCategoryTwoDAO;
import com.longxia.mybatis.mapper.BarDAO;

/**
 * 
 * @author LongXia
 * @date 2017-4-15 ����10:52:07
 * @description ��ҳҵ����
 *
 */

@Service
public class HomeService {
	
	@Autowired
	private BarCategoryDAO barCategoryDAO;
	
	@Autowired
	private BarCategoryTwoDAO barCategoryTwoDAO;
	
	@Autowired
	private BarDAO barDAO;
	
	//��ȡ��ҳ��ʾ��һ�������������
	public List<BarCategory> getAllBarCategory(){
		return barCategoryDAO.findAll();
	}
	
	public List<BarCategoryTwo> getAllBarCategoryTwo(){
		return barCategoryTwoDAO.findAll();
	}
	
	public List<Bar> getAllBar(){
		return barDAO.findAll();
	}
}
