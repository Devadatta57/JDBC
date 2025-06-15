package com.jdbcprepstat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class ResultSetMetadata {
	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement statement=null;
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Ponny@017");
			if(connection!=null) {
				System.out.println("connected");
			}
			    statement=connection.prepareStatement("select * from employee");
			    
			   ResultSet set= statement.executeQuery();
			   ResultSetMetaData metadata=set.getMetaData();
			  for(int i=1;i<=metadata.getColumnCount();i++) {
			   System.out.println(metadata.getColumnName(i)+" "+metadata.getColumnTypeName(i));
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
