$(document).ready(function () {
    $('#blogContent').hide();
    loadAllPosts();
    //loadTags();

});

function loadAllPosts() {
    $.ajax({
        url: 'posts'
    }).success(function (allposts, status) {
        loadPosts(allposts, status);
    });
}
//have the postById function pass through this to support the same layout

function loadPosts(data, status) {
    clearPosts();
    var blogRoll = $('#blogContent');
    var tagList = $('#tagDisplay');


    $.each(data, function (index, post) {
        blogRoll.append($('<div class="postContain">')
                .text(post.title + " " + post.postDate + " by " + post.author).append(post.body));
        $.each(post.tags, function (index, tag) {
            blogRoll.append($('<p class="tagToPost">').text("#" + tag.tagName + " "));
            tagList.append($('<li class="tagList">')).append($('<a class="tags">')
                    .attr({"onClick": "showByTag(" + tag.tagId + ")"}).text("#" + tag.tagName + ""));
        });

    });
    blogRoll.fadeIn(3000);
}

function clearPosts() {
    $('#blogContent').empty();
    $('#tagDisplay').empty();
}



function showByTag(id) {
    var blogRoll = $('#blogContent');
    clearPosts();
    $.ajax({
        url: 'postsByTag/' + id
    }).success(function (allposts, status) {
        $.each(allposts, function (index, post) {
        blogRoll.append($('<div class="postContain">')
                .text(post.title + " " + post.postDate + " by " + post.author).append(post.body));
        $.each(post.tags, function (index, tag) {
            blogRoll.append($('<p class="tagToPost">').text("#" + tag.tagName + " "));;
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
