<%--
  Created by IntelliJ IDEA.
  User: sonbig
  Date: 3/19/21
  Time: 8:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
          crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expandmd navbar-dark">
        <div>
            <a href="">User Management App</a>
        </div>
        <ul class="navbar-nav">
            <li>
                <a href="<%=request.getContextPath()%>/list">User</a>
            </li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div card-body>
            <c:if test="${user != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${user == null}">
                    <form action="insert" method="post">
                        </c:if>
                            <caption>
                                <h2>
                                    <c:if test="${user != null}">
                                        Edit User
                                    </c:if>
                                    <c:if test="${user == null}">
                                        Add New User
                                    </c:if>
                                </h2>
                            </caption>

                        <c:if test="${user != null}">
                            <input type="hidden" name="id" value="<c:out value="${user.id}"/>" />
                        </c:if>
                            <fieldset class="form-group">
                                <lavel>User Name</lavel>
                                <input type="text" value="<c:out value="${user.name}"/>"
                                       class="form-control" name="name" required="required">
                            </fieldset>
                            <fieldset class="form-group">
                                <lavel>User Email</lavel>
                                <input type="text" value="<c:out value="${user.email}"/>"
                                       class="form-control" name="email">
                            </fieldset>
                            <fieldset class="form-group">
                                <lavel>User Country</lavel>
                                <input type="text" value="<c:out value="${user.country}"/>"
                                       class="form-control" name="country">
                            </fieldset>
                        <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>
