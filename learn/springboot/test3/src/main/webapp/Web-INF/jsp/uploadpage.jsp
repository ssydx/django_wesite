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
    <h1>文件上传</h1>
    <h3 style="color:red">${filesuccess}</h3>
    <form:form method="post" action="savefile" enctype="multipart/form-data" accept-charset="UTF-8">
        <p><label for="image">Choose Image</label></p>
        <p><input name="file" id="fileToUpload" type="file" /></p>
        <p><input type="submit" value="Upload"></p>
    </form:form>
</body>
</html>