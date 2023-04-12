import axios from 'axios';
import React, { useEffect } from 'react'
import { useState } from 'react';
import Page from '../utils/Page';
import SearchForm from '../Search/SearchForm';
import DeleteButton from '../Button/DeleteButton';
import EditButton from '../Button/EditButton';
import { customer } from '../utils/UrlPack';
import NoResult from '../Layout/NoResult';

export default function CustomerList() {
    const url = customer;
    const [list, setList] = useState({ data: { content: [] } });
    const [condition, setCondition] = useState("");
    const [display, setDisplay] = useState(true);

    function handleClick(page) {
        axios.get(`${url}?p=${page}&c=${condition}`).then(res => {
            setList(res);
        })
    }

    const onSubmit = (data) => {
        setCondition(data);
    }

    const rerender = () => {
        setDisplay(!display);
    }

    useEffect(() => {
        axios.get(`${url}?c=${condition}`).then(res => {
            setList(res);
        })
    }, [condition, display])

    return (
        <div>
            <SearchForm
                onSubmit={onSubmit}
            />
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
                            Address
                        </td>
                        <td>
                            Phone
                        </td>
                        <td>
                            Email
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
                        <NoResult column={7} />
                    }
                    {list.data.content.length > 0 &&
                        list.data.content.map((item, index) =>
                            <tr key={item.id + index}>
                                <td>{index + 1}</td>
                                <td>{item.name}</td>
                                <td>{item.address}</td>
                                <td>{item.phone}</td>
                                <td>{item.email}</td>
                                <td>
                                    <EditButton url={'customer'} id={item.id} />
                                </td>
                                <td>
                                    <DeleteButton url={url} id={item.id} rerender={rerender} />
                                </td>

                            </tr>
                        )}
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
