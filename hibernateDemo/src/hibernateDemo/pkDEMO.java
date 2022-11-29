package hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class pkDEMO {

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
		studentDemo tempStudent1 = new studentDemo("Sachin","T", "sachin@gmail.com");
		studentDemo tempStudent2 = new studentDemo("Saurav","G", "saurav@gmail.com");
		studentDemo tempStudent3 = new studentDemo("Rahul","D", "rahul@gmail.com");



		// start a transaction
		session.beginTransaction();


		// save student object
		System.out.println("saving student object");
		session.save(tempStudent1);
		session.save(tempStudent2);
		session.save(tempStudent3);

		// commit transaction

		session.getTransaction().commit();

		System.out.println("DONE !!!!!");


	} 
		finally {
			factory.close();
		}


	
	}
}

