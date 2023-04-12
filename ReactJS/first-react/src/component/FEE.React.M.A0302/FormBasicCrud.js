import React, { useCallback, useEffect, useState } from 'react'
import Form from './Form';
import "./style.css"
import PageView from './PageView';
export default function FormBasicCrud() {
    const [stateTable, setMainTable] = useState([]);
    const [displayTable, setDisplayTable] = useState([]);
    const [stateDisplay, setDisplay] = useState({ form: false })
    const [target, setTarget] = useState({});
    const [editFast, setEditFast] = useState({});

    const handleSubmit = (data) => {
        setDisplay({ form: false })
        if (target.id === "") {
            setMainTable([...stateTable, data]);
            return;
        }
        setMainTable(stateTable.map(x => x.id === data.id ? data : x));
    }

    const transferForm = useCallback(() => {
        setDisplay({ form: true });
        setTarget({ id: "", name: "", phone: "", address: "", age: "" });
        setEditFast({ id: "", name: "", phone: "", address: "", age: "" });
    }, [target]);

    function handleClick(page) {
        setDisplayTable([...stateTable].slice(page, page + 2));
    }

    function edit(data) {
        setDisplay({ form: true });
        setEditFast({ id: "", name: "", phone: "", address: "", age: "" });
        setTarget({ id: data.id, name: data.name, phone: data.phone, address: data.address, age: data.age })
    }

    function deleteById(id) {
        setMainTable([...stateTable].filter(x => x.id !== id));
    }

    function editItemFast(x) {
        setEditFast(x);
        setDisplay({ form: false });
    }

    function handleChange(e) {
        setEditFast({ ...editFast, [e.target.name]: e.target.value })
    }

    const submitEditFast = () => {
        setMainTable(stateTable.map(x => x.id === editFast.id ? editFast : x));
        setEditFast({ id: "", name: "", phone: "", address: "", age: "" });
    }

    useEffect(() => {
        setDisplayTable([...stateTable].slice(0, 2));
    }, [stateTable, target]);

    return (
        <div className='container' >
            <div className='wrap-item-left' >
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th>
                                Id
                            </th>
                            <th>
                                Name
                            </th>
                            <th>
                                Address
                            </th>
                            <th>
                                Action
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        {displayTable.map((x, index) => {
                            if (editFast.id === x.id) {
                                return <tr key={x.id} onDoubleClick={() => editItemFast(x)}>
                                    <td>
                                        {index + 1}
                                    </td>
                                    <td>
                                        <input name="name"
                                            defaultValue={editFast.name}
                                            onChange={(e) => { handleChange(e) }}
                                        ></input>
                                    </td>
                                    <td>
                                        <input name="address"
                                            onChange={(e) => { handleChange(e) }}
                                            defaultValue={editFast.address} />
                                    </td>
                                    <td>
                                        <button className='btn btn-warning' onClick={submitEditFast}> <i className="fa-regular fa-pen-to-square"></i></button>
                                    </td>
                                </tr>

                            } else {
                                return <tr key={x.id} onDoubleClick={() => editItemFast(x)}>
                                    <td>
                                        {index + 1}
                                    </td>
                                    <td>
                                        {x.name}
                                    </td>
                                    <td>
                                        {x.address}
                                    </td>
                                    <td>
                                        <button className='btn btn-warning' onClick={() => edit(x)}> <i className="fa-regular fa-pen-to-square"></i></button>
                                        <button className='btn btn-danger' onClick={() => deleteById(x.id)}> <i className="fa-solid fa-eraser"></i></button>
                                    </td>
                                </tr>
                            }
                        }
                        )
                        }
                    </tbody>
                </table>
                {stateTable.length > 0 && <PageView list={stateTable} handleClick={handleClick} />}
                <button className='btn btn-outline-success' onClick={transferForm}>
                    Create
                </button>
            </div>
            <div className='wrap-item-right'>
                {stateDisplay.form && <Form target={target} handleSubmit={handleSubmit} />}
            </div>
        </div>
    )
}


