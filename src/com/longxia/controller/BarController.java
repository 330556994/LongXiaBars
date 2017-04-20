package com.longxia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.longxia.entities.Bar;
import com.longxia.service.BarService;

/**
 * 
 * @author LongXia
 * @date 2017-4-20 ÏÂÎç7:59:52
 * @description Ìù°É¿ØÖÆÆ÷
 *
 */

@Controller
public class BarController {
	
	@Autowired
	private BarService barService;

	public List<Bar> getBarByCategory2Id(int category2Id){
		return barService.getBarByCategory2Id(category2Id);
		
	}
	
}
