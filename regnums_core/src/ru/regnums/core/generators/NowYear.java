package ru.regnums.core.generators;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ru.regnums.core.bean.Register;

public class NowYear extends Generator {

	public NowYear(Register reg){
		
	}
	
	@Override
	public List<String> getNextNumber() {
		List<String> res = new ArrayList<String>();
		try{
			Calendar c = Calendar.getInstance();
			res.add(Integer.toString(c.get(Calendar.YEAR)));	
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<String> getCurrentNumber() {
		return getNextNumber();
	}

}
