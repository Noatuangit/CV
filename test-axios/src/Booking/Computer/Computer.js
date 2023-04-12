import React, { useEffect, useState } from 'react'
import "../layout.css"
import axios from 'axios'
import { comRest, comDetails, cusDetails } from '../../utils/UrlPack';
import CreateModal from '../../Button/EditModal';
import DeleteButton from '../../Button/DeleteButton';
import { useNavigate } from 'react-router-dom';
import Page from '../../utils/Page';
import SearchForm from '../../Search/SearchForm';
import NoResult from '../../Layout/NoResult';
export default function Computer() {
    const [state, setState] = useState({ data: { content: [] } });
    const [condition, setCondition] = useState("");
    let navigate = useNavigate();
    const [render, setRender] = useState(false);
    const rerender = () => setRender(!render);

    useEffect(() => {
        axios.get(`${comRest}?c=${condition}`).then(resp => {
            setState(resp);
        }
        );
    }, [render, condition]);

    const handleEdit = (data) => {
        navigate("/bookingComputer/edit", {
            state: data
        })
    }

    function handleClick(page) {
        axios.get(`${comRest}?p=${page}&c=${condition}`).then(res => {
            setState(res);
        })
    }

    const onSubmit = (data) => {
        setCondition(data)
    }
    return (
        <div>
            <div className="main">

                <div className="wrap-item">
                    <CreateModal
                        url1={comDetails}
                        url2={cusDetails}
                        rerender={rerender} />
                </div>
                <div className="wrap-item-center">
                    <SearchForm
                        onSubmit={onSubmit}
                    />
                    <table className="table table-striped">
                        <thead>
                            <tr>
                                <td>#</td>
                                <td>Customer name</td>
                                <td>id computer</td>
                                <td>Date begin</td>
                                <td>Time begin</td>
                                <td>Time use</td>
                                <td></td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                state.data.content.length == 0 &&
                                <NoResult column={8} />
                            }
                            {state.data.content.length > 0 &&
                                state.data.content.map((item, index) =>
                                    <tr key={item.customerName + index + item.computerId}>
                                        <td>{index + 1}</td>
                                        <td>{item.customerName}</td>
                                        <td>{item.computerId}</td>
                                        <td>{item.dateBegin}</td>
                                        <td>{item.timeBegin}</td>
                                        <td>{item.timeUse}</td>
                                        <td>
                                            <button id={item} className='btn btn-warning' style={{ width: "40px" }} onClick={() => handleEdit(item)}>
                                                <i className="fa-solid fa-user-pen">
                                                </i>
                                            </button>
                                        </td>
                                        <td>
                                            <DeleteButton url={comRest}
                                                item={item}
                                                rerender={rerender} />
                                        </td>

                                    </tr>)
                            }

                        </tbody>
                    </table>

                    <Page
                        totalPages={state.data.totalPages}
                        number={state.data.number}
                        handleClick={handleClick}
                    />
                </div>
            </div>

        </div>
    )
}
