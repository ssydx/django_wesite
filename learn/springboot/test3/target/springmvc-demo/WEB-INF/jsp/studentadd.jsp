<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>增加学生</h1>
    <form:form action="studentview" modelAttribute="student">
        id: <form:input path="id" />
        <form:errors path="id"/>
        <br/>
        name: <form:input path="name"/>        
        <form:errors path="name"/>
        <br/>
        age: <form:input path="age"/>
        <form:errors path="age"/>
        <br/>
        score: <form:input path="score"/>
        <form:errors path="score"/>
        <br/>
        password: <form:input path="password"/>
        <form:errors path="password"/>
        <br/>
        <input type="submit" value="提交">
    </form:form>
</body>
</html>