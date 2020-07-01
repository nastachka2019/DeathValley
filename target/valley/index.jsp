<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hello!</title>
    <style type="text/css">
    .block{
        width: 200px;
        border: 1px solid black;
        display: inline-block;
    }
        .wrapper{
            display: flex;
            flex-direction: column;
        }
        .wrapper-block{
            margin-bottom: 20px;
        }

</style>
</head>
<body>

<h3>If you want begin work with database you should enter : </h3>

<h5>For returning all users enter:  localhost:8080/valley_war_exploded/userList</h5>

<h5>For returning all accounts enter:  localhost:8080/valley_war_exploded/accountList</h5>

<h5>Find user by id enter: localhost:8080/valley_war_exploded/user?id={id}</h5>


<div class="wrapper">
    <form action="accountSum.jsp">
 <div class="wrapper-block"> <div class="block">richest user</div> <button>get</button></div>
    </form>
    <div>
        <form action="theRichestUser.jsp">
        <div class="block">accounts sum</div> <button>get</button></div>
    </form>
</div>

</body>
</html>