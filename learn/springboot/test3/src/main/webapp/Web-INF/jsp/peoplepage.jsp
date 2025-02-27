<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <!-- 表单内容绑定到模型people上 -->
    <form:form action="submitForm" modelAttribute="people">
        <!-- 姓名绑定到name属性 -->
        姓名: <form:input path="name" />      
        <br/>
        <!-- 年龄绑定到age属性 -->
        年龄: <form:input type="number" path="age" min="18" max="60" step="1"/>
        <br/>
        <form:radiobutton path="gender" value="male"/> 男
        <form:radiobutton path="gender" value="female"/> 女
        <br/>
        <form:checkbox path="hobbies" value="music" /> 音乐
        <form:checkbox path="hobbies" value="manga" /> 漫画
        <form:checkbox path="hobbies" value="novel" /> 小说
        <form:checkbox path="hobbies" value="sport" /> 运动
        <br/>
        从：
        <form:select multiple="true" path="from">
            <form:option label="驻马店" value="zhumadian" />
            <form:option label="漯河" value="luohe" />
            <form:option label="周口" value="zhoukou" />
        </form:select>
        到：
        <form:select path="to">
            <form:option label="北京" value="beijing" />
            <form:option label="上海" value="shanghai" />
            <form:option label="广州" value="guangzhou" />
        </form:select>
        <br/>
        <button type="submit">提交</button> 
    </form:form>
</body>
</html>