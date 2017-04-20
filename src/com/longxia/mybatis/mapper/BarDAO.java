package com.longxia.mybatis.mapper;

import java.util.List;

import com.longxia.entities.Bar;

public interface BarDAO {
	
	List<Bar> findAll();
	
	List<Bar> findByCategory2Id(int category2Id);

}
