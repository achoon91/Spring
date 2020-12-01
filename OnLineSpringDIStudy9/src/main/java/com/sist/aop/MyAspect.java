package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 * 		public void select()
 * 		try
 * 		{
 * 			%%%%%% => Before
 * 			---------
 * 			insert();	Around ==> JoinPoint
 * 			---------
 * 		}catch(Exception ex)
 *		{
 *			%%%%%%% ==> After-Throwing
 *		}
 *		finally
 *		{
 *			%%%%%%% ==> After
 *		}
 *		return;  %%%%%% => After-Returning
 * 
 * 
 */
//공통모듈
@Aspect
@Component
public class MyAspect {
	@Autowired
	private MyDAO dao;
	@Before("execution(* com.sist.aop.MyDAO.db_*(..))")
	// * 리턴형 (관계없이 처리) db_*() => 매개변수가 없는 상태
	// db_*(int) db_*(String,String) db_*(..) 매개변수존재(O),존재(x)
	/*
	 * 		1. Before
	 * 		2. After
	 * 		3. After-Throwing
	 * 		4. After-Returning
	 * 		5. Around
	 * 		======================= 호출위치 (JoinPoint)
	 * 		적용되는 메소드 설정 ==> PointCut
	 * 		=========================================== Advice 여러개 ==> Aspect
	 * 
	 * 		==> Proxy 패턴
	 * 			=========
	 * 				=> 대신 호출(대체자)
	 * 		
	 * 		class A
	 * 		{
	 * 			public void display()
	 * 			{
	 * 				System.out.println("display()");
	 * 			}
	 * 		}
	 * 		class Proxy
	 * 		{
	 * 			public void display(A a)
	 * 			{
	 * 				System.out.println("Before");
	 * 				a.display();
	 * 				System.out.println("After");
	 * 			}	
	 * 		}
	 * 		
	 * 		A a=new A();
	 * 		a.display(); ==> X
	 * 		Proxy p=new Proxy();
	 * 		p.display(a); ==> O
	 */
	public void before()
	{
		dao.getConnection();
	}
	@After("execution(* com.sist.aop.MyDAO.db_*(..))")
	public void after()
	{
		dao.disConnection();
	}
}
