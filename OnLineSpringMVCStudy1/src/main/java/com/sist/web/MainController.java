package com.sist.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//MVC => Model클래스 설정 :요청처리 => 결과값 전송(B)
/*
 * 		Model
 * 		===================
 * 		= ~VO
 * 		= ~DAO
 * 		= ~Manger
 * 		= ~Controller
 * 		======================== 재사용  ==> Model + View = 서블릿(DispatcherServlet)
 * 		View
 * 		= CSS
 * 		= JS
 * 		= JSP
 * 		= HTML
 * 		======================== 재사용
 * 
 * 		1. 프로그램 => 상태관리 (데이터관리) : 변수 (변수,클래스)
 * 			var, val (kotlin)
 */
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {
	// ID, Password
	// 1. 입력하는 JSP
	@RequestMapping("main/output.do")
	// 매개변수는 DispatcherServlet이 설정해준다
	public String main_input(HttpServletRequest request)
	{
		// 스프링 2.5 이하 => request
		// 스프링 2.5 이상 => 권장 => request를 사용하지 않는다
		// 보안 (request안에는 접속자의 IP를 확인이 가능) => 5.0이상 (클래스)
		// 데이터 처리 => 전송 (JSP) 
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
		return "main/output";
		/*
		 *  return "" => forward
		 *  return "폴더명/JSP명"
		 *  		"main/main" ==> .jsp를 생략한다
		 *  return "" => sendRedirect
		 *  		"redirect:main.do"
		 */
	}
	@RequestMapping("main/input.do")
	public String main_input()
	{
		return "main/input";
	}
	
	@RequestMapping("main/output2.do")
	// MemberVO vo
	public String main_output2(String id,String pwd,Model model)
	{	
		// Model => 인터페이스 (해당 JSP 데이터 전송 역할)
		// 전송
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		// Spring => 요청값 받을 때 => 매개변수로 받는다, 전송시에는 Model을 이용해서 전송
		/*
		 * 		public class Model
		 * 		{	
		 * 			HttpServletRequest request;
		 * 			public void addAttribute(String key,Object obj)
		 * 			{
		 * 				request.setAttrubute(key,obj) => DispatcherServlet
		 * 			}
		 * 		}
		 */
		return "main/output2";
	}
	
	
}
