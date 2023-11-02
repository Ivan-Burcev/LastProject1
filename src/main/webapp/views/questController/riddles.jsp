<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.javarush.quest.burcev.enums.Riddles" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Riddles</title>
    <style>
        <%@include file="/static/main.css"%>
    </style>
</head>
<body>


<%String incorrect = "incorrect";%>
<% String answer;%>

<c:if test="${requestScope.title==Riddles.FIRST_RIDDLE}">
    <% answer = "girl";%>
    <hr>
    <div class="container">

        <p class="text-center">
            Король, у которого нет королевы, сыновей или дочерей, решает найти способ выбрать
            преемника. Он дает всем детям в королевстве по одному семени и говорит, что тот, у
            кого будет самое большое и красивое растение, унаследует его трон. Когда наступает
            назначенный день, все дети дарят гигантские растения. Выделились трое:
            маленькая девочка с пустым горшком, большой и сильный мальчик с персиковым деревом
            на котором почти не осталось персиков, худощавый подросток с красивейшей розой.
            Кого он выбрал?
        </p>

    </div>
    <hr>
    <div class="button-container">
        <form action="intermediate-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button1" type="submit"> Девочка с пустым горшком</button>
        </form>
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button2" type="submit">Мальчик с персиковым деревом</button>
        </form>
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button3" type="submit">Подросток с розой</button>
        </form>
    </div>

</c:if>
<c:if test="${requestScope.title==Riddles.SECOND_RIDDLE}">
    <% answer = "water";%>
    <hr>
    <div class="container">
        <p>
            Давным-давно злая ведьма похитила трех замужних женщин и превратила их в кусты
            роз. Одна из женщин, у которой были дети, умоляла ведьму дать ей повидаться с ее
            семьей, и ведьма согласилась. Она отвезла женщину к ней домой и на следующее утро
            снова превратила ее в розовый куст. Ведьма и не подозревала, что муж решил
            выследить ее, потому что хотел спасти свою жену. Он посмотрел на три одинаковых куста,
            и вдруг понял, который из них его жена. Как?
        </p>
    </div>
    <hr>
    <div class="button-container">
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button1" type="submit">Дело в цвете</button>
        </form>
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button2" type="submit">Ошибка ведьмы</button>
        </form>
        <form action="intermediate-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button3" type="submit">Всё дело в листьях</button>
        </form>
    </div>
</c:if>
<c:if test="${requestScope.title==Riddles.THIRD_RIDDLE}">
    <% answer = "ice";%>
    <hr>
    <div class="container">
        <p>
            Дэйв и Брэд, два популярных политика, встретились в клубе, чтобы обсудить
            свержение лидера своей партии. Каждый из них заказал по водке со льдом. Брэд осушил
            свой стакан и заказал еще. Затем он залпом выпил вторую порцию и решил подождать,
            прежде чем заказать третью. Тем временем Дэйв, который потягивал свой напиток,
            внезапно упал замертво. Обоих мужчин собирались убить. Почему Дэйв умер, а Брэд
            остался жив?
        </p>
    </div>
    <hr>
    <div class="button-container">
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button1" type="submit">Водка - лучшее противоядие</button>
        </form>
        <form action="intermediate-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button2" type="submit">Всё дело во льду</button>
        </form>
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button3" type="submit">Противоядие во второй рюмке</button>
        </form>
    </div>
</c:if>
<c:if test="${requestScope.title==Riddles.FOURTH_RIDDLE}">
    <% answer = "newspaper";%>
    <hr>
    <div class="container">
        <p>
            В одной деревне произошло убийство. Сотрудник полиции поручил двум полицейским
            констеблям выехать на место преступления, провести расследование и подготовить
            предварительный отчет о происшествии. Было уже за полночь, а место преступления
            находилось далеко от полицейского участка. Двое констеблей решили не выезжать на
            место преступления и вместо этого составили фальшивый отчет о происшествии. Ниже
            приведен отчет:
            «Когда мы добрались до места, дверь была открыта, и один мужчина в возрасте от 40 до
            45 лет был найден лежащим мертвым на полу. Свет и вентилятор были включены. На
            столе были найдены некоторые предметы:
            – одна открытая бутылка с ядом,
            – одна наполовину заполненная бутылка с питьевой водой,
            – одна перьевая ручка,
            – одна газета была раскрыта, страницы 9 и 10 обращены друг к другу,
            – один настольный календарь с изображением 20 июня,
            – одна тетрадь.
            Человек покончил жизнь самоубийством, выпив яд».
            Прочитав отчет о происшествии, полицейский сразу понял, что это фейк. Как он узнал?
        </p>
    </div>
    <hr>
    <div class="button-container">
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button1" type="submit">Зачем вторая бутылка</button>
        </form>
        <form action="intermediate-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button2" type="submit">Странная газетёнка</button>
        </form>
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button3" type="submit">Тетрадь?</button>
        </form>
    </div>
</c:if>
<c:if test="${requestScope.title==Riddles.FIFTH_RIDDLE}">
    <% answer = "knife";%>
    <hr>
    <div class="container">
        <p>
            Лукреция Борджиа пригласила предполагаемую жертву на обед. Они съели сытный
            обед из жареной оленины со свежими овощами, запив все лучшим вином, привезенным
            из Бордо во Франции. После трапезы они ели свежесобранный инжир и
            виноград. «Осталось всего одно яблоко, – сказала Лукреция, – я настаиваю, чтобы оно
            было у вас». «Нет, – сказал гость, – я не могу». Тогда Лукреция быстро разрезала его
            пополам острым ножом. Гость и Лукреция начали есть свои половинки, как вдруг глаза
            гостя закатились к потолку, и он повалился навзничь замертво. «Еще одна жертва
            успешно уничтожена», – подумала Лукреция
            Почему Лукреция не отравилась после того, как съела яблоко?
        </p>
    </div>
    <hr>
    <div class="button-container">
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button1" type="submit">Противоядие было у лукреции</button>
        </form>
        <form action="manager-servlet" method="post">
            <input type="hidden" name="answer" value="<%= incorrect%>">
            <button class="button button2" type="submit">А точно дело не в вине?</button>
        </form>
        <form action="intermediate-servlet" method="post">
            <input type="hidden" name="answer" value="<%= answer%>">
            <button class="button button3" type="submit">Причина в ноже</button>
        </form>
    </div>
</c:if>


</body>
</html>