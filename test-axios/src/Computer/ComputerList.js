import React, { useEffect, useState } from 'react'
import SearchForm from '../Search/SearchForm';
import axios from 'axios';
import Page from '../utils/Page';
import DeleteButton from '../Button/DeleteButton';
import EditButton from '../Button/EditButton';
import { computer } from '../utils/UrlPack';
import NoResult from '../Layout/NoResult';
export default function ComputerList() {
    const url = computer;
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
                            Position
                        </td>
                        <td>
                            Status
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
                        <NoResult column={5} />
                    }
                    {list.data.content.length > 0 && list.data.content.map((item, index) =>
                        <tr key={item.id}>
                            <td style={item.status === 'on' ? { color: "green" } : { color: "gray" }}>{index + 1}</td>
                            <td style={item.status === 'on' ? { color: "green" } : { color: "gray" }}>{item.position}</td>
                            <td style={item.status === 'on' ? { color: "green" } : { color: "gray" }}>{item.status}</td>
                            <td>
                                <EditButton url={"computer"} id={item.id} />
                            </td>
                            <td>
                                {item.status !== 'off' && <DeleteButton url={url} id={item.id} rerender={rerender} />}
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
