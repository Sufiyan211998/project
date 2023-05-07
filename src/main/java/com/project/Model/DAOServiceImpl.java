package com.project.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {
private Connection con;
private Statement stmnt;
	@Override
	public void ConnectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hussain","root","8660045454");
		  stmnt = con.createStatement();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean VerifyCredentials(String username, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email ='"+username+"'and password ='"+password+"'");
			return result.next();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveregistration(String name, String city, String email, String mobile) {
		try {
			 stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet listAll() {
		try {
			ResultSet result = stmnt.executeQuery("select * from registration");
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteregistration(String email) {
		try {
			 stmnt.executeUpdate("delete from registration where email ='"+email+"'");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateregistration(String email, String mobile) {
		try {
			 stmnt.executeUpdate("update registration set email ='"+email+"' where mobile ='"+mobile+"'");
		      
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}



}
