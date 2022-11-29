package hibernateDemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class testJDBC {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&allowPublicKeyRetrieval=true";
		String user ="admin";
		String pass ="admin";
		try {
			System.out.println("Connecting to database" +jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("connection sucessfull"+myConn);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
