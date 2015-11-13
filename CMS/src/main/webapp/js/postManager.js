$(document).ready(function () {
    tinymce.init({
        selector: "#edit-body",
        inline: false,
        plugins: [
            "advlist autolink lists link image charmap print preview anchor",
            "searchreplace visualblocks code fullscreen",
            "insertdatetime media table contextmenu paste"
        ],
        toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image"
    });
    loadPosts();
    
        $('#edit-button').click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'PUT',
            url: 'post/' + $('#edit-postId').val(),
            data: JSON.stringify({
                postId: $('#edit-postId').val(),
                title: $('#edit-title').val(),
                body: tinyMCE.activeEditor.getContent({format: 'raw'}),
                postDate: $('#edit-postDate').val(),
                expiration: $('#edit-expiration').val(),
                isPublished: $('#edit-isPublished').val(),
                tags: $('#edit-tags').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            loadPosts();
            $('#editModal').modal('hide');
        }).error(function (data, status) {
            console.log("Error");
        });
    });
});
//Functions

function loadPosts() {
    clearPosts();
    var cTable = $('#contentRows');

    $.ajax({
        url: 'allposts'
    }).success(function (allposts, status) {
        $.each(allposts, function (index, post) {
            if (post.expiration == null) {
                post.expiration = "none";
            }

            cTable.append($('<tr>')
                    .append($('<td>').text(post.postDate))
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        "data-postid": post.postId,
                                        "data-toggle": "modal",
                                        "data-target": "#detailsModal"
                                    })
                                    .text(post.title)
                                    )
                            )
                    .append($('<td>').text(post.expiration))
                    // .append($('<td>').text(post.isPublished))
                    .append($('<td>')
                            .append($('<input>')
                                    .attr({'type': 'checkbox',
                                        'id': post.postId,
                                        'onClick': 'pubUnpub(' + post.postId + ')'
                                    }).prop('checked', post.isPublished)))
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        "data-postid": post.postId,
                                        "data-toggle": "modal",
                                        "data-target": "#editModal"
                                    })
                                    .text('Edit')
                                    ) // </td>
                            )
                    .append($('<td>').text('Delete'))
                    );
        });
    });
}

function pubUnpub(id) {
    $('#' + id).change(function () {
        if ($(this).is(':checked')) {
            console.log("CCCCheckeddddddd");
            $.ajax({
                    url: "publish/" + id,
                    method: 'PUT'
                }).success(function () {
                    loadPosts();});
        }
        else
        {
            console.log("UNCheckeddddddd");
            $.ajax({
                    url: "unpublish/" + id,
                    method: 'PUT'
                }).success(function () {
                    loadPosts();});
        }
    });

}

function clearPosts() {
    $('#contentRows').empty();
}

$('#detailsModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var postId = element.data('postid');
    var modal = $(this);
    $('#body').empty();

    $.ajax({
        type: 'GET',
        url: 'post/' + postId
    }).success(function (post) {
        modal.find('#title').text(post.title);
        //modal.find('#author').text(post.author.publicName);
        modal.find('#body').append(post.body);
        modal.find('#postDate').text(post.postDate);
        modal.find('#expiration').text(post.expiration);
        modal.find('#isPublished').text(post.isPublished);
        var tagString = "";
        $.each(post.tags, function (index, tag) {
            if (index >= post.tags.length - 1) {
                tagString += tag.tagName;
            } else {
                tagString += tag.tagName + ", ";
            }
        });
        modal.find('#tags').text(tagString);

    });

});

$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var postId = element.data('postid');
    var modal = $(this);
    $('#edit-body').empty();

    $.ajax({
        type: 'GET',
        url: 'post/' + postId
    }).success(function (post) {


        modal.find("#edit-postId").val(post.postId);
        modal.find('#edit-title').val(post.title);
        //modal.find('#edit-author').val(post.author.publicName);
        tinyMCE.activeEditor.setContent(post.body);
        modal.find('#edit-postDate').val(post.postDate);
        modal.find('#edit-expiration').val(post.expiration);
        modal.find('#edit-isPublished').val(post.isPublished);
        var tagString = "";
        $.each(post.tags, function (index, tag) {
            tagString += tag.tagName;
        });
        modal.find('#edit-tags').val(tagString);
    });
});
