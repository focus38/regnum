<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/regnums.css" />
    	<title>RegNums - регистрационные номера</title>
  </head>
  <body>
  	<shiro:authenticated>  		
  		<p><a href="logout">Выход</a>
  	</shiro:authenticated>
        <form id="loginform" name="loginform" action="login" method="post">
            <table>
                <tr>
                    <td>Имя пользователя</td>
                    <td><input class="rinput" type="text" maxlength="100" value="" name="username" /></td>
                </tr>
                <tr>
                    <td>Пароль</td>
                    <td><input class="rinput" type="password" maxlength="200" value="" name="password"/></td>
                </tr>
                <tr>
                    <td><div></div></tr>
                    <td><div></div></tr>
                </tr>
                <tr>
                    <td align="left">
                        <a href="newaccount.html" class="submit_button">Регистрация</a>
                    </td>
                    <td align="right">
                        <a href="#" class="submit_button" onclick="document.loginform.submit();">Вход</a>
                    </td>
                </tr>
            </table>
            <!-- <input type="submit" value="Вход" /><br/> -->
        </form>        
  </body>
</html> 
