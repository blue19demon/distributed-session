package com.distribution.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 页面登陆控制器
 */
@RestController
@RequestMapping("/")
public class LoginController {

	@Autowired
	private HttpSession session;

	@GetMapping("/welcome")
	public ModelAndView welcome(ModelAndView modelAndView) {
		String username = (String) session.getAttribute("userName");
		if (StringUtils.isEmpty(username)) {
			modelAndView.addObject("error", "请先登录！");
			modelAndView.setViewName("redirect:/login");
			return modelAndView;
		}
		modelAndView.setViewName("welcome");
		return modelAndView;
	}

	@GetMapping("/login")
	public ModelAndView login(ModelAndView modelAndView) {
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@GetMapping("/logout")
	public ModelAndView logout(ModelAndView modelAndView) {
		session.removeAttribute("userName");
		modelAndView.setViewName("redirect:/login");
		return modelAndView;
	}

	@PostMapping("/login")
	public ModelAndView login(HttpServletRequest request, ModelAndView modelAndView) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String error = request.getParameter("error");
		if (!StringUtils.isEmpty(error)) {
			modelAndView.addObject("error", error);
			modelAndView.setViewName("login");
			return modelAndView;
		}
		if (!("admin".equalsIgnoreCase(username) && "123".equalsIgnoreCase(password))) {
			modelAndView.addObject("error", "无此用户！");
			modelAndView.setViewName("login");
			return modelAndView;
		}
		session.setAttribute("userName", username);
		modelAndView.setViewName("redirect:/welcome");
		return modelAndView;
	}
}