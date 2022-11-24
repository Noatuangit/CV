function validDataPeople(data) {
    let flag = false;
    if (!data.name.match('^[\\w ]+$')) {
        $('#error-people-name').html("name not have number or special text");
        flag = true;
    }
    if (new Date(data.birthday) > new Date()) {
        $('#error-people-date').html("birthday is past or today. not in future!!!");
        flag = true;
    }
    if (!data.cmnd.match('^[\\d]{7}$')) {
        $('#error-people-cmnd').html("cmnd have 7 number not have text");
        flag = true;
    }
    return flag;

}

function addPeopleInId(id) {
    document.getElementById("idHouseHold").value = id;
}

function deleteIdSelect() {
    document.getElementById("deleteAllButton").style.display = "block";
}

window.onload = () => {
    setTimeout(function () {
        document.getElementById("loading").style.display = "none";
        document.getElementById("body").style.display = "block";
    }, 100);
}