package ru.regnums.web;

import java.util.Hashtable;

/**
 *
 * @author Makarov Aleksey e-mail: alexd.makarov@gmail.com
 * @crate on Feb 24, 2012
 */
public class AccountFormBean
{
    String accname;
    String accemail;
    String accpswd;
    String id;
    
    private Hashtable errors;
    
    public AccountFormBean()
    {
        accname = "";
        accemail = "";
        accpswd = "";
        id = "0";
        errors = new Hashtable();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getAccemail() {
        return accemail;
    }

    public void setAccemail(String accemail) {
        this.accemail = accemail;
    }

    public String getAccname() {
        return accname;
    }

    public void setAccname(String accname) {
        this.accname = accname;
    }

    public String getAccpswd() {
        return accpswd;
    }

    public void setAccpswd(String accpswd) {
        this.accpswd = accpswd;
    }
    
    public boolean validate()
    {
        boolean isok = true;
        if(this.accname.equals(""))
        {
            errors.put("accname", "Имя (название организации) должно быть указано.");
            accname = "";
            isok = false;
        }
        if(this.accemail.equals(""))
        {
            errors.put("accemail", "Email, должен быть указан. Будет использоваться дальше, как имя пользователя для доступа.");
            accemail = "";
            isok = false;
        }
        if(this.accpswd.equals(""))
        {
            errors.put("accpswd", "Пароль нужен. Куда без него в наше время.");
            accpswd = "";
            isok = false;
        }
        return isok;
    }
    
    public String getErrorMsg(String s)
    {
        String errorMsg =(String)errors.get(s.trim());
        return (errorMsg == null) ? "":errorMsg;
    }
    
}
