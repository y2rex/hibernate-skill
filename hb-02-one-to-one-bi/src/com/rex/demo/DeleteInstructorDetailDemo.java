package com.rex.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rex.demo.entity.Instructor;
import com.rex.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {			
	
			session.beginTransaction();
			int theId = 6;
			InstructorDetail tempInstructorDetail = 
					session.get(InstructorDetail.class, theId);
			
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
						
			// print  the associated instructor
			System.out.println("the associated instructor: " + 
								tempInstructorDetail.getInstructor());
			
			// now let's delete the instructor detail
			System.out.println("Deleting tempInstructorDetail: " 
											+ tempInstructorDetail);

			/*
			 * If you want delete only from InstructorDeatil table then
			 * 				@OneToOne(mappedBy = "instructorDetail",
			 *					cascade={CascadeType.DETACH, CascadeType.MERGE, 
			 *					CascadeType.PERSIST,
			 *					CascadeType.REFRESH})
			 * private Instructor instructor;
			 * 
			 *remove the associated object reference 
			 *break bi-directional link 
			 * 			tempInstructorDetail.getInstructor().setInstructorDetail(null); <<===In main class
			 */
			
			
			/*
			 * @OneToOne(mappedBy = "instructorDetail", cascade={CascadeType.ALL}) 
			 * private Instructor instructor;
			 * 
			 * it will also delete from Instructor table
			 */
			session.delete(tempInstructorDetail);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			
			factory.close();
		}
	}

}