<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <p>信息输入成功，如下：</p>
    姓名 : ${ people.name } <br>
    年龄 : ${ people.age }
    性别 : ${ people.gender }
    爱好 : 
    <ul>
        <c:forEach var="hobby" items="${ people.hobbies }">
        <li>${ hobby }</li>
        </c:forEach>
    </ul>
    从：<c:forEach var="addr" items="${ people.from }"><span>${ addr }</span></c:forEach> 到：<span>${ people.to }</span>
</body>
</html>