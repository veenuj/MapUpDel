package hibernateDemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserDataDemo {
	
	public static void main(String[] args) {
		
		

		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(studentDemo.class)
									.buildSessionFactory();
		
	
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use session object to save Java object
			
			// create student object
			
			System.out.println("creating new student object");
			Scanner s = new Scanner(System.in);
			System.out.println("Enter the First Name:");
			String fName = s.nextLine();
			System.out.println("Enter the Last Name:");
			String lName = s.nextLine();
			System.out.println("Enter the e-mail id:");
			String eMail = s.nextLine();
			
			studentDemo tempStudent = new studentDemo(fName,lName,eMail);
			
		   s.close();
			
			
			// start a transaction
			session.beginTransaction();
			

			// save student object
			System.out.println("saving student object");
			session.save(tempStudent);
			
			// commit transaction
			
			session.getTransaction().commit();
			
			System.out.println("DONE !!!!!");
			
			
		} finally {
			factory.close();
		}
				

	}

}
