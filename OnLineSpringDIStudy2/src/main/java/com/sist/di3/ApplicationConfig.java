package com.sist.di3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
// XML�� ��� �̿�
@Configuration
public class ApplicationConfig {
	@Bean("mem")
	//@Scope("prototype")
	// <bean> XML => ��ó�ϴ� ���α׷� (������̼�)
	// �̱���
	public Member memberInfo()
	{
		Member m=new Member("�̼���","����","010-1111-1111");
		return m;
	}
}
