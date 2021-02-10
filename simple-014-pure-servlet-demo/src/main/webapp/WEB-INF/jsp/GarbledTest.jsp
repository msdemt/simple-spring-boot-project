<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>乱码测试</title>

    <script type="text/javascript" src="<%=request.getContextPath()%>/js/test.js"></script>
</head>
<body>

<form action="<%=request.getContextPath()%>/test" method="post">
    <input type="text" name="name" value="你好">
    <input type="submit" value="request post 乱码测试"/>
</form>

</body>
</html>
