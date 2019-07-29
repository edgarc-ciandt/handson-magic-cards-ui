$(document).ready(function() {
    $('#tableCards').DataTable( {
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

    $('#tableExpansion').DataTable( {
            "bFilter":false,
            "processing": true,
            "serverSide": true,
            "ajax": "/expansion/data",
            "columns": [
                {"data":"expansionId"},
                {"data":"name"},
                {"data":"ptBrName"},
                {
                    "data": null,
                    "render": function (data, type, row, meta) {
                        return '<a href="/expansion/update/' + row['expansionId'] + '" class="editor_edit">Edit</a> | <a href="/expansion/delete/' + row['expansionId'] + '" class="editor_remove">Delete</a>';
                    }
                }
            ]
        } );
} );