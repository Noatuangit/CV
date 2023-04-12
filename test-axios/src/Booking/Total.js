import React, { useMemo, useState } from 'react'
import { totalRest } from '../utils/UrlPack';
import "./layout.css"
import axios from 'axios';
import Page from '../utils/Page';
export default function Total() {
    const [state, setState] = useState({ data: { content: [] } });

    useMemo(() => {
        axios.get(totalRest).then(resp => setState(resp));
    }, []);

    function handleClick(page) {
        axios.get(`${totalRest}?p=${page}`).then(res => {
            setState(res);
        })
    };

    function converterSecondToDate(second) {
        if (second == null) return "N/A";
        const date = new Date(second);
        return `${date.getDate()}/${date.getMonth() + 1}/${date.getFullYear()}`;
    }
    return (
        <div>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <td>ID customer</td>
                        <td>Name customer</td>
                        <td>Computer Id</td>
                        <td>Computer Position</td>
                        <td>Computer Status</td>
                        <td>Date Begin computer</td>
                        <td>Time Begin computer</td>
                        <td>Time Use Computer</td>
                        <td>Service Name</td>
                        <td>Date Service</td>
                        <td>Time Service</td>
                        <td>Amount</td>
                        <td>Total</td>
                    </tr>
                </thead>
                <tbody>
                    {state.data.content.map(item =>
                        <tr key={item[0] + Math.random()}>
                            <td>{item[0]}</td>
                            <td>{item[1]}</td>
                            <td>{item[2] ?? "N/A"}</td>
                            <td>{item[3] ?? "N/A"}</td>
                            <td>{item[4] ?? "N/A"}</td>
                            <td>{converterSecondToDate(item[5]) ?? "N/A"}</td>
                            <td>{item[6] ?? "N/A"}</td>
                            <td>{item[7] ?? "N/A"}</td>
                            <td>{item[8] ?? "N/A"}</td>
                            <td>{converterSecondToDate(item[9]) ?? "N/A"}</td>
                            <td>{item[10] ?? "N/A"}</td>
                            <td>{item[11] ?? "N/A"}</td>
                            <td>{item[12] ?? "N/A"}</td>
                        </tr>)}
                </tbody>
            </table>
            <Page
                totalPages={state.data.totalPages}
                number={state.data.number}
                handleClick={handleClick}
            />
        </div>
    )
}
