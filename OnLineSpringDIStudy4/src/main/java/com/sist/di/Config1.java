package com.sist.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config1 {
	@Bean("sawon")
	public Sawon sawonInfo()
	{
		Sawon s=new Sawon(); // ��ü ����
		// DI
		s.setName("�̼���");
		s.setDept("���ߺ�");
		s.setJob("����");
		return s;
	}
}
