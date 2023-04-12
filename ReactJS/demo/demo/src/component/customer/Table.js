import React from 'react'

export default function Table(props) {
    function onClick(data) {
        props.onClick(data);
    }
    return (
        <div>
            <h1> Table </h1>
            <table className='table' border={1}>
                <thead>
                    <tr>
                        <td>
                            #
                        </td>
                        <td>
                            username
                        </td>
                        <td>
                            status
                        </td>
                        <td>
                            email
                        </td>
                        <td>
                            edit
                        </td>
                    </tr>
                </thead>
                <tbody>
                    {props.data.map((item, index) =>
                        <tr key={item.id + Math.random(100000)} style={item.status == "NoActive" ? { color: "green" } : { color: "tomato" }}>
                            <td>
                                {index + 1}
                            </td>
                            <td>
                                {item.username}
                            </td>
                            <td>
                                {item.status}
                            </td>
                            <td>
                                {item.email}
                            </td>
                            <td>
                                <button onClick={() => onClick(item)}>edit</button>
                            </td>
                        </tr>
                    )}
                </tbody>
            </table>
        </div>
    )
}
