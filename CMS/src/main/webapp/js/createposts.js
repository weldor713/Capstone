$(document).ready(function () {
    tinymce.init({
            selector: "#bodytextarea"
        });

    
    $("#add-post-button").click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'makePost',
            data: JSON.stringify({
                title: $('#add-title').val(),
                body: tinymce.activeEditor.getContent({format: 'raw'}),
//               author: $('#add-author').val(),
                tags: $('#add-tags').val(),
                postDate: $('#add-postDate').datepicker('getDate'),
                expiration: $('#add-expiration').datepicker('getDate')
//               isPublished: $('#add-isPublished').val()
            }),
            headers: {'Accept': 'application/json',
                'Content-Type': 'application/json'},
            dataType: 'json'
        }).success(function (data, status) {
            $('#add-title').val("");
            $('#add-tags').val("");
            $('#add-postDate').val("");
            $('#add-expiration').val("");
            tinymce.activeEditor.setContent("");
            console.log("Success!");
        }).error(function (data, status) {
            console.log("Error!");
        }); 
//        $.ajax({
//            type: 'POST',
//            url: 'addTag',
//            data: JSON.stringify({
//                tagName: $('#add-tags').val()
//            }),
//            headers: {'Accept': 'application/json',
//                'Content-Type': 'application/json'},
//            dataType: 'json'
//        }).success(function (data, status) {
//            $('#add-tags').val("");
//        }).error(function (data, status){
//            console.log("ohno");
//        });
    });

//    $("#add-expiration").datepicker("getDate");
//    $("#add-postDate").datepicker("getDate");


    $(function () {
        $("#add-postDate").datepicker({
            dateFormat: "yy-mm-dd"
        });
    });

    $(function () {
        $("#add-expiration").datepicker({
            dateFormat: "yy-mm-dd"
        });
    });
});





