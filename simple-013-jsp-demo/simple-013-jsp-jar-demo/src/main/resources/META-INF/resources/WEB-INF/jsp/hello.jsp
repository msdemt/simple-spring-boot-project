<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/test.js"></script>
</head>
<body>

<input id="testButton" type="button" value="hello" onclick="alertAjaxTest('GET', '/ajax/content')"/>

</body>
</html>
