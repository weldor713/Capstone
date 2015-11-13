<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>David's blog</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.gif">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/homestyle.css">
    </head>
    <body  style='background-color:#b3ffd9'>
        <a href="${pageContext.request.contextPath}/createPosts">Click here, Emma!</a>
        <br>
        <div class="container">
            <!--<div id="grad1"></div>-->
            <div class="jumbotron"  id="grad1">
                <h1 class="serif">David's Blog</h1>
            </div>
        </div>
        <div class ="container">
            <div  id="static"></div>

            <br>

            <div class="row">
                <div id="tagContainer" class="col-sm-2">
                    <div id="tagDisplay"></div>


                </div>
                <div class="container col-sm-10" >
                    <!--                <div class="col-sm-9 col-sm-offset-1" style="background-color:lightgoldenrodyellow;">-->
                    <div class="col-sm-12">
                        <div id="blogContent">
                        </div>


                        <hr>
                    </div>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/postDisplay.js"></script>
        <script src="${pageContext.request.contextPath}/js/staticContentManager.js"></script>

    </body>
</html>
