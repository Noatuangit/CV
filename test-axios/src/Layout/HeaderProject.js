import React from 'react'
import { Nav } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import "./header.css"
export default function HeaderProject() {
    return (
        <div>
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <div className="container-fluid">
                    <Link className="navbar-brand" >Navbar</Link>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNavDropdown">
                        <ul className="navbar-nav">
                            <li className="nav-item dropdown">
                                <Link className="nav-link dropdown-toggle" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Customer
                                </Link>
                                <ul className="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <li> <Nav.Link as={Link} className="dropdown-item" to='/customer/list' style={{ textDecoration: 'none' }}>List Customer</Nav.Link></li>

                                    <li> <Nav.Link as={Link} className="dropdown-item" to='/customer/createCustomer' style={{ textDecoration: 'none' }}>Create Customer</Nav.Link></li>
                                </ul>
                            </li>

                            <li className="nav-item dropdown" >
                                <Link className="nav-link dropdown-toggle" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Computer
                                </Link>
                                <ul className="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <li>
                                        <Nav.Link as={Link} className="nav-link" to='/computer/list' style={{ textDecoration: 'none' }}>List Computer</Nav.Link>
                                    </li>
                                    <li>
                                        <Nav.Link as={Link} className="nav-link" to='/computer/createComputer' style={{ textDecoration: 'none' }}>Create Computer</Nav.Link>
                                    </li>

                                </ul>
                            </li>
                            <li className="nav-item dropdown">
                                <Link className="nav-link dropdown-toggle" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Service
                                </Link>
                                <ul className="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <li>
                                        <Nav.Link as={Link} className="nav-link" to='/service/list' style={{ textDecoration: 'none' }}>List Service</Nav.Link>
                                    </li>
                                    <li>
                                        <Nav.Link as={Link} className="nav-link" to='/service/createService' style={{ textDecoration: 'none' }}>Create Service</Nav.Link>
                                    </li>

                                </ul>
                            </li>
                            <li className="nav-item dropdown">
                                <Link className="nav-link dropdown-toggle" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Booking
                                </Link>
                                <ul className="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <li><Link as={Link} className="dropdown-item" to='/bookingComputer' >Booking Computer</Link></li>
                                    <li><Link as={Link} className="dropdown-item" to='/bookingService' >Booking Service</Link></li>
                                    <li><Link as={Link} className="dropdown-item" to='/manager'>Manager All Bill</Link></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    )
}
