package com.rex.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rex.demo.entity.Student;

public class PracticeQuery {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();


		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			List<Student> list=session.createQuery("from Student").list();
			System.out.println(list);
			
			int i=session.createQuery("delete from Student where id=8").executeUpdate();
			System.out.println(i);
			
		
			
			session.getTransaction().commit();
		}
		finally {
			
		}

	}

}
