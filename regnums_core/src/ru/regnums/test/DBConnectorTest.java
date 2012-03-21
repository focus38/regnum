package ru.regnums.test;

import ru.regnums.config.xml.NumberPartDocument.NumberPart;
import ru.regnums.config.xml.RegnumConfigDocument;
import ru.regnums.config.xml.RegnumConfigDocument.RegnumConfig;
import ru.regnums.config.xml.PartType;
import ru.regnums.core.bean.Register;
import ru.regnums.core.bean.dao.RegisterDAO;
import ru.regnums.core.generators.SimpleNumericGenerator;
import ru.regnums.db.DBConnector;

import java.awt.image.DataBufferDouble;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.apache.xmlbeans.XmlException;
import org.omg.CORBA.portable.InvokeHandler;

import java.lang.reflect.*;

public class DBConnectorTest {
	
	public static void main(String[] args) throws SQLException, InterruptedException {		
		
		DBConnector db = DBConnector.getInstance();
		RegisterDAO rdao = new RegisterDAO();
		Register reg = rdao.getRegisterById(3);
		RegnumConfigDocument doc;
		try {
			doc = RegnumConfigDocument.Factory.parse(reg.getXml_config());
			if(doc.getRegnumConfig() != null){
				RegnumConfig cfg = doc.getRegnumConfig();
				if(cfg.getNumberPartArray() != null){
					NumberPart[] num_part = cfg.getNumberPartArray();
					List<NumberPart> party_list = new ArrayList<NumberPart>();
					Collections.addAll(party_list, num_part);
					//Collections.sort(party_list);
					String complex_num = "";
					for(NumberPart part : num_part){
						if(part.getType() == PartType.CONSTANT_WORD ||
						   part.getType() == PartType.CONSTANT_NUMBER)
						{
							complex_num += part.getValue()+(part.getDelimiter()!=null?part.getDelimiter():"");
						}else{
							if(part.getClass1() != null){
								try
								{
									Class<?> generator_class = Class.forName(part.getClass1());								
									Method exe_m = generator_class.getMethod("getNextNumber", new Class[] { });
									Constructor<?> ct = generator_class.getConstructor(new Class[] { Class.forName("ru.regnums.core.bean.Register") });
									Object exe_object = ct.newInstance(new Object[] { reg });
									Object res_object = exe_m.invoke(exe_object, new Object[] { });
									List<String> g_items = (List<String>) res_object;
									for(String m: g_items){										
										complex_num +=m+(part.getDelimiter()!=null?part.getDelimiter():"");
									}
								}catch(Exception ce){
									ce.printStackTrace();
								}
							}
						}
					}
					System.out.println(complex_num);
				}
			}
		} catch (XmlException e) { 
			e.printStackTrace();
		}		
	}
}
