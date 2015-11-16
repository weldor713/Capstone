
$(document).ready(function () {

    loadStaticContent();

    tinymce.init({
        selector: "#staticContent",
        plugins: ["image preview"]
    });


    $("#add-content-button").click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'PUT',
            url: 'header',
            data: JSON.stringify({
                contentId: 1,
                content: tinymce.activeEditor.getContent({format: 'raw'})
            }),
            headers: {'Accept': 'application/json',
                'Content-Type': 'application/json'},
            dataType: 'json'
        }).success(function (data, status) {
            tinymce.activeEditor.setContent("");
            console.log("Success!");
        }).error(function (data, status) {
            console.log("Error!");
        });

        tinymce.activeEditor.setContent("");
    });

});

function loadStaticContent() {
    $.ajax({
        url: 'header'
    }).success(function (data, status) {
        $('#static').append(data.content);
    });

}

