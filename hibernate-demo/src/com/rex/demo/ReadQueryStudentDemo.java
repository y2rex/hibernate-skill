package com.rex.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rex.demo.entity.Student;

public class ReadQueryStudentDemo {

	public static void main(String[] args) {

				SessionFactory factory=new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				
				Session session=factory.getCurrentSession();
				
				try {
					session.beginTransaction();
					List<Student> list=session.createQuery("from Student").list();
					show(list);
			/*
			 * for(Student st : list) System.out.println(st);
			 */
					
					System.out.println("\n\n");
					
					list=session.createQuery("from Student where lastName='jax'").list();
					show(list);
				     
					System.out.println("\n\n");	
			
			  list=session.createQuery("from Student where lastName like '_a%'").list();
			  show(list);

			  System.out.println("\n\n");			
			  list=session.createQuery("from Student where id=1").list();
			  show(list);
			  
			  System.out.println("\n\n");
			  int a=1;
			  list=session.createQuery("from Student where id="+a).list();
			  show(list);
					
					
				
					session.getTransaction().commit();
				}
				finally {
					factory.close();
				}


	}

	   private static void show(List<Student> list) {

		   for(Student st : list)
			   System.out.println(st);
		
	}

}
