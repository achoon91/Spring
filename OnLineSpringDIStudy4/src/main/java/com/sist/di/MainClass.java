package com.sist.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] xml={"app1.xml","app2.xml"}; // 2개 이상이면 배열로 처리
		ApplicationContext app=new ClassPathXmlApplicationContext(xml);
		Sawon sa=(Sawon)app.getBean("sa"); // Object => 반드시 형변환
		System.out.println("이름:"+sa.getName());
		System.out.println("부서:"+sa.getDept());
		System.out.println("직위:"+sa.getJob());
		Member mem=app.getBean("mem",Member.class);
		System.out.println("이름:"+mem.getName());
		System.out.println("주소:"+mem.getAddr());
		System.out.println("전화:"+mem.getTel());
	}

}
