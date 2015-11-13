$(document).ready(function () {
    $('#blogContent').hide();
    loadPosts();
    loadTags();

});

//have the postById function pass through this to support the same layout
function loadPosts() {
    clearPosts();
    var blogRoll = $('#blogContent');
    
    $.ajax({
        url: 'posts'
    }).success(function (allposts, status) {
        $.each(allposts, function (index, post) {
            blogRoll.append($('<div class="postContain">')
                    .text(post.title + " " + post.postDate + " by " + post.author).append(post.body));
            $.each(post.tags, function (index, tag) {
                blogRoll.append($('<span class="tagToPost">').text("#" + tag.tagName + " "));
            });

        });

    });
    blogRoll.fadeIn(3000);
}

function loadTags() {
    var tagList = $('#tagDisplay');
    $.ajax({
        url: 'tags'
    }).success(function (alltags, status) {
        $.each(alltags, function (index, tag) {
            tagList.append($('<li>')).append($('<a class="tags">')
                    .attr({"onClick": "showByTag(" + tag.tagId + ")"}).text(tag.tagName));
            //.css({'color': '#b3ffd9'}));
        });
    });

}

function showByTag(id) {
    clearPosts();
    var blogRoll = $('#blogContent');
    $.ajax({
        url: 'postsByTag/' + id
    }).success(function (allposts, status) {
        $.each(allposts, function (index, post) {
            blogRoll.append($('<p>').text(post.title + " " + post.postDate)) // </p>
                    .append(post.body);

            $.each(post.tags, function (index, tag) {
                blogRoll.append($('<span>').text(tag.tagName
                        + " "));
            });
        });
    });
}

function clearPosts() {
    $('#blogContent').empty();
}

function doRotate(elementId) {
    var g = $(elementId);
    g.delay(300).animate({rotate: '360deg'}, 1500);

}

function spinorama() {

}
