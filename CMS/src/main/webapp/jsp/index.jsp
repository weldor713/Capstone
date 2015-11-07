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
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <style>
            h1.serif {
                font-family: "Times New Roman", Times, serif;
            }
        </style>
    </head>
    <body>
<a href="${pageContext.request.contextPath}/createPosts">Click here, Emma!</a>
<br>
        <div class="container">
            <div class="jumbotron">
            <h1 class="serif">David's Blog<span class="glyphicon glyphicon-sunglasses"></span></h1>
            </div>
        </div>
            <div class ="container">
                <!-- display staticContentId -->

                <div  id="static">Static part goes here.ut perspiciatis unde omnis iste natus error sit voluptatem accusantium dolo
                    ut perspiciatis unde omnis iste natus error sit voluptatem accusantium dolo. ut perspiciatis unde 
                    omnis iste natus error sit voluptatem accusantium dolo. ut perspiciatis unde omnis iste natus error
                    sit voluptatem accusantium dolo.
                </div>
            
                <br>
            


            <div class="row">
                <div class="col-sm-2" style="background-color:lavenderblush;">
                    <p id="tag">Tags</p>
                    <p>Here</p>
                    <p>Tag 1</p>
               

                </div>
                <div class="container col-sm-10" style="background-color:lightgoldenrodyellow;">
                    <!--                <div class="col-sm-9 col-sm-offset-1" style="background-color:lightgoldenrodyellow;">-->
                    <div class="col-sm-12" style="background-color:lavenderblush;">
                        <div id="blogContent">
                        </div>
                        
                        
                <hr>
            </div>
            </div>
            </div>
            </div>
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/postDisplay.js"></script>

    </body>
</html>
