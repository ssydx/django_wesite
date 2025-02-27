<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
        <h1>Add new Employee</h1>
        <form:form method="POST" action="save" modelAttribute="emp">
            Name : <form:input path="name"  />
            Age : <form:input path="age"  />
            <input type="submit" value="保存" />
        </form:form>