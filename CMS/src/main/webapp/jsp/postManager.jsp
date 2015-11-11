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
            <div class="row">

                <div class="col-md-9">
                    <h2>Blog Posts</h2>
                    <table id="addressTable" class="table table-hover">
                        <tr>
                            <th width="15%">Post Date</th>
                            <th width="20%">Title</th>
                            <th width="10%">Approved</th>
                            <th width="15%">Expiration Date</th>
                            <th width="15%">Visible to Public</th>
                            <th width="12%"></th>
                            <th width="12%"></th>
                        </tr>
                        <tbody id="contentRows"></tbody>
                    </table>
                </div> <!-- end left column -->
                <div>
                    
                    
                </div> <!-- end right column -->

            </div> <!-- End row div -->  

        </div>

        <div class="modal fade" id="detailsModal" tabindex="-1" role="dialog"
             aria-labelledby="detailsModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="detailsModalLabel">Post Details</h4>
                    </div>
                    <div class="modal-body">
                        <h3 id="post-id"></h3>
                        <table class="table table-bordered">
                            <tr>
                                <th>Title:</th>
                                <td id="title"></td>
                            </tr>
                            <tr>
                                <th>Author:</th>
                                <td id="author"></td>
                            </tr>
                            <tr>
                                <th>body:</th>
                                <td id="body"></td>
                            </tr>
                            <tr>
                                <th>Post Date:</th>
                                <td id="postDate"></td>
                            </tr>
                            <tr>
                                <th>Expiration:</th>
                                <td id="expiration"></td>
                            </tr>
                            <tr>
                                <th>Approved:</th>
                                <td id="isApproved"></td>
                            </tr>
                            <tr>
                                <th>Visible:</th>
                                <td id="isVisible"></td>
                            </tr>
                            <tr>
                                <th>Tags:</th>
                                <td id="tags"></td>
                            </tr>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            Close
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Edit Modal -->
        <div class="modal fade" id="editModal" tabindex="-1" role="dialog"
             aria-labelledby="detailsModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="detailsModalLabel">Edit
                            Post</h4>
                    </div>
                    <div class="modal-body">
                        <h3 id="post-id"></h3>
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="edit-title" class="col-md-4 control-label">
                                    Title:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-title"
                                           placeholder="First Name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-body" class="col-md-4 control-label">
                                    Body:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-body"
                                           placeholder="Last Name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-postDate" class="col-md-4 control-label">
                                    Post Date:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-postDate"
                                           placeholder="Street">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-expiration" class="col-md-4 control-label">
                                    Expiration Date:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-expiration"
                                           placeholder="city">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-isApproved" class="col-md-4 control-label">
                                    Approved:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-isApproved"
                                           placeholder="State">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-isVisible" class="col-md-4 control-label">
                                    Is Visible:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-isVisible"
                                           placeholder="Zip">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-tags" class="col-md-4 control-label">
                                    Tags:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-tags"
                                           placeholder="Zip">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                    <button  id="edit-button" class="btn btn-default">
                                        Edit Post
                                    </button>
                                    <button id="edit-modal-cancel" type="button" class="btn btn-default" data-dismiss="modal">
                                        Cancel
                                    </button>
                                    <input type="hidden" id="edit-address-id">
                                </div>
                            </div>
                        </form>
                        <div id="validationErrorsModal" style="color: red"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/postManager.js"></script>
</body>
</html>