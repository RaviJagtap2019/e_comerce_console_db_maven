package ECOMMERCE_WITH_DB;

import java.sql.SQLException;
import java.util.Scanner;

public class Ecom_Main {
	public static void main(String[] args) throws SQLException {
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("\t \t << Lets's Begin E_COMERCE Project>>\n");
		
		Login.login();
		
		while(true) {
			System.out.println("Which Type OF Project You Will Have To Do Today..??\n");
			System.out.println("1.User Management::>");
			System.out.println("2.Product Management::>");
			System.out.println("3.Exit::>");
			
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				User_Management.usermanagement();
				break;
				
			case 2:
				Product_Management.Productmanagement();
				break;
			
			case 3:
				System.out.println("Exiting Project...!!!");
				return;
				
			}
		}
	}
}
