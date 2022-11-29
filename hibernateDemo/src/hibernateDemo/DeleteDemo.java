package hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

	
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

			int studentId = 2;

			// start a transaction
			session.beginTransaction();

			studentDemo theStudent = session.get(studentDemo.class, studentId);
			
			System.out.println(theStudent);
			
			
			// updating object
			
			System.out.println("delete student object");
			
			//session.delete(theStudent);
			
			session.createQuery("delete from studentDemo where id = 2").executeUpdate();
			
		
			// commit transaction

			session.getTransaction().commit();
			
		





			System.out.println("DONE !!!!!");


		} finally {
			factory.close();
		}


	}
}
