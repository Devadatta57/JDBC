package com.jdbcprepstat;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TransactionManagement {
	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement statement=null;
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Ponny@017");
			if(connection!=null) {
				connection.setAutoCommit(false);
				System.out.println("connected");
			}
			   
				System.out.println("enter name: ");
				String name=sc.next();
				System.out.println("enter age: ");
				int age=sc.nextInt();
			    statement=connection.prepareStatement("insert into employee values(?,?)");
			    statement.setString(1, name);
			    statement.setInt(2,age);
			   int i= statement.executeUpdate();
			if(i==1) {
			    connection.commit();
			}
			else{
				connection.rollback();
			}
			
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
