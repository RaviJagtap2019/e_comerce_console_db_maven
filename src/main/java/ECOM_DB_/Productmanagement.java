package ECOM_DB_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Productmanagement {
	public static void main(String[] args) throws SQLException {
		System.out.println("\t \t <<...Welcome To E_COMERCE...>>");
		Scanner scan = new Scanner(System.in);
		
		String url="jdbc:mysql://127.0.0.1:3306/product_managment1";
		String username="root";
		String password="Ravi@2005";
		
		Connection connection=DriverManager.getConnection(url,username,password);
		Statement statement =connection.createStatement();
		
		while(true) {
			
		}
	}
}
