package ru.regnums.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
//
import javax.naming.Context;
import javax.naming.InitialContext;

public class DBConnector
{
	
	private static DBConnector instance;	
	private static DataSource ds = null;
	
	private DBConnector() {
		ds = setupDataSource();
	}
	
	public Connection getConnection(){		
		if(ds != null){
			try{
				return ds.getConnection();	
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}else{
			return null;
		}
	}
		
	private static DataSource setupDataSource()
	{
		try
		{
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("jdbc/regnums");
		}catch(Exception e){
			e.printStackTrace();	
		}
		return ds;
	}
	
	public static DataSource getDataSource(){		
		if(ds != null){
			return ds;
		}else{
			return null;
		}
	}		
	
	public static DBConnector getInstance(){
		if(instance == null){
			instance = new DBConnector();
		}
		return instance;
	}
}