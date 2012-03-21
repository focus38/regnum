<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ru.regnums.core.bean.RegisterType"%>
<%@page import="ru.regnums.core.bean.dao.RegisterTypeDAO" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/regnums.css" />
        <script lang="javascript" type="text/javascript" src="js/regnums.js.js" ></script>
        <title>Добавление новго реестра номеров</title>
    </head>
    <%
        RegisterTypeDAO rtdao = new RegisterTypeDAO();
        List<RegisterType> regtype_list = rtdao.getRegisterTypeList();
    %>
    <body>        
        <table id="reg_table">
            <tr>
                <!-- <td><img src="img/add2.png" alt="Добавить элемент номера" onclick="addGeneratorElement()"/></td> -->
                <td><a href="#" class="submit_button"></a></td>
            </tr>
            <tr>
                <td>Тип генератора</td>
                <td>
                    <select class="rinput" name="gentype1" onchange="onSelectRegisterType(event)">
                        <option value="-1" title="Укажите тип генератора">Укажите тип генератора</option>
                        <%
                        for(RegisterType rt : regtype_list){
                            %>
                            <option id="gentype1_<%=rt.getID() %>" value="<%=rt.getID() %>" title="<%=rt.getTitle() %>"><%=rt.getTitle() %></option>
                            <%
                        }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Разделитель</td>
                <td><input id="delimiter1" name="delimiter1" class="rinput" /></td>
            </tr>
            <div id="td_constvalue1" style="visibility: false">
                <tr>
                    <td>Постоянное значение</td>
                    <td><input id="constvalue1" name="constvalue1" class="rinput" /></td>
                </tr>
            </div>
            <tr>
                <td>
                    <div id="divMsg"></div>
                </td>
            </tr>
        </table>
    </body>
</html>
