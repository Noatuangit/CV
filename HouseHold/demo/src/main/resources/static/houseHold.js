const baseUrl = window.location.origin;
let nameDelete = "";
let flag = false;


$(document).ready(function () {
    $("#update-Button").on("click", function () {
        updateDataInModalUpdate();
    });

    $("#statusClose").on("click", function () {
        window.location = `${baseUrl}`;
    });

    $("#deleteIt").on("click", function () {
        deleteById();
    });
    // $("#deleteAll").on("click", function () {
    //     deleteAllById();
    // })


})

// function deleteAllById() {
//     $.ajax({
//         type: "PATCH",
//         url: `${baseUrl}/api/`,
//         contentType: "application/json",
//         dataType: 'json',
//         data: JSON.stringify(getDataByJson()),
//     })
// }

function getDataByJson() {
    return {
        id: $("#idEdit").val(),
        name: $("#update-name").val(),
        address: $("#update-address").val(),
        dateCreate: $("#update-dateCreate").val()
    };
}

function updateDataInModalUpdate() {
    let id = $("#idEdit").val();
    if (id === '') {
        saveNewHouseHold();
        return;
    }
    saveEditHouseHold();
}

function saveEditHouseHold() {
    $.ajax({
        type: "PATCH",
        url: `${baseUrl}/api/`,
        contentType: "application/json",
        dataType: 'json',
        data: JSON.stringify(getDataByJson()),
        success: function (event) {
            $('#updateModal').modal("hide");
            $('#actionStatus').html(`Edit success!!! hello ${event.name}`);
            $('#statusModal').modal("show");
        },
        error: function (event) {
            editError(event);
        }
    })
}

function deleteById() {
    $.ajax({
        type: "DELETE",
        url: `${baseUrl}/api/${$('#deleteId').val()}`,
        success: function (event) {
            console.log(event);
            console.log(nameDelete);
            $('#delete').modal("hide");
            $('#actionStatus').html(`Delete success!!! bye ${nameDelete}`);
            $('#statusModal').modal("show");
        },
        error: function (event) {
            editError(event)
        }
    })
}

function saveNewHouseHold() {
    $.ajax({
        type: "POST",
        url: `${baseUrl}/api/`,
        contentType: "application/json",
        dataType: 'json',
        data: JSON.stringify(getDataByJson()),
        success: async function (event) {
            await addListPeople(event.id);
            $('#actionStatus').html(`Create success!!! hello ${event.name}`);
            $('#updateModal').modal("hide");
            $('#statusModal').modal("show");
        },
        error: function (event) {
            editError(event);
        }
    })
}

    function editError(data) {
        switch (data.status) {
            case 404:
                console.log(data);
                $("#actionStatus").html(data.responseJSON.messageError);
                $('#statusModal').modal("show");
                break;
            case 500:

                $("#actionStatus").html(data.responseJSON.message);
                $("#statusModal").modal("show");
                break;
            case 400:
                $("#error-update-name").html(data.responseJSON.name);
                $("#error-update-address").html(data.responseJSON.address);
                $("#error-update-dateCreate").html(data.responseJSON.dateCreate);
                break;
        }
    }

function showInfoDelete(id, name) {
    nameDelete = name;
    document.getElementById("deleteId").value = id;
    document.getElementById("nameDelete").innerText = name;
}

function showInfoEdit(id, name, day, address) {
    $("#idEdit").val(id);
    $("#update-name").val(name);
    $("#update-address").val(address);
    $("#update-dateCreate").val(day)
}


function toggle(source) {
    if (flag) {
        flag = false;
        document.getElementById("deleteAllButton").style.display = "none";
    } else {
        flag = true;
        document.getElementById("deleteAllButton").style.display = "block";
    }


    let checkboxes = document.getElementsByName('listId');
    for (let i = 0, n = checkboxes.length; i < n; i++) {
        checkboxes[i].checked = source.checked;
    }
}


