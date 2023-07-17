<%--
  Created by IntelliJ IDEA.
  User: x-smit
  Date: 16.07.2023
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://xmlns.jcp.org/jsp/jstl/core" %>--%>

<html>
    <head>
        <title>pp_2.3.1 - Пользователи</title>
    </head>
    <body>
        <h2>ПОЛЬЗОВАТЕЛИ</h2>
        <br>
        <table border="1" style="border-collapse: collapse">
            <tr>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Возраст</th>
                <th>Операции</th>
            </tr>
            <c:forEach var="usr" items="${allUsers}">
                <c:url var="updateButton" value="/updateInfo">
                    <c:param name="usrId" value="${usr.id}"/>
                </c:url>
                <c:url var="deleteButton" value="/deleteUser">
                    <c:param name="usrId" value="${usr.id}"/>
                </c:url>
                <tr>
                    <td>${usr.name}</td>
                    <td>${usr.surname}</td>
                    <td align="right">${usr.age}</td>
                    <td align="center">
                        <input type="button" value="..." onclick="window.location.href = '${updateButton}'"/>
                        <input type="button" value="X" onclick="window.location.href = '${deleteButton}'"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <input type="button" value="+" onclick="window.location.href = 'addNewUser'"/>
    </body>
</html>
