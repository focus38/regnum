package ru.regnums.core.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author makarovad
 */

public class RegNum {

	/*
	 * Номер "документа"
	 */
	private String document_number = "";
	/*
	 * Дата "документа"
	 */
	private String document_date = "";
	
	public RegNum(String doc_num, String doc_date)
	{
		setDocumentNumber(doc_num);
		setDocumentDate(doc_date);
	}

	/**
	 * @param document_number the document_number to set
	 */
	public void setDocumentNumber(String document_number) {
		this.document_number = document_number;
	}

	/**
	 * @return the document_number
	 */
	public String getDocumentNumber() {
		return document_number;
	}

	/**
	 * @param document_date the document_date to set
	 */
	public void setDocumentDate(String document_date) {
		this.document_date = document_date;
	}

	/**
	 * @return the document_date
	 */
	public String getDocumentDate() {
		return document_date;
	}
	
	public Date getDocumentDate(boolean return_date){
		Date return_value = null;
		if(return_date){
			if(document_date != null){
				try{
					DateFormat sdf = new SimpleDateFormat();
					return_value = sdf.parse(this.document_date);
				}catch(Exception e){
					
				}
			}
		}		
		return return_value;
	}
}
