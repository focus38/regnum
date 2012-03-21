package ru.regnums.core.generators;

import java.util.List;

/**
 * @author makarovad
 *
 */
public interface Generable {
	
	public String NAME = "";
	public String TITLE = "";
	
	public List<String> getNextNumber(); //Возвращает следующий номер
	public List<String> getCurrentNumber(); //Возвращает текущий номер
	
}
