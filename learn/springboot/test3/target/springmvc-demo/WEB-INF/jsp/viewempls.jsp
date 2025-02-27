<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>雇员列表</h1>
    <ul>
        <c:forEach var="emp" items="${ empls }">
            <li><span>${ emp.id }</span> <span>${ emp.name }</span> <span>${ emp.age }</span></li>
        </c:forEach>
    </ul>
    <a href="2">查看第二页</a>
</body>
</html>