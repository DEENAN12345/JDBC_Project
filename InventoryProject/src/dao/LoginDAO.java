package dao;

import java.sql.*;

import connectionManager.ConnectionManager;
import model.Login;
public class LoginDAO 
{
	public boolean validate(Login login) throws ClassNotFoundException, SQLException
	{
		String username = login.getUsername();
		String password = login.getPassword();
		
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		//Statement class
		Statement st = con.createStatement();
		
		//ResultSet class
		ResultSet rs=st.executeQuery("select * from Login");
		
		while(rs.next())
		{
		if(username.equals(rs.getString("username")) && password.equals(rs.getString("password")))
		{
			conm.closeConnection();
			return true;
		}
		}
			conm.closeConnection();
			return false;
	}
}
