package com.session.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	// post登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password, Map<String, Object> map) {
		// 添加用户认证信息
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
		// 进行验证，这里可以捕获异常，然后返回对应信息
		subject.login(usernamePasswordToken);
		System.out.println("aaaaaaaaaaaaaaaaaaa");
		return "forward:/index";
	}

	// 退出的时候是get请求，主要是用于退出
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Map<String, Object> map) {
		String user=(String) SecurityUtils.getSubject().getPrincipal();
		map.put("user", user);
		map.put("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return "index";
	}

	// 退出的时候是get请求，主要是用于退出
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	// 登出
	@RequestMapping(value = "/logout")
	public String logout() {
		return "logout";
	}

	// 错误页面展示
	@RequestMapping(value = "/error", method = RequestMethod.POST)
	public String error() {
		return "error ok!";
	}

}
