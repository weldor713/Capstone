
$(document).ready(function () {

    tinyMCE.init({
        selector: "#staticContent",
        inline: false,
        plugins: [
            "advlist autolink lists link image charmap print preview anchor",
            "searchreplace visualblocks code fullscreen",
            "insertdatetime media table contextmenu paste"
        ],
        toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image"
    });

    loadStaticContent();

//    loadStaticContent();

    $("#add-content-button").click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'PUT',
            url: 'header',
            data: JSON.stringify({
                contentId: 1,
                content: tinyMCE.activeEditor.getContent({format: 'raw'})
            }),
            headers: {'Accept': 'application/json',
                'Content-Type': 'application/json'},
            dataType: 'json'
        }).success(function (data, status) {
            tinyMCE.activeEditor.setContent("");
            console.log("Success!");
        }).error(function (data, status) {
            console.log("Error!");
        });

        tinyMCE.activeEditor.setContent("");
    });

});

function loadStaticContent() {
    $.ajax({
        url: 'header'
    }).success(function (staticContent) {
        //var content = data.content;
        tinyMCE.activeEditor.setContent(staticContent.contentId);
        //$('#staticContent').activeEditor.setContent(data.content);
    });

}

