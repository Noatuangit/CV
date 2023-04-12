import React, { useState, useRef, useEffect } from 'react'
import Cart from './Cart'

export default function BillMilk(props) {
    const [stateTopping, setTopping] = useState(false);
    const [total, setTotal] = useState(0);
    const [order, setOrder] = useState({ name: "" });
    let [previous, setPrevious] = useState({ name: "", price: 0 });
    const milk = [
        { name: "Green Milk", price: 3 },
        { name: "Pure Milk", price: 4 },
        { name: "Orange Milk", price: 5 },
        { name: "Milk", price: 2 }];

    function onClick() {
        props.onClick({ ...order, total: total.toFixed(2) });
        setOrder({ name: "" });
        setTotal(0);
        setPrevious({ name: "", price: 0 });
    }

    const onClickCart = (data) => {
        setTopping(false);
        setOrder({ ...order, topping: mergerTwoArray(data[0], order.topping) });
        setTotal(total + parseFloat(data[1]))
    }

    const onChangeMilkTea = (e) => {
        let milkChoice = milk.find(x => x.name === e.target.value);
        setOrder({ ...order, name: milkChoice });
        setTotal(total - previous.price + milkChoice.price);
        setPrevious(milkChoice);
    }

    const mergerTwoArray = (topping, toppingOrder) => {
        if (toppingOrder === undefined) return topping.map(x => { return { ...x, quantity: 1 } });
        topping.forEach(element => {
            let flag = true;
            toppingOrder.forEach(item => {
                if (item.name === element.name) {
                    item.quantity += 1;
                    flag = false;
                }
            })
            if (flag) {
                let newElement = { ...element, quantity: 1 };
                toppingOrder.push(newElement);
            }

        });
        return toppingOrder;
    }

    return (
        <div style={{ textAlign: "center" }}>
            <div className={stateTopping ? "colum-wrap" : "colum-wrap-full"}>
                <h1>Choice Milk tea</h1>
                <select value={order.name.name || ""} name="milk" className='form-select form-select-lg mb-3' onChange={onChangeMilkTea}>
                    <option value='' disabled>choice something</option>
                    {milk.map(item =>
                        <option value={item.name} key={item.name + Math.random(100)}>{item.name} have cost ${item.price}</option>)}
                </select>
                {
                    order.name !== "" &&
                    <button
                        className='btn btn-success'
                        onClick={() => setTopping(!stateTopping)}>{stateTopping ? "cancel topping" : "add topping"}
                    </button>}

                {
                    order.topping !== undefined &&
                    <table className='table table-success table-striped' style={{ border: "1px" }}>
                        <thead>
                            <tr>
                                <td>
                                    No.
                                </td>
                                <td>
                                    Name
                                </td>
                                <td>
                                    Price
                                </td>
                                <td>
                                    Quantity
                                </td>
                                <td>
                                    Total
                                </td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>{order.name.name}</td>
                                <td>{order.name.price}</td>
                                <td>1</td>
                                <td>{order.name.price}</td>
                            </tr>
                            {order.topping.map((item, index) =>
                                <tr key={item + Math.random(100000)}>
                                    <td>{index + 2}</td>
                                    <td>{item.name}</td>
                                    <td>{item.price}</td>
                                    <td>{item.quantity}</td>
                                    <td>{item.quantity * item.price}</td>
                                </tr>)}
                        </tbody>
                    </table>
                }
                {
                    total !== 0 && <div><h4>Totals : ${total.toFixed(2)}</h4>
                        <button className='btn btn-info' onClick={() => onClick()}>buy this!</button></div>
                }
            </div>
            {
                stateTopping && <div className="colum-wrap">
                    <Cart onClick={onClickCart} />
                </div>
            }

        </div>
    )
}
