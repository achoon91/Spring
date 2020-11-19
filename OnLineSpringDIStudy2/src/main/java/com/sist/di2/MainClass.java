package com.sist.di2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MainClass {

   public static void main(String[] args) {
      ApplicationContext app = new ClassPathXmlApplicationContext("app2.xml");
      EmpDAO dao = (EmpDAO)app.getBean("empDAO");
      List<EmpVO> list= dao.empAllData();
      for(EmpVO vo:list)
      {
         System.out.println(vo.getEmpno()+" "
               +vo.getEname()+" "
               +vo.getJob()+" "
               +vo.getSal());
      }
   }
}