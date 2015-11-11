<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AEGiS Content Management System</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/js/jquery-ui.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">
            <h1>Create Post</h1>
            <hr/>
            <div class="nav bar"> 
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/createPosts">Create Posts</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/postMan">Manage Posts</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/userMan">Manage Users</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/staticMan">Manage Static Area</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">View Blog</a>
                    </li>
                    
                    
                    
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a>
                    </li>
                </ul>
            </div>

            <div class="row">
                <br>
                <div class="col-md-6">
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-title" class="col-md-4 control-label">
                                Title:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-title" placeholder="Title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-postDate" class="col-md-4 control-label">
                                Post Date:
                            </label>
                            <div class="col-md-8">
                                <input type="test" class="form-control"
                                       id="add-postDate" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-expiration" class="col-md-4 control-label">
                                Expiration Date:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-expiration" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="bodytextarea" class="col-md-4 control-label">
                                Body:
                            </label>
                            <div class="col-md-8">
                                <input type="textarea"class="form-control"
                                       id="bodytextarea" placeholder="Body"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-tags" class="col-md-4 control-label">
                                Tags:
                            </label>
                            <div class="col-md-8">
                                <input type="text"class="form-control"
                                       id="add-tags" placeholder="Tags"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" id="add-post-button" class="btn btn-default">
                                    Add Post
                                </button>
                            </div>
                        </div>
                    </form>
                </div> 
            </div>

        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/createposts.js"></script>
    </body>
</html>

