let url = "http://localhost:8080/ATJB2";
let customers = [];


$(document).ready(function () {
    $('#createButton').on("click", function () {
        createForm();
    });
    $('#customer').on("keyup", function () {
        showName();
    });
    $('#save').on("click", function () {
        save();
    });
    $('#deleteItem').on("click", function () {
        deleteItem();
    });
    $("#createModal").on('hide.bs.modal', function () {
        clearValid();
        document.getElementById("form").reset();
    });
});

function createForm() {
	console.log(window.location.href);
    let computer = fetch(`${url}/api/computer`).then(resp => resp.json());
    let customer = fetch(`${url}/api/customer`).then(resp => resp.json());
    Promise.all([customer, computer])
        .then(resp => {
            customers = resp[0];
            $("#computer").html(displaySelectComputer(resp[1]));
        })
}

function displaySelectComputer(array) {
    return '<option value="" disabled selected>choice something</option>' + array.map(x => `<option value="${x.id}">${x.position} with status ${x.status}</option>`).join('');
}

function showName() {
    let id = $("#customer").val().toUpperCase()
    let customer = customers.filter(x => x.id === id);
    let string = customer.length === 0 ? "Not found customer name with id " + id : customer[0].name;
    $('#name-customer').val(string);
}

function save() {
    fetch(`${url}/api`, {
        method: "POST",
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(getDataInForm())
    }).then(resp => {
        if (resp.status === 200) {
            window.location = `${url}/managerComputer`;
            return;
        }
        return Promise.reject(resp);
    }).then(resp => {
        managerError(resp);
    })
        .catch(error => {
            error.json().then((json) => {
                managerError(json);
            })
        })
}

function managerError(error) {
    $('#errorCustomer').html(error.customer_id);
    $('#errorComputer').html(error.computer_id);
    $('#errorDate').html(error.date_begin);
    $('#errorTimeBegin').html(error.time_begin);
    $('#errorTimeUse').html(error.timeUse);
}

function getDataInForm() {
     return {
        customer_id: $("#customer").val().toUpperCase(),
        computer_id: $("#computer").val(),
        date_begin: $("#dateBegin").val(),
        time_begin: $("#timeBegin").val(),
        timeUse: $("#timeUse").val(),
    }
}

function clearValid() {
    $('#errorCustomer').html("");
    $('#errorComputer').html("");
    $('#errorDate').html("");
    $('#errorTimeBegin').html("");
    $('#errorTimeUse').html("");
}


function deleteItem() {
    let dto = {
        customer_id: $('#delete_cus_id').val(),
        computer_id: $('#delete_com_id').val(),
        date_begin: $('#delete_date').val(),
        time_begin: $('#delete_time').val().substring(0, 5),
        timeUse: $('#delete_timeUses').val(),
    }
    fetch(`${url}/comDetails/delete`, {
        method: "POST",
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dto)
    })
        .then(resp => {
            console.log(resp);
           if(resp.status === 200){
               window.location = `${url}/managerComputer`;
           }
        })
}
