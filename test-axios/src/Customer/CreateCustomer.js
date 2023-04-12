import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';
import axios from 'axios';
import { useNavigate } from "react-router-dom";
import { customer } from '../utils/UrlPack';

export default function CreateCustomer() {
    const { id } = useParams();
    const [target, setTarget] = useState({});
    const [valid, setValid] = useState({});

    const error = { color: "red" };

    const navigate = useNavigate();

    const onSubmit = (e) => {
        e.preventDefault();
        if (id) {
            axios.put(customer, target, {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(resp => {
                navigate("/customer/list");
            }).catch(error => {
                setValid(error.response.data);
            })
        }
        axios.post(customer, target, {
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(resp => {
            navigate("/customer/list");
        }).catch(error => {
            setValid(error.response.data);
        })
    }

    const handleChange = (element) => {
        setTarget({ ...target, [element.target.name]: element.target.value })
    }

    useEffect(() => {
        if (id) {
            axios.get(`${customer}/${id}`)
                .then(resp => {
                    setTarget(resp.data)
                });
        }
    }, [id]);

    return (
        <div style={{ display: "flex", justifyContent: "center", width: "80%", marginLeft: "10%", marginBottom: "10px", marginTop: "10px", backgroundImage: `url(${"https://images.pexels.com/photos/2662116/pexels-photo-2662116.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"})` }}  >
            <form id="form" onSubmit={onSubmit} style={{ textAlign: "left", color: "white", width: "80%" }}>
                <div className="col-12">
                    <label htmlFor="exampleInputEmail1" className="form-label">Full Name {valid.name && <span style={error}>{valid.name}</span>}</label>
                    <input type="text"
                        className="form-control"
                        name='name'
                        id="exampleInputEmail1"
                        aria-describedby="emailHelp"
                        value={target.name}
                        onChange={handleChange} />
                </div>
                <div className="col-12">
                    <label htmlFor="exampleInputPassword1" className="form-label">Email {valid.email && <span style={error}>{valid.email}</span>}</label>
                    <input type="text"
                        className="form-control"
                        name='email'
                        readOnly={target.id}
                        id="exampleInputPassword1"
                        value={target.email}
                        onChange={handleChange}
                    />

                </div>
                <div className="col-12">
                    <label htmlFor="exampleInputPassword1" className="form-label">Phone {valid.phone && <span style={error}>{valid.phone}</span>}</label>
                    <input type="text"
                        name='phone'
                        value={target.phone}
                        className="form-control"
                        id="exampleInputPassword1"
                        onChange={handleChange} />

                </div>
                <div className="col-12">
                    <label htmlFor="exampleInputPassword1" className="form-label">Address {valid.address && <span style={error}>{valid.address}</span>}</label>
                    <input
                        value={target.address}
                        type="text"
                        name='address'
                        className="form-control"
                        id="exampleInputPassword1"
                        onChange={handleChange} />

                </div>
                <div className="col-12" style={{ textAlign: "center" }} >
                    <button type="submit" className="btn btn-primary">Submit</button>
                    <button type="reset" className="btn btn-warning" onClick={() => setValid({})}>Reset</button>
                    <button type="button" className="btn btn-info">
                        <Link as={Link} to='/customer/list' style={{ textDecoration: 'none' }}>Back List</Link>
                    </button>
                </div>
            </form>
        </div>
    )
}
