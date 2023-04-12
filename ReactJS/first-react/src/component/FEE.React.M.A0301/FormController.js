import React, { useEffect, useState } from 'react'
import "./Form.css"
import { Link, Outlet } from 'react-router-dom'
import { Nav } from 'react-bootstrap'
import { useLocation } from 'react-router-dom';


export default function FormController() {
    const location = useLocation();
    const [state, setState] = useState("");
    let email = "";
    useEffect(() => {
        setState(location.state.email);
    }, [email]);

    return (
        <div>
            <h1>FormController</h1>
            <headers className="header-top">
                <div className="title">CMS</div>
                <div className="logOut dropdown">
                    <img src={require(`./add-user.png`)} />
                    <div className="content_dropdown">
                        <Nav.Link>
                            <Link to={`/formController/formEdit/${state}`} style={{ textDecoration: 'none' }}><i class="fa-solid fa-file-pen">Edit User</i></Link>
                        </Nav.Link>
                        <Nav.Link>
                            <Link to='/login' style={{ textDecoration: 'none' }}><i class="fa-solid fa-file-pen">Logout</i></Link>
                        </Nav.Link>
                    </div>
                </div>
            </headers>
            <div className="main-container">
                <div className="wrap-item-navbar">
                    <div className="input-group">
                        <input type="search" className="form-control rounded" placeholder="Search" aria-label="Search"
                            described="search-addon" />
                        <button type="button" className="btn btn-outline-primary">
                            <img src={require(`./search.png`)} />
                        </button>
                    </div>
                    <div className="item-1" name="list-choice" >
                        <Nav.Link>
                            <Link to='/formController/tableController' style={{ textDecoration: 'none' }}><i class="fa-solid fa-file-pen">View contents</i></Link>
                        </Nav.Link>
                    </div>
                    <div className="item-2" name="list-choice"  >
                        <Nav.Link>
                            <Link to='/formController/formAdd' style={{ textDecoration: 'none' }}> <i className="fa-solid fa-file-pen">Form contents</i></Link>
                        </Nav.Link>
                    </div>
                </div>
                <div className="header-body" id="add-content">
                    <Outlet />
                </div>
            </div>
        </div>
    )
}
