import React, { useState, useEffect } from 'react'
import "./Login.css"
import { Link, useNavigate } from 'react-router-dom'
import { Nav } from 'react-bootstrap'
export default function LoginForm() {

    const [stateValid, setStateValid] = useState({ wrongEmail: false, emailFail: false, wrongPass: false });
    const [state, setState] = useState([]);

    const navigate = useNavigate();

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
                setState(myJson);
            });
    }

    useEffect(() => {
        getData()
    }, [])

    const validUserEmail = (email) => {
        return state.some(x => x.email == email);
    }

    const validUserPassword = (password) => {
        return state.some(x => x.password == password);
    }

    const validEmail = (email) => {
        if (!/^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$/.test(email)) {
            return false;
        }
        return true;
    }

    const onSubmit = (e) => {
        let valid = { wrongEmail: false, emailFail: false, wrongPass: false };
        e.preventDefault();
        const dataForm = (Object.fromEntries(new FormData(e.target)));
        if (validEmail(dataForm.email)) {
            if (validUserEmail(dataForm.email)) {
                if (validUserPassword(dataForm.password)) {
                    navigate("/formController", {
                        state: dataForm,
                    });
                    return;
                }
                valid.wrongPass = true;
            } else {
                valid.emailFail = true;
            }
        } else {
            valid.wrongEmail = true;
        }
        setStateValid(valid);
    }
    return (
        <div className="center">
            <div className="text-header">
                <h1>Please Sign In</h1>
                <p>email suggest: admin@gmail.com, pass: admin</p>
            </div>
            <form method="post" id="myForm" onSubmit={onSubmit}>
                <div className="txt_field">
                    <input type="text" name='email' id='email' required maxLength={50} />
                    <label htmlFor='email' >E-mail
                        {stateValid.wrongEmail && <span id="errorType" style={{ color: "red" }}> error type</span>}
                        {stateValid.emailFail && <span id="errorType" style={{ color: "red" }}> mail not exists</span>}
                    </label>
                </div>

                <div className="txt_field">
                    <input type="password" name="password" id='password' required maxLength={50} />
                    <label htmlFor='password'>Password
                        {stateValid.wrongPass && <span id="wrongPassword" style={{ color: "red" }}> wrong password</span>}
                    </label>
                </div>

                <div className="remember">
                    <input type="checkbox" />Remember me
                </div>

                <input type="submit" value="Login" />
                <div className="sign_up_link">
                    <Nav.Link>
                        <Link to='/register' style={{ textDecoration: 'none' }}>Register</Link>
                    </Nav.Link>
                </div>
            </form>
        </div>
    )
}
