package com.sist.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(ApplicationConfig. class);

		// ��ϵ� Ŭ������ ���� => Ŭ������ �ʿ�ø��� app�� ���ؼ� ��ü�ּ� ���´�
		// ��ü ~ �Ҹ�
		// ����
		Sawon s1=app.getBean("sa",Sawon.class);
		// (Sawon)app.getBean("Sa")
		System.out.println("�̸�:"+s1.getName());
		System.out.println("�ּ�:"+s1.getAddr());
		System.out.println("��ȭ:"+s1.getTel());
		
		app.close();
	}

}
