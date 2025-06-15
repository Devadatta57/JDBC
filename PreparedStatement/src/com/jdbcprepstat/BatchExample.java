package com.jdbcprepstat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchExample {
	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Ponny@017");
			if(connection!=null) {
				System.out.println("connected");
			}
	    statement=connection.createStatement();
	      statement.addBatch("insert into employee values('java',45)");
	      statement.addBatch("insert into employee values('python',45)");
	      statement.addBatch("insert into employee values('goat',45)");
        statement.executeBatch();
			   
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(statement!=null) {
		     	try {
					statement.close();
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
