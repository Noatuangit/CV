let map = new Map([["name", false],
    ["typeId", false],
    ["persons", false],
    ["children", false],
    ["dateOrder", false],
    ["timeIn", false],
    ["phone", false]]);

function change(event) {
    let id = event.target.id;
    let value = event.target.value.trim();
    validField(id, value, map);
    if (Array.from(map).every(x => x[1] === true)) {
        document.getElementById("button-submit").disabled = false;
        return;
    }
    document.getElementById(id + "Error").innerText = map.get(id) === true ? "" : map.get(id);
    document.getElementById("button-submit").disabled = true;
}

function validField(id, value, map) {
    value === '' ? map.set(id, id + " not null") : map.set(id, true);
    if (id === 'persons' || id === 'children') {
        if (value < 0) {
            map.set(id, id + " must bigger zero.");
            return;
        }
        map.set(id, true);
        return;
    }
    if (id === "phone") {
        if (!/^0[0-9]{9}$/.test(value)) {
            map.set(id, id + " not correct type.");
            return;
        }
        map.set(id, true);
    }
}