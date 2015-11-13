<%-- 
    Document   : home
    Created on : Oct 16, 2015, 10:19:31 AM
    Author     : Suzanne Ludwig
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1,
              user-scalable=no">
        <title>DVD Library</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">

            <h1 id="ttle">DVD Library</h1>
            <hr/>
            <div class="navbar"> 
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a>
                    </li>
                </ul>

            </div>

            <div class="row">
                <div class="col-md-6">
                    <h2 id="spinner">DVDs</h2>
                    <table id="addressTable" class="table table-hover">
                        <tr>
                            <th width="20%">Title</th>
                            <th width="16%">Director</th>
                            <th width="16%">Year</th>
                            <th width="16%">Studio</th>
                            <th width="16%">Rating</th>
                            <th width="16%">Note</th>
                        </tr>
                        <tbody id="tableContent"></tbody>
                    </table>
                </div>

                <div class="col-md-6">
                    <h2>Add DVD to Library</h2>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-first-name" class="col-md-4 control-label">
                                Title:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-title" placeholder="Title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-last-name" class="col-md-4 control-label">
                                Director:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-director" placeholder="Director's Name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-street" class="col-md-4 control-label">
                                Year:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-year" placeholder="Year (ex: 1999)"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-city" class="col-md-4 control-label">
                                Studio:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-studio" placeholder="Studio"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-state" class="col-md-4 control-label">
                                Rating:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-rating" placeholder="Rating (ex: R, PG)"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-zip" class="col-md-4 control-label">
                                Note:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-note" placeholder="Add Note (optional)"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-zip" class="col-md-4 control-label">
                                Image Link:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control"
                                       id="add-image" placeholder="e.g. www.example.com/image.png"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" id="add-button" class="btn btn-default">
                                    Add DVD
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div> 


        </div>

        <div class="modal fade" id="detailsModal" tabIndex="-1" role="dialog"
             aria-labelledby="detailsModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="detailsModalLabel">
                            Information
                        </h4>
                    </div>
                    <div class="modal-body">
                        <h3 id="dvd-id"></h3>
                        <table class="table table-bordered">
                            <tr>
                                <th>Title:</th>
                                <td id="dvd-title"></td>
                            </tr>
                            <tr>
                                <th>Director:</th>
                                <td id="dvd-director"></td>
                            </tr>
                            <tr>
                                <th>Year:</th>
                                <td id="dvd-year"></td>
                            </tr>
                            <tr>
                                <th>Studio:</th>
                                <td id="dvd-studio"></td>
                            </tr>
                            <tr>
                                <th>Rating:</th>
                                <td id="dvd-rating"></td>
                            </tr>
                            <tr>
                                <th>Note:</th>
                                <td id="dvd-note"></td>
                            </tr>
                            <tr>
                                <th>Image:</th>
                                <td id="dvd-image"></td>
                            </tr>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"data-toggle="modal" data-target="#editModal">
                            Edit
                        </button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            Close
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="editModal" tabIndex="-1" role="dialog"
             aria-labelledby="editModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="detailsModalLabel">
                            Edit Note
                        </h4>
                    </div>
                    <div class="modal-body">
                        <h3 id="dvd-id"></h3>
                        <form class="form-horizontal" role="form">
                            <input type="hidden" id="edit-address-id">
                            <div class="form-group">
                                <label for="edit-zip" class="col-md-4 control-label">
                                    Note:
                                </label>

                                <div class="col-md-8">
                                    <input type="text" class="form-control"
                                           id="edit-note" placeholder="enter new note"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                    <button type="submit" id="edit-button" 
                                            class="btn btn-default"
                                            data-dismiss="modal">
                                        Edit Note
                                    </button>
                                    <button type="button" class="btn btn-default"
                                            data-dismiss="modal">
                                        Cancel
                                    </button>
                                    <input type="hidden" id="edit-title">
                                    <input type="hidden" id="edit-director">
                                    <input type="hidden" id="edit-year">
                                    <input type="hidden" id="edit-studio>"
                                           <input type="hidden" id="edit-rating">
                                    <input type="hidden" id="edit-image">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
        <!--<script src="${pageContext.request.contextPath}/js/velocity.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/velocity.ui.min.js.js"></script>
        <script src="../js/velocity.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.RotatAnim.js"></script> -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/dvds.js"></script>
        <script src="${pageContext.request.contextPath}/js/QTransform.js"></script>
    </body>
</html>
