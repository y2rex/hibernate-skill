package com.rex.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rex.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		try {
//=========================1st method==========================
			Session session =factory.getCurrentSession();
			session.beginTransaction();
			int id=1;
			Student theStudent=session.get(Student.class, id);
			session.delete(theStudent);
			
//=========================2nd method==========================			
			session.createQuery("delete from Student where id=8").executeUpdate();
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}

	}

}
