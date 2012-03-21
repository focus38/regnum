package ru.regnums.core.bean;

public class SimpleNumericItem {
	
	private int ID = -1;
	private int REGISTER_ID;
	private boolean ISACTIVE = false;
	private String SQ_NAME;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getREGISTER_ID() {
		return REGISTER_ID;
	}
	public void setREGISTER_ID(int rEGISTER_ID) {
		REGISTER_ID = rEGISTER_ID;
	}
	public boolean isIsactive() {
		return ISACTIVE;
	}
	public void setIsactive(boolean isactive) {
		this.ISACTIVE = isactive;
	}
	public String getSq_name() {
		return SQ_NAME;
	}
	public void setSq_name(String sq_name) {
		this.SQ_NAME = sq_name;
	}	
}
