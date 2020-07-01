<%@ page import="com.devIncubator.task.dao.impl.AccountDaoImpl" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<h2>Accounts sum</h2>
<form method='post'>
    <table border = "2">
            <% AccountDaoImpl accountDao=new AccountDaoImpl();
            {%>
        <tr>
            <td><%=accountDao.findSumOfAccount()%></td>

        </tr>
            <%}%>
</form>
</body>
</html>