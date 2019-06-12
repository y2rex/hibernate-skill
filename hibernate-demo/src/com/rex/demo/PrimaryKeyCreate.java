package com.rex.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rex.demo.entity.Student;

public class PrimaryKeyCreate {

	public static void main(String[] args) {

		//create session factory
				SessionFactory factory=new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				//create session
				Session session=factory.getCurrentSession();
				
				try {
					//create student
					Student theStudent1=
							new Student("aadish", "kagla", "aadish@gmail.com");
					Student theStudent2=
							new Student("abhishek", "tailor", "abhishek@gmail.com");
					Student theStudent3=
							new Student("aditi", "udadhyay", "aditi@gmail.com");
					
					//start transaction
					session.beginTransaction();
					
					//save the student object
					session.save(theStudent1);
					session.save(theStudent2);
					session.save(theStudent3);
					//commit the transaction
					session.getTransaction().commit();
				}
				finally {
					factory.close();
				}


	}

}
