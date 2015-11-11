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
        <style>
            h1.serif {
                font-family: "Times New Roman", Times, serif;
                text-shadow: 2px 2px #C0C0C0;
                color:#5f97bf;
            }

            #grad1 {
                height: 200px;
                background: -webkit-linear-gradient(left, Gainsboro , Navy); /* For Safari 5.1 to 6.0 */
                background: -o-linear-gradient(right, Gainsboro, Navy); /* For Opera 11.1 to 12.0 */
                background: -moz-linear-gradient(right, Gainsboro, Navy); /* For Firefox 3.6 to 15 */
                background: linear-gradient(to right, Gainsboro, Navy); /* Standard syntax (must be last) */
            }
        </style>
    </head>
    <body  style='background-color:teal'>
        <a href="${pageContext.request.contextPath}/createPosts">Click here, Emma!</a>
        <br>
        <div class="container">
            <!--<div id="grad1"></div>-->
            <div class="jumbotron"  id="grad1">
                <h1 class="serif">David's Blog</h1>
            </div>
        </div>
        <div class ="container">

            <div  id="static" style='background-color:silver'></div>

            <br>



            <div class="row">
                <div class="col-sm-2" style="background-color:lavenderblush;">
                    <div id="tagDisplay"></div>


                </div>
                <div class="container col-sm-10" >
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
        <script src="${pageContext.request.contextPath}/js/staticContentManager.js"></script>

    </body>
</html>
