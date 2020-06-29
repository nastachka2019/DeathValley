<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Users</title>
    <meta charset="utf-8">

</head>
<body>
<h1 align="center">Users</h1>

</br>
</br>

<button>
    <a href="users?allusers">Show all users</a>
</button>


<form action="users" method="get">
    <input type="number" name="id" placeholder="Enter id of user">
    <input type="submit" value="Search">
    <input name="action" value="findById" hidden="hidden">
</form>

<br/>
<%--<c:out value="${exception}"/>--%>


<div class="table_users">
    <table>

        <thead class="title_table">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>surname</th>
        </tr>
        </thead>

        <c:forEach items="${user}" var="user">
            <tr>
                <td align="center">${user.userId}</td>
                <td align="center">${user.name}</td>
                <td align="center">${user.surname}</td>
            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>
