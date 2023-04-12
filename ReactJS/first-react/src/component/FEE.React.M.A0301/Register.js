import React, { useState, useEffect } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { Nav } from 'react-bootstrap'

export default function Register(props) {
    const valid = { color: "red" };
    const navigate = useNavigate();
    const [validState, setStateValid] = useState([{ wrongEmail: false }, { emptyEmail: false }, { emptyUsername: false }, { wrongUsername: false }, { emptyPassword: false }, { wrongPassword: false }]);
    const [data, setData] = useState([]);
    const getData = () => {
        fetch('./dataUser.json'
            , {
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                }
            }).then(function (response) {
                return response.json();
            }).then(function (myJson) {
                setData(myJson);
            });
    }

    useEffect(() => {
        getData()
    }, [])



    const validData = (data) => {
        const valid = [
            { wrongEmail: false },
            { emptyEmail: false },
            { emptyUsername: false },
            { wrongUsername: false },
            { emptyPassword: false },
            { wrongPassword: false }];

        let flag = true;

        if (data.username === '') {
            valid[2].emptyUsername = true;
            flag = false;
        };

        if (!/^[A-Za-z0-9-.]+@([A-Za-z0-9-]+\.)+[A-Za-z0-9-]{2,4}$/.test(data.email) && data.email !== '') {
            valid[0].wrongEmail = true;
            flag = false;
        }

        if (data.email === '') {
            valid[1].emptyEmail = true;
            flag = false;
        }

        if (!/^[A-Za-z0-9 ]+$/.test(data.username) && data.username !== '') {
            valid[3].wrongUsername = true;
            flag = false;
        }

        if (data.password === '') {
            valid[4].emptyPassword = true;
            flag = false;
        }

        if (data.rePassword !== data.password) {
            valid[5].wrongPassword = true;
            flag = false;
        }
        setStateValid(valid);
        return flag;
    }

    const onSubmit = (e) => {
        e.preventDefault();
        const dataForm = (Object.fromEntries(new FormData(e.target)));
        if (validData(dataForm)) {
            setData([...data, dataForm]);
            navigate('/formController', {
                state: { data: dataForm },
            });
        }
    }

    return (
        <div className="center">
            <div className="text-header">
                <h1>Register</h1>
            </div>
            <form method="post" id="form-register" autoComplete='false' onSubmit={onSubmit}>
                <div className="txt_field">
                    <input type="text" name="username" />
                    <label>Username</label>
                    {validState[3].wrongUsername && <span id="username-pattern" style={valid}>không được có kí tự đặc biệt!!!</span>}
                    {validState[2].emptyUsername && <span id="username-required" style={valid}>không được để trống!!!</span>}
                </div>

                <div className="txt_field">
                    <input type="text" name="email" />
                    <label>E-mail</label>
                    {validState[0].wrongEmail && <span id="email-pattern" style={valid}>không đúng định dạng!!!</span>}
                    {validState[1].emptyEmail && <span id="email-required" style={valid}>không được để trống!!!</span>}
                </div>

                <div className="txt_field">
                    <input type="password" name="password" />
                    <label>Password</label>
                    {validState[4].emptyPassword && <span id="password-required" style={valid}>không được để trống!!!</span>}
                </div>
                <div className="txt_field">
                    <input type="password" name="rePassword" />
                    <label>Re-Password</label>
                    {validState[5].wrongPassword && <span id="repassword-match" style={valid}>không trùng với mật khẩu!!!</span>}
                </div>
                <input type="submit" value="Login" />
                <div className="sign_up_link">
                    <Nav.Link>
                        <Link to='/login' style={{ textDecoration: 'none' }}>Login</Link>
                    </Nav.Link>
                </div>
            </form>
        </div>
    )
}
