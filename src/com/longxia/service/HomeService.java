package com.longxia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longxia.entities.Bar;
import com.longxia.entities.BarCategorTwo;
import com.longxia.entities.BarCategory;
import com.longxia.hibernate.dao.impl.BarCategorTwoDAO;
import com.longxia.hibernate.dao.impl.BarCategoryDAO;
import com.longxia.hibernate.dao.impl.BarDAO;

/**
 * 
 * @author LongXia
 * @date 2017-4-15 上午10:52:07
 * @description 首页业务类
 *
 */

@Service
public class HomeService {
	
	@Autowired
	private BarCategoryDAO barCategoryDAO;
	
	@Autowired
	private BarCategorTwoDAO barCategorTwoDAO;
	
	@Autowired
	private BarDAO barDAO;
	
	//获取首页显示的一级导航分类标题
	public List<BarCategory> getAllBarCategory(){
		return barCategoryDAO.findAll();
	}
	
	public List<BarCategorTwo> getAllBarCategoryTwo(){
		return barCategorTwoDAO.findAll();
	}
	
	public List<Bar> getAllBar(){
		return barDAO.findAll();
	}
}
