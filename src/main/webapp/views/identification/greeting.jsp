<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 02.11.2023
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>
    <style><%@include file="/static/main.css"%>
    </style>
</head>
<body>
<div class="container">

    <h1 class="text-center">
       Но для начала надо идентифицироваться. Зарегестрируся или пройди аутентификацию.
    </h1>
</div>
<div class="button-container">
    <form action="registration-servlet" method="GET">
        <button class="button button2" type="submit">Регистрация</button>
    </form>
    <form action="authentication-servlet" method="GET">
        <button class="button button1" type="submit">Аутентификация</button>
    </form>
</div>
</body>
</html>
