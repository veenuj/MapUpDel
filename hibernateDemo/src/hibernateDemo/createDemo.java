package hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class createDemo {

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
			studentDemo tempStudent = new studentDemo( "Suresh","Raina", "suresh@gmail.com");
			
			
			
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


