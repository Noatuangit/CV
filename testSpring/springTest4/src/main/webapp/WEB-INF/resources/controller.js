let map = new Map([]);

function change(event) {
    let id = event.target.id;
    validField(id, event.target.value.trim(), map);
    if (Array.from(map).every(x => x[1] === true)) {
        document.getElementById(id + "Error").innerText = "";
        document.getElementById("button-submit").disabled = false;
        return;
    }
    document.getElementById(id + "Error").innerText = map.get(id) === true ? "" : map.get(id);
    document.getElementById("button-submit").disabled = true;
}

function validField(id, value, map) {
    value === '' ? map.set(id, "Bạn cần nhập dữ liệu") : map.set(id, true);
    if (id === "phone") document.getElementById('existsPhone').style.display = 'none';
    if (id === "idCard") document.getElementById('existsIdCard').style.display = 'none';
    if (id === "carId") document.getElementById('existsCarId').style.display = 'none';
    if (id === "dayBegin" && value !== '') {
        // console.log(document.getElementById("dayBegin").value)
        // console.log(new Date().toISOString());
        // console.log(document.getElementById("dayBegin").value < new Date().toISOString())
        if (document.getElementById("dayBegin").value < new Date().toISOString()) {
            map.set(id, " phai lon hon hien tai");
            return;
        }
        map.set(id, true);
    }

    if (id === "dayTest") {
        if (value === "" && document.getElementById("result").value.trim() !== "") {
            map.set(id, "ban can nhap du lieu cho truong nay");
            return;
        }
        if (value === "") {
            map.set(id, "Bạn cần nhập dữ liệu");
            return;
        }
        map.set(id, true);
    }
}

window.onload = () => {
    // console.log(new Date().toDateString());
    // console.log(new Date().toLocaleString());
    // console.log(new Date().toISOString());
    // console.log(new Date().toString());
    let formData = Object.fromEntries(new FormData(document.querySelector("form")));
    for (let key of Object.keys(formData)) {
        document.getElementById(key).value === '' ? map.set(key, false) : map.set(key, true);
    }
    if (Array.from(map).every(x => x[1] === true)) {
        document.getElementById("button-submit").disabled = false;
    }

}



