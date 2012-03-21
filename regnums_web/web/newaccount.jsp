<%@ page import="java.util.*" %>

<%!
    ResourceBundle bundle =null;
    public void jspInit()
    {
        //bundle = ResourceBundle.getBundle("forms", Locale.);
    }
%>

<jsp:useBean id="formHandler" class="ru.regnums.web.AccountFormBean" scope="request">
<jsp:setProperty name="formHandler" property="*"/>
</jsp:useBean>

<%
if (formHandler.validate())
{
%>
<jsp:forward page="addaccount.jsp" />
<%
}  else {
%>
<jsp:forward page="newaccount.html" />
<%
}
%>