import React, { useEffect, useState } from 'react'
import { Link, useLocation, useNavigate } from 'react-router-dom'
import { cusDetails, serDetails, serRest } from '../../utils/UrlPack';
import SelectListObject from '../../Button/SelectListObject';
import axios from 'axios';
export default function FormServiceDetails() {
    const [state, setState] = useState({});
    const [valid, setValid] = useState({});
    const error = { color: "red" };
    const navigate = useNavigate();
    const location = useLocation();
    const onSubmit = (e) => {
        e.preventDefault();
        axios.post(serRest, state, {
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(resp => navigate("/bookingService")).catch(error => setValid(error.response.data))
    }

    function handleChange(e) {
        setState({ ...state, [e.target.name]: e.target.value });
    }

    useEffect(() => {
        setState(location.state);
    }, []);

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
                                            <h3 className="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Form Information</h3>
                                            <form className="px-md-2" style={{ textAlign: "left" }} onSubmit={onSubmit} id="form">
                                                <div className="row">
                                                    <div className="col-md-6 mb-4" >
                                                        <label className="form-label" htmlFor="serviceId">
                                                            Service Booking  {valid.serviceId && <span style={error}>{valid.serviceId}</span>}  </label>
                                                        <SelectListObject url={serDetails} name="serviceId" handleChange={(e) => handleChange(e)} />
                                                    </div>
                                                    <div className="col-md-6 mb-4">
                                                        <label className="form-label" htmlFor="customerId">
                                                            Customer Booking    {valid.customerId && <span style={error}>{valid.customerId}</span>}       </label>
                                                        <SelectListObject url={cusDetails} name="customerId" handleChange={(e) => handleChange(e)} />
                                                    </div>
                                                </div>
                                                <div className="row mb-4 pb-2 pb-md-0 mb-md-5">
                                                    <div className="col-md-6">
                                                        <div className="form-outline">
                                                            <label className="form-label" htmlFor="dateBegin">
                                                                Day begin   {valid.dateBegin && <span style={error}>{valid.dateBegin}</span>}    </label>
                                                            <input type="date" name='dateBegin' id="dateBegin" onChange={(e) => handleChange(e)} className="form-control" />
                                                        </div>
                                                    </div>
                                                    <div className="col-md-6">
                                                        <div className="form-outline">
                                                            <label className="form-label" htmlFor="timeBegin">
                                                                Time begin      {valid.timeBegin && <span style={error}>{valid.timeBegin}</span>}     </label>
                                                            <input type="time" name='timeBegin' id="timeBegin" onChange={(e) => handleChange(e)} className="form-control" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div className="row mb-4 pb-2 pb-md-0 mb-md-5">
                                                    <label className="form-label" htmlFor="timeUse">
                                                        Amount   {valid.amount && <span style={error}>{valid.amount}</span>}
                                                    </label>
                                                    <input type="number" name='amount' onChange={(e) => handleChange(e)} id="amount" className="form-control" />
                                                </div>
                                                <div className="modal-footer">
                                                    <Link as={Link} to='/bookingService'>
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
