import React, { useState } from 'react'
import '../../App.css'
import './Customer.css'
import FormCreate from './FormCreate';
import Table from './Table';
import RoleTable from './RoleTable';
import FormRole from './FormRole';

export default function Customer() {
    const [stateForm, setStateForm] = useState(true);
    const [tableDisplay, setTableDisplay] = useState([]);
    const [tableRole, setTableRoles] = useState([]);
    const [target, setTarget] = useState({ id: "", username: "", email: "", status: "" });
    const onSubmit = (data) => {
        if (target.id === "") {
            setTableDisplay([...tableDisplay, data]);
        } else {
            setTableDisplay([...tableDisplay.map(x => x.id === target.id ? data : x)])
        }
        setTarget({ id: "", username: "", email: "", status: "" });
    }

    const handleRole = (data) => {
        setTableRoles([...tableRole, data])
    }

    const onClick = (data) => {
        setTarget(data);
        setStateForm(true);
    }

    function changeCreateForm() {
        setStateForm(true);
        setTarget({ id: "", username: "", email: "", status: "" });
    }


    return (
        <div>
            <div className='main'>
                <div className="wrap-item-left">
                    <h1>Menu item</h1>
                    <button
                        onClick={() => changeCreateForm()}
                        className={stateForm ? "btn btn-info" : "btn btn-second"}
                        style={{ marginTop: "10px" }}>
                        User Manager
                    </button>
                    <button
                        onClick={() => setStateForm(false)}
                        className={stateForm ? "btn btn-second" : "btn btn-info"}
                        style={{ marginTop: "10px" }}>Role Manager</button>
                </div>
                <div className="wrap-item-right">
                    <h1>User Form</h1>
                    {stateForm && <FormCreate
                        data={target}
                        onSubmit={onSubmit} />}
                    {!stateForm && <FormRole
                        data={tableDisplay}
                        handleRole={handleRole} />}
                </div>

            </div>
            {stateForm && <Table data={tableDisplay} onClick={onClick} />
            }
            {!stateForm && <RoleTable data={tableRole} onClick={onClick} />
            }
        </div>
    )
}
