<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.10.2023
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.javarush.quest.burcev.enums.Riddles" %>
<%@ page import="com.javarush.quest.burcev.enums.Movie" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Correct Answer Riddles</title>
    <style>
        <%@include file="/static/main.css"%>
    </style>
</head>
<body>
<% String answer;%>

<c:if test="${requestScope.query==Riddles.FIRST_RIDDLE}">
    <% answer = "girl";%>
    <hr>
    <div class="container">

        <p class="text-center">
            Он дал всем детям фальшивые семена,
            которые не прорастали, – эта маленькая девочка была единственной,
            кто не делал вид, что семя проросло
        </p>
        <div style="text-align: center;">
            <img style="" src="<c:url value='/images/king.jpg' />" width="700" height="300" alt="Король">
        </div>
    </div>
    <hr>
    <div class="button-container">
        <form action="riddle-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button1" type="submit">Продолжить</button>
        </form>

    </div>

</c:if>
<c:if test="${requestScope.query==Riddles.SECOND_RIDDLE}">
    <% answer = "water";%>
    <hr>
    <div class="container">

        <p class="text-center">
            На розовом кусте, в который была превращена его жена, не было ни
            капли ночной росы на листьях.
        </p>
        <div style="text-align: center;">
            <img style="" src="<c:url value='/images/water.jpg' />" width="700" height="300" alt="Вода">
        </div>
    </div>
    <hr>
    <div class="button-container">
        <form action="riddle-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button1" type="submit">Продолжить</button>
        </form>

    </div>

</c:if>
<c:if test="${requestScope.query==Riddles.THIRD_RIDDLE}">
    <% answer = "ice";%>
    <hr>
    <div class="container">

        <p class="text-center">
            И Дэйву, и Брэду давали напитки с отравленными кубиками льда. Брэд
            выпил свои напитки так быстро, что лед не успел растаять и выпустить яд.
        </p>
        <div style="text-align: center;">
            <img style="" src="<c:url value='/images/ise.jpg' />" width="700" height="300" alt="Лёд">
        </div>
    </div>
    <hr>
    <div class="button-container">
        <form action="riddle-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button1" type="submit">Продолжить</button>
        </form>

    </div>

</c:if>
<c:if test="${requestScope.query==Riddles.FOURTH_RIDDLE}">
    <% answer = "newspaper";%>
    <hr>
    <div class="container">

        <p class="text-center">
            Номера страниц газеты, когда они открыты, всегда четно-нечетны, например,
            2-3, 4-5 и т. д. Таким образом, полицейский отчет не может быть правдой,
            так как страницы 9 и 10 газеты не могут быть обращены друг к другу.
        </p>
        <div style="text-align: center;">
            <img style="" src="<c:url value='/images/newspaper.jpg' />" width="700" height="300" alt="Газета">
        </div>
    </div>
    <hr>
    <div class="button-container">
        <form action="riddle-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button1" type="submit">Продолжить</button>
        </form>

    </div>

</c:if>
<c:if test="${requestScope.query==Riddles.FIFTH_RIDDLE}">
    <% answer = "knife";%>
    <hr>
    <div class="container">
        <p class="text-center">
            Лукреция использовала нож, смазанный ядом только с одной стороны
            лезвия. Когда она разрезала яблоко пополам, отравленной оказалась
            лишь половина, предназначенная для жертвы.
        </p>
        <div style="text-align: center;">
            <img style="" src="<c:url value='/images/apple.jpg' />" width="700" height="300" alt="Яблоко">
        </div>
    </div>
    <hr>
    <div class="button-container">
        <form action="riddle-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button1" type="submit">Продолжить</button>
        </form>

    </div>
</c:if>

</body>
</html>
