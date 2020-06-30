<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <%--jstl tag--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Users</title>
</head>
<body>
<h1 align="center">Users List</h1>

</br>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
    </tr>

    <c:forEach items="${list}" var="user">
        <tr>
            <td><c:out value="${user.userId}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.surname}"/></td>
        </tr>
    </c:forEach>

</table>

<h1 align="center">Find user by Id: </h1>

</br>
<form action="${param.id}" method="get">
    <input type="number" name="id" placeholder="enter user id">
    <input type="submit" value="Search">

</form>



</body>