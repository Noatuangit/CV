import React, { useState } from 'react';
import '../../App.css';
import BillMilk from './BillMilk';
import Details from './Details';
import '../../layout.css'

export default function OrderManager() {
    const [dataList, setDataList] = useState([]);
    const [details, setDetails] = useState([]);
    const onClick = (data) => {
        setDataList([...dataList, { ...data, date: new Date().toLocaleString() + "" }]);
    }

    function showInfoItem(item) {
        setDetails(item);
    }

    const handleModal = () => {
        setDetails([]);
    }

    const styleTD = { height: "60px" }
    return (
        <div className="App main">
            <div className="wrap-item">
                <h1>Đơn hàng trong ngày</h1>
                <table className='table'>
                    <thead>
                        <tr>
                            <td>
                                No.
                            </td>
                            <td>
                                Name
                            </td>
                            <td>
                                Time Buy
                            </td>
                            <td>
                                Total Price
                            </td>
                            <td>
                                Add On
                            </td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            dataList.map((item, index) =>
                                <tr key={item.name.name + item.total + Math.random(10000)}>
                                    <td style={styleTD}>{index + 1}</td>
                                    <td style={styleTD}>{item.name.name}</td>
                                    <td style={styleTD}>{item.date}</td>
                                    <td style={styleTD}>${item.total}</td>
                                    <td style={styleTD}>
                                        {item.topping !== undefined &&
                                            <button className='btn btn-outline-info' onClick={() => showInfoItem(item.topping)}>
                                                <img src='./info.png' alt='no load'>
                                                </img>
                                            </button>}
                                    </td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
            <div className="wrap-item warp-item-left">
                <BillMilk onClick={onClick} />
            </div>
            {details.length !== 0 && <Details data={details} onClick={handleModal} />}
        </div>
    )
}
