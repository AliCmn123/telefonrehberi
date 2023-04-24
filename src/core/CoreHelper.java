package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import interfaces.CoreInterfaces;

public class CoreHelper extends CoreFields implements CoreInterfaces{

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			 conn=DriverManager.getConnection(getUrl(),getUsername(),getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

	
	
}
