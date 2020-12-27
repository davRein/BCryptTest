package de.dreinerts.bcrypt_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class CheckPassword {
	
	public void verification() {
		System.out.print("Name: ");
		Scanner s = new Scanner(System.in);
		String username = s.next();
		
		System.out.print("Pwd: ");
		String pwd = s.next();
		
		String hash = BCrypt.hashpw(pwd, BCrypt.gensalt(17));
		System.out.println(hash);
		
		boolean matched = BCrypt.checkpw(pwd, hash);
		System.out.println(matched);
	}
	
	private void db() {
		String url = "jdbc:mysql://82.165.185.245:3306/idis_ordertool";
		String username = "idisdb_admin";
		String password = "Id!sDB2020!";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("connected");
			
			
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
