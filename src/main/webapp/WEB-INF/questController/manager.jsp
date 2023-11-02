<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.10.2023
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.javarush.quest.burcev.enums.Manager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Manager</title>
    <style>
        <%@include file="/static/main.css"%>
    </style>
</head>
<body>
<% String riddle = "riddle";
    String movie = "movie";%>
<c:if test="${requestScope.query==Manager.START}">
<hr>
<div class="container">
    <h1 class="text-center">Загадки</h1>
    <p>
        Всё, что тебе нужно делать в этом квесте, это правильно дать ответ на загадку.
        Для начала выбери тип загадок, которые тебе больше нравятся.
        Есть обычные детективные загадки, в которых тебе просто нужно дать верный ответ.
        А есть загадки по фильмам. Тебе нужно по описанию угадать фильм.
        Выбирай!
    </p>
</div>
    <hr>
    <div class="button-container">
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= riddle%>">
            <button class="button button1" type="submit">Детективные загадки</button>
        </form>
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= movie%>">
            <button class="button button2" type="submit">Угадай фильм</button>
        </form>
    </div>
</c:if>

<c:if test="${requestScope.query == Manager.INCORRECT_ANSWER}">
<hr>
    <h1 class="text-center">Ответ неверный, попробуй ещё раз!</h1>
<div class="button-container">

    <%String back = "back";%>

    <form action="manager-servlet" method="post">
        <input type="hidden" name="answer" value="<%= back%>">
        <button class="button button3" type="submit">Вернуться</button>
    </form>
</div>
    <hr>
</c:if>
<c:if test="${requestScope.query==Manager.FINAL}">
    <hr>
    <div class="container">
        <h1>Молодец!!! Ты прошёл!!!</h1>
        <p>Взгляни на свои результаты:</p>
        <p>Верных ответов: ${sessionScope.correct_answer}</p>
        <p>Неверных ответов: ${sessionScope.incorrect_answer}</p>
        <p>Имя участника: ${sessionScope.name_of_user}</p>
    </div>

    <div class="button-container">

        <form action="greeting-servlet" method="post">
            <button class="button button3" type="submit">Начать сначала?</button>
        </form>
        <form action="manager-servlet" method="get">
            <button class="button button1" type="submit">Попробовать другой квест</button>
        </form>
    </div>
    <hr>
</c:if>
</body>

</html>
