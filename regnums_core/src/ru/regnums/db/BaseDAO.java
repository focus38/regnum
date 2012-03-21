package ru.regnums.db;

import java.sql.Connection;
import ru.regnums.db.DBConnector;

public abstract class BaseDAO {
	
	protected Connection con = null;
	protected DBConnector db = null;
	
	public BaseDAO()
	{
		this.db = DBConnector.getInstance();		
	}
	
	public void createConnection(){
		this.con = this.db.getConnection();		
	}
	
	public void closeConnection()
	{
		try
		{
			this.con.close();	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
