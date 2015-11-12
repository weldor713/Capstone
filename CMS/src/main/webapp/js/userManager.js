/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    loadUsers();
    
    // on click for our add button
$('#add-button').click(function (event) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
    event.preventDefault();
// Make an Ajax call to the server. HTTP verb = POST, URL = user 
    $.ajax({
        type: 'POST',
        url: 'user',
// Build a JSON object from the data in the form 
        data: JSON.stringify({
            publicName: $('#add-publicname').val(),
            userName: $('#add-username').val(),
            authority: $('#add-authority').val(),
            user_id: $('#add-user_id').val(),
            password: $('#add-password').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function (data, status) {
// If the call succeeds, clear the form and reload the summary
        $('#add-publicname').val('');
        $('#add-username').val('');
        $('#add-authority').val('');
        $('#add-user_id').val('');
        $('#add-password').val('');
        $('#validationErrors').empty();
        loadUsers();
        //return false;
    }).error(function (data, status) {
        console.log("error");
        });
    });
    
    $('#edit-button').click(function (event) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
    event.preventDefault();
// Make an Ajax call to the server. HTTP verb = POST, URL = user 
    $.ajax({
        type: 'PUT',
        url: 'user/'+  $("#edit-user-id").val(),
// Build a JSON object from the data in the form 
        data: JSON.stringify({
            publicName: $('#edit-publicname').val(),
            userName: $('#edit-username').val(),
            authority: $('#edit-authority').val(),
            password: $('#edit-password').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function (data, status) {
        $("#editModal").modal("hide");

    loadUsers();
        //return false;
    }).error(function (data, status) {
        console.log("error");
        });
    });
    
});

//Functions

function loadUsers() {
    clearUsers();
    var userTable = $('#userTable');
    $.ajax({
        url: 'displayUserList'
    }).success(function (users, status) {
        $.each(users, function (index, user) {
            userTable.append($('<tr>'))
                    .append($('<td>').text(user.userName))
                    .append($('<td>').text(user.authority))
                    .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-user-id': user.userId,
                                    'data-toggle': 'modal',
                                    'data-target': '#editModal'
                                })
                                .text('Edit')
                                ) // ends the <a> tag
                        ) // ends the <td> tag for Edit
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'onClick': 'deleteUser(' +
                                            user.userId + ')'
                                })
                                .text('Delete')
                                ) // ends the <a> tag
//                        ) // ends the <td> tag for Delete
                ); // ends the <tr> 

        });
    });

}

//// This code runs in response to show.bs.modal event for the details Modal
//$('#detailsModal').on('show.bs.modal', function (event) {
//// get the element that triggered the event
//    var element = $(event.relatedTarget);
//    var userId = element.data('user-id');
//    var modal = $(this);
//// make an ajax call to get user information for given user id
//// this is a GET request to user/{id}
//// upon success, put the returned JSON data into the modal dialog
//
//
//    $.ajax({
//        type: 'GET',
//        url: 'user/' + userId
//    }).success(function (user) {
//        modal.find('#publicname').text(user.publicName);
//        modal.find('#username').text(user.userName);
//        modal.find('#authority').text(user.authority);
//        modal.find('#user_id').text(user.userId);
////        modal.find('#enabled').text(user.enabled);
//        modal.find('#password').text(user.password);
//    });
//});

// This code runs in response to the show.hs.modal event for the edit Modal
$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var userId = element.data('user-id');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'user/' + userId
    }).success(function (user) {
        modal.find('#edit-user-id').val(user.userId);
        modal.find('#edit-publicname').val(user.publicName);
        modal.find('#edit-username').val(user.userName);
        modal.find('#edit-authority').val(user.authority);
        modal.find('#edit-password').val(user.password);
    });
});

function clearUsers() {
    $('#userTable').empty();
}

function deleteUser(id) {
    var answer = confirm("Do you really want to delete this user?");
    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'user/' + id
        }).success(function () {
            loadUsers();
        });
    }
}


