<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
        <h1>Edit Employee</h1>
       <form:form method="POST" action="editsave" modelAttribute="emp">
            Id   : <form:input path="id" readonly="true"/>
            Name : <form:input path="name"  />
            Age  : <form:input path="age"  />
            <button type="submit">修改</button>
       </form:form>