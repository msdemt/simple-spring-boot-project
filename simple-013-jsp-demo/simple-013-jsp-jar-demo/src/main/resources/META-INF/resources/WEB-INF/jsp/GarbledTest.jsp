<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>乱码测试</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/test2" method="get">
    <input type="text" name="name" value="你好">
    <input type="submit" value="request get 乱码测试"/>
</form>

<form action="<%=request.getContextPath()%>/test3" method="post">
    <input type="text" name="name" value="你好">
    <input type="submit" value="request post 乱码测试">
</form>

<form action="<%=request.getContextPath()%>/test6" method="post">
    <input type="text" name="name" value="你好">
    <input type="submit" value="request post 乱码测试">
</form>

</body>
</html>
