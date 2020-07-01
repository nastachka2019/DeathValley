<%@ page import="com.devIncubator.task.dao.impl.AccountDaoImpl" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<h2>Accounts sum</h2>
<table border="2">
        <% AccountDaoImpl accountDao=new AccountDaoImpl();
            {%>
    <tr>
        <td><%=accountDao.findSumOfAccount()%>
        </td>

    </tr>
        <%}%>

</body>
</html>
