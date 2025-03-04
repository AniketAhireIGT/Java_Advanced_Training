package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {
	
	public static void insertRecord(Connection con)
	{
		PreparedStatement pstmt = null;
		try {
			// load drivers
			
			// create statement
			pstmt = con.prepareStatement("INSERT INTO Employee VALUES (?,?,?,?,?)");
			
			// execute query
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Id : ");
			int id = sc.nextInt();
			System.out.println("Enter Name : ");
			String name = sc.next();
			System.out.println("Enter Age : ");
			int age = sc.nextInt();
			System.out.println("Enter Salary : ");
			int sal = sc.nextInt();
			System.out.println("Enter Designation : ");
			String desig = sc.next();
			
			pstmt.setInt(1, id);
			pstmt.setString(2,name);
			pstmt.setInt(3,age);
			pstmt.setInt(4,sal);
			pstmt.setString(5,desig);
			pstmt.executeUpdate();
			
			
			System.out.println("Record Inserted...");
		}
		catch(Exception se)
		{
			System.out.println(se);
		}
		finally {
			try {
				if(pstmt != null)
					pstmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void readRecord(Connection con)
	{	ResultSet rs = null;
		Statement pstmt = null;
		try {
			pstmt = con.createStatement();
			rs = pstmt.executeQuery("Select * from Employee");
			while(rs.next())
			{
			
				System.out.println("Id : "+rs.getInt(1)+", Name : "+rs.getString(2)+", Age : "+rs.getInt(3)+", Salary : "+rs.getInt(4)+", Designation : "+rs.getString(5));
				
			}
			
		}
		catch(Exception se)
		{
			System.out.println(se);
		}
		finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public static void updateRecord(Connection con, String colName, String val,int id)
	{	
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {		
			 stmt = con.createStatement();
			 rs = stmt.executeQuery("SELECT COUNT(*) FROM Employee");
		 if (rs.next() && rs.getInt(1) == 0) {
                System.out.println("Your Table is Empty");
                return; // Exit the method if the table is empty
            }
			String sql = "UPDATE Employee SET " + colName + " = ? WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			if(val instanceof String)
			{
				pstmt.setString(1,val);	
			}
			else {
				if(colName.equalsIgnoreCase(val))
				{
					pstmt.setInt(1, Integer.parseInt(val));
				}
			}
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			try {
				if(stmt != null)
					stmt.close();
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void deleteRecord(Connection con,int id)
	{
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM Employee");
			
			 if (rs.next() && rs.getInt(1) == 0) {
	                System.out.println("Your Table is Empty");
	                return; // Exit the method if the table is empty
	            }
			
			pstmt = con.prepareStatement("DELETE FROM Employee WHERE id = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			try {
				if(stmt != null)
					stmt.close();
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Training","root","root");
			System.out.println("Connection establised");
			Scanner sc = new Scanner(System.in);
			
			int op1 = 0,op = 0;
			while(op1 != 2)
			{
				System.out.println("----------------------------");
				System.out.println("1. Start Sql Connection");
				System.out.println("2. Exit");
				System.out.println("----------------------------");
				System.out.print("Enter option : ");
				op1 = sc.nextInt();
				
				
				if(op1 == 2)
					break;
				while(op != 5)
				{
					System.out.println("----------------------------");
					System.out.println("1. Insert");
					System.out.println("2. Read");
					System.out.println("3. Update");
					System.out.println("4. delete");
					System.out.println("5. exit");
					System.out.println("----------------------------");
					System.out.print("Enter option : ");
					op = sc.nextInt();
					
					switch(op)
					{
					case 1:{
						insertRecord(con);
						break;
					}
						
					case 2:{
						readRecord(con);
						break;
					}
					case 3:{
						System.out.println("Enter Column Name : ");
						String col = sc.next();
						System.out.println("Enter newValue : ");
						String val = sc.next();
						System.out.println("Enter the id : ");
						int id = sc.nextInt();
						updateRecord(con, col, val, id);
						break;
					}
					case 4:{
						System.out.println("Enter the id : ");
						int id = sc.nextInt();
						deleteRecord(con, id);
						break;
					}
					case 5:{
						if (con != null)	
							con.close();
						break;
					}
					
					}
				}
				
			}
			System.out.println("Thankyou....!");
			
		}
		catch(Exception se)
		{
			System.out.println(se);
		}
		finally {
			try {
				if (con != null)	
					con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
		
		
		
		
		
		
		
			
			
		
		
	}
}
