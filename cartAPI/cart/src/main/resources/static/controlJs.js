const listCart = [];
const baseUrl = window.location.origin;
$(document).ready(function () {
    $('button[id^="product"]').on("click", function (event) {
        event.preventDefault();
        addListCart(this.id);
    })

    $('#buyIt').on('click', function () {
        loginAndBuyIt();
    })
})

function loginAndBuyIt() {
    const nameLogin = $('#nameLogin').val();
    const emailLogin = $('#emailLogin').val();
    const dataObj = {
        name: nameLogin,
        email: emailLogin,
    }

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "post",
        url: baseUrl + "/api/getCustomer",
        data: JSON.stringify(dataObj),
        success: async function (order) {
            saveCartInCustomer(order);
        },
        error: function () {
            document.getElementById("info").innerText = "Not Found!!!";
            $('#doSomething').modal('show');
        }
    })
}


function saveCartInCustomer(order) {
    const dataObj = {
        data: converterToJsonOfCart(listCart)
    }

    console.log(JSON.stringify(dataObj));

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "post",
        url: baseUrl + "/api/saveOrder",
        data: JSON.stringify(dataObj),
        success: function () {
            document.getElementById("info").innerText = "Buy Success";
            $('#doSomething').modal('show');
            listCart.length = 0;
            document.getElementById("cart").style.display = "none";
        },
        error: function () {
            console.log("error");
        }
    })
}

function addListCart(id) {
    const idProduct = id.split("product");
    const idAmount = "#amount" + idProduct[1];
    const idPrice = "#price" + idProduct[1];
    const idName = "#name" + idProduct[1];
    const amountBook = $(idAmount).val();
    const price = $(idPrice).val();
    const nameProduct = $(idName).val();
    if (amountBook === "") {
        document.getElementById("info").innerText = "Buy Something";
        $('#doSomething').modal('show');
        return;
    }
    document.getElementById("cart").style.display = "block";

    const data = {
        product: {
            id: idProduct[1],
            name: nameProduct,
        },
        quantity: amountBook,
        money: parseInt(amountBook) * parseFloat(price),
    }

    addData(listCart, data);
    document.getElementById("body").innerHTML = drawRecord(listCart);
    document.getElementById("total").innerText = calculatorMoney(listCart);
    return listCart;
}

function addData(listCart, data) {
    for (let i = 0; i < listCart.length; i++) {
        if (listCart[i].product.id === data.product.id) {
            listCart[i].quantity = parseInt(listCart[i].quantity) + parseInt(data.quantity);
            listCart[i].money = parseFloat(data.money) + parseFloat(listCart[i].money);
            return;
        }
    }
    listCart.push(data)
}

function converterToJsonOfCart(list) {
    const data = [];
    for (let i = 0; i < list.length; i++) {
        const current = {

            product: list[i].product.id,
            quantity: list[i].quantity,
            money: list[i].money,
        }
        data.push(current);
    }
    return data;
}

function calculatorMoney(listCart) {
    let current = 0;
    for (let i = 0; i < listCart.length; i++) {
        current += parseFloat(listCart[i].money);
    }
    return current.toFixed(2);
}

function drawRecord(listCart) {
    let row = '';
    let current = 0;
    for (let i = 0; i < listCart.length; i++) {
        row += `<tr><td>${++current}</td><td>${listCart[i].product.name}</td>
        <td>${listCart[i].quantity}</td><td>${listCart[i].money}</td></tr>`;
    }
    return row;
}
