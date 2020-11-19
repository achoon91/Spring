package com.sist.di;

import javax.annotation.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
   // 클래스
   @Bean("sa")
   public Sawon sawonInfo()
   {
      Sawon sa = new Sawon();
      sa.setName("홍길동");
      sa.setAddr("서울");
      sa.setTel("010-1111-1111");
      
      return sa;
   }
   @PostConstruct
   // <bean id="sa" class="Sawon" init-method="init" destroy-method="destroy">
   /*
    * 	메소드 호출
    * 		객체생성시 : init-method (@PostConstruct)
    * 				=============DB (드라이버등록)
    * 		객체소멸시 : destroy-method (@PreDestroy)
    * 				============ DB (disConnection)
    * 
    * 	DI
    * 	= setter DI
    * 	= method DI (init-method,destroy-method)
    * 	= constructor DI 생성자 매개변수
    * 	= 자동 주입
    */
   public void init()
   {
      System.out.println("=========사원 정보 ==========");
      
   }
   
   @PreDestroy
   public void destroy()
   {
      System.out.println("=========================");
   }
}