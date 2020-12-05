package com.sist.aop;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("main/main.do")
	public String main_main(MemberVO vo, Model model)
	{
		model.addAttribute("vo", vo);
		return "main/main";
	}
}
