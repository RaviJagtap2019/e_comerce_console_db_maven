package ECOMMERCE_WITH_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Product_Management {
	public static void Productmanagement() throws SQLException {
		Scanner scan=new Scanner(System.in);
		System.out.println("\t Welcome To Ecomerce Product Management \n");
		String url="jdbc:mysql://127.0.0.1:3306/product_management";
		String username="root";
		String password="Ravi@2005";
		
		Connection connection=DriverManager.getConnection(url,username,password);
		
		Statement statement=connection.createStatement();
		
		while(true) {
			   	
			  	System.out.println("What Would you like To Do Today:");
				System.out.println("1.Add Product:");
				System.out.println("2.Search Product:");
				System.out.println("3.Update Product:");
				System.out.println("4.Delete Product:");
				System.out.println("5.Print Product:");
				System.out.println("9.Exit:");
				
				int choice=scan.nextInt();	
				
				if(choice==1) {
					System.out.println("\t Let's Add Product\n");
					
					System.out.println("Enter Product Id :");
					String id=scan.next();
					
					System.out.println("Enter Product Name :");
					String productname=scan.next();
					
					System.out.println("Enter Product Price :");
					String productprice=scan.next();
					
					System.out.println("Enter Product Quantity :");
					String productquantity=scan.next();
					
					String query="INSERT INTO `product_management`.`product`\n"
							+"(product_id,productname,productprice,productquantity)\n"
							+"VALUES('"+id+"','"+productname+"','"+productprice+"','"+productquantity+"')";
					statement.execute(query);
					
					System.out.println("\t Product Added Sucssesfully \n");
				}else if(choice==2) {
					System.out.println("\t Searching Product\n");
					System.out.println("Enter Product Name to search:");
					String search=scan.next();
					
					String query="SELECT * FROM product_management.product where productname='"+search+"';";
					ResultSet result=statement.executeQuery(query);
					while(result.next()) {
						for(int i=1; i<5; i++) {
							System.out.println(result.getString(i));
						}
					}
					  
		   }   //else if(choice==3) {
//			  		System.out.println("\t Let's Update Product\n");
//			  		
//			  		System.out.println("Enter Product Name To Update:");
//			  		String update=scan.next();
//			  		
//			
//					System.out.println("Enter New Product New Id :");
//					String id=scan.next();
//				
//					System.out.println("Enter New  Product Name To Update :");
//					String newname=scan.next();
//		
//					System.out.println("Enter New Product Price To Update :");
//					String newprice=scan.next();
//				
//					System.out.println("Enter New Product Quantity to Update :");
//					String newquantity=scan.next();
//				
//					String query="INSERT INTO `product_management`.`product`\n"
//                                    +"(product_id,productname,productprice,productquantity)\n"
//                                     +"VALUES('"+id+"','"+newname+"','"+newprice+"','"+newquantity+"')";
//				statement.execute(query);
//		}
				else if(choice==4) {
					System.out.println("\t Removing Product...!!");
					System.out.println("Enter Product Name To Delete :");
					String remove=scan.next();
					
					String query ="DELETE from product_management.product WHERE productname='"+remove+"';";
					statement.execute(query);
					
					System.out.println("\t Product Deleted ..!");
				}else if(choice==5) {
					System.out.println("\t Presenting Product Deteils :");
					
					String query="SELECT * from product_management.product";
					ResultSet result=statement.executeQuery(query);
					while(result.next()) {
						for(int i=1;i<5;i++) {
							System.out.println(result.getString(i));
						}
					}
					System.out.println("\t Product Details Presented");
					
				}else if(choice==9) {
					System.out.println("EXITING THE APPLICATION...!!!");
					connection.close();
					return;
					
				}else {
					System.out.println("Invalid Choice Selected ");
				}
			 	
		}
	}
}

