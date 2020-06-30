<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <%--jstl tag--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Users</title>
</head>
<body>

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
<%--FORM TO SELECT BOOK BY ID--%>
<form action="books.do" method="get">
    <input type="number" name="id" placeholder="введите номер книги">
    <input type="submit" value="Найти">
    <input name="action" value="findById" hidden="hidden">
</form>



</body>