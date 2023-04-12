import React, { useEffect, useState } from 'react'
export default function Form(props) {
    const [target, setTarget] = useState({ id: props.id, name: props.name, address: props.name, phone: props.phone, age: props.age });
    const [stateValidForm, setValidForm] = useState({ emptyName: false, emptyPhone: false, emptyAge: false, emptyAddress: false, wrongName: false, wrongAddress: false, wrongPhone: false, wrongAge: false });

    const handleSubmit = (event) => {
        event.preventDefault();
        const dataForm = Object.fromEntries(new FormData(event.target));
        let defaultValid = ({ emptyName: false, emptyPhone: false, emptyAge: false, emptyAddress: false, wrongName: false, wrongAddress: false, wrongPhone: false, wrongAge: false });
        let result = validFormData(defaultValid, dataForm);
        if (result[1]) {
            props.handleSubmit(dataForm);
        }
        setValidForm(result[0]);
    }

    const validFormData = (defaultValid, dataForm) => {
        const validResult = [defaultValid, true];
        if ((dataForm.name).match(/[0-9]/)) {
            validResult[0].wrongName = true;
            validResult[1] = false;
        }
        if ((dataForm.name + "").trim() == '') {
            validResult[0].emptyName = true;
            validResult[1] = false;
        }
        if ((dataForm.address).match(/[0-9]/)) {
            validResult[0].wrongAddress = true;
            validResult[1] = false;
        }
        if ((dataForm.address + "").trim() == '') {
            validResult[0].emptyAddress = true;
            validResult[1] = false;
        }
        if (!/^[0-9]+$/.test(dataForm.age)) {
            validResult[0].wrongAge = true;
            validResult[1] = false;
        }
        if (!/^[0-9]{10}$/.test(dataForm.phone)) {
            validResult[0].wrongPhone = true;
            validResult[1] = false;
        }
        return validResult;
    }

    useEffect(() => {
        setTarget(props.target)
    }, [props]);

    const clearForm = () => {
        setTarget(props.target)
        setValidForm({ emptyName: false, emptyPhone: false, emptyAge: false, emptyAddress: false, wrongName: false, wrongAddress: false, wrongPhone: false, wrongAge: false });
    }

    function handleChange(e) {
        setTarget({ ...target, [e.target.name]: e.target.value })
    }

    return (
        <form className="row g-3 needs-validation" id="formCreate" noValidate onSubmit={handleSubmit}>
            <table>
                <tbody>
                    <tr>
                        <td><label htmlFor="validationCustom01" className="form-label">Name</label></td>
                        <td ><input type="text"
                            className="form-control"
                            id="validationCustom01"
                            name="name"
                            onChange={(e) => { handleChange(e) }}
                            defaultValue={target.name}
                            required /></td>
                        <input type="text"
                            className="form-control"
                            defaultValue={target.id == "" ? Date.now() : target.id}
                            id="validationCustom01"
                            hidden
                            name="id"></input>
                        {stateValidForm.wrongName && <td style={{ color: 'red' }}>Name must text.</td>}
                        {stateValidForm.emptyName && <td style={{ color: 'red' }}>Name must required.</td>}
                    </tr>
                    <tr>
                        <td>
                            <label htmlFor="validationCustom02" className="form-label">Age</label>
                        </td>
                        <td >
                            <input type="text"
                                className="form-control"
                                defaultValue={target.age}
                                onChange={(e) => { handleChange(e) }}
                                id="validationCustom02"
                                name="age"
                                required />
                        </td>
                        {stateValidForm.wrongAge && <td style={{ color: 'red' }}>Age must number and bigger zero.</td>}
                    </tr>

                    <tr>
                        <td>
                            <label htmlFor="validationCustomUsername" className="form-label">address</label>
                        </td>
                        <td >
                            <input type="text"
                                name="address"
                                className="form-control"
                                onChange={(e) => { handleChange(e) }}
                                defaultValue={target.address}
                                id="validationCustomUsername" />
                        </td>
                        {stateValidForm.wrongAddress && <td style={{ color: 'red' }}>Address must text.</td>}
                        {stateValidForm.emptyAddress && <td style={{ color: 'red' }}>Address must required.</td>}
                    </tr>

                    <tr>
                        <td>
                            <label htmlFor="validationCustom03" className="form-label">Phone</label>
                        </td>
                        <td >
                            <input
                                type="text"
                                className="form-control"
                                name='phone'
                                id="validationCustom03"
                                onChange={(e) => { handleChange(e) }}
                                value={target.phone} />
                        </td>
                        {stateValidForm.wrongPhone && <td style={{ color: 'red' }}>Phone must number and 10 number.</td>}
                    </tr>
                    <tr>
                        <td>
                            <button className="btn btn-primary" type="submit">{target.id == "" ? "Submit" : "Update"}</button>
                        </td>
                        <td>
                            <button className="btn btn-warning" type="reset" onClick={clearForm}>Reset</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    )
}
