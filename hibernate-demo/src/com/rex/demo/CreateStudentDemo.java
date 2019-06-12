package com.rex.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rex.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			//create student(new data for database)
			Student theStudent=
					new Student("rex", "jax", "rejax@gmail.com");
			
			session.beginTransaction();
			session.save(theStudent);
			session.getTransaction().commit();
			
			//retrieving data
			session=factory.getCurrentSession();
			int id=theStudent.getId();
			session.beginTransaction();
			System.out.println(session.get(Student.class, id));
			
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}

	}

}
