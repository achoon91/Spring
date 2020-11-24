package com.sist.di2;

import org.springframework.stereotype.Repository;

@Repository
public class MySql implements MyDAO{

	@Override
	public void getConnection() {
		// TODO Auto-generated method stub
		System.out.println("MySql 연결");
	}

	@Override
	public void disConection() {
		// TODO Auto-generated method stub
		System.out.println("MySql 해제");
	}

}
