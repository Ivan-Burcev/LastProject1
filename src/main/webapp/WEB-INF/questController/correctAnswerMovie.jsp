<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.10.2023
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.javarush.quest.burcev.enums.Riddles" %>
<%@ page import="com.javarush.quest.burcev.enums.Movie" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Correct Answer Movies</title>
    <style>
        <%@include file="/static/main.css"%>
    </style>
</head>
<body>
<% String answer;%>
<c:if test="${requestScope.query==Movie.FIRST_MOVIE}">
    <% answer = "terminator";%>
    <hr>
    <div class="container">
        <p class="text-center">
            «Термина́тор» (англ. The Terminator) — американский научно-фантастический фильм 1984 года режиссёра Джеймса Кэмерона.
            В центре сюжета — противостояние солдата и робота-терминатора, прибывших в 1984 год из постапокалиптического
            2029 года. Цель терминатора: убить Сару Коннор — девушку, чей ещё нерождённый сын в возможном будущем выиграет
            войну человечества с машинами. Влюблённый в Сару солдат Кайл Риз пытается помешать терминатору. В фильме
            поднимаются проблемы путешествий во времени, судьбы, создания искусственного интеллекта, поведения людей в
            экстремальных ситуациях.
        </p>
        <div style="text-align: center;">
            <img style="" src="<c:url value='/images/terminator_poster.jpg' />" width="450" height="700" alt="Терминатор">
        </div>
    </div>
    <hr>
    <div class="button-container">
        <form action="movie-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button1" type="submit">Продолжить</button>
        </form>

    </div>
</c:if>
<c:if test="${requestScope.query==Movie.SECOND_MOVIE}">
    <% answer = "men_in_black";%>
    <hr>
    <div class="container">
        <p class="text-center">
            «Люди в чёрном» (англ. Men in Black) — американский научно-фантастический комедийный боевик 1997
            года режиссёра Барри Зонненфельда, основанный на одноименной серии комиксов[en] издательства Marvel Comics и
            повествует о деятельности двух сотрудников секретного надправительственного агентства «Люди в чёрном»,
            контролирующего пребывание инопланетных пришельцев на Земле. В главных ролях снялись Уилл Смит и Томми
            Ли Джонс. Фильм получил премию «Оскар» за лучший грим.
        <div style="text-align: center;">
            <img style="" src="<c:url value='/images/Men_in_Black_Poster.jpg' />" width="450" height="700" alt="Люди в чёрном">
        </div>
        </p>
    </div>
    <hr>
    <div class="button-container">
        <form action="movie-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button1" type="submit">Продолжить</button>
        </form>

    </div>
</c:if>
<c:if test="${requestScope.query==Movie.THIRD_MOVIE}">
    <% answer = "brother";%>
    <hr>
    <div class="container">
        <p class="text-center">
            «Брат» — российская криминальная драма режиссёра и автора сценария Алексея Балабанова.
            Первая часть дилогии (вторая — «Брат 2») о герое 1990-х годов Даниле Багрове, роль
            которого сыграл Сергей Бодров-младший.
            Балабанов и Бодров получили гран-при фестиваля «Кинотавр» (1997) как лучший режиссёр
            и лучший актёр соответственно. Фильм включён в список «100 главных русских фильмов» по
            версии журнала «Афиша».
        </p>

        <div style="text-align: center;">
            <img style="" src="<c:url value='/images/brother.jpg' />" width="450" height="700" alt="Брат">
        </div>

    </div>
    <hr>
    <div class="button-container">
        <form action="movie-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button1" type="submit">Продолжить</button>
        </form>

    </div>
</c:if>
<c:if test="${requestScope.query==Movie.FOURTH_MOVIE}">
    <% answer = "matrix";%>
    <hr>
    <div class="container">
        <p class="text-center">
            «Матрица» (англ. The Matrix) — научно-фантастический боевик, поставленный братьями Вачовски по
            собственному сценарию и спродюсированный Джоэлом Сильвером. Главные роли исполнили Киану Ривз,
            Лоренс Фишберн, Керри-Энн Мосс и Хьюго УивингПерейти к разделу «#Актёрский состав». Фильм вышел на
            экраны США 31 марта 1999 года и послужил созданию одноимённой медиафраншизы, в которую вошли ещё три
            фильма, комиксы, компьютерные игры и аниме
        </p>
        <div style="text-align: center;">
            <img style="" src="<c:url value='/images/matrix.jpg' />" width="450" height="700" alt="Матрица">
        </div>
    </div>
    <hr>
    <div class="button-container">
        <form action="movie-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button1" type="submit">Продолжить</button>
        </form>
    </div>
</c:if>
<c:if test="${requestScope.query==Movie.FIFTH_MOVIE}">
    <% answer = "pulp_fiction";%>
    <hr>
    <div class="container">
        <p class="text-center">
            «Кримина́льное чти́во» (англ. Pulp Fiction — «Бульварное чтиво») — культовый кинофильм
            режиссёра Квентина Тарантино. Сюжет фильма нелинеен, как и почти во всех остальных
            работах Тарантино. Этот приём стал чрезвычайно популярен, породив множество подражаний
            во второй половине 1990-х. В фильме рассказывается несколько историй, в которых показаны
            ограбление кафе, философские дискуссии двух гангстеров, спасение девушки от передозировки
            героином и боксёр, которого задели за живое. Название является отсылкой к популярным в
            середине XX века в США pulp-журналам. Именно в стиле таких журналов были оформлены афиши,
            а позднее саундтрек, видеокассеты и DVD с фильмом.
        </p>
        <div style="text-align: center;">
            <img style="" src="<c:url value='/images/pulp_fiction.jpg' />" width="450" height="700" alt="Криминальное чтиво">
        </div>
    </div>
    <hr>
    <div class="button-container">
        <form action="movie-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button1" type="submit">Продолжить</button>
        </form>

    </div>
</c:if>
</body>
</html>
