<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/user/register/result" method="post">
    <input type="text" name="name">
    <input type="submit">
</form>

</body>
</html>
