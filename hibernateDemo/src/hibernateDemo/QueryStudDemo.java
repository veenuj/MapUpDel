package hibernateDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudDemo {

public static void main(String[] args) {
		
		
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(studentDemo.class)
									.buildSessionFactory();
		
	
		// create session
		Session session = factory.getCurrentSession();
		
		try {
	
			
			// start a transaction
			session.beginTransaction();
			

		
			// query students
			
			List<studentDemo> students = session.createQuery("from studentDemo s where s.lastName='Raina1'").list();
		
			
			// display students
			
			
			for(studentDemo tStudent: students) {
				System.out.println(tStudent);
			}

			
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("DONE !!!!!");
			
			
		} finally {
			factory.close();
		}
				

	}
	
}
