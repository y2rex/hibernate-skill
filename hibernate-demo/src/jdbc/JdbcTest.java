package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {

	public static void main(String[] args) {

		/*
		 * String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		 * 
		 * ==>>optional and this is new feature which is introduced in mysql-8  "?useSSL=false"  
		 * */
		
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker";
		
		String user="hbstudent";
		String pass="hbstudent";
		
		try {
			System.out.println("Contecting...");
			Connection com=DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println(com);
			System.out.println();
			System.out.println("Conntected successfully....");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
