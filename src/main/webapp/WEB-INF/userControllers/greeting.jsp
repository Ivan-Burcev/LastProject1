<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.10.2023
  Time: 15:29
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
    <h1 class="text-center">Добро пожаловать</h1>
    <p>
    Приветствую тебя. Сегодня ты сможешь пройти простой и интересный квест.
    Твоя задача выбрать верный ответ. Ты можешь выбрать один из квестов.
    Первый - детективные загадки. Во втором твоя задача угадать фильм по
    его описанию.
    Но для начала.....необходимо пройти регистрацию. Если ты зарегестрирован,
    то авторизируйся и выбирай понравившийся квест.
    </p>
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
