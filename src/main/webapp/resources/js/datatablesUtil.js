var form;

function updateTableByData(data) {
    datatableApi.clear().rows.add(data).draw();
}

var failedNote;

function closeNoty() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}

function successNoty(text) {
    closeNoty();
    noty({
        text: text,
        type: 'success',
        layout: 'bottomRight',
        timeout: true
    });
}


function failNotySimple(msg) {
    closeNoty();
    failedNote = noty({
        text: 'Failed: ' + msg,
        type: 'error',
        layout: 'bottomRight',
        timeout: true
    });
}

function failNoty(event, jqXHR, options, jsExc) {
    closeNoty();
    var errorInfo = $.parseJSON(jqXHR.responseText);
    failedNote = noty({
        text: 'Failed: ' + jqXHR.statusText + "<br>" + errorInfo.cause + "<br>" + errorInfo.detail,
        type: 'error',
        layout: 'bottomRight'
    });
}

function renderPointName(date, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-xs btn-info" href="showPoint?id=' + row.id + '">' + row.name + '</a>';
    }
}

function renderShowBtn(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-xs btn-info" onclick="showPoint(' + row.id + ');">Show</a>';
    }
    return data;
}

function renderEditBtn(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-xs btn-primary" onclick="updateRow(' + row.id + ');">Edit</a>';
    }
    return data;
}

function renderDeleteBtn(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-xs btn-danger" onclick="deleteRow(' + row.id + ');">Delete</a>';
    }
    return data;
}

function makeEditable() {
    form = $('#detailsForm');

    form.submit(function () {
        save();
        return false;
    });

    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(event, jqXHR, options, jsExc);
    });
}

function save() {
    myGeoCode(form);
}

function add() {
    form.find(":input").val("");
    $('#id').val(0);
    $('#editRow').modal();
}

function showPoint(id) {
    $.get(ajaxUrl + id, function (data) {
        myDeGeoCode(data.coords, data.name);
    });
}

function deleteRow(id) {
    $.ajax({
        url: ajaxUrl + id,
        type: 'DELETE',
        success: function () {
            updateTable();
            successNoty('Deleted');
        }
    });
}

function updateRow(id) {
    $.get(ajaxUrl + id, function (data) {
        $('#editRow').modal();
    });
}




