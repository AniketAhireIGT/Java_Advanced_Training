package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
 
public class Demo1 {
 
	public static void main(String[] args) {
//		5 steps : 1) Load the driver 
//				   2) COREATE THE CONNECTION TO DB 
//					3 ) Crerate the statment 
//					4 execute 
//					5 close 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded....!");
			
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Training","root", "root");
			Statement stmt=con.createStatement();
			
			stmt.execute("insert into Employee values(100,'Thanesh',28,500000,'Developer')");
			stmt.close();con.close();
			System.out.println("Data Inserted....!");
		} catch (Exception e) {
			System.out.println(e);
		}
 
	}
 
}