<%-- 
    Document   : customError
    Created on : Nov 10, 2015, 10:57:31 AM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>AEGiS ERROR</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
              rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/error.css"
              rel="stylesheet">
        <link rel="shortcut icon"
              href="${pageContext.request.contextPath}/img/icon.gif">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/homestyle.css">
    </head>
    <body>
        <div class="container">
            <h1>ERROR</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/createPosts">Create Posts</a>
                    </li>
                    <li role="presentation">
                        <a style="color: black" href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a>
                    </li>
                </ul>
            </div>
            <div>
                <h3>${errorMessage}</h3>

            </div>

            <footer class="bot">
                <p>copyright&copy 2015 AEGiS All Rights Reserved</p>
            </footer>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
