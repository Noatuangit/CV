import React, { useEffect, useState } from 'react';
import validationCustom from './ValidationCustom';
export default function FormCreate(props) {
    let data = props.data;
    const [tableValidation, setTableValidation] = useState({});
    const selectValue = ["Active", "NoActive"];
    const danger = { color: "red" };
    const onSubmit = (e) => {
        e.preventDefault();
        let formData = Object.fromEntries(new FormData(e.target));
        let checkValid = validationCustom(formData);
        if (checkValid[1]) {
            document.getElementById("formCreate").reset();
            setTableValidation([]);
            props.onSubmit(targetSaveInTable(formData));
            return;
        }
        setTableValidation(checkValid[0])
    }
    const targetSaveInTable = (formData) => {
        if (formData.status == undefined) {
            return { ...formData, status: "Active" }
        }
        return formData;
    }


    useEffect(() => {

    }, [])
    return (
        <div>
            <form onSubmit={onSubmit} id="formCreate">
                <div className="row">
                    <div className="col-md-6 mb-4">
                        <div className="form-outline datepicker">
                            <label htmlFor="userName" className="form-label">User Name</label>
                            {tableValidation.requiredUsername !== undefined && <span style={danger}> no empty</span>}
                            {tableValidation.patternUsername !== undefined && <span style={danger}> no have number</span>}
                            <input type="text" className="form-control" name="username" id="userName" defaultValue={data.username} />
                            <input hidden className="form-control" name="id" id="id" defaultValue={data.id == "" ? Date.now() : data.id} />
                        </div>

                    </div>
                    <div className="col-md-6 mb-4">
                        <label htmlFor="status" className="form-label">Status</label>
                        {tableValidation.requiredStatus !== undefined && <span style={danger}> no empty</span>}
                        <select
                            defaultValue={data.status}
                            className="form-select mb-3"
                            id="status"
                            name="status"
                            aria-label=".form-select-lg example">
                            <option value=''>Open this select menu</option>
                            {selectValue.map(item => <option key={item + Math.random(1000)}
                                value={item}
                                selected={item == data.status}
                                disabled={data.status == "Active"}>{item}</option>)}
                        </select>
                    </div>
                </div>

                <div className="mb-4">
                    <label htmlFor="email" className="form-label">Email</label>
                    {tableValidation.requiredEmail !== undefined && <span style={danger}> no empty</span>}
                    {tableValidation.patternEmail !== undefined && <span style={danger}> no correct type email</span>}
                    <input type="text" name="email" className="form-control" id="email" defaultValue={data.email} />
                </div>
                <button type='submit' className='btn btn-success'>{data.id == "" ? "Submit" : "Update"}</button>
            </form >

        </div >
    )
}
