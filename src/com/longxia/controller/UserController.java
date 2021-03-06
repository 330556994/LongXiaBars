package com.longxia.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.longxia.entities.User;
import com.longxia.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/loginOrRegistry";
	}

	// // 登陆功能
	// @RequestMapping(value = "/login" , method = RequestMethod.POST )
	// public String login(String username, String password, Model model,
	// HttpServletRequest request) {
	// if (userService.login(username, password)) {
	// // 登陆成功
	// request.getSession().setAttribute("currentUser",userService.getUserByUsername(username));
	// return "redirect:/index";
	// } else {
	// // 登陆失败
	// model.addAttribute("message", "用户名或密码错误");
	// model.addAttribute("username", username);
	// }
	// return "redirect:/index";
	// }

	// 登陆功能
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, HttpServletRequest request) {
		if (userService.login(user.getUsername(), user.getPassword())) {
			// 登陆成功
			request.getSession().setAttribute("currentUser",
					userService.getUserByUsername(user.getUsername()));
			return "{\"success\":0}";
		} else {
			return "{\"success\":-1}";
		}

	}

	

	// 退出方法
	@ResponseBody
	@RequestMapping(value = "/exit")
	public String exit(HttpServletRequest request) {
		try {
			request.getSession().removeAttribute("currentUser");
			return "{\"success\":0}";
		} catch (RuntimeException e) {
			return "{\"success\":-1}";
		}

	}
	
	//注册请求静态页面
	@RequestMapping(value="/registry",method=RequestMethod.GET)
	public String registry(Model model){
		model.addAttribute("mode", "registry");
		return "user/loginOrRegistry";
	}
	
	// 注册添加方法
	@ResponseBody
	@RequestMapping(value = "/registry", method = RequestMethod.POST)
	public String add(User user,HttpServletRequest request) {
		user.setAge(0);
		user.setFanscount(0);
		user.setAttentioncount(0);
		user.setNickname("大王叫我来巡山");
		user.setCreatetime(new Timestamp(0));
		user.setSex(1);
		int result = userService.registry(user);
		if(result==0){
			request.getSession().setAttribute("currentUser",user);
		}
		return "{\"success\":\""+ result +"\"}";
	}
	
	
}
