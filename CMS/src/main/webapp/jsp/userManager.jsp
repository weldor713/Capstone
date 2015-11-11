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
            <h1>Manage Users</h1>
            <hr/>
            <div class="nav bar"> 
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/createPosts">Create Posts</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/postMan">Manage Posts</a>
                    </li>
                    <li role="presentation" class="active">
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
                <div class="col-md-6">
                    <br>
                    <br>
                    <table id="addressTable" class="table table-hover">
                        <tr>
                            <th width="35%">User Name</th>
                            <th width="35%">Role</th>
                            <th width="15%"></th>
                            <th width="15%"></th>
                        </tr>
                        <tbody id="tableContent"></tbody>
                    </table>
                </div>

                <div class="col-md-6">
                    <br>
                    <br>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-userName" class="col-md-4 control-label">
                                Login Name:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-userName" placeholder="Login Name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-displayName" class="col-md-4 control-label">
                                Display Name:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-displayName" placeholder="Display Name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-password" class="col-md-4 control-label">
                                Password:
                            </label>
                            <div class="col-md-8">
                                <input type="password" class="form-control"
                                       id="add-password" placeholder="Password"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-street" class="col-md-4 control-label">
                                Role:
                            </label>
                            <div class="col-md-8">
                                <select class="form-control" id="add-role">
                                    <option>1</option>
                                    <option>2</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" id="add-button" class="btn btn-default">
                                    Create User
                                </button>
                            </div>
                        </div>
                    </form>
                    <div id="validationErrors" style="color: tomato"></div>
                </div>
            </div>         
        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
