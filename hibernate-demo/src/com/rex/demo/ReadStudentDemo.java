package com.rex.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rex.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int theId=5;
			Student tempStudent=session.get(Student.class, theId);
			System.out.println(tempStudent);
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}

	}

}
