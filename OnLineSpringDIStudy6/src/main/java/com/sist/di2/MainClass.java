package com.sist.di2;

import static org.hamcrest.CoreMatchers.instanceOf;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class MainClass {
	//@Autowired
	//@Qualifier("oracle")
	// @Autowired + @Qualifier("oracle") = @Resurce
	@Resource(name="mySql")
	private MyDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app3.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		mc.dao.getConnection();
		mc.dao.disConection();
		
		String s="Hello";
		StringBuffer sb=new StringBuffer();
		Object obj=new Object();
//		if(s instanceof String)
//		{
//			System.out.println("����");
//		}
		
		/*
		 * 	@Autowired : �������� ������ ����� Ŭ���� ��ü�� ����
		 * 				����� Ŭ������ �ּҰ��� �������� �ڵ����� ����
		 * 
		 */
		
	}

}
