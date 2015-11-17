
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AEGiS Content Management System</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.gif">
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
                        <tbody id="userTable"></tbody>
                    </table>
                </div>

                <div class="col-md-6">
                    <br>
                    <br>


                    <!--
                    <form method="POST" action="addUser">
                        Username: <input type="text" name="username"/><br/>
                        Password:&nbsp; <input type="password" name="password"/><br/>
                        Admin User? <input type="checkbox" name="isAdmin" value="yes"/>
                        <br/>
                        <input type="submit" value="Add User"/><br/>
                    </form>

                    -->


                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-publicname" class="col-md-4 control-label">
                                Public Name:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-publicname" placeholder="Name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-username" class="col-md-4 control-label">
                                User Name:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-username" placeholder="Display Name"/>
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
                            <label for="add-authority" class="col-md-4 control-label">
                                Authority:
                            </label>
                            <div class="col-md-8">
                                <select class="form-control" id="add-authority">
                                    <option>ROLE_ADMIN</option>
                                    <option>ROLE_USER</option>
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

        <!--Edit modal-->
        <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="detailsModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="detailsModalLabel">Edit  Dvd</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="edit-publicname" class="col-md-4 control-label">
                                    Name:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-publicname" placeholder="Name">
                                </div> </div>
                            <div class="form-group">
                                <label for="edit-username" class="col-md-4 control-label">
                                    User Name:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-username" placeholder="User Name">
                                </div> </div>
                            <div class="form-group">
                                <label for="edit-authority" class="col-md-4 control-label">
                                    Authority:
                                </label>
                                <div class="col-md-8">
                                    <select class="form-control" id="edit-authority">
                                        <option>ROLE_ADMIN</option>
                                        <option>ROLE_USER</option>
                                    </select>
                                </div> 
                            </div>
                            <div class="form-group">
                                <label for="edit-password" class="col-md-4 control-label">
                                    Password:
                                </label>
                                <div class="col-md-8">
                                    <input type="password" class="form-control" id="edit-password" placeholder="Password">
                                </div> 
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                    <button type="submit" id="edit-button" class="btn btn-default">
                                        Edit User
                                    </button>
                                    <button type="button" class="btn btn-default"
                                            data-dismiss="modal">
                                        Cancel
                                    </button>
                                    <input type="hidden" id="edit-user-id">
                                </div> 
                            </div>
                        </form> 
                        <div id="validationEditErrors" style="color: tomato"></div>
                    </div>
                </div> 
            </div>
        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/userManager.js"></script>
    </body>
</html>
