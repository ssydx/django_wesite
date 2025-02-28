<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<p>Spring MVC目录页</p>
<a href="page1">点击跳转page1</a>
<a href="page2">点击跳转page2</a>
<form action="page3" method="post">
    <label for="username1">用户姓名</label>
    <input type="text" id="username1" name="username">
    <br>
    <label for="userpwd1">用户密码</label>
    <input type="password" id="userpwd1" name="userpwd">
    <br>
    <button type="submit">提交</button>
</form>
<form action="page4" method="post">
    <label for="username2">用户姓名</label>
    <input type="text" id="username2" name="username">
    <br>
    <label for="userpwd2">用户密码</label>
    <input type="password" id="userpwd2" name="userpwd">
    <br>
    <button type="submit">提交</button>
</form>
<a href="people/bookingForm">点击跳转People</a>
<a href="empform">Add Employee</a>
<a href="viewemp">View Employees</a>
<a href="viewempls/1">查看分页雇员列表</a>
<a href="uploadform">上传文件</a>
<a href="studentadd">增加学生</a>
</body>
</html>