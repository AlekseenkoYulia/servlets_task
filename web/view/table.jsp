<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: Yulia_Alekseenko
  Date: 9/18/2018
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Locales</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>

<table class="table">
    <caption>Locales</caption>
    <tr>
        <th>Locale</th>
        <th>Name</th>
    </tr>
    <%
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            out.println("<tr><td>" + locale + "</td>");
            out.println("<td>" + locale.getDisplayName() + "</td></tr>");
        }
    %>
</table>

</body>
</html>
