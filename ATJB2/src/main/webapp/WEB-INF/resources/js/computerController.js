let flagPosition = false;
let flagStatus = false;
let url = window.location.origin;
$(document).ready(function () {
    $("#createModal").on('hide.bs.modal', function () {
        clearValid();
        document.getElementById("form").reset();
    });
});

function deleteThis(id, position, status) {
    $('#position-delete').html(position);
    $('#status-delete').html(status);
    $('#id-delete').val(id);
}

function validatePosition() {
    let position = $('#position-update').val();
    if ('' === position.trim()) {
        $('#required-position').css("display", "block");
        flagPosition = false;
        checkValue();
        return;
    }
    flagPosition = true
    $('#required-position').css("display", "none");
    checkValue();
}

function validateStatus() {
    let status = $('#status-update').val();
    if ('' === status.trim()) {
        $("#required-status").css("display", "block");
        $("#pattern-status").css("display", "none");
        flagStatus = false;
        checkValue();
        return;
    }
    if (!(/^[Oo][NnFf][Ff]?$|pending|waiting/.test(status)) && '' !== status.trim()) {
        $("#pattern-status").css("display", "block");
        $("#required-status").css("display", "none");
        flagStatus = false;
        checkValue();
        return;
    }
    $("#required-status").css("display", "none");
    $("#pattern-status").css("display", "none");
    flagStatus = true;
    checkValue();
}

function checkValue() {
    if (flagStatus && flagPosition) {
        $('#save').removeAttr('disabled');
        return;
    }
    $('#save').attr('disabled', 'disabled');
}

function clearValid() {
    $("#required-status").css("display", "none");
    $("#pattern-status").css("display", "none");
    $("#required-position").css("display", "none");
}

function editForm(id, position, status) {
    $('#id-update').val(id);
    $('#position-update').val(position);
    $('#status-update').val(status);
    flagPosition = false;
    flagStatus = false;
}
