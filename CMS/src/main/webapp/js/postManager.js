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
});
//Functions

function loadPosts() {
    clearPosts();
    var cTable = $('#contentRows');

    $.ajax({
        url: 'allposts'
    }).success(function (allposts, status) {
        $.each(allposts, function (index, post) {
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
                    .append($('<td>').text(post.isPublished))
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


        modal.find("#postid").text(post.postId);
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
