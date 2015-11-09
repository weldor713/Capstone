$(document).ready(function () {
    loadPosts();
});


function loadPosts() {
    clearPosts();
    var blogRoll = $('#blogContent');

    $.ajax({
        url: 'posts'
    }).success(function (allposts, status) {
        $.each(allposts, function (index, post) {
            blogRoll.append($('<p>').text(post.title + " " + post.postDate)) // </p>
                    .append(post.body);
            
//            $.each(post.tags, function (index, tag) {
//                blogRoll.append($('<span>').text(tag.tagName + " "));
//            });
        });
    });
}

function clearPosts() {
    $('#blogContent').empty();
}



