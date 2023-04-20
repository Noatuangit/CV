let valid = new Map();
document.getElementById("form").addEventListener("submit", function (e) {
    alert("here")
    e.preventDefault();
    let formData = Object.fromEntries(new FormData(e.target));
    resetValid(valid);
    validForm(formData, valid);
    if (valid.size > 0) {
        renderMapError(valid);
        return;
    }
    document.getElementById("form").submit();
})

function renderMapError(valid) {
    for (const [key, value] of valid.entries()) {
        document.getElementById(key).innerText = value;
    }
}

function resetValid(valid) {
    for (const [key] of valid.entries()) {
        document.getElementById(key).innerText = "";
    }
    valid.clear();
}

function validForm(data, mapValid) {
    let currentValue = "";
    let idError = "";
    for (let i of Object.keys(data)) {
        currentValue = document.getElementById(i).value;
        idError = i + "Error";
        if (i === "id") continue;

        if (currentValue.trim() === "") {
            mapValid.set(idError, "Không được để trống");
            continue;
        }

        if (i === "phone") {
            if (!/^0[0-9]{9}$/.test(currentValue)) {
                mapValid.set(idError, "Số điện thoại không phù hợp.");
                continue;
            }
        }

        if (i === "numberMonth") {
            if (0 > +currentValue || 12 < +currentValue) {
                mapValid.set(idError, "Số tháng không phù hợp");
                continue;
            }
        }

        if (i === "area") {
            if (0 > +currentValue) {
                mapValid.set(idError, "Số diện tích lớn hơn 0");
                continue;
            }
        }

        if (document.getElementById("dayEnd").value < document.getElementById("monthJoin").value) {
            mapValid.set("dayEndError", "Ngày trả tiền sau ngày nhận phòng.");
        }
    }
}