<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.javarush.quest.burcev.enums.Movie" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Movie</title>
    <style>

        <%@include file="/static/main.css"%>

    </style>
</head>
<body>
<%String incorrect = "incorrect";%>
<% String answer;%>
<c:if test="${requestScope.title==Movie.FIRST_MOVIE}">
    <% answer = "terminator";%>
<hr>
<div class="container">
    <p>
        Безжалостный киборг-убийца из будущего путешествует в прошлое, чтобы уничтожить женщину,
    рождающую будущего спасителя человечества.
    </p>

</div>
    <hr>
    <div class="button-container">
        <form action="intermediate-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button1" type="submit">Терминатор</button>
        </form>
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button2" type="submit">Робокоп</button>
        </form>
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button3" type="submit">Хищник</button>
        </form>

    </div>
</c:if>
<c:if test="${requestScope.title==Movie.SECOND_MOVIE}">
    <% answer = "men_in_black";%>
<hr>
<div class="container">
    <p>
        Комедия о пришельцах, в которой замечательно показан процесс прохождения группового ассесмента
    и отбор лучшего кандидата, который будет защищать землян. И ещё на этой работе очень
    крутой дресс-код, по которому и был назван фильм.?
    </p>
</div>
    <hr>
    <div class="button-container">
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button1" type="submit">Хранители</button>
        </form>
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button2" type="submit">Звездный путь</button>
        </form>
        <form action="intermediate-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button3" type="submit">Люди в чёрном</button>
        </form>
    </div>
</c:if>
<c:if test="${requestScope.title==Movie.THIRD_MOVIE}">
    <% answer = "brother";%>
<hr>
<div class="container">
    <p>
        Ветеран войны направляется в город N, чтобы найти своего родственника. Вскоре он узнаёт,
    что родственник стал наёмным убийцей.?
    </p>
</div>
    <hr>
    <div class="button-container">
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button1" type="submit">Грязь</button>
        </form>
        <form action="intermediate-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button2" type="submit">Брат</button>
        </form>
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button3" type="submit">Однажды в Америке</button>
        </form>
    </div>
</c:if>
<c:if test="${requestScope.title==Movie.FOURTH_MOVIE}">
    <% answer = "matrix";%>
<hr>
<div class="container">
    <p>
        Люди вокруг – всего лишь источник питания для искусственного интеллекта, поработившего
    человечество, а весь мир – иллюзия.</p>
</div>
    <hr>

    <div class="button-container">
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button1" type="submit">Бегущий по лезвию</button>
        </form>
        <form action="intermediate-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button2" type="submit">Матрица</button>
        </form>
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button3" type="submit">Аватар</button>
        </form>
    </div>


</c:if>
<c:if test="${requestScope.title==Movie.FIFTH_MOVIE}">
    <% answer = "pulp_fiction";%>
<hr>
<div class="container">
    <p>В перерывах между криминальными разборками двое бандитов коротают время в философских беседах.</p>
</div>
    <hr>
    <div class="button-container">
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button1" type="submit">Бешеные псы</button>
        </form>
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button2" type="submit">Джеки Браун</button>
        </form>
        <form action="intermediate-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button3" type="submit">Криминальное чтиво</button>
        </form>
    </div>
</c:if>
</body>
</html>