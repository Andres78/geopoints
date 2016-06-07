var ajaxUrl = 'ajax/points/';
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

$(function () {
    datatableApi = $('#datatable').DataTable({
        "ajax": {
            "url": ajaxUrl,
            "dataSrc": ""
        },
        "scrollY": "250px",
        "scrollCollapse": true,
        "paging": true,
        "lengthMenu": [[5, 10, 25, 50, -1], [5, 10, 25, 50, "All"]],
        "pagingType": "full_numbers",
        "info": true,
        "columns": [
            {
                "data": "name",
                "defaultContent": "",
                "render": renderPointName
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderShowBtn
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderDeleteBtn
            }
        ],
        "order": [
            [
                0,
                "asc"
            ]
        ],
        "initComplete": function () {
            makeEditable();
        }

    });
});