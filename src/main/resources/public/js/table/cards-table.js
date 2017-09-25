$(document).ready(function() {
    $('.dataTable').DataTable( {
        "bFilter":false,
        "processing": true,
        "serverSide": true,
        "ajax": "/cards/data",
        "columns": [
            {"data":"gathererId"},
            {"data":"englishName"},
            {"data":"ptBrName"},
            {
                "data": null,
                "render": function (data, type, row, meta) {
                    return '<a href="/cards/update/' + row['gathererId'] + '" class="editor_edit">Edit</a> | <a href="/cards/delete/' + row['gathererId'] + '" class="editor_remove">Delete</a>';
                }
            }
        ]
    } );
} );