/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    loadPosts();
});
//Functions

function loadPosts() {
    clearPosts();
    var blogRoll = $('#blogContent');
    $.each(testPostData, function (index, post) {
        blogRoll.append($('<p>').text(post.title + " " + post.postDate)) // </p>
                .append($('<p>').text(post.body))
                .append($('<p>').text(post.author.publicName))
                
                .append($('<td>')
//                        .append($('<a>')
//                                .attr({
//                                    "data-postId": post.postId,
//                                    "data-toggle": "modal",
//                                    "data-target": "#detailsModal"
//                                })
//                                .text(post.title)
//                                )
//                        )
//                .append($('<td>').text(post.isApproved))
//                .append($('<td>').text(post.expirationDate))
//                .append($('<td>').text(post.isVisible))
//                .append($('<td>')
//                        .append($('<a>')
//                                .attr({
//                                    "data-postId": post.postId,
//                                    "data-toggle": "modal",
//                                    "data-target": "#editModal"
//                                })
//                                .text('Edit')
//                                ) // </td>
//                        )
//                .append($('<td>').text('Delete'))
                );
    });
}
function clearPosts() {
    $('#contentRows').empty();
}
//
//$('#detailsModal').on('show.bs.modal', function (event) {
//
//    var element = $(event.relatedTarget);
//    var addressId = element.data('address-id');
//    var modal = $(this);
//
//    $.ajax({
//        type: 'GET',
//        url: 'address/' + addressId
//    }).success(function (address) {
//        modal.find('#address-id').text(address.addressId);
//        modal.find('#address-firstName').text(address.firstName);
//        modal.find('#address-lastName').text(address.lastName);
//        modal.find('#address-street').text(address.street);
//        modal.find('#address-city').text(address.city);
//        modal.find('#address-state').text(address.state);
//        modal.find('#address-zip').text(address.zip);
//    });
//
//});

//$('#detailsModal').on('show.bs.modal', function (event) {
//    var element = $(event.relatedTarget);
//    var postId = element.data('post-id');
//    var modal = $(this);
//    modal.find('#title').text(dummyPost.postId);
//    modal.find('#author').text(dummyPost.author.publicName);
//    modal.find('#content').text(dummyPost.body);
//    modal.find('#postDate').text(dummyPost.postDate);
//    modal.find('#expiration').text(dummyPost.expiration);
//    modal.find('#isApproved').text(dummyPost.isApproved);
//    modal.find('#isVisible').text(dummyPost.isVisible);
//    var tagString;
//    $.each(dummyPost.tags, function (index, tag) {
//        tagString += tag + " ";
//    });
//    modal.find('#tags').text(tagString);
//});




// dummy data

var testPostData = [
    {
        postId: 1,
        title: "Cat's are cool",
        body: "This is the body of my First post. asdfleu jdfd awetyii ljkejrt sd \n\
        jlksdadsfkjfdskl  ewew jttio iu qwert nbvk fgri kdfsgj sgdkg ss s \n\
        lksdadsfkjfdskl  ewew jttio iu qwert nbvk fgri kdfsgj s.\n\
        lksdadsfkjfdskl  ewew jttio iu qwert nbvk fgri kdfsgj s",
        author: {
            userId: 1,
            userName: "Dave",
            password: "password",
            isEnabled: true,
            publicName: "Dave LastName"
        },
        tags: {
            tag: {
                tagId: 1,
                tagName: "happy"
            },
            tag: {
                tagId: 2,
                tagName: "sad"
            },
            tag: {
                tagId: 3,
                tagName: "mad"
            }
        },
        postDate: "11/15/2015",
        expirationDate: "12/31/2015",
        isApproved: true,
        isVisible: true},
    {
        postId: 2,
        title: "Dogs are cool 2",
        body: "This is the body of second my post. The sdfdf we oiugj sdfj fdw oo fasd eh bv asoih df sdff s sdfflke s s sdfkejrr slkjerew sdfkejr sfllsle.",
        author: {
            userId: 1,
            userName: "Dave",
            password: "password",
            isEnabled: true,
            publicName: "Dave LastName"
        },
        tags: {
            tag: {
                tagId: 1,
                tagName: "happy"
            },
            tag: {
                tagId: 2,
                tagName: "sad"
            },
            tag: {
                tagId: 3,
                tagName: "mad"
            }
        },
        postDate: "11/15/2015",
        expirationDate: "12/31/2015",
        isApproved: true,
        isVisible: true}
];

var dummyPost =
        {
            postId: 2,
            title: "Dummy Title of Post 2",
            body: "This is the dummy body of second my post",
            author: {
                userId: 1,
                userName: "Dave",
                password: "password",
                isEnabled: true,
                publicName: "Dave LastName"
            },
            tags: {
                tag: {
                    tagId: 1,
                    tagName: "happy"
                },
                tag: {
                    tagId: 2,
                    tagName: "sad"
                },
                tag: {
                    tagId: 3,
                    tagName: "mad"
                }
            },
            postDate: "11/15/2015",
            expirationDate: "12/31/2015",
            isApproved: true,
            isVisible: true
        };



