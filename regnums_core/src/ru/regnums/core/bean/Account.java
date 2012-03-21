package ru.regnums.core.bean;

public class Account {

	private int ID = 0;
	private String accname;
	private String accemail;
	private String accpswd;
	
	public void setID(int iD) {
		ID = iD;
	}
	public int getID() {
		return ID;
	}
	public void setAccname(String accname) {
		this.accname = accname;
	}
	public String getAccname() {
		return accname;
	}
	public void setAccemail(String accemail) {
		this.accemail = accemail;
	}
	public String getAccemail() {
		return accemail;
	}
	public void setAccpswd(String accpswd) {
		this.accpswd = accpswd;
	}
	public String getAccpswd() {
		return accpswd;
	}
	
}
