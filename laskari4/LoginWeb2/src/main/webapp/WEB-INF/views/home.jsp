<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ohtu App | home</title>
    </head>
    <body>
        <h1>Ohtu App</h1>

        <ul>
            <li><a href=<c:url value="/login" />>login</a></li>
            <li><a href=<c:url value="/user" />>register new user</a></li>

        </ul>
    </body>
</html>
