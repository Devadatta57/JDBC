package com.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectionAndCreate {

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
         try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Ponny@017");
			if(connection!=null) {
				System.out.println("connected");
			}
			statement=connection.createStatement();
			statement.executeUpdate("create table employee(name varchar(50),age int(6))");
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("driver not found ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
         finally {
        	 try {
            	 if(statement!=null) {
            		 statement.close();
            	 }
            	 if(connection!=null) {
				    connection.close();
            	 }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 }
         }
         
	}

