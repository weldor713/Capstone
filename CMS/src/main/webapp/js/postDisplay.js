$(document).ready(function () {
    loadPosts();
    loadTags();
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

            $.each(post.tags, function (index, tag) {
                blogRoll.append($('<p style="color:blue">').text(tag.tagName + " "));
            });
        });
    });
}

function loadTags(){
    var tagList = $('#tagDisplay');
    $.ajax({
        url: 'tags'
    }).success(function (alltags, status){
        $.each(alltags, function(index, tag){
            tagList.append($('<li>')).append($('<a class="tags">')
            .attr({"onClick": "showByTag(" + tag.tagId + ")"}).text(tag.tagName));
            //.css({'color': '#b3ffd9'}));
        });
    });
    
}

function showByTag(id){
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
