<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AEGiS Content Management System</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">
            <h1>Manage Posts</h1>
            <hr/>
            <div class="nav bar"> 
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/createPosts">Create Posts</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/postMan">Manage Posts</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/userMan">Manage Users</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/staticMan">Manage Static Area</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
        
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>