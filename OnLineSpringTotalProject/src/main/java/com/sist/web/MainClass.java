package com.sist.web;
/*
 * 		스프링
		=> DI (주입=> 필요한 데이터 주입 => 메모리 할당 (생성 => 메모리에 저장)
		     ==
		     1. setterDI => setXxx() => DB연결, 네트워크 ....
		   => <bean id="aaa" class=" "
		      p:username=""
		      p:url=""
		      p:driverClassName=""
		     2. 생성자 DI => 생성자의 매개변수를 이용해서 주입
		   => <bean id="bbb"
		      class=""
		      ip=""
		      db=""
		      table=""
		         />
		     3. 스프링에 등록된 객체 주소 주입
		   ===================> @Autowired, @Resource
		   class A => new A()
		   Class B
		   {
		        @autowird
		        A a;
		   }
		   ==> 동작
		        : XML을 읽어서 등록된 클래스를 메모리 할당
		      ============================ > 저장 (맵으로 저장)
		                     HashMap
		                     ========
		                     Key  주소
		                     ========
		                     a     new A()
		
		                  A a=getBean("a")
		                  A a=new A()
		   2. 값을 주입 (setXxx(), 생성자)
		   3. method => 생성시 => init-method
		             소멸시 => destroy-method
		   4. 프로그래머가 활용(순서에 맞게 메소드 호출 사용)
		   5. 소멸 (메모리 해제)
		   목적 => 결합성이 낮은 프로그램을 구현 => 유지보수가 편리 
		      ===============> 클래스가 독립적으로 수행 ====> POJO방식
		                    메모리 절약
		            ** 단점 => 어렵다 (xml,annotation)
		      =1. 스프링 => 라이브러리를 로딩 (XML => POM.xml)
		              ===> 메이븐 (라이브러리 관리, 프로젝트 관리, 배포관리)
		        2. 클래스를 제작 => 스프링에 등록(관리) ==> xml(application-context.xml)
		        3. 필요한 클래스를 연결 (주입) => 어노테이션 
		      =======================================================
		      
		  1. 스프링
		  	= DL => 등록된 클래스 찾기 (getBean() => 휍에서는 자동 처리)
		  	= DI => 필요한 데이터 처리(XML, Annotation)
		  	= AOP
		  		=> 어느 메소드에 추가 여부
		  		============= PointCut
		  		=> 메소드의 어떤 위치
		  		=============  	JoingPoint
		  						Before : 메소드 시작적
		  						After : 무조건 호출 (finally)
		  						Around : 코딩 위 아래
		  						After-Throwing : catch수행
		  								= 에러를 처리
		  						After-Returning : 정상수행
		  								= 리턴값을 받아서 처리
		  			PointCut+JoinPoint = Advice(=공통으로 사용되는 메소드에 집합: 공통모듈)
		  				=> 트랜잭션, 로그파일, 보안처리
		  				
		  		public void empinsert()
		  		{
		  			@Before ==> getConnection()
		  			try
		  			{
		  				============@ setAutoCommit(false)
		  				insert();
		  				update();
		  				============
		  							commit() ==> @Around
		  			}catch(Exception ex)
		  			{
		  				@After-Throwing
		  				rollback()
		  			}
		  			finally
		  			{
		  				@After
		  				setAutoCommit(true)
		  				disConnection()
		  			}
		  			return;
		  		}
		  		
		  		=MVC
		  		Model : 요청 처리 ==> @Controller <==> DAO
		  		View : JSP
		  		Controller : 요청을 받아서 => Model을 찾고 => 결과값을 받아서 JSP로 결과값을 전송
		  								HandleMapping 		ViewResolver
		  													==> JSP등록명이 등록되어 있지 않다
		  														XML
		  		.do
		  	==> 손님 ==> 서빙 =====> 주방
		  			<==		주문한 음식<===
		  		
		  	1. 기능 (메뉴) ==> @RequestMapping
		  					===============
		  					@GetMapping
		  					@PostMapping
		  		=============================== Model
		  		1. 재료 : getParameter(사용자요청)
		  		2. 가공 : DAO
		  		3. 그릇 : Request,setAttribute
		  				model.addAttribute()
		  		================================
		  		4. 상차림 : 탁자 : JSP
		  			차림 => HTML ,JSTL
		  		================================
		  		사용자 정보를 저장(qr, 수기) ==> Session
		  		
		  	2. DAO
		  		===> JDBC, ORM(Mybatis,hibernate,JPA)
		  		
		  		
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
