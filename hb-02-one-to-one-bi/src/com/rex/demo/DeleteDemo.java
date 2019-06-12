package com.rex.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rex.demo.entity.Instructor;
import com.rex.demo.entity.InstructorDetail;

public class DeleteDemo {

	//======================for deleting purpose=======================================

	public static void main(String[] args) {

		// create session factory
		//here two classes is used for adding annotation
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			
			// start a transaction
			session.beginTransaction();
			
			/*
			 * a=session.createQuery("delete from Instructor where id=2").executeUpdate();
			 * ====>>>>It will only delete from Instructor table
			 */
			
			int id=5;
			Instructor temp=session.get(Instructor.class, id);
			if(temp!=null)
				session.delete(temp);
			//It will also delete from InstructorDetail Table because of cascading all property
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





