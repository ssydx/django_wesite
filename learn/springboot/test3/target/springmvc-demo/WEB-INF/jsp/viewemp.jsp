<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Employees List</h1>
    <table style="border: 2px solid black;" width="70%" cellpadding="2">
        <thead>
            <th>Id</th>
            <th>Name</th>
            <th>Age</th>
            <th>editemp</th>
            <th>deleteemp</th>
        </thead>
        <c:forEach var="emp" items="${ list }"> 
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.age}</td>
                <td><a href="editemp/${ emp.id }">Edit</a></td>
                <td><a href="deleteemp/${ emp.id }">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="empform">Add new Employee</a>
</body>
</html>