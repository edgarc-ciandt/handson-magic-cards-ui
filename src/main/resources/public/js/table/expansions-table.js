$(document).ready(function() {
    $('.expansionTable').DataTable( {
        "bFilter":false,
        "processing": true,
        "serverSide": true,
        "ajax": "/expansions/data",
        "columns": [
            {"data":"expansionId"},
            {"data":"name"},
            {"data":"ptBrName"},
            {
                "data": null,
                "render": function (data, type, row, meta) {
                    return '<a href="/expansions/update/' + row['expansionId'] + '" class="editor_edit">Edit</a> | <a href="/expansions/delete/' + row['expansionId'] + '" class="editor_remove">Delete</a>';
                }
            }
        ]
    } );
} );