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
        <title>AEGiS Content Management System</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
              rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon"
              href="${pageContext.request.contextPath}/img/icon.gif">
    </head>
    <body>
        <div class="container">
            <h1>AEGiS Content Management System</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/createPosts">Create Posts</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a>
                    </li>
                </ul>
            </div>
            <div>
                <h1>An error has occurred, you probably don't have permission to do what you wanted to do, maybe see David...</h1>
                <h3>${errorMessage}</h3>
            </div>
            <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
            <script src="${pageContext.request.contextPath}/js/jquery-
            1.11.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
        </div>
    </body>
</html>