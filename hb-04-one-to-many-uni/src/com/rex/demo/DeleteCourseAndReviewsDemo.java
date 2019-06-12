package com.rex.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rex.demo.entity.Course;
import com.rex.demo.entity.Instructor;
import com.rex.demo.entity.InstructorDetail;
import com.rex.demo.entity.Review;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {
     
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
			Session session = factory.getCurrentSession();
			
			try {			
			
			session.beginTransaction();
			
			int theId=13;
			Course course=session.get(Course.class, theId);
			session.delete(course);
			
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			}
			finally 
			{
			
				session.close();
				factory.close();
			}
					
			
	}

}
