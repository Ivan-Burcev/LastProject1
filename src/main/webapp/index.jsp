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
    <title>Index</title>
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
    Начнём?
    </p>
</div>

<div class="button-container">
    <form action="greeting-servlet" method="GET">
        <button class="button button2" type="submit">Начать!</button>
    </form>

</div>
</body>
</html>
