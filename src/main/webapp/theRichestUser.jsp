<%@ page import="com.devIncubator.task.dao.impl.AccountDaoImpl" %>
<%@ page import="com.devIncubator.task.dao.impl.UserDaoImpl" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<h2>Information about the richest user: </h2>
<table border="2">
<% AccountDaoImpl accountDao = new AccountDaoImpl();
    UserDaoImpl userDao = new UserDaoImpl();
    {%>
<tr>
    <td>userId=<%=accountDao.findTheRichestUser()%>
    </td>
    <br><br>

    <td>Information about this user: <%=userDao.findById(accountDao.findTheRichestUser())%>
    </td>
</tr>

<%}%>

</body>
</html>