package ru.regnums.core.bean.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ru.regnums.db.BaseDAO;
import ru.regnums.core.bean.Register;
import ru.regnums.core.bean.Register;

public class RegisterDAO extends BaseDAO {
	
	public RegisterDAO(){
		this.createConnection();
	}
	
	public Register getRegisterById(int rid){
		String _sql_select  = "SELECT id, description, name, xml_config, createdon, modifiedon, account_id FROM register WHERE id=?";
		Register reg = null;
		try
		{
			PreparedStatement pst  = this.con.prepareStatement(_sql_select);
			pst.setInt(1, rid);
			ResultSet rs = pst.executeQuery();			
			if(rs.next()){
				reg = new Register();
				reg.setID(rs.getInt("id"));
				reg.setAccount_Id(rs.getInt("account_id"));
				reg.setName(rs.getString("name"));
				reg.setXml_config(rs.getString("xml_config"));
				reg.setDescription(rs.getString("description"));
				reg.setCreatedOn(rs.getTimestamp("createdon"));
				reg.setModifiedOn(rs.getTimestamp("modifiedon"));
			}
		}catch(Exception e){
			reg = null;
		}
		return reg;
	}	
}
