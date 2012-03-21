package ru.regnums.core.bean.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ru.regnums.core.bean.Account;
import ru.regnums.db.BaseDAO;
import ru.regnums.db.Utils;

public class AccountDAO extends BaseDAO {
	
	public AccountDAO(){
		this.createConnection();
	}
	
	public Account createAccount(Account acc){
		Account res = null;
		String _sql_insert = "insert into account(name, email,pwd) values(?,?,?)";
		try
		{			
			PreparedStatement pst = this.con.prepareStatement(_sql_insert, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);					
			pst.setString(1, acc.getAccname());
			pst.setString(2, acc.getAccemail());
			pst.setString(3, acc.getAccpswd());
			pst.executeUpdate();
			int acc_id = Utils.lastInsertId(pst);
			res = acc;
			res.setID(acc_id);
		}catch(Exception e){
			e.printStackTrace();
			res = null;
		}
		
		return res;
	}
	
}
