import React, { useEffect, useState } from 'react'
import SelectOption from '../Button/SelectOption'
import axios from 'axios';
import { Link, useNavigate, useParams } from "react-router-dom";
import { computer } from '../utils/UrlPack';

export default function CreateComputer(props) {
    const navigate = useNavigate();
    const error = { color: "red" };
    const { id } = useParams();
    const [state, setState] = useState({});
    const [valid, setValid] = useState({});

    function handleChange(e) {
        setState({ ...state, [e.target.name]: e.target.value })
    }

    const onSubmit = (e) => {
        e.preventDefault();

        axios.post(computer, state, {
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(resp => {
            navigate("/computer/list");
        })
            .catch(error => {
                setValid(error.response.data);
            });
    }

    useEffect(() => {
        if (id) {
            axios.get(`${computer}/${id}`).then(resp => setState(resp.data));
        }
    }, [id])

    return (
        <div style={{ display: "flex", justifyContent: "center", width: "80%", marginLeft: "10%", marginBottom: "10px", marginTop: "10px", backgroundImage: `computer(${"https://images.pexels.com/photos/2662116/pexels-photo-2662116.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"})` }}  >
            <form onSubmit={onSubmit} style={{ textAlign: "left", color: "white", width: "80%" }}>
                <div className="form-group">
                    <label htmlFor="exampleInputEmail1">Position {valid.position && <span style={error}>{valid.position}</span>}</label>
                    <input type="text" e
                        className="form-control"
                        value={state.position || ""}
                        name="position"
                        onChange={(e) => handleChange(e)}
                        id="exampleInputEmail1"
                        placeholder="Position computer" />
                </div>
                <div className="form-group">
                    <label htmlFor="exampleInputPassword1">Status {valid.status && <span style={error}>{valid.status}</span>}</label>
                    <SelectOption list={['on', 'off', 'pending', 'waiting']} value={state.status} name="status" handleChange={(e) => handleChange(e)} />
                </div>
                <div className="col-12" style={{ textAlign: "center" }} >
                    <button type="submit" className="btn btn-primary">Submit</button>

                    <button type="reset" className="btn btn-warning" onClick={() => setValid({})}>Reset</button>

                    <button type="button" className="btn btn-info">
                        <Link as={Link} to='/computer/list' style={{ textDecoration: 'none' }}>Back List</Link>
                    </button>
                </div>
            </form>
        </div>
    )
}
