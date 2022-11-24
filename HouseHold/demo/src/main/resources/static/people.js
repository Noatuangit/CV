let content = "";
let index = 0;
let listPeople = [];

$(document).ready(function () {
    $("#addPeople").on("click", function () {
        createPeople();
    });

    $('#updateModal').on('hide.bs.modal', function () {
        document.getElementById("bodyAddPeopleInCreate").style.display = "none";
        $('#error-update-name').html("");
        $('#error-update-address').html("");
        $('#error-update-dateCreate').html("");
        $('#update-name').val("");
        $('#update-address').val("");
        $('#update-dateCreate').val("");
        content = "";
        index = 0;
        listPeople = [];
    });

    $('#createPeople').on('hide.bs.modal', function () {
        $('#error-cmnd-create').html("");
        $('#error-name-create').html("");
        $('#error-birthday-create').html("");
    });
    $(document).on("click", '.addHere', function () {
        addPeopleInLocal(this.id);
    });
});

function addPeopleInLocal(id) {
    const data = {
        name: $("#name-" + id).val(),
        birthday: $("#birthday-" + id).val(),
        cmnd: $("#cmnd-" + id).val()
    }
    if (validDataPeople(data)) {
        return;
    }
    if (!listPeople.find(e => e.name === data.name)) {
        listPeople.push(data);
    }
}


function displayTable() {
    content = displayPeopleAddInList();
    document.getElementById("bodyAddPeopleInCreate").style.display = "block";
    document.getElementById("listPeopleAdd").innerHTML = content += displayInputDataPeopleAddInTable(++index);
}

function displayInputDataPeopleAddInTable(index) {
    return `<tr><td><input type='text' placeholder='cmnd input here' required id='cmnd-${index}'>
            <span style="color: red" id="error-people-cmnd"></span></td>` +
        ` <td><input type='text' placeholder='name input here' id='name-${index}' required><span style="color: red" id="error-people-name"></span></td> ` +
        `<td><input type='date' placeholder='birthday input here' id='birthday-${index}' required><span style="color: red" id="error-people-date"></span></td>` +
        ` <td><button  id ='${index}' class="btn btn-success addHere">Add</button></td></tr> `
}

function displayPeopleAddInList() {
    let content = '';
    for (let i = 0; i < listPeople.length; i++, ++index) {
        content += `<tr>
            <td><input type='text' placeholder='cmnd input here' required id='cmnd-${index}' value="${listPeople[i].cmnd}"></td>` +
            `<td><input type='text' placeholder='name input here' id='name-${index}' value="${listPeople[i].name}" required></td> ` +
            `<td><input type='date' placeholder='birthday input here' id='birthday-${index}' value="${listPeople[i].birthday}" required></td>`
    }
    return content;
}


function showListPeopleInId(id) {
    $.ajax({
        type: "GET",
        url: `${baseUrl}/api/${id}`,
        contentType: "application/json",
        dataType: 'json',
        success: function (event) {
            drawTableBody(event);
        },
        error: function () {
            $('#listPeopleInfo').modal("hide");
            $("#actionStatus").html(`No People live in HouseHold with id is ${id}`);
            $("#statusModal").modal("show");
        }
    })
}

function drawTableBody(data) {
    let bodyData = "";
    for (let i = 0; i < data.length; i++) {
        bodyData += drawRecord(i, data[i]);
    }
    $("#listPeople").html(bodyData);
    $("#listPeopleInfo").modal("show");
}

function drawRecord(index, data) {
    return `<tr><td>${index + 1}</td><td>${data.name}</td><td>${data.cmnd}</td><td>${converterDayCorrect(data.birthday)}</td></tr>`
}

function converterDayCorrect(date) {
    const [year, month, day] = date.split('-');
    return [month, day, year].join('/');
}

async function addPeopleInHouse(id, idHouseHold) {
    $.ajax({
        type: "POST",
        url: `${baseUrl}/api/peoples/${id}/houseHolds/${idHouseHold}`,
        success: function (event) {
            $('#actionStatus').html(`Add new person success!!! hello ${event.name} join in ${idHouseHold}`);
            $('#updateModal').modal("hide");
            $('#statusModal').modal("show");
        },
        error: function (event) {
            controlErrorPerson(event);
        }
    })
}

function createPeople() {
    const idHouseHold = $("#idHouseHold").val();
    const data = {
        cmnd: $("#cmnd-create").val(),
        name: $("#name-create").val(),
        birthday: $("#birthday-create").val(),
    };

    $.ajax({
        type: "POST",
        url: `${baseUrl}/api/peoples`,
        contentType: "application/json",
        dataType: 'json',
        data: JSON.stringify(data),
        success: async function (event) {
            await addPeopleInHouse(event.id, idHouseHold)
        },
        error: function (event) {
            controlErrorPerson(event);
        }
    })
}

function addListPeople(idHousehold) {
    console.log(listPeople);
    for (let i = 0; i < listPeople.length; i++) {
        console.log(listPeople[i]);
        $.ajax({
            type: "POST",
            url: `${baseUrl}/api/peoples`,
            contentType: "application/json",
            dataType: 'json',
            data: JSON.stringify(listPeople[i]),
            success: async function (event) {
                await addPeopleInHouse(event.id, idHousehold)
            },
            error: function (event) {
                controlErrorPerson(event);
            }
        })
    }
}


function controlErrorPerson(data) {
     switch (data.status) {
        case 404:
            $("#actionStatus").html(data.responseJSON.messageError);
            $('#statusModal').modal("show");
            break;
        case 405:
            $("#actionStatus").html(data.responseJSON.message);
            $("#statusModal").modal("show");
            break;
        case 500:
            $("#actionStatus").html(data.responseJSON.message);
            $("#statusModal").modal("show");
            break;
        case 400:
            $("#error-cmnd-create").html(data.responseJSON.cmnd);
            $("#error-name-create").html(data.responseJSON.name);
            $("#error-birthday-create").html(data.responseJSON.birthday);
            break;
    }
}
