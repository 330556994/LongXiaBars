package com.longxia.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.longxia.entities.User;
import com.longxia.service.HomeService;
import com.longxia.service.UserService;

/**
 * 
 * @author LongXia
 * @date 2017-4-15 ÉÏÎç10:46:47
 * @description Ê×Ò³¿ØÖÆÆ÷
 * 
 */

@Controller
public class HomeController {

	@Autowired
	private HomeService homeService;

	
	@RequestMapping(value = "index")
	public String index(Model model) {
		model.addAttribute("allBarCategory", homeService.getAllBarCategory());
		model.addAttribute("allBarCategoryTwo",
				homeService.getAllBarCategoryTwo());
		model.addAttribute("allBar", homeService.getAllBar());
		return "home/index";
	}

	
}
