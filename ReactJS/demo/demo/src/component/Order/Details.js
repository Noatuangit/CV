import React, { useState } from 'react';
import "../../layout.css";

export default function Details(props) {
    const [data, setData] = useState(props.data)

    const onClick = () => {
        props.onClick();
    }

    return (
        <div className="pop-up-container" onClick={onClick}>
            <div id="pop-up" >
                <div className="text-header">
                    <h1>Details</h1>
                    <table className='table '>
                        <thead className="thead-dark">
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
                                    totals
                                </td>

                            </tr>
                        </thead>
                        <tbody>
                            {
                                data.map((item, index) =>
                                    <tr key={item.name + index}>
                                        <td>
                                            {index + 1}
                                        </td>
                                        <td>
                                            {item.name}
                                        </td>
                                        <td>
                                            {item.price}
                                        </td>
                                        <td>
                                            {item.quantity}
                                        </td>
                                        <td>
                                            ${item.quantity * item.price}
                                        </td>
                                    </tr>)
                            }
                        </tbody>
                    </table>
                    <button className='btn btn-info' onClick={onClick} style={{ marginBottom: "5px" }}>Close</button>
                </div>
            </div>
        </div>
    )
}
