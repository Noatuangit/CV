import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { comRest } from '../utils/UrlPack';
import SelectListObject from './SelectListObject';
export default function EditModal(props) {
    const [edit, setEdit] = useState({ computerId: "" });
    const [valid, setValid] = useState({});
    const error = { color: "red" };
    const onSubmit = (e) => {
        e.preventDefault();
        axios.post(comRest, edit, {
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(resp => {
            document.getElementById('closeButton').click();
            props.rerender();
        })
            .catch(error => {
                setValid(error.response.data);
            });
    }

    function handleChange(e) {
        setEdit({ ...edit, [e.target.name]: e.target.value })
    }

    function resetForm() {
        document.getElementById('form').reset();
        setValid({});
    }

    useEffect(() => {
        if (props.display === "Edit") {
            setEdit(props.items);
        }
    })

    return (
        <div>
            <button className="btn btn-success" data-bs-toggle="modal"
                data-bs-target="#ModalCreate" id="createButton">
                <i className="fa-solid fa-plus"> </i> Create
            </button>
            <div className="modal fade" id="ModalCreate" tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div className="modal-dialog modal-lg">
                    <div className="modal-content">
                        <div className="modal-body">
                            <section className="h-70"  >
                                <div className="container">
                                    <div className="col-lg-12 col-xl-12">
                                        <div className="card rounded-3">
                                            <div className="card-body p-12 p-md-12">
                                                <h3 className="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Create Information</h3>
                                                <form className="px-md-2" style={{ textAlign: "left" }} onSubmit={onSubmit} id="form">
                                                    <div className="row">
                                                        <div className="col-md-6 mb-4" >
                                                            <label className="form-label" htmlFor="form3Example1w">
                                                                Computer Booking {valid.computerId && <span style={error}>{valid.computerId}</span>}
                                                            </label>
                                                            <SelectListObject value={edit.computerId} url={props.url1} name="computerId" handleChange={(e) => handleChange(e)} />
                                                        </div>
                                                        <div className="col-md-6 mb-4">
                                                            <label className="form-label" htmlFor="form3Example1w">
                                                                Customer Booking {valid.customerId && <span style={error}>{valid.customerId}</span>}
                                                            </label>
                                                            <SelectListObject value={edit.customerId} url={props.url2} name="customerId" handleChange={(e) => handleChange(e)} />
                                                        </div>
                                                    </div>
                                                    <div className="row mb-4 pb-2 pb-md-0 mb-md-5">
                                                        <div className="col-md-6">
                                                            <div className="form-outline">
                                                                <label className="form-label" htmlFor="form3Example1w">
                                                                    Day begin  {valid.dateBegin && <span style={error}>{valid.dateBegin}</span>}
                                                                </label>
                                                                <input type="date" onChange={(e) => handleChange(e)} name='dateBegin' id="form3Example1w" className="form-control" />
                                                            </div>
                                                        </div>
                                                        <div className="col-md-6">
                                                            <div className="form-outline">
                                                                <label className="form-label" htmlFor="form3Example1w">
                                                                    Time begin {valid.timeBegin && <span style={error}>{valid.timeBegin}</span>}
                                                                </label>
                                                                <input type="time" name='timeBegin' onChange={(e) => handleChange(e)} id="form3Example1w" className="form-control" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div className="row mb-4 pb-2 pb-md-0 mb-md-5">
                                                        <label className="form-label" htmlFor="form3Example1q">
                                                            Time use  {valid.timeUse && <span style={error}>{valid.timeUse}</span>}
                                                        </label>

                                                        <input type="number" name='timeUse' value={edit.timeUse} onChange={(e) => handleChange(e)} id="form3Example1q" className="form-control" />
                                                    </div>
                                                    <div className="modal-footer">
                                                        <button type="button" id="closeButton" className="btn btn-secondary" data-bs-dismiss="modal" onClick={resetForm}>Close</button>
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
        </div>
    )
}

