import React, { Component } from 'react'
import { Navbar, Container, Nav, NavDropdown } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import home from '../../image/home.png'
export default class HeaderNavbar extends Component {
    render() {
        return (
            <Navbar bg="light" expand="lg">
                <Container fluid>
                    <Navbar.Brand  >
                        <Nav.Link as={Link} to='/' style={{ textDecoration: 'none' }} id="RouterNavLink">
                            <img src={home} style={{ width: '100px' }} alt="no-load"></img>
                            Home
                        </Nav.Link>
                    </Navbar.Brand>
                    <Navbar.Toggle aria-controls="navbarScroll" />
                    <Navbar.Collapse id="navbarScroll">
                        <Nav
                            className="me-auto my-2 my-lg-0"
                            style={{ maxHeight: '100px' }}
                            navbarScroll
                        >
                            <NavDropdown title="Manager" id="navbarScrollingDropdown">
                                <NavDropdown.Item  >
                                    <Nav.Link as={Link} to='/productList' style={{ textDecoration: 'none' }}>Product List</Nav.Link>
                                </NavDropdown.Item>
                                <NavDropdown.Divider />
                                <NavDropdown.Item  >
                                    <Nav.Link as={Link} to='/todo' style={{ textDecoration: 'none' }}>To do list</Nav.Link>
                                </NavDropdown.Item>
                                <NavDropdown.Divider />
                                <NavDropdown.Item  >
                                    <Nav.Link as={Link} to='/table' style={{ textDecoration: 'none' }}>Table</Nav.Link>
                                </NavDropdown.Item>
                                <NavDropdown.Divider />
                                <NavDropdown.Item  >
                                    <Nav.Link as={Link} to='/login' style={{ textDecoration: 'none' }}>Login</Nav.Link>
                                </NavDropdown.Item>
                                <NavDropdown.Divider />
                                <NavDropdown.Item  >
                                    <Nav.Link as={Link} to='/crud' style={{ textDecoration: 'none' }}>CRUD basic</Nav.Link>
                                </NavDropdown.Item>
                                <NavDropdown.Divider />
                                <NavDropdown.Item  >
                                    <Nav.Link as={Link} to='/demo' style={{ textDecoration: 'none' }}>DEMO1</Nav.Link>
                                </NavDropdown.Item>
                            </NavDropdown>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>

        )
    }
}
