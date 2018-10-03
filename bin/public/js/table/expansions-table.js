$(document).ready(function() {
    $('.dataTableExpansion').DataTable( {
        "bFilter":false,
        "processing": true,
        "serverSide": true,
        "ajax": "/cards/expansions/data",
        "columns": [
            {"data":"expasionId"},
            {"data":"name"},
            {"data":"portugueseName"},
            {
                "data": null,
                "render": function (data, type, row, meta) {
                    return '<a href="/cards/expansions/update/' + row['expasionId'] + '" class="editor_edit">Edit</a> | <a href="/cards/expansions/delete/' + row['expasionId'] + '" class="editor_remove">Delete</a>';
                }
            }
        ]
    } );
} );