package com.sist.di3;
import java.util.*;

import org.springframework.stereotype.Repository;


@Repository
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			List<String> list=new ArrayList<String>();
			list.add("com.sist.di3.A");
			list.add("com.sist.di3.B");
			list.add("com.sist.di3.C");
			
			for(String s:list)
			{
				Class clsName=Class.forName(s);
				if(clsName.isAnnotationPresent(Component.class)==false)
					continue;
				Object obj=clsName.newInstance();
				System.out.println(obj);
				
			}
		}catch(Exception ex){}
	}

}
