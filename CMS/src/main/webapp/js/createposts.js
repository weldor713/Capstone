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
                postDate: $('#add-postDate').val(),
                expiration: $('#add-expiration').val()
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
    });

    $(function () {
        $("#add-postDate").datepicker({
            dateFormat: "mm/dd/yy"
        });
    });

    $(function () {
        $("#add-expiration").datepicker({
            dateFormat: "mm/dd/yy"
        });
    });
});





