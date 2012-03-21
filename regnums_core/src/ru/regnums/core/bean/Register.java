package ru.regnums.core.bean;

import java.util.Date;

public class Register {
	
	private int ID = -1;
	private String xml_config;
	private int account_id;
	private String Name;
	private String Description;
	private Date createdon;
	private Date modifiedon;
	
	public int getID() {
		return this.ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public String getXml_config() {
		return this.xml_config;
	}
	public void setXml_config(String _xml_config) {
		this.xml_config = _xml_config;
	}
	public int getAccount_Id() {
		return this.account_id;
	}
	public void setAccount_Id(int _account_id) {
		this.account_id = _account_id;
	}
	public String getName() {
		return this.Name;
	}
	public void setName(String _name) {
		this.Name = _name;
	}
	public Date getCreatedOn() {
		return this.createdon;
	}
	public void setCreatedOn(Date _createdon) {
		this.createdon = _createdon;
	}
	public Date getModifiedOn() {
		return this.modifiedon;
	}
	public void setModifiedOn(Date _modifiedon) {
		this.modifiedon = _modifiedon;
	}
	public void setDescription(String _description) {
		this.Description = _description;
	}
	public String getDescription() {
		return this.Description;
	}	
}
