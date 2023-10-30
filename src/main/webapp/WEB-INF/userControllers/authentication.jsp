<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.10.2023
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.javarush.quest.burcev.enums.Manager" %>
<html>
<head>
    <title>Authentication</title>
    <style>
        <%@include file="/static/main.css"%>
    </style>

</head>
<body>

<div class="form-inner">

    <form class="decor" action="authentication-servlet" method="post">
        <label for="name">Введите имя: </label>
        <input type="text" id="name" name="name">
        <br>
        <label  for="password">Введите пароль:</label>
        <input type="text" id="password" name="password">
        <br>
        <button class="button button2" type="submit">Отправить</button>
    </form>


</div>
<c:if test="${requestScope.incorrect==Manager.INCORRECT_ANSWER}">
    <div class="text-center">
        <p>
            Такого пользователя не существует!
        </p>
    </div>
</c:if>
</body>
</html>
