$(document).ready(function () {
    loadPosts();
});


function loadPosts() {
    clearPosts();
    var blogRoll = $('#blogContent');
    var tagList = $('#tagDisplay');

    $.ajax({
        url: 'posts'
    }).success(function (allposts, status) {
        $.each(allposts, function (index, post) {
            blogRoll.append($('<p>').text(post.title + " " + post.postDate)) // </p>
                    .append(post.body);

            $.each(post.tags, function (index, tag) {
                blogRoll.append($('<p style="color:blue">').text(tag.tagName + " "));
            });
        });
    });

    $.ajax({
        url: 'tags'
    }).success(function (data, status) {
        $.each(data, function (index, tag) {
            tagList.append($('<p style="color:blue">').text(tag.tagName + " ").append(""));
        });
    });

}
function clearPosts() {
    $('#blogContent').empty();
}



