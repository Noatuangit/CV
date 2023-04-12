import React from 'react'
import './File.css'
export default function Modal(props) {
    const onClick = () => {
        props.onClick()
    }
    return (
        <div className="pop-up-container" >
            <div id="pop-up" >
                <div className="text-header">
                    <h1>Details</h1>
                    <table className='table '>
                        <thead className="thead-dark">
                            <tr>
                                <td><h1>Setting</h1></td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Option1</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>Option2</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td> </td>
                                <td> <button className='btn btn-info' onClick={onClick} style={{ marginBottom: "5px", marginLeft: "0px" }}>Apply</button></td>
                            </tr>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    )
}
