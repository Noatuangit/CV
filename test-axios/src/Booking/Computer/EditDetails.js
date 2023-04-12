import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useLocation, useNavigate } from 'react-router-dom'
import { comRest } from '../../utils/UrlPack';

export default function EditDetails() {
    const location = useLocation();
    const navigate = useNavigate();
    const [state, setState] = useState({});
    useEffect(() => {
        setState(location.state);
    }, [])

    function handleChange(e) {
        setState({ ...state, timeUse: e.target.value });
    }

    const onSubmit = (e) => {
        e.preventDefault();
        console.log(state)
        axios.put(comRest, state, {
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(resp => {
            navigate("/bookingComputer")
        })
    }

    return (
        <div>
            <div className="modal-dialog modal-lg">
                <div className="modal-content">
                    <div className="modal-body">
                        <section className="h-70"  >
                            <div className="container">
                                <div className="col-lg-12 col-xl-12">
                                    <div className="card rounded-3">
                                        <div className="card-body p-12 p-md-12">
                                            <h3 className="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Edit Information</h3>
                                            <form className="px-md-2" style={{ textAlign: "left" }} onSubmit={onSubmit} id="form">
                                                <div className="row">
                                                    <div className="col-md-6 mb-4" >
                                                        <label className="form-label" htmlFor="computerId">
                                                            Computer Booking   </label>
                                                        <input type="text" name='computerId' id="computerId" className="form-control" readOnly value={state.computerId} />
                                                    </div>
                                                    <div className="col-md-6 mb-4">
                                                        <label className="form-label" htmlFor="customerId">
                                                            Customer Booking        </label>
                                                        <input type="text" name='customerId' id="customerId" readOnly className="form-control" value={state.customerId} />
                                                    </div>
                                                </div>
                                                <div className="row mb-4 pb-2 pb-md-0 mb-md-5">
                                                    <div className="col-md-6">
                                                        <div className="form-outline">
                                                            <label className="form-label" htmlFor="dateBegin">
                                                                Day begin    </label>
                                                            <input type="text" readOnly name='dateBegin' id="dateBegin" className="form-control" value={state.dateBegin} />
                                                        </div>
                                                    </div>
                                                    <div className="col-md-6">
                                                        <div className="form-outline">
                                                            <label className="form-label" htmlFor="timeBegin">
                                                                Time begin        </label>
                                                            <input type="time" readOnly name='timeBegin' id="timeBegin" className="form-control" value={state.timeBegin} />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div className="row mb-4 pb-2 pb-md-0 mb-md-5">
                                                    <label className="form-label" htmlFor="timeUse">
                                                        Time use
                                                    </label>
                                                    <input type="number" name='timeUse' onChange={(e) => handleChange(e)} id="timeUse" className="form-control" value={state.timeUse} min={location.state.timeUse} />
                                                </div>
                                                <div className="modal-footer">
                                                    <Link as={Link} to='/bookingComputer'>
                                                        <button type="button" id="closeButton" className="btn btn-warning">Close</button>
                                                    </Link>
                                                    <button type="submit" className="btn btn-primary">Save changes</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
            </div>
        </div>
    )
}
