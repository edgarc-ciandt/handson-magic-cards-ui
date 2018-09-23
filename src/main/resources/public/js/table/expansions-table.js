$(document).ready(function() {

	
    $('#idTableExpansion').DataTable( {
        "bFilter":false,
        "processing": true,
        "serverSide": true,
        "ajax": "/expansions/data",
        "destroy": true,
        "columns": [
            {"data":"expansionId"},
            {"data":"name"},
            {"data":"ptBrName"},
            {"data":"linkName"},
            {"data":"code"},
            {"data":"launchDate"},
            {"data":"expansionCategoryId"},
            {
                "data": null,
                "render": function (data, type, row, meta) {
                    return '<a href="/expansions/update/' + row['expansionId'] + '" class="editor_edit">Edit</a> | <a href="/expansions/delete/' + row['expansionId'] + '" class="editor_remove">Delete</a>';
                }
            }
        ]
    } );
} );