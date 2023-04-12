import React, { useMemo, useState } from 'react'
import { service } from '../utils/UrlPack';
import { Link, useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';
import Radio from '../Button/Radio';

export default function CreateService() {
    const navigate = useNavigate();
    const { id } = useParams();
    const error = { color: "red" };

    const [state, setState] = useState({});
    const [valid, setValid] = useState({});

    const onSubmit = (e) => {
        e.preventDefault();
        axios.post(service, state, {
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(resp => { navigate("/service/list") })
            .catch(error => setValid(error.response.data));
    }

    function handleChange(e) {
        setState({ ...state, [e.target.name]: e.target.value })
    }

    useMemo(() => {
        if (id) {
            axios.get(`${service}/${id}`).then(resp => setState(resp.data))
        }
    }, [id])

    return (
        <div style={{ display: "flex", justifyContent: "center", width: "80%", marginLeft: "10%", marginBottom: "10px", marginTop: "10px", backgroundImage: `url(${"https://images.pexels.com/photos/2662116/pexels-photo-2662116.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"})` }}  >
            <form onSubmit={onSubmit} style={{ textAlign: "left", color: "white", width: "80%" }}>
                <div className="form-group">
                    <label htmlFor="name">Name {valid.name && <span style={error}>{valid.name}</span>}</label>
                    <input type="text"
                        className="form-control"
                        value={state.name}
                        name="name"
                        onChange={(e) => handleChange(e)}
                        id="name"
                        placeholder="Name Service" />
                </div>
                <div className="form-group">
                    <label htmlFor="price">Price {valid.price && <span style={error}>{valid.price}</span>}</label>
                    <input type="number"
                        className="form-control"
                        value={state.price}
                        name="price"
                        onChange={(e) => handleChange(e)}
                        id="price"
                        placeholder="Price Service" />
                </div>
                <div className="form-group">
                    <label htmlFor="unit">Unit </label>
                    <Radio name="unit" value={state.unit} list={["Bottle", "Unit", "Place", "Disk"]} handleChange={(e) => handleChange(e)} />
                </div>
                <div className="col-12" style={{ textAlign: "center" }} >
                    <button type="submit" className="btn btn-primary">Submit</button>

                    <button type="reset" className="btn btn-warning" onClick={() => setValid({})}>Reset</button>

                    <button type="button" className="btn btn-info">
                        <Link as={Link} to='/service/list' style={{ textDecoration: 'none' }}>Back List</Link>
                    </button>
                </div>
            </form>
        </div>
    )
}
