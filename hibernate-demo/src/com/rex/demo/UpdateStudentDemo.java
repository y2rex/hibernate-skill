package com.rex.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rex.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		try {
//=========================1st method==========================
			Session session=factory.getCurrentSession();
			session.beginTransaction();
			int studentId=1;
			Student st=session.get(Student.class, studentId);
			st.setFirstName("akash");
			session.getTransaction().commit();
			/*
			 * when you commit the session then after this updated value, 
			 * will store in database.line number 24 only update in memory
			 * not in database.
			 */
			
//=========================2nd method==========================			
			session=factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set lastName='sharma' "
					+ "where lastName='jax'").executeUpdate();
			session.getTransaction().commit();
			

			
		}
		finally {
			factory.close();
		}

	}

}
