import React, { useEffect, useState } from 'react'

export default function Cart(props) {
    const [topping, setPopping] = useState([
        { name: "Capsicum", price: 1 },
        { name: "Panner", price: 0.5 },
        { name: "Red Paprika", price: 0.4 },
        { name: "Onions", price: 0.2 },
        { name: "Extra Cheese", price: 0.7 },
        { name: "Baby Corn", price: 0.6 },
        { name: "Extra Milk", price: 0.25 },
        { name: "Coca", price: 1.25 },
        { name: "Mushroom", price: 2 }
    ]);

    const [check, setCheckState] = useState(new Array(topping.length).fill(false));

    const [total, setTotals] = useState(0);

    const handleOnChange = (position) => {
        let checkList = check.map((item, index) => {
            if (index === position) return !item;
            return item;
        })
        setCheckState(checkList);
        setTotals(calculator(checkList).toFixed(2));
    }

    const calculator = (checkList) => {
        return checkList.reduce((sums, currentItem, index) => {
            if (currentItem) return sums += topping[index].price;
            return sums;
        }, 0);

    }

    const getListChoice = () => {
        return topping.filter((item, index) => {
            if (check[index]) return true;
            return false;
        });
    }

    const choiceList = () => {
        let choiceTopping = [getListChoice(), total];
        props.onClick(choiceTopping);
        setTotals(0);
        setCheckState(new Array(topping.length).fill(false));
    }

    useEffect(() => {

    }, [topping, total, check])
    return (
        <div style={{ textAlign: "center" }}>
            <h1>Select Topping  {total !== 0 &&
                <button className='btn btn-success'
                    onClick={choiceList}>Add On</button>} </h1>
            <div className="divCart">
                <table>
                    <thead>
                    </thead>
                    <tbody>
                        {topping.map((x, index) =>
                            <tr key={x.name + Math.random(1000)}>
                                <td>
                                    <input
                                        id={`custom-checkbox-${index}`}
                                        type="checkbox"
                                        name="topSelect"
                                        checked={check[index]}
                                        onChange={() => handleOnChange(index)}
                                        defaultValue={index}
                                    />
                                </td>
                                <td>
                                    {x.name}
                                </td>
                                <td>
                                    ${x.price}
                                </td>
                            </tr>
                        )}
                    </tbody>
                </table>

            </div>
            <h4>Totals :  ${total}</h4>
        </div>
    )
}
