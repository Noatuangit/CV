let map = new Map([]);

function change(event) {
    let id = event.target.id;
    validField(id, event.target.value.trim(), map);
    if (Array.from(map).every(x => x[1] === true) && map.size >= 7) {
        document.getElementById(id + "Error").innerText = "";
        document.getElementById("button-submit").disabled = false;
        return;
    }
    document.getElementById(id + "Error").innerText = map.get(id) === true ? "" : map.get(id);
    document.getElementById("button-submit").disabled = true;

}

function validField(id, value, map) {
    value === '' ? map.set(id, "Bạn cần nhập dữ liệu") : map.set(id, true);
    if (id === "statusOrder") {
        if (document.getElementById("statusCheckOut").value.toLowerCase() !== "da thanh toan"
            && document.getElementById("statusOrder").value.toLowerCase() === "da giao hang") {
            document.getElementById("statusCheckOutError").innerText = "phải thanh toán trước khi nhận hàng";
            return;
        }
        map.set(id, true);
    }
    if (id === "money" && value !== "") {
        if (value <= 0) {
            map.set(id, "Số tiền phải lớn hơn 0.");
            return;
        }
        map.set(id, true);
    }
    if (id === "dateEnd" && value !== "") {
        if (document.getElementById("dateEnd").value < document.getElementById("dateOrder").value) {
            map.set(id, "Số ngày hẹn trả phải lớn hơn ngày đặt hàng.");
            return;
        }
        map.set(id, true);
    }

}

function renderList(items) {
    if (items !== "") {
        document.getElementById("body").innerHTML = items;
        return;
    }
    document.getElementById("body").innerHTML = "<tr><td colspan='4' style='text-align: center'>No details</td></tr>"
}