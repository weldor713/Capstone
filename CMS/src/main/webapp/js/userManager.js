
$(document).ready(function () {
    loadUsers();
    
$('#add-button').click(function (event) {
    event.preventDefault();
    $.ajax({
        type: 'POST',
        url: 'user',
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
        $('#add-publicname').val('');
        $('#add-username').val('');
        $('#add-authority').val('');
        $('#add-user_id').val('');
        $('#add-password').val('');
        $('#validationErrors').empty();
        loadUsers();
    }).error(function (data, status) {
         $('#validationErrors').empty();
            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                var errorDiv = $("#validationErrors");
                errorDiv.append(validationError.message).append($("<br>"));
                });
        });
    });
    
    $('#edit-button').click(function (event) {
    event.preventDefault();
    $.ajax({
        type: 'PUT',
        url: 'user/'+  $("#edit-user-id").val(),
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
    }).error(function (data, status) {
        $('#validationEditErrors').empty();
            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                var errorDiv = $("#validationEditErrors");
                errorDiv.append(validationError.message).append($("<br>"));
                });
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
        var userlevel;
        $.each(users, function (index, user) {
            if (user.authority === "ROLE_ADMIN") {
                userlevel = "Admin";
            } else {
                userlevel = "User";
            }
            userTable.append($('<tr>'))
                    .append($('<td>').text(user.publicName))
                    .append($('<td>').text(user.userName))
                    .append($('<td>').text(userlevel))
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


