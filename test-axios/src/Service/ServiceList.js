import React, { useEffect, useState } from 'react'
import SearchForm from '../Search/SearchForm'
import axios from 'axios';
import DeleteButton from '../Button/DeleteButton';
import Page from '../utils/Page';
import { service } from '../utils/UrlPack';
import EditButton from '../Button/EditButton';
import NoResult from '../Layout/NoResult';

export default function ServiceList() {
    const url = service;
    const [list, setList] = useState({ data: { content: [] } });
    const [condition, setCondition] = useState("");
    const [display, setDisplay] = useState(true);
    const onSubmit = (data) => {
        setCondition(data)
    }
    const rerender = () => {
        setDisplay(!display);
    }


    function handleClick(page) {
        axios.get(`${url}?p=${page}&c=${condition}`).then(res => {
            setList(res);
        })
    }

    useEffect(() => {
        axios.get(`${url}?c=${condition}`).then(resp => setList(resp));
    }, [condition, display]);

    return (
        <div>
            <SearchForm onSubmit={onSubmit} />
            <table className="table table-striped">
                <thead>
                    <tr>
                        <td>
                            #
                        </td>
                        <td>
                            Name
                        </td>
                        <td>
                            Unit
                        </td>
                        <td>
                            Price
                        </td>
                        <td>
                        </td>
                        <td>
                        </td>
                    </tr>
                </thead>
                <tbody>
                    {
                        list.data.content.length == 0 &&
                        <NoResult column={6} />
                    }
                    {list.data.content.length > 0 && list.data.content.map((item, index) =>
                        <tr key={item.id}>
                            <td>{index + 1}</td>
                            <td>{item.name}</td>
                            <td>{item.unit}</td>
                            <td>{item.price}</td>
                            <td>
                                <EditButton url={"service"} id={item.id} />
                            </td>
                            <td>
                                <DeleteButton url={url} id={item.id} rerender={rerender} />
                            </td>
                        </tr>)}
                </tbody>
            </table>
            <Page
                totalPages={list.data.totalPages}
                number={list.data.number}
                condition={condition}
                handleClick={handleClick}
            />
        </div>
    )
}
