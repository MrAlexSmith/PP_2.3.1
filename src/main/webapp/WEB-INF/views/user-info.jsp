<%--
  Created by IntelliJ IDEA.
  User: x-smit
  Date: 16.07.2023
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
      <title>pp_2.3.1 - Пользователь</title>
  </head>
  <body>
    <h2>ИНФОРМАЦИЯ О ПОЛЬЗОВАТЕЛЕ</h2>
    <form:form action="saveUser" modelAttribute="user">
      <form:hidden path="id"/>
      Имя: <form:input path="name"/>
      <br><br>
      Фамилия: <form:input path="surname"/>
      <br><br>
      Возраст: <form:input path="age"/>
      <br><br>
      <input type="submit" value="OK"/>
    </form:form>
  </body>
</html>
