package ru.regnums.core.generators;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import ru.regnums.core.bean.Register;
import ru.regnums.core.bean.SimpleNumericItem; 

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

public class SimpleNumericGenerator extends Generator {

	private static final String REGISTER_TABLE_NAME = "simple_numeric_gnr";
	private Register register = null;
	
	public SimpleNumericGenerator(Register reg)
	{
		setRegister(reg);
		createConnection();
	}
	
	@Override
	public List<String> getNextNumber(){
		return generateNextNum();
	}

	@Override
	public List<String> getCurrentNumber() {
		// TODO Auto-generated method stub
		String _sql_curr_value = "SELECT last_value FROM %s";
		List<String> res = null;
		try
		{
			List<SimpleNumericItem> gnr_list = getGeneratorsByRegisterId(this.register.getID());
			if(gnr_list.size() > 0){
				res = new ArrayList<String>();
				for(SimpleNumericItem item : gnr_list)
				{
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(String.format(_sql_curr_value, item.getSq_name()));
					if(rs.next()){
						res.add(rs.getString(1));
					}
					rs.close();
					st.close();
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * @param register the register to set
	 */
	public void setRegister(Register register) {
		this.register = register;
	}

	private List<String> generateNextNum()
	{
		List<String> res = null;
		
		if(this.register != null)
		{			
			try
			{
				List<SimpleNumericItem> gnr_list = getGeneratorsByRegisterId(this.register.getID());				
				if(gnr_list.size() > 0){
					res = nextNum(gnr_list);
				}else{
					//1. Созадаем sequence, потом записываем его имя в табличку
					//2. Вызываем следующее значение созданного sequence
					createSequence(register);
					res = nextNum(null);
				}				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return res;
	}

	private List<String> nextNum(List<SimpleNumericItem> gnr_list){
		List<String> res = new ArrayList<String>();
		String _sql_next_value = "SELECT NEXTVAL('%s')";
		List<SimpleNumericItem> _l = null;
		if(gnr_list != null){
			_l = gnr_list;
		}else{
			_l = getGeneratorsByRegisterId(this.register.getID());
		}
			
		for(SimpleNumericItem item : _l)
		{
			try
			{
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(String.format(_sql_next_value, item.getSq_name()));
				if(rs.next()){
					res.add(rs.getString(1));
				}
				rs.close();
				st.close();	
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return res;
	}
	
	private boolean createSequence(Register register){
		boolean res = false;
		String _sql_sq = "CREATE SEQUENCE %s INCREMENT BY 1 MINVALUE 1";
		String _sql_insert = "insert into "+REGISTER_TABLE_NAME+"(register_id, isactive, sq_name) values(?,?,?)";
		try
		{
			Calendar cl = Calendar.getInstance();
			String sq_name = "sq_"+this.register.getID()+"_"+
			                       cl.get(Calendar.YEAR)+
			                       cl.get(Calendar.MONTH)+
			                       cl.get(Calendar.DAY_OF_MONTH)+
			                       cl.get(Calendar.HOUR_OF_DAY)+
			                       cl.get(Calendar.MINUTE)+
			                       cl.get(Calendar.SECOND);
			Statement stmt = this.con.createStatement();
			if(stmt.executeUpdate(String.format(_sql_sq, sq_name)) != 1){
				PreparedStatement pst = this.con.prepareStatement(_sql_insert);
				pst.setInt(1, this.register.getID());
				pst.setBoolean(2, true);
				pst.setString(3, sq_name);
				pst.executeUpdate();
				pst.close();						
			}
			stmt.close();
			res = true;
		}catch(Exception e){
			res = false;
			e.printStackTrace();
		}
		return res;
	}
	
	private List<SimpleNumericItem> getGeneratorsByRegisterId(int register_id)
	{
		List<SimpleNumericItem> item_list = new ArrayList<SimpleNumericItem>();
		try
		{
			String _sql = "SELECT id, register_id,isactive,sq_name FROM "+REGISTER_TABLE_NAME+" WHERE register_id=? and isactive = true";
			PreparedStatement pst = this.con.prepareStatement(_sql);
			pst.setInt(1, register_id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				SimpleNumericItem n = new SimpleNumericItem();
				n.setID(rs.getInt(1));
				n.setREGISTER_ID(rs.getInt(2));
				n.setIsactive(rs.getBoolean(3));
				n.setSq_name(rs.getString(4));
				item_list.add(n);				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return item_list;
	}
	
	/**
	 * @return the register
	 */
	public Register getRegister() {
		return register;
	}
}
