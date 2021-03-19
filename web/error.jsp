<%--
  Created by IntelliJ IDEA.
  User: sonbig
  Date: 3/19/21
  Time: 8:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isErrorPage="true" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error page</title>
</head>
<body>
    <h1>Error</h1>
    <h2><%=exception.getMessage()%><br></h2>
</body>
</html>
