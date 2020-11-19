package com.sist.di;

import javax.annotation.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
   // Ŭ����
   @Bean("sa")
   public Sawon sawonInfo()
   {
      Sawon sa = new Sawon();
      sa.setName("ȫ�浿");
      sa.setAddr("����");
      sa.setTel("010-1111-1111");
      
      return sa;
   }
   @PostConstruct
   // <bean id="sa" class="Sawon" init-method="init" destroy-method="destroy">
   /*
    * 	�޼ҵ� ȣ��
    * 		��ü������ : init-method (@PostConstruct)
    * 				=============DB (����̹����)
    * 		��ü�Ҹ�� : destroy-method (@PreDestroy)
    * 				============ DB (disConnection)
    * 
    * 	DI
    * 	= setter DI
    * 	= method DI (init-method,destroy-method)
    * 	= constructor DI ������ �Ű�����
    * 	= �ڵ� ����
    */
   public void init()
   {
      System.out.println("=========��� ���� ==========");
      
   }
   
   @PreDestroy
   public void destroy()
   {
      System.out.println("=========================");
   }
}