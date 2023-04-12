import React, { useEffect, useState } from 'react'

export default function FormRole(props) {
    const [state, setState] = useState([]);
    const [valid, setValid] = useState({ emptyUser: false, emptyRole: false })
    const danger = { color: "red" }
    const onSubmit = (e) => {
        e.preventDefault();
        const formData = Object.fromEntries(new FormData(e.target));
        let valid = validData(formData);
        if (valid[1]) {
            props.handleRole(formData);
            document.getElementById("formCreate").reset();
        }
        setValid(valid[0]);
    }

    useEffect(() => {
        setState(props.data.filter(x => x.status == "Active"));
    }, [])

    const validData = (dataForm) => {
        let target = { emptyUser: false, emptyRole: false };
        let flag = true;
        if (dataForm.user === '') {
            target.emptyUser = true;
            flag = false;
        }
        if (dataForm.role === '') {
            target.emptyRole = true;
            flag = false;
        }
        return [target, flag];
    }

    return (
        <div>
            <form onSubmit={onSubmit} id="formCreate">
                <div className="row">
                    <div className="col-md-6 mb-4">
                        <div className="form-outline datepicker">
                            <label htmlFor="userName" className="form-label">User Name</label>
                            {valid.emptyUser && <span style={danger}> not empty user</span>}
                            <select name="user" className="form-select mb-3" defaultValue="">
                                <option value="">--choice username--</option>
                                {
                                    state.map(item =>
                                        <option value={item.username} key={item.username + item.email}>
                                            {item.username}
                                        </option>)
                                }
                            </select>
                            <button className='btn btn-success'>Submit</button>

                        </div>

                    </div>
                    <div className="col-md-6 mb-4">
                        <label htmlFor="status" className="form-label">Roles</label>
                        {valid.emptyRole && <span style={danger}> not empty roles</span>}
                        <select className="form-select mb-3" name="role">
                            <option value="">--choice roles--</option>
                            <option value="Support">Support</option>
                            <option value="Developer">Developer</option>
                            <option value="Manager">Manager</option>
                        </select>
                    </div>

                </div>
            </form>
        </div>
    )
}
