<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AEGiS Content Management System</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <script type="text/javascript" src="${pageContext.request.contextPath}/tinymce/tinymce.min.js"></script>
        <script type="text/javascript">
            tinymce.init({
                selector: "#staticContent"         <!--mytextarea-->
            });
        </script>

    </head>
    <body>
        <div class="container">
            <h1>Manage Static Content</h1>
            <hr/>
            <div class="nav bar"> 
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/createPosts">Create Posts</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/postMan">Manage Posts</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/userMan">Manage Users</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/staticMan">Manage Static Area</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="container"> 
            <hr>
            <h2>Static Area Management</h2>
        </div>
        <div class="container">
            <!--<form role="form">-->
            <div class="form-group">
                <label for="comment">Enter Static Content:</label>
                <form>
           
                    <!--<form method="post"--> 
                          <!--onsubmit="tempHome.jsp">-->
                    <textarea id="staticContent"></textarea>           <!--mytextarea-->

                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>

                </form>


                <!--<textarea class="form-control" rows="5" id="comment"></textarea>-->
            </div>

            <!--</form>-->
        </div>


        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
