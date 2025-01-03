package ECOMMERCE_WITH_DB;

import java.sql.Connection;   
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class User_Management {

	public static void  usermanagement()throws SQLException {
		Scanner scan=new Scanner(System.in);
		System.out.println("\t \t <<<<< Welcome To Ecomerce User Management>>>> \n");
		String url="jdbc:mysql://127.0.0.1:3306/user_management";
		String username="root";
		String password="Ravi@2005";
		
		Connection connection=DriverManager.getConnection(url,username,password);
		
		Statement statement=connection.createStatement();
		
		while(true) {
			   	
			  	System.out.println("...!! What Would you like To Do Today>>>!:\n");
				System.out.println("1.Add User:");
				System.out.println("2.Search User:");
				System.out.println("3.Update User:");
				System.out.println("4.Delete User:");
				System.out.println("5.Print User:");
				System.out.println("9.Exit:");
				
				int choice=scan.nextInt();	
				
				if(choice==1) {
					System.out.println("\t Let's Add User\n");
					
					System.out.println("Enter User Id :");
					String id=scan.next();
					 
					System.out.println("Enter User  Name :");
					String Username=scan.next();
					
					System.out.println("Enter User Email Id :");
					String userEmail=scan.next();
					
					System.out.println("Enter User Passward :");
					String userPass=scan.next();
					
					System.out.println("Enter User Comfirm Passward :");
					String userConfirmPass=scan.next();
					
					String query="INSERT INTO `user_management`.`user`\n"
							+"(user_id,user_name,user_email,user_password,user_comfirmpassword)\n"
							+"VALUES('"+id+"','"+Username+"','"+userEmail+"','"+userPass+"','"+userConfirmPass+"')";
					statement.execute(query);
					
					System.out.println("\t User Added Sucssesfully \n");
				}else if(choice==2) {
					System.out.println("\t Searching User \n");
					System.out.println("User Name to search:");
					String search=scan.next();
					
					String query="SELECT * FROM user_management.user where user_name='"+search+"';";
					ResultSet result=statement.executeQuery(query);
					while(result.next()) {
						for(int i=1; i<5; i++) {
							System.out.println(result.getString(i));
						}
					}
					  
			       	}    else if(choice==4) {
					System.out.println("\t Removing User...!!");
					System.out.println("Enter User Name To Delete :");
					String remove=scan.next();
					
					String query ="DELETE from user_management.user WHERE user_name='"+remove+"';";
					statement.execute(query);
					
					System.out.println("\t User Deleted ..!");
				}else if(choice==5) {
					System.out.println("\t Presenting User Deteils :");
					
					String query="SELECT * from user_management.user";
					ResultSet result=statement.executeQuery(query);
					while(result.next()) {
						for(int i=1;i<5;i++) {
							System.out.println(result.getString(i));
						}
					}
					System.out.println("\t User Details Presented");
					
				}else if(choice==9) {
					System.out.println("Exiting The Application...!!!\n");
					connection.close();
					return;
					
				}else {
					System.out.println("Invalid Choice Selected ");
				}
			 	
		}
	}

}
