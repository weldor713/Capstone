$(document).ready(function () {
    $('#blogContent').hide();
    loadPosts();
    //loadTags();

});

//have the postById function pass through this to support the same layout
function loadPosts(data, status) {
    var blogRoll = $('#blogContent');
    var tagList = $('#tagDisplay');
    
    $.ajax({
        url: 'posts'
    }).success(function (allposts, status) {
        $.each(allposts, function (index, post) {
            blogRoll.append($('<div class="postContain">')
                    .text(post.title + " " + post.postDate + " by " + post.author).append(post.body));
            $.each(post.tags, function (index, tag) {
                blogRoll.append($('<p class="tagToPost">').text("#" + tag.tagName + " "));
                tagList.append($('<li class="tagList">')).append($('<a class="tags">')
                    .attr({"onClick": "showByTag(" + tag.tagId + ")"}).text(tag.tagName));
            });

        });

    });
    blogRoll.fadeIn(3000);
}

function clearPosts() {
    $('#blogContent').empty();
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
                blogRoll.append($('<p>').text(tag.tagName
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
