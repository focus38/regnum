<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ru.regnums.core.bean.Account"%>
<%@page import="ru.regnums.core.bean.dao.AccountDAO"%>
<jsp:useBean id="formHandler" class="ru.regnums.web.AccountFormBean" scope="request"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Регистрация нового пользователя</title>
    </head>
    <body>
<%
    String acc_id = formHandler.getId();
    if(acc_id.length() > 0){
		if(acc_id.equals("0")){
			//Регистрация новой записи
			String accname = formHandler.getAccname();
			String accemail = formHandler.getAccemail();
			String accpswd = formHandler.getAccpswd();
			
			Account acc = new Account();
			acc.setAccemail(accname);
			acc.setAccname(accemail);
			acc.setAccpswd(accpswd);
			AccountDAO dao = new AccountDAO();
			acc = dao.createAccount(acc);
			%>
			<p> Пользователь <%=acc.getAccname() %> с адресом электронной почтой <%=acc.getAccemail() %> создан </p>
			<%
		}else{
			//Уже зарегистрированный account
		}
	}
%>
    </body>
</html>
