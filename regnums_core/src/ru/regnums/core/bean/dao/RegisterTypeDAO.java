package ru.regnums.core.bean.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ru.regnums.core.bean.RegisterType;
import ru.regnums.db.BaseDAO;

public class RegisterTypeDAO extends BaseDAO {
    
    private static String GET_ENTITY = "SELECT id, title, generator_class FROM register_type WHERE id=?";
    private static String GET_ENTITY_LIST = "SELECT id, title, generator_class FROM register_type";
    
    public RegisterTypeDAO(){
        this.createConnection();
    }

    /**
     * Возвращает список объектов RegisterType
     * @return 
     */
    public List<RegisterType> getRegisterTypeList(){        
        List<RegisterType> res = null;
        try{
            Statement st = this.con.createStatement();            
            ResultSet rs = st.executeQuery(GET_ENTITY_LIST);
            res = new ArrayList<RegisterType>();            
            while(rs.next()){
                RegisterType rt = new RegisterType();
                rt.setID(rs.getInt("id"));
                rt.setTitle(rs.getString("title"));
                rt.setGenerator_class(rs.getString("generator_class"));                
                res.add(rt);
            }
            rs.close();
            st.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }
    
    /**
     * Возвращает объект RegisterType по его коду
     * @param entity_id - код
     * @return RegisterType
     */
    public RegisterType getRegisterType(int entity_id){
        RegisterType rt = null;
        try{
            PreparedStatement pst = this.con.prepareStatement(GET_ENTITY);
            pst.setInt(1, entity_id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                rt = new RegisterType();
                rt.setID(rs.getInt("id"));
                rt.setTitle(rs.getString("title"));
                rt.setGenerator_class(rs.getString("generator_class"));
                rs.close();
                pst.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return rt;
    }
}
