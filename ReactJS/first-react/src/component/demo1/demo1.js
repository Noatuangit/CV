import React, { useState, useEffect } from 'react'
import AddDiv from './AddDiv';
import SearchDiv from './SearchDiv';
import data from './data.json'

export default function Demo() {
    const [state, setState] = useState(data);
    const [hiddenForm, setStateHiddenForm] = useState("show active");
    const [hiddenSearch, setStateHiddenSearch] = useState("");
    const [displayState, setDisplayState] = useState([]);

    const showSearchForm = () => {
        setStateHiddenForm("show active")
        setStateHiddenSearch("")
    }

    const showAddForm = () => {
        setStateHiddenForm("")
        setStateHiddenSearch("show active")
    }


    const onSubmit = (data) => {
        setState([...state, data]);
    }

    const searchSubmit = (data) => {
        if (data.keyword === "" && data.category === undefined) {
            setDisplayState(state);
            return;
        }
        let temp = [...state].filter(x => {
            if (data.keyword === "") return true;
            for (let item of Object.keys(x)) {
                if ((x[item] + "").includes(data.keyword)) {
                    return true;
                }
            }
            return false;
        }).filter(x => {
            return data.category === undefined ? true : x.category === data.category
        });
        setDisplayState(temp)
    }

    useEffect(() => {
        { setDisplayState(state) };
    }, [state]);

    return (
        <div style={{ backgroundColor: "white" }}>
            <nav className="navbar navbar-expand-lg navbar-light bg-primary shadow-sm text-white mb-3">
                <div className="user-info">User</div>
            </nav>
            <div className="search-form-container border mb-3">
                <ul className="nav nav-tabs mb-3" id="my-tab" role="tablist">
                    <li className="nav-item" role="presentation">
                        <button
                            className={`nav-link ${hiddenForm}`}
                            id="search-tab"
                            data-bs-toggle="tab"
                            data-bs-target="#search-tab-pane"
                            type="button" role="tab"
                            aria-controls="search-tab-pane"
                            onClick={showSearchForm}
                            aria-selected="true">
                            Search</button>
                    </li>
                    <li className="nav-item" role="presentation">
                        <button
                            className={`nav-link ${hiddenSearch}`}
                            id="form-tab"
                            onClick={showAddForm}
                            data-bs-toggle="tab"
                            data-bs-target="#form-tab-pane"
                            type="button"
                            role="tab"
                            aria-controls="form-tab-pane"
                            aria-selected="false">Form</button>
                    </li>
                </ul>
                <div className="tab-content">
                    {
                        hiddenForm === "" && <AddDiv data={hiddenForm} onSubmit={onSubmit} />
                    }
                    {
                        hiddenSearch === "" && <SearchDiv data={hiddenSearch} searchSubmit={searchSubmit} />
                    }
                </div>
            </div>
            <div className="books-view border">
                <div className="title-text border-bottom">
                    <h2>Books</h2>
                </div>
                <table className="table table-striped align-middle">
                    <thead>
                        <tr>
                            <th scope="col">No</th>
                            <th scope="col">Cover</th>
                            <th scope="col">Title</th>
                            <th scope="col">Category</th>
                            <th scope="col">Author</th>
                            <th scope="col">Release year</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            displayState.map((item, index) =>
                                <tr key={item.id + Math.random(100)}>
                                    <td>
                                        {index + 1}
                                    </td>
                                    <td>
                                        <img src={require("../../image/ability_drop_engines.png")} alt="no load" />
                                    </td>
                                    <td>
                                        {item.title}
                                    </td>
                                    <td>
                                        {item.category}
                                    </td>
                                    <td>
                                        {item.author}
                                    </td>
                                    <td>
                                        {item.year}
                                    </td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}
