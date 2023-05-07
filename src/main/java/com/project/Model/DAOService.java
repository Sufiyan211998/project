package com.project.Model;

import java.sql.ResultSet;

public interface DAOService {
public void ConnectDB();
public boolean VerifyCredentials(String username,String password);
public void saveregistration(String name, String city, String email, String mobile);
public ResultSet listAll();
public void deleteregistration(String email);
public void updateregistration(String email, String mobile);
}
