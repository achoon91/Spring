package com.sist.di2;

import org.springframework.stereotype.Repository;

@Repository
public class Oracle implements MyDAO{

	@Override
	public void getConnection() {
		// TODO Auto-generated method stub
		System.out.println("오라클 연결");
	}

	@Override
	public void disConection() {
		// TODO Auto-generated method stub
		System.out.println("오라클 해제");
	}

}
