package com.longxia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longxia.entities.Bar;
import com.longxia.mybatis.mapper.BarDAO;
//import com.longxia.hibernate.dao.impl.BarDAO;

/**
 * 
 * @author LongXoa
 * @date 2017-4-20 下午8:01:44
 * @description 贴吧业务类
 *
 */

@Service
public class BarService {

	@Autowired
	private BarDAO barDAO;
	
	public List<Bar> getBarByCategory2Id(int category2Id){
		return barDAO.findByCategory2Id(category2Id);
	}
	
}
