package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
 
public class Demo2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Training","root","root");
//			Statement stmt=con.createStatement();
//			stmt.execute("insert into Employee values(100,'Thanesh',28,500000,'Developer')");
			PreparedStatement stmt= con.prepareStatement("insert into Employee values(?,?,?,?,?)");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter ID :");int id= sc.nextInt();
			System.out.println("Enter Name :");String name= sc.next();
			System.out.println("Enter Age :");int age= sc.nextInt();
			System.out.println("Enter Salary :");int salary= sc.nextInt();
			System.out.println("Enter Desig:");String desig= sc.next();
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setInt(3, age);
			stmt.setInt(4, salary);
			stmt.setString(5, desig);
			stmt.execute();
			stmt.close();con.close();
			System.out.println("Data Inserted....!");
			
		
		} catch (Exception e) {
			System.out.println(e);
		}
 
	}
 
}