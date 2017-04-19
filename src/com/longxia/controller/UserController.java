package com.longxia.controller;

import java.util.List;

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
		return "user/login";
	}

	// // ��½����
	// @RequestMapping(value = "/login" , method = RequestMethod.POST )
	// public String login(String username, String password, Model model,
	// HttpServletRequest request) {
	// if (userService.login(username, password)) {
	// // ��½�ɹ�
	// request.getSession().setAttribute("currentUser",userService.getUserByUsername(username));
	// return "redirect:/index";
	// } else {
	// // ��½ʧ��
	// model.addAttribute("message", "�û������������");
	// model.addAttribute("username", username);
	// }
	// return "redirect:/index";
	// }

	// ��½����
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, HttpServletRequest request) {
		if (userService.login(user.getUsername(), user.getPassword())) {
			// ��½�ɹ�
			request.getSession().setAttribute("currentUser",
					userService.getUserByUsername(user.getUsername()));
			return "{\"success\":0}";
		} else {
			return "{\"success\":-1}";
		}

	}

	// ע�᷽�� δ���
	@RequestMapping("/add")
	public String add(Model model) {
		List<User> list = userService.getList();
		model.addAttribute("list", list);
		return "add";
	}

	// �˳�����
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
}
