package hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UDQueryDemo {
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

			int studentId = 1;

			// start a transaction
			session.beginTransaction();

			studentDemo theStudent = session.get(studentDemo.class, studentId);

			System.out.println(theStudent);


			// updating object

			System.out.println("updating student object");

			theStudent.setLastName("Dutt");





			// commit transaction

			session.getTransaction().commit();



			// update email transaction

			session = factory.getCurrentSession();
			session.beginTransaction();

			// update email
			System.out.println("update email");

			session.createQuery("update studentDemo set email='dutt@gmail.com'").executeUpdate();


			session.getTransaction().commit();





			System.out.println("DONE !!!!!");


		} finally {
			factory.close();
		}


	}
}
