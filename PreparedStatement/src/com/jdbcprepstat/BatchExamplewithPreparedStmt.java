package com.jdbcprepstat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchExamplewithPreparedStmt {
	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement stmt=null;
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Ponny@017");
			if(connection!=null) {
				System.out.println("connected");
			}
	  
	      String query="insert into employee values(?,?)";
	     stmt=connection.prepareStatement(query);
	      while(true) {
	    	  System.out.println("enter name");
	    	  String name=sc.next();
	    	  System.out.println("enter age");
	    	  int age=sc.nextInt();
	    	  stmt.setString(1, name);
	    	  stmt.setInt(2, age);
	    	  stmt.addBatch();
	    	  
	    	  System.out.println("enter choice");
	    	  String ch=sc.next();
	    	  if(ch.equals("no")) {
	    		  break;
	    	  }
        
	      }
	   
        stmt.executeBatch();
			   
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(stmt!=null) {
		     	try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
			

	}

	}
}
