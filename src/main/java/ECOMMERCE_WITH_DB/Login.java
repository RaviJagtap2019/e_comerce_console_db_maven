package ECOMMERCE_WITH_DB;

import java.util.Scanner;

public class Login {
	
	public static void login() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println(" Welcome To Login Page ");
		
		System.out.println("\t Login");
		
		System.out.println("\t Enter User Name :");
		String username=scan.next();
		
		System.out.println("\t Enter Password :");
		String Pass=scan.next();
		
		if(username.equals("Jagtap")) {
			if(Pass.equals("Ravi")) {
			System.out.println("\t \t Welcome Login Succsessful\n");
			return;
			}
		}
		
		System.out.println(" Login Failed ...!");
		System.exit(0);
	}
}
