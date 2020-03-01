<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sebastian
  Date: 01/03/2020
  Time: 13.06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Huskeliste</title>
</head>
<body>

<h1>Velkommen til din webshoppen, du er klar til at tilføje til din indkøbskurv</h1>

${sessionScope.besked}

<form action="AddItemServlet" method="post">
    <label for="fname">Skriv vare:</label><br>
    <input type="text" id="fname" name="vareNavn"><br>
    <input type="submit" value="Tilføj">
</form>

<br>
<br>

${requestScope.besked}

<br>
<br>

<c:forEach var="element" items="${sessionScope.basket}">

    ${element}
    <br>

</c:forEach>

<br>
<br>

<form action="LogoutServlet" method="post">
    <input type="submit" value="Logout">
</form>

<br>
<br>

</body>
</html>
